package com.mars.rti.ws.controller;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.common.model.UserRegistrationDetails;
import com.mars.common.service.UserRegistrationService;
import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.common.utils.SessionUser;
import com.mars.rti.controller.SendSMSEmailController;
import com.mars.rti.model.FireDetails;
import com.mars.rti.model.FireFeesMasterUpdated;
import com.mars.rti.model.FireRecommendation;
import com.mars.rti.model.MandapPermission;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.FireDepartmentWiseLoginService;
import com.mars.rti.service.FireDetailsService;
import com.mars.rti.service.FireFeesMasterUpdatedService;
import com.mars.rti.service.FireRecommendationService;
import com.mars.rti.service.FireSubDepartmentWiseLoginService;
import com.mars.rti.service.MandapPermissionService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.FireDetailsRestDTO;
import com.mars.rti.ws.model.FireRecommendationRestDTO;
import com.mars.rti.ws.model.MandapPermissionCertficateRestDTO;

@Controller
public class FireRecommendationRestController implements Serializable {
	
	
	private static Log log = LogFactory.getLog(MandapCertificateRestController.class);

	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private FireRecommendationService fireRecommendationService;
	
	@Autowired
	private UserRegistrationService userService;
	
	@Autowired
	private FireDetailsService fireDetailsService;
	
	@Autowired
	private FireFeesMasterUpdatedService fireFeesMasterUpdatedService;
	
	@Autowired
	private FireDepartmentWiseLoginService fireDepartmentWiseLoginService;

