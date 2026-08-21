
package com.mars.rti.ws.controller;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mars.common.utils.CommonUtils;
import com.mars.common.utils.SendEmail;
import com.mars.common.utils.SendSMS;
import com.mars.rti.model.FireComplianceCertificate;
import com.mars.rti.model.RTIApplication;
import com.mars.rti.model.RTIApplicationDetails;
import com.mars.rti.service.FireComplianceCertificateService;
import com.mars.rti.service.RTIApplicationService;
import com.mars.rti.utils.CoreConstants;
import com.mars.rti.ws.model.FireCompilancecertifcateRestDTO;

@Controller
public class FireCompilancecertifcateRestController {
	private static Log log = LogFactory.getLog(FireCompilancecertifcateRestController.class);
	@Autowired
	private RTIApplicationService rtiApplicationService;

	@Autowired
	private FireComplianceCertificateService  tradeLicenseTransferService;

	@RequestMapping(method = RequestMethod.POST, value = "/saveFireCompliance")
	public @ResponseBody FireCompilancecertifcateRestDTO saveFireCompliance(
			@RequestBody FireCompilancecertifcateRestDTO FireCompilancecertifcateRestDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		boolean condition = true;
		StringBuilder message = new StringBuilder();
		String[] files = new String[8];
		if (log.isDebugEnabled()) {
			log.debug("Invoking saveTradeRenewal");
			FireComplianceCertificate tradeLicenceTransfer = new FireComplianceCertificate();

			try {

				if ((FireCompilancecertifcateRestDTO.getFirstName() != null)
						&& !FireCompilancecertifcateRestDTO.getFirstName().isEmpty()) {
					tradeLicenceTransfer.setFirstName(FireCompilancecertifcateRestDTO.getFirstName());
				} else {
					String firstName = "Name field is Required";
					condition = false;
					message.append(firstName).append(",");
				}
				if ((FireCompilancecertifcateRestDTO.getTitle() != null)
						&& !FireCompilancecertifcateRestDTO.getTitle().isEmpty()) {
					tradeLicenceTransfer.setTitle(FireCompilancecertifcateRestDTO.getTitle());
				} else {
					String Title = "Title field is Required";
					condition = false;
					message.append(Title).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getLastName() != null)
						&& !FireCompilancecertifcateRestDTO.getLastName().isEmpty()) {
					tradeLicenceTransfer.setLastName(FireCompilancecertifcateRestDTO.getLastName());
				} else {
					String LastName = "LastName field is Required";
					condition = false;
					message.append(LastName).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getFullName() != null)
						&& !FireCompilancecertifcateRestDTO.getFullName().isEmpty()) {
					tradeLicenceTransfer.setFullName(FireCompilancecertifcateRestDTO.getFullName());
				} else {
					String FullName = "FullName field is Required";
					condition = false;
					message.append(FullName).append(",");
				}

				if (FireCompilancecertifcateRestDTO.getPlotno() != null
						&& !FireCompilancecertifcateRestDTO.getPlotno().isEmpty()) {
					tradeLicenceTransfer.setPlotno(FireCompilancecertifcateRestDTO.getPlotno());
				} else {
					String ApplicantPinCode = "Plot/ Flat No field is Required";
					condition = false;
					message.append(ApplicantPinCode).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getCitysurveyno() != null
						&& !FireCompilancecertifcateRestDTO.getCitysurveyno().isEmpty()) {
					tradeLicenceTransfer.setCitysurveyno(FireCompilancecertifcateRestDTO.getCitysurveyno());
				} else {
					String Citysurveyno = "City Survey No field is Required";
					condition = false;
					message.append(Citysurveyno).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getStrretname() != null
						&& !FireCompilancecertifcateRestDTO.getStrretname().isEmpty()) {
					tradeLicenceTransfer.setStrretname(FireCompilancecertifcateRestDTO.getStrretname());
				} else {
					String Strretname = "Name of the Street field is Required";
					condition = false;
					message.append(Strretname).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getHousemouzano() != null
						&& !FireCompilancecertifcateRestDTO.getHousemouzano().isEmpty()) {
					tradeLicenceTransfer.setHousemouzano(FireCompilancecertifcateRestDTO.getHousemouzano());
				} else {
					String Housemouzano = "House Mouza No field is Required";
					condition = false;
					message.append(Housemouzano).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getPincode() != 0) {
					tradeLicenceTransfer.setPincode(FireCompilancecertifcateRestDTO.getPincode());
				} else {
					String Pincode = "PinCode. field is Required";
					condition = false;
					message.append(Pincode).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getLandmark() != null
						&& !FireCompilancecertifcateRestDTO.getLandmark().isEmpty()) {
					tradeLicenceTransfer.setLandmark(FireCompilancecertifcateRestDTO.getLandmark());
				} else {
					String Landmark = "Landmark field is Required";
					condition = false;
					message.append(Landmark).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getEmailid() != null
						&& !FireCompilancecertifcateRestDTO.getEmailid().isEmpty()) {
					tradeLicenceTransfer.setEmailid(FireCompilancecertifcateRestDTO.getEmailid());
				} else {
					String Email = "Email Id field is Required";
					condition = false;
					message.append(Email).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getMobileno() != 0) {

					tradeLicenceTransfer.setMobileno(String.valueOf(FireCompilancecertifcateRestDTO.getMobileno()));
				} else {
					String phoneNo = "PhoneNo. field is Required";
					condition = false;
					message.append(phoneNo).append(",");

				}

				if ((FireCompilancecertifcateRestDTO.getNameofpowerofattorney() != null)
						&& !FireCompilancecertifcateRestDTO.getNameofpowerofattorney().isEmpty()) {
					tradeLicenceTransfer.setNameofpowerofattorney(FireCompilancecertifcateRestDTO.getNameofpowerofattorney());
				} else {
					String Nameaofpower = "Name of Power of Attorney  field is Required";
					condition = false;
					message.append(Nameaofpower).append(",");
				}

				if (FireCompilancecertifcateRestDTO.getNoofstandby() != 0) {

					tradeLicenceTransfer.setNoofstandby(String.valueOf(FireCompilancecertifcateRestDTO.getNoofstandby()));
				} else {
					String Noofstandby = "No.of standby field is Required";
					condition = false;
					message.append(Noofstandby).append(",");

				}

				if ((FireCompilancecertifcateRestDTO.getAddressofpowerofattorney() != null)
						&& !FireCompilancecertifcateRestDTO.getAddressofpowerofattorney() .isEmpty()) {
					tradeLicenceTransfer.setAddressofpowerofattorney(FireCompilancecertifcateRestDTO.getAddressofpowerofattorney() );
				} else {
					String Address = "Address field is Required";
					condition = false;
					message.append(Address).append(",");
				}
				if (FireCompilancecertifcateRestDTO.getZoneno() != 0) {
					tradeLicenceTransfer.setZoneno(FireCompilancecertifcateRestDTO.getZoneno());
				} else {
					String zone = "ZonNo. field is Required";
					condition = false;
					message.append(zone).append(",");
				}

				if (FireCompilancecertifcateRestDTO.getPermitno() != null
						&& !FireCompilancecertifcateRestDTO.getPermitno().isEmpty()) {

					tradeLicenceTransfer.setPermitno(FireCompilancecertifcateRestDTO.getPermitno());
				} else {
					String Permitno = "Permit No field is Required";
					condition = false;
					message.append(Permitno).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getPermitnodate() != null
						&& !FireCompilancecertifcateRestDTO.getPermitnodate().isEmpty()) {

					tradeLicenceTransfer.setPermitnodate(FireCompilancecertifcateRestDTO.getPermitnodate());
				} else {
					String Permitnodate = "Date  field is Required";
					condition = false;
					message.append(Permitnodate).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getFirerecommendationno() != null
						&& !FireCompilancecertifcateRestDTO.getFirerecommendationno().isEmpty()) {

					tradeLicenceTransfer
							.setFirerecommendationno(FireCompilancecertifcateRestDTO.getFirerecommendationno());
				} else {
					String Firerecommendationno = "Fire Recommendation Letter No field is Required";
					condition = false;
					message.append(Firerecommendationno).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getFirerecommendationnodate() != null
						&& !FireCompilancecertifcateRestDTO.getFirerecommendationnodate().isEmpty()) {

					tradeLicenceTransfer
							.setFirerecommendationnodate(FireCompilancecertifcateRestDTO.getFirerecommendationnodate());
				} else {
					String Firerecommendationnodate = "Date field is Required";
					condition = false;
					message.append(Firerecommendationnodate).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getReceiptno() != null
						&& !FireCompilancecertifcateRestDTO.getReceiptno().isEmpty()) {

					tradeLicenceTransfer.setReceiptno(FireCompilancecertifcateRestDTO.getReceiptno());
				} else {
					String Receiptno = "Receipt No field is Required";
					condition = false;
					message.append(Receiptno).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getReceiptnodate() != null
						&& !FireCompilancecertifcateRestDTO.getReceiptnodate().isEmpty()) {

					tradeLicenceTransfer
							.setReceiptnodate(FireCompilancecertifcateRestDTO.getReceiptnodate());
				} else {
					String Receiptnodate = "Date field is Required";
					condition = false;
					message.append(Receiptnodate).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getBuildingname() != null
						&& !FireCompilancecertifcateRestDTO.getBuildingname().isEmpty()) {

					tradeLicenceTransfer.setBuildingname(FireCompilancecertifcateRestDTO.getBuildingname());
				} else {
					String Buildingname = "Name of Building field is Required";
					condition = false;
					message.append(Buildingname).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getNameaddresspromoter() != null
						&& !FireCompilancecertifcateRestDTO.getNameaddresspromoter().isEmpty()) {

					tradeLicenceTransfer
							.setNameaddresspromoter(FireCompilancecertifcateRestDTO.getNameaddresspromoter());
				} else {
					String Nameaddresspromoter = "Name & Address of Building /promoter field is Required";
					condition = false;
					message.append(Nameaddresspromoter).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getNameaddressowner() != null
						&& !FireCompilancecertifcateRestDTO.getNameaddressowner().isEmpty()) {

					tradeLicenceTransfer
							.setNameaddressowner(FireCompilancecertifcateRestDTO.getNameaddressowner());
				} else {
					String Nameaddressowner = "Name & Address of Building/Promoter/Owner/Occupiers of individual flats field is Required";
					condition = false;
					message.append(Nameaddressowner).append(",");

				}

				
				
				if (FireCompilancecertifcateRestDTO.getNameaddress() != null
						&& !FireCompilancecertifcateRestDTO.getNameaddress().isEmpty()) {

					tradeLicenceTransfer
							.setNameaddress(FireCompilancecertifcateRestDTO.getNameaddress());
				} else {
					String NameaddressBuilding = "Address of Building field is Required";
					condition = false;
					message.append(NameaddressBuilding).append(",");

				}
				
				
				if (FireCompilancecertifcateRestDTO.getBasementextends() != null
						&& !FireCompilancecertifcateRestDTO.getBasementextends().isEmpty()) {

					tradeLicenceTransfer
							.setBasementextends(FireCompilancecertifcateRestDTO.getBasementextends());
				} else {
					String Basementextends= "basement extends beyond the building line field is Required";
					condition = false;
					message.append(Basementextends).append(",");

				}
				
				
				
				if (FireCompilancecertifcateRestDTO.getTypeofoccupancy() != null
						&& !FireCompilancecertifcateRestDTO.getTypeofoccupancy().isEmpty()) {

					tradeLicenceTransfer
							.setTypeofoccupancy(FireCompilancecertifcateRestDTO.getTypeofoccupancy());
				} else {
					String Typeofoccupancy = "Type of occupancy  field is Required";
					condition = false;
					message.append(Typeofoccupancy).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getPlotarea() != null
						&& !FireCompilancecertifcateRestDTO.getPlotarea().isEmpty()) {

					tradeLicenceTransfer.setPlotarea(FireCompilancecertifcateRestDTO.getPlotarea());
				} else {
					String Plotarea = "Plot area  field is Required";
					condition = false;
					message.append(Plotarea).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getTotalbuiltuparea() != null
						&& !FireCompilancecertifcateRestDTO.getTotalbuiltuparea().isEmpty()) {

					tradeLicenceTransfer
							.setTotalbuiltuparea(FireCompilancecertifcateRestDTO.getTotalbuiltuparea());
				} else {
					String Totalbuiltuparea = "Total Built up area field is Required";
					condition = false;
					message.append(Totalbuiltuparea).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getHeightofbuilding() != null
						&& !FireCompilancecertifcateRestDTO.getHeightofbuilding().isEmpty()) {

					tradeLicenceTransfer
							.setHeightofbuilding(FireCompilancecertifcateRestDTO.getHeightofbuilding());
				} else {
					String Heightofbuilding = "Height of building  field is Required";
					condition = false;
					message.append(Heightofbuilding).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getFront() != 0) {

					tradeLicenceTransfer.setFront(FireCompilancecertifcateRestDTO.getFront());
				} else {
					String Front = "Side marginal space Front  field is Required";
					condition = false;
					message.append(Front).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getRear() != null&& !FireCompilancecertifcateRestDTO.getRear().isEmpty()) {

					tradeLicenceTransfer.setRear(FireCompilancecertifcateRestDTO.getRear());
				} else {
					String Rear = "Side marginal space Rear field is Required";
					condition = false;
					message.append(Rear).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getSide1() != null&& !FireCompilancecertifcateRestDTO.getSide1().isEmpty()) {

					tradeLicenceTransfer.setSide1(FireCompilancecertifcateRestDTO.getSide1());
				} else {
					String Side1 = "Side marginal space Side1  field is Required";
					condition = false;
					message.append(Side1).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getSide2() != null&& !FireCompilancecertifcateRestDTO.getSide1().isEmpty()) {

					tradeLicenceTransfer.setSide2(FireCompilancecertifcateRestDTO.getSide2());
				} else {
					String phoneNo = "Side marginal space Side2  field is Required";
					condition = false;
					message.append(phoneNo).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getWidthofapproach() != null
						&& !FireCompilancecertifcateRestDTO.getWidthofapproach().isEmpty()) {

					tradeLicenceTransfer
							.setWidthofapproach((FireCompilancecertifcateRestDTO.getWidthofapproach()));
				} else {
					String phoneNo = "Width of approach road to the building premises";
					condition = false;
					message.append(phoneNo).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getWidthofentrance() != null
						&& !FireCompilancecertifcateRestDTO.getWidthofentrance().isEmpty()) {

					tradeLicenceTransfer
							.setWidthofentrance(FireCompilancecertifcateRestDTO.getWidthofentrance());
				} else {
					String phoneNo = "Width of entrance gate  is Required";
					condition = false;
					message.append(phoneNo).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getVerticalclearance() != null
						&& !FireCompilancecertifcateRestDTO.getVerticalclearance().isEmpty()) {

					tradeLicenceTransfer
							.setVerticalclearance(FireCompilancecertifcateRestDTO.getVerticalclearance());
				} else {
					String phoneNo = "Vertical clearance of entrance gate  field is Required";
					condition = false;
					message.append(phoneNo).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getDateofsanctioning() != null
						&& !FireCompilancecertifcateRestDTO.getDateofsanctioning().isEmpty()) {

					tradeLicenceTransfer
							.setDateofsanctioning(FireCompilancecertifcateRestDTO.getDateofsanctioning());
				} else {
					String phoneNo = "Date of sanctioning of building : plan by N.M.C./N.I.T  field is Required";
					condition = false;
					message.append(phoneNo).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getNumberofbasements() != null && !FireCompilancecertifcateRestDTO.getNumberofbasements().isEmpty()) {

					tradeLicenceTransfer
							.setNumberofbasements(FireCompilancecertifcateRestDTO.getNumberofbasements());
				} else {
					String phoneNo = "Number of basements   field is Required";
					condition = false;
					message.append(phoneNo).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getNumberoffloors() != null &&!FireCompilancecertifcateRestDTO.getNumberoffloors().isEmpty()) {


					tradeLicenceTransfer
							.setNumberoffloors(FireCompilancecertifcateRestDTO.getNumberoffloors());
				} else {
					String Numberoffloors = "Number of floors field is Required";
					condition = false;
					message.append(Numberoffloors).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getAreaofbasement() != null
						&& !FireCompilancecertifcateRestDTO.getAreaofbasement().isEmpty()) {

					tradeLicenceTransfer
							.setAreaofbasement(FireCompilancecertifcateRestDTO.getAreaofbasement());
				} else {
					String Areaofbasement = "Area of basement  field is Required";
					condition = false;
					message.append(Areaofbasement).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getCoveredarea() != null
						&& !FireCompilancecertifcateRestDTO.getCoveredarea().isEmpty()) {

					tradeLicenceTransfer.setCoveredarea(FireCompilancecertifcateRestDTO.getCoveredarea());
				} else {
					String Coveredarea = "Covered area of typical floor  field is Required";
					condition = false;
					message.append(Coveredarea).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getCapacity() != null
						&& !FireCompilancecertifcateRestDTO.getCapacity().isEmpty()) {

					tradeLicenceTransfer.setCapacity(FireCompilancecertifcateRestDTO.getCapacity());
				} else {
					String Capacity = "please indicate the load bearing strength of the roof of basement field is Required";
					condition = false;
					message.append(Capacity).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getCapacityofug() != null
						&& !FireCompilancecertifcateRestDTO.getCapacityofug().isEmpty()) {

					tradeLicenceTransfer.setCapacityofug(FireCompilancecertifcateRestDTO.getCapacityofug());
				} else {
					String Capacityofug = "Capacity of U/G tank  field is Required";
					condition = false;
					message.append(Capacityofug).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getCapacityofterrace() != null
						&& !FireCompilancecertifcateRestDTO.getCapacityofterrace().isEmpty()) {

					tradeLicenceTransfer
							.setCapacityofterrace(FireCompilancecertifcateRestDTO.getCapacityofterrace());
				} else {
					String Capacityofterrace = "Capacity of Terrace tank   field is Required";
					condition = false;
					message.append(Capacityofterrace).append(",");

				}
				if (FireCompilancecertifcateRestDTO.getWetriser() != null
						&& !FireCompilancecertifcateRestDTO.getWetriser().isEmpty()) {

					tradeLicenceTransfer.setWetriser(FireCompilancecertifcateRestDTO.getWetriser());
				} else {
					String Wetriser = "please indicate the number if risers  field is Required";
					condition = false;
					message.append(Wetriser).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getDryriser() != null
						&& !FireCompilancecertifcateRestDTO.getDryriser().isEmpty()) {

					tradeLicenceTransfer.setDryriser(FireCompilancecertifcateRestDTO.getDryriser());
				} else {
					String Dryriser = "Has any dry riser/down comer been provided , give details  field is Required";
					condition = false;
					message.append(Dryriser).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getDowncomer() != null
						&& !FireCompilancecertifcateRestDTO.getDowncomer().isEmpty()) {

					tradeLicenceTransfer.setDowncomer(FireCompilancecertifcateRestDTO.getDowncomer());
				} else {
					String Downcomer = "Has any down comer been provided  field is Required";
					condition = false;
					message.append(Downcomer).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getPresentarrangement() != null
						&& !FireCompilancecertifcateRestDTO.getPresentarrangement().isEmpty()) {

					tradeLicenceTransfer
							.setPresentarrangement(FireCompilancecertifcateRestDTO.getPresentarrangement());
				} else {
					String Presentarrangement = "present arrangement for replacement of water for firefighting  field is Required";
					condition = false;
					message.append(Presentarrangement).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getHydrantonfloor() != null
						&& !FireCompilancecertifcateRestDTO.getHydrantonfloor().isEmpty()) {

					tradeLicenceTransfer
							.setHydrantonfloor(FireCompilancecertifcateRestDTO.getHydrantonfloor());
				} else {
					String Hydrantonfloor = "No. of hydrant on each floor including basement  field is Required";
					condition = false;
					message.append(Hydrantonfloor).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getHydrantsingle() != null
						&& !FireCompilancecertifcateRestDTO.getHydrantsingle().isEmpty()) {

					tradeLicenceTransfer
							.setHydrantsingle(FireCompilancecertifcateRestDTO.getHydrantsingle());
				} else {
					String Hydrantsingle = " hydrant single or twin outlets field is Required";
					condition = false;
					message.append(Hydrantsingle).append(",");

				}

				if (FireCompilancecertifcateRestDTO.getNohosereels() != null
						&& !FireCompilancecertifcateRestDTO.getNohosereels().isEmpty()) {

					tradeLicenceTransfer.setNohosereels(FireCompilancecertifcateRestDTO.getNohosereels());
				} else {
					String Nohosereels = "No. of hose reels on each floors field is Required";
					condition = false;
					message.append(Nohosereels).append(",");

				}

				if ((FireCompilancecertifcateRestDTO.getHosereeltubing() != null)
						&& !FireCompilancecertifcateRestDTO.getHosereeltubing().isEmpty()) {
					tradeLicenceTransfer.setHosereeltubing(FireCompilancecertifcateRestDTO.getHosereeltubing());
				} else {
					String Hosereeltubing = "Hose reel tubing on each reel field is Required ";
					condition = false;
					message.append(Hosereeltubing).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getSizeofnozzle() != null)
						&& !FireCompilancecertifcateRestDTO.getSizeofnozzle().isEmpty()) {
					tradeLicenceTransfer.setSizeofnozzle(FireCompilancecertifcateRestDTO.getSizeofnozzle());
				} else {
					String Sizeofnozzle = "Size (Bore) and type Nozzle fitted to on each reel field is Required";
					condition = false;
					message.append(Sizeofnozzle).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getHosereelconnected() != null)
						&& !FireCompilancecertifcateRestDTO.getHosereelconnected().isEmpty()) {
					tradeLicenceTransfer.setHosereelconnected(FireCompilancecertifcateRestDTO.getHosereelconnected());
				} else {
					String Hosereelconnected = "hose reel connected directly to the riser or to the hydrant outlet field is Required";
					condition = false;
					message.append(Hosereelconnected).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getYardhydrant() != null)
						&& !FireCompilancecertifcateRestDTO.getYardhydrant().isEmpty()) {
					tradeLicenceTransfer.setYardhydrant(FireCompilancecertifcateRestDTO.getYardhydrant());
				} else {
					String Yardhydrant = "hydrant been provided from the Buildings fire pump field is Required";
					condition = false;
					message.append(Yardhydrant).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getTypeofhoses() != null)
						&& !FireCompilancecertifcateRestDTO.getTypeofhoses().isEmpty()) {
					tradeLicenceTransfer.setTypeofhoses(FireCompilancecertifcateRestDTO.getTypeofhoses());
				} else {
					String Typeofhoses = "The type of hoses field is Required";
					condition = false;
					message.append(Typeofhoses).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getSizeofhoses() != null)
						&& !FireCompilancecertifcateRestDTO.getSizeofhoses().isEmpty()) {
					tradeLicenceTransfer.setSizeofhoses(FireCompilancecertifcateRestDTO.getSizeofhoses());
				} else {
					String Sizeofhoses = "The size (Bore) of Hoses  field is Required";
					condition = false;
					message.append(Sizeofhoses).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getLengthofeachhose() != null)
						&& !FireCompilancecertifcateRestDTO.getLengthofeachhose().isEmpty()) {
					tradeLicenceTransfer.setLengthofeachhose(FireCompilancecertifcateRestDTO.getLengthofeachhose());
				} else {
					String Lengthofeachhose = "The length of each hose  field is Required";
					condition = false;
					message.append(Lengthofeachhose).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getTotalnohoses() != null)
						&& !FireCompilancecertifcateRestDTO.getTotalnohoses().isEmpty()) {
					tradeLicenceTransfer.setTotalnohoses(FireCompilancecertifcateRestDTO.getTotalnohoses());
				} else {
					String Totalnohoses = "The length of each hose  field is Required";
					condition = false;
					message.append(Totalnohoses).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getTypeofbranch() != null)
						&& !FireCompilancecertifcateRestDTO.getTypeofbranch().isEmpty()) {
					tradeLicenceTransfer.setTypeofbranch(FireCompilancecertifcateRestDTO.getTypeofbranch());
				} else {
					String Typeofbranch = "The type of branch pipes  field is Required";
					condition = false;
					message.append(Typeofbranch).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getSizebore() != null)
						&& !FireCompilancecertifcateRestDTO.getSizebore().isEmpty()) {
					tradeLicenceTransfer.setSizebore(FireCompilancecertifcateRestDTO.getSizebore());
				} else {
					String Sizebore= "Size of nozzle fitted to each branch  field is Required";
					condition = false;
					message.append(Sizebore).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getCarparking() != null)
						&& !FireCompilancecertifcateRestDTO.getCarparking().isEmpty()) {
					tradeLicenceTransfer.setCarparking(FireCompilancecertifcateRestDTO.getCarparking());
				} else {
					String Carparking = "basement is used for car parking  field is Required";
					condition = false;
					message.append(Carparking).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getSprinklersystem() != null)
						&& !FireCompilancecertifcateRestDTO.getSprinklersystem().isEmpty()) {
					tradeLicenceTransfer.setSprinklersystem(FireCompilancecertifcateRestDTO.getSprinklersystem());
				} else {
					String Sprinklersystem = "Sprinkler system is provided on all floor field is Required";
					condition = false;
					message.append(Sprinklersystem).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getNoofpump() != null)
						&& !FireCompilancecertifcateRestDTO.getNoofpump().isEmpty()) {
					tradeLicenceTransfer.setNoofpump(FireCompilancecertifcateRestDTO.getNoofpump());
				} else {
					String Noofpump = "The number of pump field is Required";
					condition = false;
					message.append(Noofpump).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getSizeofsuction() != null)
						&& !FireCompilancecertifcateRestDTO.getSizeofsuction().isEmpty()) {
					tradeLicenceTransfer.setSizeofsuction(FireCompilancecertifcateRestDTO.getSizeofsuction());
				} else {
					String Sizeofsuction = "size of suction and delivery connections field is Required";
					condition = false;
					message.append(Sizeofsuction).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getMaxhead() != null)
						&& !FireCompilancecertifcateRestDTO.getMaxhead().isEmpty()) {
					tradeLicenceTransfer.setMaxhead(FireCompilancecertifcateRestDTO.getMaxhead());
				} else {
					String Maxhead = "The maximum head against which the pump can operate at the output mentioned field is Required";
					condition = false;
					message.append(Maxhead).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getOutputofeach() != null)
						&& !FireCompilancecertifcateRestDTO.getOutputofeach().isEmpty()) {
					tradeLicenceTransfer.setOutputofeach(FireCompilancecertifcateRestDTO.getOutputofeach());
				} else {
					String Outputofeach = "Output of each pump field is Required";
					condition = false;
					message.append(Outputofeach).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getPumpautomatic() != null)
						&& !FireCompilancecertifcateRestDTO.getPumpautomatic().isEmpty()) {
					tradeLicenceTransfer.setPumpautomatic(FireCompilancecertifcateRestDTO.getPumpautomatic());
				} else {
					String Pumpautomatic = "Is the pump automatic in action field is Required";
					condition = false;
					message.append(Pumpautomatic).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getTypeofdetectors() != null)
						&& !FireCompilancecertifcateRestDTO.getTypeofdetectors().isEmpty()) {
					tradeLicenceTransfer.setTypeofdetectors(FireCompilancecertifcateRestDTO.getTypeofdetectors());
				} else {
					String Typeofdetectors= "The type of detectors used field is Required";
					condition = false;
					message.append(Typeofdetectors).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getDetectionconfirm() != null)
						&& !FireCompilancecertifcateRestDTO.getDetectionconfirm().isEmpty()) {
					tradeLicenceTransfer.setDetectionconfirm(FireCompilancecertifcateRestDTO.getDetectionconfirm());
				} else {
					String Detectionconfirm = "The standard to which the detection confirm field is Required";
					condition = false;
					message.append(Detectionconfirm).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getInstallationconfirm() != null)
						&& !FireCompilancecertifcateRestDTO.getInstallationconfirm().isEmpty()) {
					tradeLicenceTransfer.setInstallationconfirm(FireCompilancecertifcateRestDTO.getInstallationconfirm());
				} else {
					String Installationconfirm = "The code to which the installation confirm field is Required";
					condition = false;
					message.append(Installationconfirm).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getCallboxes() != null)
						&& !FireCompilancecertifcateRestDTO.getCallboxes().isEmpty()) {
					tradeLicenceTransfer.setCallboxes(FireCompilancecertifcateRestDTO.getCallboxes());
				} else {
					String Callboxes= "Have manual call boxes been installed field is Required";
					condition = false;
					message.append(Callboxes).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getPublicaddress() != null)
						&& !FireCompilancecertifcateRestDTO.getPublicaddress().isEmpty()) {
					tradeLicenceTransfer.setPublicaddress(FireCompilancecertifcateRestDTO.getPublicaddress());
				} else {
					String Publicaddress = "public address system been installed field is Required";
					condition = false;
					message.append(Publicaddress).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getIntercomsystem() != null)
						&& !FireCompilancecertifcateRestDTO.getIntercomsystem().isEmpty()) {
					tradeLicenceTransfer.setIntercomsystem(FireCompilancecertifcateRestDTO.getIntercomsystem());
				} else {
					String Intercomsystem = "intercom system been provided between the various floors field is Required";
					condition = false;
					message.append(Intercomsystem).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getAcducts() != null)
						&& !FireCompilancecertifcateRestDTO.getAcducts().isEmpty()) {
					tradeLicenceTransfer.setAcducts(FireCompilancecertifcateRestDTO.getAcducts());
				} else {
					String Acducts = "fire dampers are provided in A/c ducts give detail field is Required";
					condition = false;
					message.append(Acducts).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getFirecontrolroom() != null)
						&& !FireCompilancecertifcateRestDTO.getFirecontrolroom().isEmpty()) {
					tradeLicenceTransfer.setFirecontrolroom(FireCompilancecertifcateRestDTO.getFirecontrolroom());
				} else {
					String Firecontrolroom = "fire control room been provided in the entrance lobby field is Required";
					condition = false;
					message.append(Firecontrolroom).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getWidthofstairway() != null)
						&& !FireCompilancecertifcateRestDTO.getWidthofstairway().isEmpty()) {
					tradeLicenceTransfer.setWidthofstairway(FireCompilancecertifcateRestDTO.getWidthofstairway());
				} else {
					String Widthofstairway = "The width of the stairway field is Required";
					condition = false;
					message.append(Widthofstairway).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getExternalstaircase() != null)
						&& !FireCompilancecertifcateRestDTO.getExternalstaircase().isEmpty()) {
					tradeLicenceTransfer.setExternalstaircase(FireCompilancecertifcateRestDTO.getExternalstaircase());
				} else {
					String Externalstaircase = "external staircase been provided accessible form all floors field is Required";
					condition = false;
					message.append(Externalstaircase).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getRefugeareadetails() != null)
						&& !FireCompilancecertifcateRestDTO.getRefugeareadetails().isEmpty()) {
					tradeLicenceTransfer.setRefugeareadetails(FireCompilancecertifcateRestDTO.getRefugeareadetails());
				} else {
					String Refugeareadetails = " Refuge area details field is Required";
					condition = false;
					message.append(Refugeareadetails).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getFloorsliftruns() != null)
						&& !FireCompilancecertifcateRestDTO.getFloorsliftruns().isEmpty()) {
					tradeLicenceTransfer.setFloorsliftruns(FireCompilancecertifcateRestDTO.getFloorsliftruns());
				} else {
					String Floorsliftruns = "The floors between which the lift runs field is Required";
					condition = false;
					message.append(Floorsliftruns).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getDoorsliftruns() != null)
						&& !FireCompilancecertifcateRestDTO.getDoorsliftruns().isEmpty()) {
					tradeLicenceTransfer.setDoorsliftruns(FireCompilancecertifcateRestDTO.getDoorsliftruns());
				} else {
					String Doorsliftruns = "The type of doors fitted to the lift runs field is Required";
					condition = false;
					message.append(Doorsliftruns).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getLiftcar() != null)
						&& !FireCompilancecertifcateRestDTO.getLiftcar().isEmpty()) {
					tradeLicenceTransfer.setLiftcar(FireCompilancecertifcateRestDTO.getLiftcar());
				} else {
					String Liftcar = "Floor area of the lift car field is Required";
					condition = false;
					message.append(Liftcar).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getFireresistance() != null)
						&& !FireCompilancecertifcateRestDTO.getFireresistance().isEmpty()) {
					tradeLicenceTransfer.setFireresistance(FireCompilancecertifcateRestDTO.getFireresistance());
				} else {
					String Fireresistance = "Fire resistance rating of lift car and Landing doors field is Required";
					condition = false;
					message.append(Fireresistance).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getCommunicationsystem() != null)
						&& !FireCompilancecertifcateRestDTO.getCommunicationsystem().isEmpty()) {
					tradeLicenceTransfer.setCommunicationsystem(FireCompilancecertifcateRestDTO.getCommunicationsystem());
				} else {
					String Communicationsystem = " communication system been installed in the lift car field is Required";
					condition = false;
					message.append(Communicationsystem).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getFiremanswitch() != null)
						&& !FireCompilancecertifcateRestDTO.getFiremanswitch().isEmpty()) {
					tradeLicenceTransfer.setFiremanswitch(FireCompilancecertifcateRestDTO.getFiremanswitch());
				} else {
					String Firemanswitch = "firemanas switch been installed in the lift for grounding field is Required";
					condition = false;
					message.append(Firemanswitch).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getCapacity() != null)
						&& !FireCompilancecertifcateRestDTO.getCapacity().isEmpty()) {
					tradeLicenceTransfer.setCapacity(FireCompilancecertifcateRestDTO.getCapacity());
				} else {
					String Capacity = " The capacity(output) field is Required";
					condition = false;
					message.append(Capacity).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getLightingprotect() != null)
						&& !FireCompilancecertifcateRestDTO.getLightingprotect().isEmpty()) {
					tradeLicenceTransfer.setLightingprotect(FireCompilancecertifcateRestDTO.getLightingprotect());
				} else {
					String Lightingprotect = " use of generator, each as operating lift (s), pump, Emergency lighting field is Required";
					condition = false;
					message.append(Lightingprotect).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getGeneratorautomaticaction() != null)
						&& !FireCompilancecertifcateRestDTO.getGeneratorautomaticaction().isEmpty()) {
					tradeLicenceTransfer.setGeneratorautomaticaction(FireCompilancecertifcateRestDTO.getGeneratorautomaticaction());
				} else {
					String Generatorautomaticaction = "generator automatic in action or has to be started manually field is Required";
					condition = false;
					message.append(Generatorautomaticaction).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getFireresisting() != null)
						&& !FireCompilancecertifcateRestDTO.getFireresisting().isEmpty()) {
					tradeLicenceTransfer.setFireresisting(FireCompilancecertifcateRestDTO.getFireresisting());
				} else {
					String Fireresisting = "lifts are installed in a common enclosure field is Required";
					condition = false;
					message.append(Fireresisting).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getStairwell() != null)
						&& !FireCompilancecertifcateRestDTO.getStairwell().isEmpty()) {
					tradeLicenceTransfer.setStairwell(FireCompilancecertifcateRestDTO.getStairwell());
				} else {
					String Stairwell = "lift shaft (s) Lift lobby or stairwell been pressurised field is Required";
					condition = false;
					message.append(Stairwell).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getLiftlobbiesstaircasessmoke() != null)
						&& !FireCompilancecertifcateRestDTO.getLiftlobbiesstaircasessmoke().isEmpty()) {
					tradeLicenceTransfer.setLiftlobbiesstaircasessmoke(FireCompilancecertifcateRestDTO.getLiftlobbiesstaircasessmoke());
				} else {
					String Liftlobbiesstaircasessmoke = "staircases been effectively enclosed to prevent fire/smoke entering them from outside at any floor field is Required";
					condition = false;
					message.append(Liftlobbiesstaircasessmoke).append(",");
				}
				
				if ((FireCompilancecertifcateRestDTO.getEmergencyprocedures() != null)
						&& !FireCompilancecertifcateRestDTO.getEmergencyprocedures() .isEmpty()) {
					tradeLicenceTransfer.setEmergencyprocedures(FireCompilancecertifcateRestDTO.getEmergencyprocedures());
				} else {
					String Liftlobbiesstaircasessmoke = "occupants of the building systematically Trained in fire prevention and emergency procedures field is Required";
					condition = false;
					message.append(Liftlobbiesstaircasessmoke).append(",");
				}
				
				if ((FireCompilancecertifcateRestDTO.getFunctions() != null)
						&& !FireCompilancecertifcateRestDTO.getFunctions() .isEmpty()) {
					tradeLicenceTransfer.setFunctions(FireCompilancecertifcateRestDTO.getFunctions());
				} else {
					String Liftlobbiesstaircasessmoke = "functions that can be maintained Simultaneously by the use of generator field is Required";
					condition = false;
					message.append(Liftlobbiesstaircasessmoke).append(",");
				}
				

				if ((FireCompilancecertifcateRestDTO.getExistsdirection() != null)
						&& !FireCompilancecertifcateRestDTO.getExistsdirection().isEmpty()) {
					tradeLicenceTransfer.setExistsdirection(FireCompilancecertifcateRestDTO.getExistsdirection());
				} else {
					String Existsdirection = "Have all exists and direction of travel to such exit  field is Required";
					condition = false;
					message.append(Existsdirection).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getFalseceiling() != null)
						&& !FireCompilancecertifcateRestDTO.getFalseceiling().isEmpty()) {
					tradeLicenceTransfer.setFalseceiling(FireCompilancecertifcateRestDTO.getFalseceiling());
				} else {
					String Falseceiling = "false ceiling been provided in any portion of the building  field is Required";
					condition = false;
					message.append(Falseceiling).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getConstructionductsfittings() != null)
						&& !FireCompilancecertifcateRestDTO.getConstructionductsfittings().isEmpty()) {
					tradeLicenceTransfer.setConstructionductsfittings(FireCompilancecertifcateRestDTO.getConstructionductsfittings());
				} else {
					String Constructionductsfittings = "The material used for construction of ducts and its fittings  field is Required";
					condition = false;
					message.append(Constructionductsfittings).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getTypeoftining() != null)
						&& !FireCompilancecertifcateRestDTO.getTypeoftining().isEmpty()) {
					tradeLicenceTransfer.setTypeoftining(FireCompilancecertifcateRestDTO.getTypeoftining());
				} else {
					String Typeoftining = "The type off tining used for ducts if any  field is Required";
					condition = false;
					message.append(Typeoftining).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getTypeoflgging() != null)
						&& !FireCompilancecertifcateRestDTO.getTypeoflgging().isEmpty()) {
					tradeLicenceTransfer.setTypeoflgging(FireCompilancecertifcateRestDTO.getTypeoflgging());
				} else {
					String Typeoflgging = "Type of logging used, if any for insulating any portion of the duct field is Required";
					condition = false;
					message.append(Typeoflgging).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getFalseceilinginformation() != null)
						&& !FireCompilancecertifcateRestDTO.getFalseceilinginformation().isEmpty()) {
					tradeLicenceTransfer.setFalseceilinginformation(FireCompilancecertifcateRestDTO.getFalseceilinginformation());
				} else {
					String Falseceilinginformation = "false ceiling is provided, please give information as at 43 above field is Required";
					condition = false;
					message.append(Falseceilinginformation).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getPlenum() != null)
						&& !FireCompilancecertifcateRestDTO.getPlenum().isEmpty()) {
					tradeLicenceTransfer.setPlenum(FireCompilancecertifcateRestDTO.getPlenum());
				} else {
					String Plenum = "plenum is used as return air passagee field is Required";
					condition = false;
					message.append(Plenum).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getAhu() != null)
						&& !FireCompilancecertifcateRestDTO.getAhu().isEmpty()) {
					tradeLicenceTransfer.setAhu(FireCompilancecertifcateRestDTO.getAhu());
				} else {
					String Ahu = "separate A H U been provided for each floor field is Required";
					condition = false;
					message.append(Ahu).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getDuctingisolatedmorethenone() != null)
						&& !FireCompilancecertifcateRestDTO.getDuctingisolatedmorethenone().isEmpty()) {
					tradeLicenceTransfer.setDuctingisolatedmorethenone(FireCompilancecertifcateRestDTO.getDuctingisolatedmorethenone());
				} else {
					String Ductingisolatedmorethenone = "ducting for each floor effectively isolated of is it continuous on more than one floors field is Required";
					condition = false;
					message.append(Ductingisolatedmorethenone).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getSwitchgeartransformerlocation() != null)
						&& !FireCompilancecertifcateRestDTO.getSwitchgeartransformerlocation().isEmpty()) {
					tradeLicenceTransfer.setSwitchgeartransformerlocation(FireCompilancecertifcateRestDTO.getSwitchgeartransformerlocation());
				} else {
					String Switchgeartransformerlocation = "Where are the switchgear and transformer located field is Required";
					condition = false;
					message.append(Switchgeartransformerlocation).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getSwitchgeartransformerseparated() != null)
						&& !FireCompilancecertifcateRestDTO.getSwitchgeartransformerseparated().isEmpty()) {
					tradeLicenceTransfer.setSwitchgeartransformerseparated(FireCompilancecertifcateRestDTO.getSwitchgeartransformerseparated());
				} else {
					String Switchgeartransformerseparated = "witchgear and transformer (s) have been housed in separate compartments field is Required";
					condition = false;
					message.append(Switchgeartransformerseparated).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getResistivematerial() != null)
						&& !FireCompilancecertifcateRestDTO.getResistivematerial().isEmpty()) {
					tradeLicenceTransfer.setResistivematerial(FireCompilancecertifcateRestDTO.getResistivematerial());
				} else {
					String Resistivematerial = "electric cables, telephone cables dry/Wet riser /down comer pass through a floor or wal field is Required";
					condition = false;
					message.append(Resistivematerial).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getBearingisi() != null)
						&& !FireCompilancecertifcateRestDTO.getBearingisi().isEmpty()) {
					tradeLicenceTransfer.setBearingisi(FireCompilancecertifcateRestDTO.getBearingisi());
				} else {
					String Bearingisi = "indicate the number and extinguishers Bearing ISI certification Mark field is Required";
					condition = false;
					message.append(Bearingisi).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getFirecontrolroom() != null)
						&& !FireCompilancecertifcateRestDTO.getFirecontrolroom().isEmpty()) {
					tradeLicenceTransfer.setFirecontrolroom(FireCompilancecertifcateRestDTO.getFirecontrolroom());
				} else {
					String Firecontrolroom = "occupants of the building systematically Trained in fire prevention field is Required";
					condition = false;
					message.append(Firecontrolroom).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getEmergencyorganizationexist() != null)
						&& !FireCompilancecertifcateRestDTO.getEmergencyorganizationexist().isEmpty()) {
					tradeLicenceTransfer.setEmergencyorganizationexist(FireCompilancecertifcateRestDTO.getEmergencyorganizationexist());
				} else {
					String Emergencyorganizationexist = " emergency organization exist in the building  field is Required";
					condition = false;
					message.append(Emergencyorganizationexist).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getQualifiedfireofficer() != null)
						&& !FireCompilancecertifcateRestDTO.getQualifiedfireofficer().isEmpty()) {
					tradeLicenceTransfer.setQualifiedfireofficer(FireCompilancecertifcateRestDTO.getQualifiedfireofficer());
				} else {
					String Qualifiedfireofficer = " Qualified Fire officer been appointed for the building   field is Required";
					condition = false;
					message.append(Qualifiedfireofficer).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getLightingprotect() != null)
						&& !FireCompilancecertifcateRestDTO.getLightingprotect().isEmpty()) {
					tradeLicenceTransfer.setLightingprotect(FireCompilancecertifcateRestDTO.getLightingprotect());
				} else {
					String Lightingprotect = " building been protected against lighting  field is Required";
					condition = false;
					message.append(Lightingprotect).append(",");
				}

				if ((FireCompilancecertifcateRestDTO.getFirefightinglife() != null)
						&& !FireCompilancecertifcateRestDTO.getFirefightinglife().isEmpty()) {
					tradeLicenceTransfer.setFirefightinglife(FireCompilancecertifcateRestDTO.getFirefightinglife());
				} else {
					String Lightingprotect = " Other information related to fire fighting & life safety arrangement field is Required";
					condition = false;
					message.append(Lightingprotect).append(",");
				}

				if (FireCompilancecertifcateRestDTO.getFitnesscertificatefromlicensingagency() != null
						&& !FireCompilancecertifcateRestDTO.getFitnesscertificatefromlicensingagency().isEmpty()) {
					String doc1 = FireCompilancecertifcateRestDTO.getFitnesscertificatefromlicensingagency();

					files[0] = doc1;
				} else {
					String doc1 = "Fitness certificate from licensing agency field is Required";
					condition = false;
					message.append(doc1).append(",");
				}

				if (FireCompilancecertifcateRestDTO.getBuildingPlanSectionsandElevations() != null
						&& !FireCompilancecertifcateRestDTO.getBuildingPlanSectionsandElevations().isEmpty()) {
					String doc2 = FireCompilancecertifcateRestDTO.getBuildingPlanSectionsandElevations();

					files[1] = doc2;
				} else {
					String doc2 = "Building Plan,Sections and Elevations field is Required";
					condition = false;
					message.append(doc2).append(",");
				}

				if (FireCompilancecertifcateRestDTO.getArchitectcertificateforfirewatertanks() != null
						&& !FireCompilancecertifcateRestDTO.getArchitectcertificateforfirewatertanks().isEmpty()) {
					String doc3 = FireCompilancecertifcateRestDTO.getArchitectcertificateforfirewatertanks();

					files[2] = doc3;
				} else {
					String doc3 = "Architect certificate for fire water tanks field is Required";
					condition = false;
					message.append(doc3).append(",");
				}

				if (FireCompilancecertifcateRestDTO.getElectricalinspectorcertificate() != null
						&& !FireCompilancecertifcateRestDTO.getElectricalinspectorcertificate().isEmpty()) {
					String doc4 = FireCompilancecertifcateRestDTO.getElectricalinspectorcertificate();

					files[3] = doc4;
				} else {
					String doc4 = "Electrical inspector certificate field is Required";
					condition = false;
					message.append(doc4).append(",");
				}

				if (FireCompilancecertifcateRestDTO.getSanctionedbuildingplan() != null
						&& !FireCompilancecertifcateRestDTO.getSanctionedbuildingplan().isEmpty()) {
					String doc5 = FireCompilancecertifcateRestDTO.getSanctionedbuildingplan();

					files[4] = doc5;
				} else {
					String doc5 = "Sanctioned building planfield is Required";
					condition = false;
					message.append(doc5).append(",");
				}
				
				
				if (FireCompilancecertifcateRestDTO.getLicensecopyoflift() != null
						&& !FireCompilancecertifcateRestDTO.getLicensecopyoflift() .isEmpty()) {
					String doc6 = FireCompilancecertifcateRestDTO.getLicensecopyoflift() ;

					files[5] = doc6;
				} else {
					String doc6 = "License copy of lift field is Required";
					condition = false;
					message.append(doc6).append(",");
				}
				
				if (FireCompilancecertifcateRestDTO.getSignature() != null
						&& !FireCompilancecertifcateRestDTO.getSignature().isEmpty()) {
					String doc7 = FireCompilancecertifcateRestDTO.getSignature();

					files[6] = doc7;
				} else {
					String doc7 = "Signature  field is Required";
					condition = false;
					message.append(doc7).append(",");
				}
				String doc8 = FireCompilancecertifcateRestDTO.getCivilEngineercertificateofStructuralstability();
				files[7] = doc8;
				
				
				String savedFilePath = FireCompilancecertifcateRestController.saveFile(files,
						request);
				
				tradeLicenceTransfer.setMiddleName(FireCompilancecertifcateRestDTO.getFatherName());
				
				tradeLicenceTransfer.setAddressbuilding(FireCompilancecertifcateRestDTO.getAddressbuilding());
				
				tradeLicenceTransfer.setCompletion(FireCompilancecertifcateRestDTO.getCompletion());
				
				tradeLicenceTransfer.setOccupancy(FireCompilancecertifcateRestDTO.getOccupancy());
				
				tradeLicenceTransfer.setFeatureone(FireCompilancecertifcateRestDTO.getFeatureone());
				tradeLicenceTransfer.setFeaturetwo(FireCompilancecertifcateRestDTO.getFeaturetwo());
				tradeLicenceTransfer.setFeaturethree(FireCompilancecertifcateRestDTO.getFeaturethree());
				tradeLicenceTransfer.setFeaturefour(FireCompilancecertifcateRestDTO.getFeaturefour());
				
				tradeLicenceTransfer.setTypetwo(FireCompilancecertifcateRestDTO.getTypetwo());
				tradeLicenceTransfer.setTypethree(FireCompilancecertifcateRestDTO.getTypethree());
				tradeLicenceTransfer.setTypeone(FireCompilancecertifcateRestDTO.getTypeone());
				tradeLicenceTransfer.setTypefour(FireCompilancecertifcateRestDTO.getTypefour());
				
				
				
				RTIApplication rtiApplication = new RTIApplication();	
				
				if (FireCompilancecertifcateRestDTO.getUserMobileNumber() != 0) {
					rtiApplication.setMobileNumber(String.valueOf(FireCompilancecertifcateRestDTO.getUserMobileNumber()));
				} else {
					String userMobilenumber = "User Mobile Number field is Required";
					condition = false;
					message.append(userMobilenumber).append(",");
				}
				if (FireCompilancecertifcateRestDTO.getMobileno() != 0) {
					rtiApplication.setPhoneNumber(String.valueOf(FireCompilancecertifcateRestDTO.getMobileno()));
				} else {
					String PhoneNumber = "PhoneNo. field is Required";
					condition = false;
					message.append(PhoneNumber).append(",");

				}
				
				if (condition) {
					rtiApplication.setCreatedDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setRegistrationDate(CommonUtils.getCurrentStringDateAndTime());
					rtiApplication.setSubject("FIRE-COMPLIENCE-CERTIFICATE");
					rtiApplication.setDepartment("FIRE-DEPARTMENT");
					rtiApplication.setTemplateName("fireDepartment");
					rtiApplication.setWorkFlowStatus(0);
					rtiApplication.setFinalStatus("0");
					rtiApplication.setRtiserviceid(69);
					rtiApplication.setApplicantName(tradeLicenceTransfer.getFirstName() + " "
							+ tradeLicenceTransfer.getMiddleName() + " " + tradeLicenceTransfer.getLastName());
					rtiApplication.setPhoneNumber(tradeLicenceTransfer.getMobileno());
					rtiApplication.setMobileNumber(tradeLicenceTransfer.getMobileno());
					rtiApplication.setZone("2");
					// rtiApplication.set(tradeLicesnseOutadedRenewalRestDTO.getUserMobileNumber();
					rtiApplication.setPdfUploadFromPortal(savedFilePath);
					rtiApplication.setEmail(tradeLicenceTransfer.getEmailid());

					rtiApplication.setApplicationCost(200);
					// rtiApplication.setApplicationCost(15);

					rtiApplication.setApplicantName(tradeLicenceTransfer.getFullName());
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
						rti.setRtiApplnNumber("RTS/MD" + "/" + Year.now() + "/" + savedRti.getRtiApplicationId());
						tradeLicenceTransfer.setRtiapplrefno(rti.getRtiApplnNumber());
						tradeLicenceTransfer.setRti_ref_id(savedRti.getRtiApplicationId());
						long zone_regis_id = tradeLicenseTransferService.fireComplianceCertificate(tradeLicenceTransfer);
						rti.setRtiApplicationRefId(zone_regis_id);
						// rti.setRtiApplicationRefId(birthRegistrationService.);
						RTIApplication retunRti = rtiApplicationService.merge(rti);

						if ((retunRti != null) && (zone_regis_id > 0)) {
							FireCompilancecertifcateRestDTO.setResponseStatus("Requested data saved successfully");
							FireCompilancecertifcateRestDTO.setResponseCode(200);// 2145
							FireCompilancecertifcateRestDTO.setStatus("ok");
							FireCompilancecertifcateRestDTO.setResult(retunRti.getRtiApplnNumber());

						}
						String name = tradeLicenceTransfer.getFirstName() + tradeLicenceTransfer.getMiddleName()
								+ tradeLicenceTransfer.getLastName();
						String link = "https://tinyurl.com/4hhhy9w9";
						String applnNo = rti.getRtiApplnNumber();

						String msg = "Dear " + name + " your application with Application No. " + applnNo
								+ " submitted successfully. Kindly Save for RTS Tracking record. Regards, NMCGOV";

						msg.replace("var3", "");

						SendSMS.sendSingleSMS("1507167462244373944", "NMCGov", tradeLicenceTransfer.getMobileno(), msg);
						SendEmail.sendEmail(tradeLicenceTransfer.getEmailid(),
								"Application Submitted Successfully" + applnNo, msg);

					}
				}
				if (!condition) {
					if (message.charAt(message.length() - 1) == ',') {
						message.deleteCharAt(message.length() - 1);
						FireCompilancecertifcateRestDTO.setResult(message.toString());
						FireCompilancecertifcateRestDTO.setResponseStatus("Requested data not saved successfully");
						FireCompilancecertifcateRestDTO.setResponseCode(500);
						FireCompilancecertifcateRestDTO.setStatus("Internal Server Error");
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
				log.equals(ex.getMessage());
				FireCompilancecertifcateRestDTO.setResponseStatus("Data fields are Empty");
				FireCompilancecertifcateRestDTO.setResponseCode(405);
				FireCompilancecertifcateRestDTO.setStatus("Method not Allowed");
			}
		}
		return FireCompilancecertifcateRestDTO;
	}

	public static String saveFile(String data[], HttpServletRequest request) throws IOException {
		String filesPath = null;
		StringBuilder filesPathBuilder = new StringBuilder();
		String baseDir = CoreConstants.UPLOAD_PATH + "firecompliancecertificate";
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