	@Autowired
	private FireSubDepartmentWiseLoginService fireSubDepartmentWiseLoginService;

	
	@RequestMapping(method = RequestMethod.POST, value ="/saveFireNOC")
	public @ResponseBody FireRecommendationRestDTO saveMandapApplication(
		   @RequestBody FireRecommendationRestDTO fireRecommendationRestDTO,HttpServletRequest request,HttpServletResponse reponse) throws ServletException{

		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[4];

		if (log.isDebugEnabled()) {
			log.debug("Invoking saveMandapApplication");
		}
		FireRecommendation fireRecommendation = new FireRecommendation();

		try {
			
			if(fireRecommendationRestDTO.getTitle()!=null && !fireRecommendationRestDTO.getTitle().isEmpty()) {
				fireRecommendation.setTitle(fireRecommendationRestDTO.getTitle());
			}
			else
			{
				String title = "title field is Required";
				condition = false;
				message.append(title).append(",");
			}
			
			if(fireRecommendationRestDTO.getFirstName()!=null && !fireRecommendationRestDTO.getFirstName().isEmpty()) {
				fireRecommendation.setFirstName(fireRecommendationRestDTO.getFirstName());
			}
			else
			{
				String firstName = "firstName field is Required";
				condition = false;
				message.append(firstName).append(",");
			}
			fireRecommendation.setMiddleName(fireRecommendationRestDTO.getMiddleName());

			if(fireRecommendationRestDTO.getLastName()!=null && !fireRecommendationRestDTO.getLastName().isEmpty()) {
				fireRecommendation.setLastName(fireRecommendationRestDTO.getLastName());
			}
			else
			{
				String lastName = "lastName field is Required";
				condition = false;
				message.append(lastName).append(",");
			}
			
			if(fireRecommendationRestDTO.getFullName()!=null && !fireRecommendationRestDTO.getFullName().isEmpty()) {
				fireRecommendation.setFullName(fireRecommendationRestDTO.getFullName());
			}
			else
			{
				String fullName = "fullName field is Required";
				condition = false;
				message.append(fullName).append(",");
			}
			
			fireRecommendation.setMiddleName(fireRecommendationRestDTO.getPlotNumber());
			fireRecommendation.setSurveyNo(fireRecommendationRestDTO.getSurveyNo());
			fireRecommendation.setSheetNo(fireRecommendationRestDTO.getSheetNo());
			fireRecommendation.setKhasaraNo(fireRecommendationRestDTO.getKhasaraNo());

			if(fireRecommendationRestDTO.getStreetName()!=null && !fireRecommendationRestDTO.getStreetName().isEmpty()) {
				fireRecommendation.setStreetName(fireRecommendationRestDTO.getStreetName());
			}
			else
			{
				String streetName = "streetName field is Required";
				condition = false;
				message.append(streetName).append(",");
			}
			
			fireRecommendation.setHouseNo(fireRecommendationRestDTO.getMouzaNo());
			
			if(fireRecommendationRestDTO.getPinCode()!=null && !fireRecommendationRestDTO.getPinCode().isEmpty()) {
				fireRecommendation.setPinCode(fireRecommendationRestDTO.getPinCode());
			}
			else
			{
				String pinCode = "pinCode field is Required";
				condition = false;
				message.append(pinCode).append(",");
			}
				fireRecommendation.setLandmark(fireRecommendationRestDTO.getLandmark());

			if(fireRecommendationRestDTO.getMobileNo()!=null && !fireRecommendationRestDTO.getMobileNo().isEmpty()) {
				fireRecommendation.setMobileNo(fireRecommendationRestDTO.getMobileNo());
			}
			else
			{
				String mobileNo = "mobileNo field is Required";
				condition = false;
				message.append(mobileNo).append(",");
			}
			
			if(fireRecommendationRestDTO.getAppEmail()!=null && !fireRecommendationRestDTO.getAppEmail().isEmpty()) {
				fireRecommendation.setAppEmail(String.valueOf(fireRecommendationRestDTO.getAppEmail()));
			}
			else
			{
				String appEmail = "appEmail Number field is Required";
				condition = false;
				message.append(appEmail).append(",");
			}
			
			fireRecommendation.setAddressOfPowerAttorney(fireRecommendationRestDTO.getApplAddress());

			
			if(fireRecommendationRestDTO.getTitleArchitecture()!=null && !fireRecommendationRestDTO.getTitleArchitecture().isEmpty()) {
				fireRecommendation.setTitleArchitecture(fireRecommendationRestDTO.getTitleArchitecture());
			}
			else
			{
				String titleArchitecture = "titleArchitecture field is Required";
				condition = false;
				message.append(titleArchitecture).append(",");
			}
			
			if(fireRecommendationRestDTO.getFirstNameArchitecture()!=null && !fireRecommendationRestDTO.getFirstNameArchitecture().isEmpty()) {
				fireRecommendation.setFirstNameArchitecture(fireRecommendationRestDTO.getFirstNameArchitecture());
			}
			else
			{
				String firstNameArchitecture = "firstNameArchitecture field is Required";
				condition = false;
				message.append(firstNameArchitecture).append(",");
			}
			
			fireRecommendation.setMiddleNameArchitecture(fireRecommendationRestDTO.getMiddleNameArchitecture());

			if(fireRecommendationRestDTO.getLastNameArchitecture()!=null && !fireRecommendationRestDTO.getLastNameArchitecture().isEmpty()) {
				fireRecommendation.setLastNameArchitecture(fireRecommendationRestDTO.getLastNameArchitecture());
			}
			else
			{
				String lastNameArchitecture = "lastNameArchitecture field is Required";
				condition = false;
				message.append(lastNameArchitecture).append(",");
			}
	
			fireRecommendation.setFullNameArchitecture(fireRecommendationRestDTO.getFullNameArchitecture());

			if(fireRecommendationRestDTO.getMobileNoArchitecture()!=null && !fireRecommendationRestDTO.getMobileNoArchitecture().isEmpty()) {
				fireRecommendation.setMobileNoArchitecture(fireRecommendationRestDTO.getMobileNoArchitecture());
			}
			else
			{
				String mobileNoArchitecture = "mobileNoArchitecture field is Required";
				condition = false;
				message.append(mobileNoArchitecture).append(",");
			}
			
			if(fireRecommendationRestDTO.getAppEmailArchitecture()!=null && !fireRecommendationRestDTO.getAppEmailArchitecture().isEmpty()) {
				fireRecommendation.setAppEmailArchitecture(fireRecommendationRestDTO.getAppEmailArchitecture());
			}
			else
			{
				String appEmailArchitecture = "appEmailArchitecture field is Required";
				condition = false;
				message.append(appEmailArchitecture).append(",");
			}
			
			if(fireRecommendationRestDTO.getArchitectLicenceNumber()!=null && !fireRecommendationRestDTO.getArchitectLicenceNumber().isEmpty()) {
				fireRecommendation.setArchitectLicenceNumber(fireRecommendationRestDTO.getArchitectLicenceNumber());
			}
			else
			{
				String architectLicenceNumber = "architectLicenceNumber field is Required";
				condition = false;
				message.append(architectLicenceNumber).append(",");
			}
			
			
			
			if(fireRecommendationRestDTO.getNameofBuildingOwner()!=null && !fireRecommendationRestDTO.getNameofBuildingOwner().isEmpty()) {
				fireRecommendation.setNameofBuildingOwner(fireRecommendationRestDTO.getNameofBuildingOwner());
			}
			else
			{
				String nameofBuildingOwner = "nameofBuildingOwner field is Required";
				condition = false;
				message.append(nameofBuildingOwner).append(",");
			}
			
			fireRecommendation.setAddressofbuilding(fireRecommendationRestDTO.getAddressofbuilding());

			if(fireRecommendationRestDTO.getTypeOfBuilding()!=null && !fireRecommendationRestDTO.getTypeOfBuilding().isEmpty()) {
				fireRecommendation.setTypeOfBuilding(fireRecommendationRestDTO.getTypeOfBuilding());
			}
			else
			{
				String typeOfBuilding = "typeOfBuilding field is Required";
				condition = false;
				message.append(typeOfBuilding).append(",");
			}
			
			
			if(fireRecommendationRestDTO.getSubTypeOfBuilding()!=null && !fireRecommendationRestDTO.getSubTypeOfBuilding().isEmpty()) {
				fireRecommendation.setTypeOfBuilding(fireRecommendationRestDTO.getSubTypeOfBuilding());
			}
			else
			{
				String subTypeOfBuilding = "subTypeOfBuilding field is Required";
				condition = false;
				message.append(subTypeOfBuilding).append(",");
			}
			
			
			if(fireRecommendationRestDTO.getTypeOfHeight()!=null && !fireRecommendationRestDTO.getTypeOfHeight().isEmpty()) {
				fireRecommendation.setTypeOfHeight(fireRecommendationRestDTO.getTypeOfHeight());
			}
			else
			{
				String typeOfHeight = "typeOfHeight field is Required";
				condition = false;
				message.append(typeOfHeight).append(",");
			}
			
			
			if(fireRecommendationRestDTO.getTypeOfConstruction()!=null && !fireRecommendationRestDTO.getTypeOfConstruction().isEmpty()) {
				fireRecommendation.setTypeOfConstruction(fireRecommendationRestDTO.getTypeOfConstruction());
			}
			else
			{
				String typeOfConstruction = "typeOfConstruction field is Required";
				condition = false;
				message.append(typeOfConstruction).append(",");
			}
			
			if(fireRecommendationRestDTO.getZoneNO()!=null && !fireRecommendationRestDTO.getZoneNO().isEmpty()) {
				fireRecommendation.setZoneNO(String.valueOf(fireRecommendationRestDTO.getZoneNO()));
			}
			else
			{
				String zoneNO = "zoneNO Number field is Required";
				condition = false;
				message.append(zoneNO).append(",");
			}
			if(fireRecommendationRestDTO.getWardNo()!=null && !fireRecommendationRestDTO.getWardNo().isEmpty()) {
				fireRecommendation.setWardNo(fireRecommendationRestDTO.getWardNo());
			}
			else
			{
				String wardNo = "wardNo Number field is Required";
				condition = false;
				message.append(wardNo).append(",");
			}
			
		
			if(fireRecommendationRestDTO.getHightOfBuilding()!=null && !fireRecommendationRestDTO.getHightOfBuilding().isEmpty()) {
				fireRecommendation.setHightOfBuilding(fireRecommendationRestDTO.getHightOfBuilding());
			}
			else
			{
				String hightOfBuilding = "hightOfBuilding field is Required";
				condition = false;
				message.append(hightOfBuilding).append(",");
			}
		
			
			if(fireRecommendationRestDTO.getFloors()!=null && !fireRecommendationRestDTO.getFloors().isEmpty()) {
				fireRecommendation.setFloors(fireRecommendationRestDTO.getFloors());
			}
			else
			{
				String floors = "floors Of Event field is Required";
				condition = false;
				message.append(floors).append(",");
			}
			
			
			
			if(fireRecommendationRestDTO.getTotalPlotArea()!=null && !fireRecommendationRestDTO.getTotalPlotArea().isEmpty()) {
				fireRecommendation.setTotalPlotArea(fireRecommendationRestDTO.getTotalPlotArea());
			}
			else
			{
				String totalPlotArea = "totalPlotArea field is Required";
				condition = false;
				message.append(totalPlotArea).append(",");
			}
			if(fireRecommendationRestDTO.getBuildUpArea()!=null && !fireRecommendationRestDTO.getBuildUpArea().isEmpty()) {
				fireRecommendation.setBuildUpArea(fireRecommendationRestDTO.getBuildUpArea());
			}
			else
			{
				String buildUpArea = "buildUpArea field is Required";
				condition = false;
				message.append(buildUpArea).append(",");
			}
			if(fireRecommendationRestDTO.getSuperBuildarea()!=null && !fireRecommendationRestDTO.getSuperBuildarea().isEmpty()) {
				fireRecommendation.setSuperBuildarea(fireRecommendationRestDTO.getSuperBuildarea());
			}
			else
			{
				String superBuildarea = "superBuildarea field is Required";
				condition = false;
				message.append(superBuildarea).append(",");
			}			
			if(fireRecommendationRestDTO.getNumberOfBuilding()!=null && !fireRecommendationRestDTO.getNumberOfBuilding().isEmpty()) {
				fireRecommendation.setNumberOfBuilding(fireRecommendationRestDTO.getNumberOfBuilding());
			}
			else
			{
				String numberOfBuilding = "numberOfBuilding field is Required";
				condition = false;
				message.append(numberOfBuilding).append(",");
			}
			if(fireRecommendationRestDTO.getNumOfWings()!=null && !fireRecommendationRestDTO.getNumOfWings().isEmpty()) {
				fireRecommendation.setNumOfWings(fireRecommendationRestDTO.getNumOfWings());
			}
			else
			{
				String numOfWings = "numOfWings field is Required";
				condition = false;
				message.append(numOfWings).append(",");
			}
			if(fireRecommendationRestDTO.getPresentPosition()!=null && !fireRecommendationRestDTO.getPresentPosition().isEmpty()) {
				fireRecommendation.setPresentPosition(fireRecommendationRestDTO.getPresentPosition());
			}
			else
			{
				String presentPosition = "presentPosition field is Required";
				condition = false;
				message.append(presentPosition).append(",");
			}
			
			if(fireRecommendationRestDTO.getFrontMarginWidth()!=null && !fireRecommendationRestDTO.getFrontMarginWidth().isEmpty()) {
				fireRecommendation.setFrontMarginWidth(fireRecommendationRestDTO.getFrontMarginWidth());
			}
			else
			{
				String frontMarginWidth = "frontMarginWidth field is Required";
				condition = false;
				message.append(frontMarginWidth).append(",");
			}
			
			if(fireRecommendationRestDTO.getRealMargin()!=null && !fireRecommendationRestDTO.getRealMargin().isEmpty()) {
				fireRecommendation.setRealMargin(fireRecommendationRestDTO.getRealMargin());
			}
			else
			{
				String realMargin = "realMargin field is Required";
				condition = false;
				message.append(realMargin).append(",");
			}
			
			if(fireRecommendationRestDTO.getSideMargine()!=null && !fireRecommendationRestDTO.getSideMargine().isEmpty()) {
				fireRecommendation.setSideMargine(fireRecommendationRestDTO.getSideMargine());
			}
			else
			{
				String sideMargine = "sideMargine field is Required";
				condition = false;
				message.append(sideMargine).append(",");
			}
			
			if(fireRecommendationRestDTO.getSideMargineTwo()!=null && !fireRecommendationRestDTO.getSideMargineTwo().isEmpty()) {
				fireRecommendation.setSideMargineTwo(fireRecommendationRestDTO.getSideMargineTwo());
			}
			else
			{
				String sideMargineTwo = "sideMargineTwo field is Required";
				condition = false;
				message.append(sideMargineTwo).append(",");
			}
			
			if(fireRecommendationRestDTO.getWidthOfEntrance()!=null && !fireRecommendationRestDTO.getWidthOfEntrance().isEmpty()) {
				fireRecommendation.setWidthOfEntrance(fireRecommendationRestDTO.getWidthOfEntrance());
			}
			else
			{
				String widthOfEntrance = "widthOfEntrance field is Required";
				condition = false;
				message.append(widthOfEntrance).append(",");
			}
			//
			if(fireRecommendationRestDTO.getAreaOfBasement()!=null && !fireRecommendationRestDTO.getAreaOfBasement().isEmpty()) {
				fireRecommendation.setAreaOfBasement(fireRecommendationRestDTO.getAreaOfBasement());
			}
			else
			{
				String areaOfBasement = "areaOfBasement field is Required";
				condition = false;
				message.append(areaOfBasement).append(",");
			}
			
			if(fireRecommendationRestDTO.getCapacityOfUnderGroundTank()!=null && !fireRecommendationRestDTO.getCapacityOfUnderGroundTank().isEmpty()) {
				fireRecommendation.setCapacityOfUnderGroundTank(fireRecommendationRestDTO.getCapacityOfUnderGroundTank());
			}
			else
			{
				String capacityOfUnderGroundTank = "capacityOfUnderGroundTank field is Required";
				condition = false;
				message.append(capacityOfUnderGroundTank).append(",");
			}
			
			if(fireRecommendationRestDTO.getCapacityOFOverHeadTank()!=null && !fireRecommendationRestDTO.getCapacityOFOverHeadTank().isEmpty()) {
				fireRecommendation.setCapacityOFOverHeadTank(fireRecommendationRestDTO.getCapacityOFOverHeadTank());
			}
			else
			{
				String capacityOFOverHeadTank = "capacityOFOverHeadTank field is Required";
				condition = false;
				message.append(capacityOFOverHeadTank).append(",");
			}
			
			if(fireRecommendationRestDTO.getLocationOfTransferRoom()!=null && !fireRecommendationRestDTO.getLocationOfTransferRoom().isEmpty()) {
				fireRecommendation.setLocationOfTransferRoom(fireRecommendationRestDTO.getLocationOfTransferRoom());
			}
			else
			{
				String locationOfTransferRoom = "locationOfTransferRoom field is Required";
				condition = false;
				message.append(locationOfTransferRoom).append(",");
			}
			
			if(fireRecommendationRestDTO.getAcPlant()!=null && !fireRecommendationRestDTO.getAcPlant().isEmpty()) {
				fireRecommendation.setAcPlant(fireRecommendationRestDTO.getAcPlant());
			}
			else
			{
				String acPlant = "acPlant field is Required";
				condition = false;
				message.append(acPlant).append(",");
			}
			
			if(fireRecommendationRestDTO.getFireFightingSystemNBC()!=null && !fireRecommendationRestDTO.getFireFightingSystemNBC().isEmpty()) {
				fireRecommendation.setFireFightingSystemNBC(fireRecommendationRestDTO.getFireFightingSystemNBC());
			}
			else
			{
				String fireFightingSystemNBC = "fireFightingSystemNBC field is Required";
				condition = false;
				message.append(fireFightingSystemNBC).append(",");
			}
			
			if(fireRecommendationRestDTO.getEast()!=null && !fireRecommendationRestDTO.getEast().isEmpty()) {
				fireRecommendation.setEast(fireRecommendationRestDTO.getEast());
			}
			else
			{
				String east = "east field is Required";
				condition = false;
				message.append(east).append(",");
			}
			
			if(fireRecommendationRestDTO.getWest()!=null && !fireRecommendationRestDTO.getWest().isEmpty()) {
				fireRecommendation.setWest(fireRecommendationRestDTO.getWest());
			}
			else
			{
				String west = "west field is Required";
				condition = false;
				message.append(west).append(",");
			}
			
			if(fireRecommendationRestDTO.getNorth()!=null && !fireRecommendationRestDTO.getNorth().isEmpty()) {
				fireRecommendation.setNorth(fireRecommendationRestDTO.getNorth());
			}
			else
			{
				String north = "north field is Required";
				condition = false;
				message.append(north).append(",");
			}
			
			if(fireRecommendationRestDTO.getSouth()!=null && !fireRecommendationRestDTO.getSouth().isEmpty()) {
				fireRecommendation.setSouth(fireRecommendationRestDTO.getSouth());
			}
			else
			{
				String south = "south field is Required";
				condition = false;
				message.append(south).append(",");
			}
			
			
			if(fireRecommendationRestDTO.getElectricPump()!=null && !fireRecommendationRestDTO.getElectricPump().isEmpty()) {
				fireRecommendation.setElectricPump(fireRecommendationRestDTO.getElectricPump());
			}
			else
			{
				String electricPump = "electricPump field is Required";
				condition = false;
				message.append(electricPump).append(",");
			}
			
			if(fireRecommendationRestDTO.getElectricPumpCapacity()!=null && !fireRecommendationRestDTO.getElectricPumpCapacity().isEmpty()) {
				fireRecommendation.setElectricPumpCapacity(fireRecommendationRestDTO.getElectricPumpCapacity());
			}
			else
			{
				String electricPumpCapacity = "electricPumpCapacity field is Required";
				condition = false;
				message.append(electricPumpCapacity).append(",");
			}
			
			if(fireRecommendationRestDTO.getDieselPump()!=null && !fireRecommendationRestDTO.getDieselPump().isEmpty()) {
				fireRecommendation.setDieselPump(fireRecommendationRestDTO.getDieselPump());
			}
			else
			{
				String dieselPump = "dieselPump field is Required";
				condition = false;
				message.append(dieselPump).append(",");
			}
			
			if(fireRecommendationRestDTO.getDieselPumpCapacity()!=null && !fireRecommendationRestDTO.getDieselPumpCapacity().isEmpty()) {
				fireRecommendation.setDieselPumpCapacity(fireRecommendationRestDTO.getDieselPumpCapacity());
			}
			else
			{
				String dieselPumpCapacity = "dieselPumpCapacity field is Required";
				condition = false;
				message.append(dieselPumpCapacity).append(",");
			}
			
			if(fireRecommendationRestDTO.getJockyPump()!=null && !fireRecommendationRestDTO.getJockyPump().isEmpty()) {
				fireRecommendation.setJockyPump(fireRecommendationRestDTO.getJockyPump());
			}
			else
			{
				String jockyPump = "jockyPump field is Required";
				condition = false;
				message.append(jockyPump).append(",");
			}
			
			if(fireRecommendationRestDTO.getJockyPumpCapacity()!=null && !fireRecommendationRestDTO.getJockyPumpCapacity().isEmpty()) {
				fireRecommendation.setJockyPumpCapacity(fireRecommendationRestDTO.getJockyPumpCapacity());
			}
			else
			{
				String jockyPumpCapacity = "jockyPumpCapacity field is Required";
				condition = false;
				message.append(jockyPumpCapacity).append(",");
			}
			
			
			if(fireRecommendationRestDTO.getBoosterPump()!=null && !fireRecommendationRestDTO.getBoosterPump().isEmpty()) {
				fireRecommendation.setBoosterPump(fireRecommendationRestDTO.getBoosterPump());
			}
			else
			{
				String boosterPump = "boosterPump field is Required";
				condition = false;
				message.append(boosterPump).append(",");
			}
			
			//
			if(fireRecommendationRestDTO.getBoosterPumpCapacity()!=null && !fireRecommendationRestDTO.getBoosterPumpCapacity().isEmpty()) {
				fireRecommendation.setBoosterPumpCapacity(fireRecommendationRestDTO.getBoosterPumpCapacity());
			}
			else
			{
				String boosterPumpCapacity = "boosterPumpCapacity field is Required";
				condition = false;
				message.append(boosterPumpCapacity).append(",");
			}
			
			if(fireRecommendationRestDTO.getNumInternalStaircaseProvided()!=null && !fireRecommendationRestDTO.getNumInternalStaircaseProvided().isEmpty()) {
				fireRecommendation.setNumInternalStaircaseProvided(fireRecommendationRestDTO.getNumInternalStaircaseProvided());
			}
			else
			{
				String numInternalStaircaseProvided = "numInternalStaircaseProvided field is Required";
				condition = false;
				message.append(numInternalStaircaseProvided).append(",");
			}
			
			if(fireRecommendationRestDTO.getNumberOfExternal()!=null && !fireRecommendationRestDTO.getNumberOfExternal().isEmpty()) {
				fireRecommendation.setNumberOfExternal(fireRecommendationRestDTO.getNumberOfExternal());
			}
			else
			{
				String numberOfExternal = "numberOfExternal field is Required";
				condition = false;
				message.append(numberOfExternal).append(",");
			}
			
			if(fireRecommendationRestDTO.getNoLift()!=null && !fireRecommendationRestDTO.getNoLift().isEmpty()) {
				fireRecommendation.setNoLift(fireRecommendationRestDTO.getNoLift());
			}
			else
			{
				String noLift = "noLift field is Required";
				condition = false;
				message.append(noLift).append(",");
			}
			
			if(fireRecommendationRestDTO.getFireDepartmentWiseLogin()!=null && !fireRecommendationRestDTO.getFireDepartmentWiseLogin().isEmpty()) {
				fireRecommendation.setFireDepartmentWiseLogin(fireRecommendationRestDTO.getFireDepartmentWiseLogin());
			}
			else
			{
				String fireDepartmentWiseLogin = "fireDepartmentWiseLogin field is Required";
				condition = false;
				message.append(fireDepartmentWiseLogin).append(",");
			}
			
			if(fireRecommendationRestDTO.getFireSubDepartmentWiseLogin()!=null && !fireRecommendationRestDTO.getFireSubDepartmentWiseLogin().isEmpty()) {
				fireRecommendation.setFireSubDepartmentWiseLogin(fireRecommendationRestDTO.getFireSubDepartmentWiseLogin());
			}
			else
			{
				String fireSubDepartmentWiseLogin = "fireSubDepartmentWiseLogin field is Required";
				condition = false;
				message.append(fireSubDepartmentWiseLogin).append(",");
			}
			
		
			 // === Table Data Validation ===
			List<FireDetailsRestDTO> floorDetails = fireRecommendationRestDTO.getTableData();
			List<FireDetails> fireDetailsEntities = new ArrayList<>();

			if (floorDetails == null || floorDetails.isEmpty()) {
			    condition = false;
			    message.append("At least one floor detail is required.");
			} else {
			    for (int i = 0; i < floorDetails.size(); i++) {
			        FireDetailsRestDTO detail = floorDetails.get(i);
			        boolean rowValid = true;

			        if (detail.getFloorName() == null || detail.getFloorName().isEmpty()) {
			            message.append("floorName is required at row ").append(i + 1).append(", ");
			            condition = false;
			            rowValid = false;
			        }
			        if (detail.getFireFloorType() == null || detail.getFireFloorType().isEmpty()) {
			            message.append("fireFloorType is required at row ").append(i + 1).append(", ");
			            condition = false;
			            rowValid = false;
			        }
//			        if (detail.getResidArea() == null || detail.getResidArea().isEmpty()) {
//			            message.append("residArea is required at row ").append(i + 1).append(", ");
//			            condition = false;
//			            rowValid = false;
//			        }
//			        if (detail.getPrimumAr() == null || detail.getPrimumAr().isEmpty()) {
//			            message.append("primumAr is required at row ").append(i + 1).append(", ");
//			            condition = false;
//			            rowValid = false;
//			        }
//			        if (detail.getCommArea() == null || detail.getCommArea().isEmpty()) {
//			            message.append("commArea is required at row ").append(i + 1).append(", ");
//			            condition = false;
//			            rowValid = false;
//			        }
//			        if (detail.getOtherUse() == null || detail.getOtherUse().isEmpty()) {
//			            message.append("otherUse is required at row ").append(i + 1).append(", ");
//			            condition = false;
//			            rowValid = false;
//			        }
//			        if (detail.getTotalFees() == null || detail.getTotalFees().isEmpty()) {
//			            message.append("totalFees is required at row ").append(i + 1).append(", ");
//			            condition = false;
//			            rowValid = false;
//			        }

			        if (detail.getResidArea() == null) {
			            message.append("residArea is required at row ").append(i + 1).append(", ");
			            condition = false;
			            rowValid = false;
			        }
			        	
			        if (detail.getPrimumAr() == null) {
			            message.append("primumAr is required at row ").append(i + 1).append(", ");
			            condition = false;
			            rowValid = false;
			        }
			        if (detail.getCommArea() == null) {
			            message.append("commArea is required at row ").append(i + 1).append(", ");
			            condition = false;
			            rowValid = false;
			        }
			        if (detail.getOtherUse() == null) {
			            message.append("otherUse is required at row ").append(i + 1).append(", ");
			            condition = false;
			            rowValid = false;
			        }
			        if (detail.getTotalFees() == null) {
			            message.append("totalFees is required at row ").append(i + 1).append(", ");
			            condition = false;
			            rowValid = false;
			        }
			        // Convert only if all required fields are present
			        if (rowValid) {
			            FireDetails entity = new FireDetails();
			            entity.setFloorName(detail.getFloorName());
			            entity.setFireFloorTypes(detail.getFireFloorType());
			            entity.setResidArea(detail.getResidArea());
			            entity.setPrimumAr(detail.getPrimumAr());
			            entity.setCommArea(detail.getCommArea());
			            entity.setOtherUse(detail.getOtherUse());
			            entity.setTotalTable(detail.getTotalFees());

			            // Set parent reference (VERY IMPORTANT)
			            entity.setFireRecommendation(fireRecommendation);

			            fireDetailsEntities.add(entity);
			        }
			    }

			    // Finally, set to parent entity
			    fireRecommendation.setFireDetails(fireDetailsEntities);
			}

			if(fireRecommendationRestDTO.getWidthInternalStaircaseProvided()!=null && !fireRecommendationRestDTO.getWidthInternalStaircaseProvided().isEmpty()) {
				fireRecommendation.setWidthInternalStaircaseProvided(fireRecommendationRestDTO.getWidthInternalStaircaseProvided());
			}
			else
			{
				String widthInternalStaircaseProvided = "widthInternalStaircaseProvided field is Required";
				condition = false;
				message.append(widthInternalStaircaseProvided).append(",");
			}
			
			if(fireRecommendationRestDTO.getFromInternalStaricase()!=null && !fireRecommendationRestDTO.getFromInternalStaricase().isEmpty()) {
				fireRecommendation.setFromInternalStaricase(fireRecommendationRestDTO.getFromInternalStaricase());
			}
			else
			{
				String fromInternalStaricase = "fromInternalStaricase field is Required";
				condition = false;
				message.append(fromInternalStaricase).append(",");
			}
			
			if(fireRecommendationRestDTO.getWidthOfExternal()!=null && !fireRecommendationRestDTO.getWidthOfExternal().isEmpty()) {
				fireRecommendation.setWidthOfExternal(fireRecommendationRestDTO.getWidthOfExternal());
			}
			else
			{
				String widthOfExternal = "widthOfExternal field is Required";
				condition = false;
				message.append(widthOfExternal).append(",");
			}
			
			if(fireRecommendationRestDTO.getFromExternalStaricase()!=null && !fireRecommendationRestDTO.getFromExternalStaricase().isEmpty()) {
				fireRecommendation.setFromExternalStaricase(fireRecommendationRestDTO.getFromExternalStaricase());
			}
			else
			{
				String fromExternalStaricase = "fromExternalStaricase field is Required";
				condition = false;
				message.append(fromExternalStaricase).append(",");
			}
			
			if(fireRecommendationRestDTO.getNoLiftType()!=null && !fireRecommendationRestDTO.getNoLiftType().isEmpty()) {
				fireRecommendation.setTypeOfLift(fireRecommendationRestDTO.getNoLiftType());
			}
			else
			{
				String noLiftType = "noLiftType field is Required";
				condition = false;
				message.append(noLiftType).append(",");
			}
			
			//Files
			if (fireRecommendationRestDTO.getFormPCertificatePdf() != null
					&& !fireRecommendationRestDTO.getFormPCertificatePdf()
							.isEmpty()) {
				String doc1 = fireRecommendationRestDTO
						.getFormPCertificatePdf();

				files[0] = doc1;
			} else {
				String doc1 = "formPCertificatePdf field is Required";
				condition = false;
				message.append(doc1).append(",");
			}
			
			if (fireRecommendationRestDTO.getNmcTaxReciptPdf() != null
					&& !fireRecommendationRestDTO.getNmcTaxReciptPdf()
							.isEmpty()) {
				String doc2 = fireRecommendationRestDTO
						.getNmcTaxReciptPdf();

				files[1] = doc2;
			} else {
				String doc2 = "nmcTaxReciptPdf field is Required";
				condition = false;
				message.append(doc2).append(",");
			}
			
			if (fireRecommendationRestDTO.getCoveringLetterPdf() != null
					&& !fireRecommendationRestDTO.getCoveringLetterPdf()
							.isEmpty()) {
				String doc3 = fireRecommendationRestDTO
						.getCoveringLetterPdf();

				files[2] = doc3;
			} else {
				String doc3 = "coveringLetterPdf  field is Required";
				condition = false;
				message.append(doc3).append(",");
			}
			
			if (fireRecommendationRestDTO.getBuildingPlanPdf() != null
					&& !fireRecommendationRestDTO.getBuildingPlanPdf()
							.isEmpty()) {
				String doc4 = fireRecommendationRestDTO
						.getBuildingPlanPdf();

				files[3] = doc4;
			} else {
				String doc4 = "buildingPlanPdf  field is Required";
				condition = false;
				message.append(doc4).append(",");
			}
			
			// Save FilesPath
						String savedFilePath = MandapCertificateRestController
								.saveFile(files, request);

//			UserRegistrationDetails user = new UserRegistrationDetails();
//			user.setMobileNo(fireRecommendationRestDTO.getApplicantmobileno());

			RTIApplication rtiApplication = new RTIApplication();
//			MandapPermissionRestDTO mandapPermissionRestDTO = new MandapPermissionRestDTO();
			if (fireRecommendationRestDTO.getUserMobileNumber() != 0) {
				rtiApplication.setMobileAppUserNumber(String.valueOf(
						fireRecommendationRestDTO.getUserMobileNumber()));
			} else {
				String userMobilenumber = "userMobilenumber field is Required";
				condition = false;
				message.append(userMobilenumber).append(",");
			}

			if(condition) {
				HttpSession session = request.getSession(true);
				SessionUser sessionUser = (SessionUser) session.getAttribute("SessionUser");

				UserRegistrationDetails user = userService.getUserByMobileNo(String.valueOf(fireRecommendationRestDTO.getUserMobileNumber()));
				Object as_status=session.getAttribute("as_status");

			rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
			rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
			rtiApplication.setSubject("FIRE-Recommendation");
			rtiApplication.setTemplateName("fireRecommendation");
			rtiApplication.setDepartment("FIRE-DEPARTMENT");
			rtiApplication.setTemplateName("fire");	
			rtiApplication.setWorkFlowStatus(0);
			rtiApplication.setFinalStatus("0");
			rtiApplication.setRtiserviceid(69);
			//rtiApplication.setUserRegistrationDetails(user);
			rtiApplication.setFirstPaymentFees(fireRecommendation.getScrutinyFeesOnAboveTotal());
			rtiApplication.setApplicantName(fireRecommendation.getFirstName() + " " + fireRecommendation.getMiddleName()
					+ " " + fireRecommendation.getLastName());
			rtiApplication.setPhoneNumber(fireRecommendation.getMobileNo());
			rtiApplication.setMobileNumber(fireRecommendation.getMobileNo());
			if(fireRecommendation.getFireSubDepartmentWiseLogin().equals("2")||fireRecommendation.getFireSubDepartmentWiseLogin().equals("3"))
			{
				rtiApplication.setZone("10");
			}
			else
			{
				rtiApplication.setZone(fireRecommendation.getFireDepartmentWiseLogin());
			}
			rtiApplication.setEmail(fireRecommendation.getAppEmail());
//			rtiApplication.setZone(fireRecommendation.getZoneNO());
			rtiApplication.setUserRegistrationDetails(user);			
			rtiApplication.setEmail(fireRecommendation.getAppEmail());
			rtiApplication.setZone(fireRecommendation.getZoneNO());

			//rtiApplication.setApplicationCost(fireRecommendation.getFees());

			rtiApplication.setApplicantName(fireRecommendation.getFullName());
			rtiApplication.setPdfUploadFromPortal(savedFilePath);
			List<RTIApplicationDetails> rtiApplicationDetailsList = new ArrayList<RTIApplicationDetails>();
			RTIApplicationDetails rtiApplicationDetails = new RTIApplicationDetails();

			rtiApplicationDetails.setRtiApplication(rtiApplication);
			rtiApplicationDetails.setStatus(0);
			rtiApplicationDetails.setAssignToStatus(1);
			rtiApplicationDetails.setAssignedStartDate(rtiApplication.getCreatedDate());
			rtiApplicationDetails.setAssignedEndDate(CommonUtils.getCurrentStringDateAndTime());

			rtiApplicationDetails.setComments("Form Submitted");// ();
			rtiApplicationDetails.setWorkflowLevel(0);
			rtiApplicationDetailsList.add(rtiApplicationDetails);
			rtiApplication.setRtiApplicationDetails(rtiApplicationDetailsList);
			RTIApplication savedRti = rtiApplicationService.merge(rtiApplication);
			
			if (savedRti.getRtiApplicationId() > 0) {
				
				RTIApplication rti = rtiApplicationService.get(savedRti.getRtiApplicationId());
				rti.setRtiApplnNumber("RTS/FD"+"/"+Year.now()+"/" + savedRti.getRtiApplicationId());
				fireRecommendation.setRtiapplrefno(rti.getRtiApplnNumber());
				fireRecommendation.setRti_ref_id(savedRti.getRtiApplicationId());
				long fire_regis_id = fireRecommendationService.fireRecommendation(fireRecommendation);
				fireRecommendation.setFireRecommendationId(fire_regis_id);
				rti.setRtiApplicationRefId(fire_regis_id);
				// rti.setRtiApplicationRefId(birthRegistrationService.);
	

		        RTIApplication retunRti = rtiApplicationService.merge(rti);
	              fireRecommendationService.saveFireForm(fireRecommendation);
					rtiApplicationService.save(savedRti);


				if ((retunRti != null) && (fire_regis_id > 0)) {
					fireRecommendationRestDTO.setResponseStatus("Requested data saved successfully");
					fireRecommendationRestDTO.setResponseCode(200);
					fireRecommendationRestDTO.setResult(retunRti.getRtiApplnNumber());
					fireRecommendationRestDTO.setStatus("ok");
					reponse.setStatus(HttpStatus.OK.value());
					
					fireRecommendationRestDTO.setFormPCertificatePdf("");
					fireRecommendationRestDTO.setNmcTaxReciptPdf("");
					fireRecommendationRestDTO.setCoveringLetterPdf("");
					fireRecommendationRestDTO.setBuildingPlanPdf("");
				}
				String name = fireRecommendation.getFullName();
				String applnNo = retunRti.getRtiApplnNumber();
               String mobileNo = retunRti.getPhoneNumber();
               String email = retunRti.getEmail();
				SendSMSEmailController.sendApplicationSubmitted(name, mobileNo, applnNo, email);

			}
		}
			if (!condition) {
				if (message.charAt(message.length() - 1) == ',') {
						message.deleteCharAt(message.length() - 1);
						fireRecommendationRestDTO.setResult(message.toString());
						fireRecommendationRestDTO.setResponseStatus("Requested data not saved successfully");
						fireRecommendationRestDTO.setResponseCode(500);
						reponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
						fireRecommendationRestDTO.setStatus("Internal Server Error");
											
						fireRecommendationRestDTO.setFormPCertificatePdf("");
						fireRecommendationRestDTO.setNmcTaxReciptPdf("");
						fireRecommendationRestDTO.setCoveringLetterPdf("");
						fireRecommendationRestDTO.setBuildingPlanPdf("");

					}
				}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.equals(ex.getMessage());
			fireRecommendationRestDTO.setResponseStatus(ex.getMessage());
			fireRecommendationRestDTO.setResponseCode(405);
			reponse.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
			fireRecommendationRestDTO.setStatus("Method not Allowed");
			
			fireRecommendationRestDTO.setFormPCertificatePdf("");
			fireRecommendationRestDTO.setNmcTaxReciptPdf("");
			fireRecommendationRestDTO.setCoveringLetterPdf("");
			fireRecommendationRestDTO.setBuildingPlanPdf("");
		}


		return fireRecommendationRestDTO; 
	}

	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "fireRecommendation";
		File file = new File(baseDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		if (data != null) {
			for (String element : data) {
				if (element != null) {
					byte[] pdfBytes = Base64.getDecoder().decode(element);
					String fileName;
					String uniqueFileName = UUID.randomUUID().toString().substring(0, 8) + ".pdf";
					int l = uniqueFileName.lastIndexOf(".");
					String imageext = uniqueFileName.substring(l, uniqueFileName.length());
					fileName = uniqueFileName.substring(0, l);
					fileName = fileName.replaceAll("[^a-zA-Z0-9]", "");
					fileName = fileName.replaceAll("\\W", "");
					fileName = fileName + "" + imageext;
					File storeFile = new File(baseDir, fileName);
					try (FileOutputStream outputStream = new FileOutputStream(storeFile)) {
						outputStream.write(pdfBytes);
						outputStream.flush();
						outputStream.close();
					}
					filesPath = baseDir + File.separator + fileName;
					filesPathBuilder.append(filesPath).append(",");
				} else {
					filesPathBuilder.append("null").append(",");

				}
			}
		} else {
			filesPathBuilder.append("null").append(",");
		}
		if (filesPathBuilder != null) {
			if (filesPathBuilder.charAt(filesPathBuilder.length() - 1) == ',') {
				filesPathBuilder.deleteCharAt(filesPathBuilder.length() - 1);
			}
			filesPath = filesPathBuilder.toString();
		}
		return filesPath;
	}
}
