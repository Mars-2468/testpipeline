package com.mars.rti.ws.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@SuppressWarnings("serial")
@JsonPropertyOrder({ "title", "firstName", "middleName", "lastName", "fullName", "plotNumber", "surveyNo", "sheetNo",
		"khasaraNo", "streetName", "mouzaNo", "pinCode", "landmark", "mobileNo", "appEmail", "applAddress",
		"titleArchitecture", "firstNameArchitecture", "middleNameArchitecture", "lastNameArchitecture",
		"fullNameArchitecture", "mobileNoArchitecture", "appEmailArchitecture", "architectLicenceNumber",
		"nameofBuildingOwner", "addressofbuilding", "typeOfBuilding", "subTypeOfBuilding", "typeOfHeight",
		"typeOfConstruction","zoneNO", "wardNo", "hightOfBuilding", "floors", "totalPlotArea", "buildUpArea", 
		"superBuildarea","numberOfBuilding", "numOfWings", "presentPosition","frontMarginWidth", "realMargin", 
		"sideMargine", "sideMargineTwo", "widthOfEntrance", "areaOfBasement","capacityOfUnderGroundTank", 
		"capacityOFOverHeadTank", "locationOfTransferRoom", "acPlant","fireFightingSystemNBC","east", "west", "north", "south",
		"electricPump", "electricPumpCapacity", "dieselPump", "dieselPumpCapacity", "jockyPump", "jockyPumpCapacity",
		"boosterPump", "boosterPumpCapacity","numInternalStaircaseProvided", "numberOfExternal", "noLift",
		"fireDepartmentWiseLogin", "fireSubDepartmentWiseLogin", 
		"tableData",//"floorName", "fireFloorTypes", "residArea", "primumAr",	"commArea", "otherUse","totalFees",
		"widthInternalStaircaseProvided","fromInternalStaricase","widthOfExternal","fromExternalStaricase","noLiftType",
		"formPCertificatePdf", "nmcTaxReciptPdf", "coveringLetterPdf", "buildingPlanPdf",
		"userMobileNumber","result", "response", "responseCode", "status", "responseStatus" })

public class FireRecommendationRestDTO implements Serializable {

	private String title;

	private String firstName;

	private String middleName;

	private String lastName;

	private String fullName;

	private String plotNumber;

	private String surveyNo;

	private String sheetNo;

	private String khasaraNo;

	private String streetName;

	private String mouzaNo;

	private String pinCode;

	private String landmark;

	private String mobileNo;

	private String appEmail;

	private String applAddress;

	private String titleArchitecture;

	private String firstNameArchitecture;

	private String middleNameArchitecture;

	private String lastNameArchitecture;

	private String fullNameArchitecture;

	private String mobileNoArchitecture;

	private String appEmailArchitecture;

	private String architectLicenceNumber;

	private String nameofBuildingOwner;

	private String addressofbuilding;

	private String typeOfBuilding;

	private String subTypeOfBuilding;

	private String typeOfHeight;

	private String typeOfConstruction;

	private String zoneNO;

	private String wardNo;

	private String hightOfBuilding;

	private String floors;

	private String totalPlotArea;

	private String buildUpArea;

	private String superBuildarea;

	private String numberOfBuilding;

	private String numOfWings;

	private String presentPosition;

	private String frontMarginWidth;

	private String realMargin;

	private String sideMargine;

	private String sideMargineTwo;

	private String widthOfEntrance;

	private String areaOfBasement;

	private String capacityOfUnderGroundTank;

	private String capacityOFOverHeadTank;

	private String locationOfTransferRoom;

	private String acPlant;

	private String fireFightingSystemNBC;

	private String east;

	private String west;

	private String north;

	private String south;

	private String electricPump;

	private String electricPumpCapacity;

	private String dieselPump;

	private String dieselPumpCapacity;

	private String jockyPump;

	private String jockyPumpCapacity;

	private String boosterPump;

	private String boosterPumpCapacity;

	private String numInternalStaircaseProvided;
	
	private String widthInternalStaircaseProvided;
	private String fromInternalStaricase;


	private String numberOfExternal;
	private String widthOfExternal;
	private String fromExternalStaricase;

	private String noLift;
	private String noLiftType;

	private String fireDepartmentWiseLogin;

	private String fireSubDepartmentWiseLogin;

//	private String floorName;
//
//	private String fireFloorTypes;
//
//	private String residArea;
//
//	private String primumAr;
//
//	private String commArea;
//
//	private String otherUse;
//
//	private String totalFees;

	private String formPCertificatePdf;

	private String nmcTaxReciptPdf;

	private String coveringLetterPdf;

	private String buildingPlanPdf;

	private long userMobileNumber;

	private String result;

	private long response;

	private int responseCode;

	private String status;

	private String responseStatus;

	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@XmlElement(name = "middleName")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@XmlElement(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElement(name = "fullName")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@XmlElement(name = "plotNumber")
	public String getPlotNumber() {
		return plotNumber;
	}

	public void setPlotNumber(String plotNumber) {
		this.plotNumber = plotNumber;
	}

	@XmlElement(name = "surveyNo")
	public String getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}

	@XmlElement(name = "sheetNo")
	public String getSheetNo() {
		return sheetNo;
	}

	public void setSheetNo(String sheetNo) {
		this.sheetNo = sheetNo;
	}

	@XmlElement(name = "khasaraNo")
	public String getKhasaraNo() {
		return khasaraNo;
	}

	public void setKhasaraNo(String khasaraNo) {
		this.khasaraNo = khasaraNo;
	}

	@XmlElement(name = "streetName")
	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@XmlElement(name = "mouzaNo")
	public String getMouzaNo() {
		return mouzaNo;
	}

	public void setMouzaNo(String mouzaNo) {
		this.mouzaNo = mouzaNo;
	}

	@XmlElement(name = "pinCode")
	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@XmlElement(name = "landmark")
	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@XmlElement(name = "mobileNo")
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@XmlElement(name = "appEmail")
	public String getAppEmail() {
		return appEmail;
	}

	public void setAppEmail(String appEmail) {
		this.appEmail = appEmail;
	}

	@XmlElement(name = "applAddress")
	public String getApplAddress() {
		return applAddress;
	}

	public void setApplAddress(String applAddress) {
		this.applAddress = applAddress;
	}

	@XmlElement(name = "titleArchitecture")
	public String getTitleArchitecture() {
		return titleArchitecture;
	}

	public void setTitleArchitecture(String titleArchitecture) {
		this.titleArchitecture = titleArchitecture;
	}

	@XmlElement(name = "firstNameArchitecture")
	public String getFirstNameArchitecture() {
		return firstNameArchitecture;
	}

	public void setFirstNameArchitecture(String firstNameArchitecture) {
		this.firstNameArchitecture = firstNameArchitecture;
	}

	@XmlElement(name = "middleNameArchitecture")
	public String getMiddleNameArchitecture() {
		return middleNameArchitecture;
	}

	public void setMiddleNameArchitecture(String middleNameArchitecture) {
		this.middleNameArchitecture = middleNameArchitecture;
	}

	@XmlElement(name = "lastNameArchitecture")
	public String getLastNameArchitecture() {
		return lastNameArchitecture;
	}

	public void setLastNameArchitecture(String lastNameArchitecture) {
		this.lastNameArchitecture = lastNameArchitecture;
	}

	@XmlElement(name = "fullNameArchitecture")
	public String getFullNameArchitecture() {
		return fullNameArchitecture;
	}

	public void setFullNameArchitecture(String fullNameArchitecture) {
		this.fullNameArchitecture = fullNameArchitecture;
	}

	@XmlElement(name = "mobileNoArchitecture")
	public String getMobileNoArchitecture() {
		return mobileNoArchitecture;
	}

	public void setMobileNoArchitecture(String mobileNoArchitecture) {
		this.mobileNoArchitecture = mobileNoArchitecture;
	}

	@XmlElement(name = "appEmailArchitecture")
	public String getAppEmailArchitecture() {
		return appEmailArchitecture;
	}

	public void setAppEmailArchitecture(String appEmailArchitecture) {
		this.appEmailArchitecture = appEmailArchitecture;
	}

	@XmlElement(name = "architectLicenceNumber")
	public String getArchitectLicenceNumber() {
		return architectLicenceNumber;
	}

	public void setArchitectLicenceNumber(String architectLicenceNumber) {
		this.architectLicenceNumber = architectLicenceNumber;
	}

	@XmlElement(name = "nameofBuildingOwner")
	public String getNameofBuildingOwner() {
		return nameofBuildingOwner;
	}

	public void setNameofBuildingOwner(String nameofBuildingOwner) {
		this.nameofBuildingOwner = nameofBuildingOwner;
	}

	@XmlElement(name = "addressofbuilding")
	public String getAddressofbuilding() {
		return addressofbuilding;
	}

	public void setAddressofbuilding(String addressofbuilding) {
		this.addressofbuilding = addressofbuilding;
	}

	@XmlElement(name = "typeOfBuilding")
	public String getTypeOfBuilding() {
		return typeOfBuilding;
	}

	public void setTypeOfBuilding(String typeOfBuilding) {
		this.typeOfBuilding = typeOfBuilding;
	}

	@XmlElement(name = "subTypeOfBuilding")
	public String getSubTypeOfBuilding() {
		return subTypeOfBuilding;
	}

	public void setSubTypeOfBuilding(String subTypeOfBuilding) {
		this.subTypeOfBuilding = subTypeOfBuilding;
	}

	@XmlElement(name = "typeOfHeight")
	public String getTypeOfHeight() {
		return typeOfHeight;
	}

	public void setTypeOfHeight(String typeOfHeight) {
		this.typeOfHeight = typeOfHeight;
	}

	@XmlElement(name = "typeOfConstruction")
	public String getTypeOfConstruction() {
		return typeOfConstruction;
	}

	public void setTypeOfConstruction(String typeOfConstruction) {
		this.typeOfConstruction = typeOfConstruction;
	}

	@XmlElement(name = "zoneNO")
	public String getZoneNO() {
		return zoneNO;
	}

	public void setZoneNO(String zoneNO) {
		this.zoneNO = zoneNO;
	}

	@XmlElement(name = "wardNo")
	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	@XmlElement(name = "hightOfBuilding")
	public String getHightOfBuilding() {
		return hightOfBuilding;
	}

	public void setHightOfBuilding(String hightOfBuilding) {
		this.hightOfBuilding = hightOfBuilding;
	}

	@XmlElement(name = "floors")
	public String getFloors() {
		return floors;
	}

	public void setFloors(String floors) {
		this.floors = floors;
	}

	@XmlElement(name = "totalPlotArea")
	public String getTotalPlotArea() {
		return totalPlotArea;
	}

	public void setTotalPlotArea(String totalPlotArea) {
		this.totalPlotArea = totalPlotArea;
	}

	@XmlElement(name = "buildUpArea")
	public String getBuildUpArea() {
		return buildUpArea;
	}

	public void setBuildUpArea(String buildUpArea) {
		this.buildUpArea = buildUpArea;
	}

	@XmlElement(name = "superBuildarea")
	public String getSuperBuildarea() {
		return superBuildarea;
	}

	public void setSuperBuildarea(String superBuildarea) {
		this.superBuildarea = superBuildarea;
	}

	@XmlElement(name = "numberOfBuilding")
	public String getNumberOfBuilding() {
		return numberOfBuilding;
	}

	public void setNumberOfBuilding(String numberOfBuilding) {
		this.numberOfBuilding = numberOfBuilding;
	}

	@XmlElement(name = "numOfWings")
	public String getNumOfWings() {
		return numOfWings;
	}

	public void setNumOfWings(String numOfWings) {
		this.numOfWings = numOfWings;
	}

	@XmlElement(name = "presentPosition")
	public String getPresentPosition() {
		return presentPosition;
	}

	public void setPresentPosition(String presentPosition) {
		this.presentPosition = presentPosition;
	}

	@XmlElement(name = "frontMarginWidth")
	public String getFrontMarginWidth() {
		return frontMarginWidth;
	}

	public void setFrontMarginWidth(String frontMarginWidth) {
		this.frontMarginWidth = frontMarginWidth;
	}

	@XmlElement(name = "realMargin")
	public String getRealMargin() {
		return realMargin;
	}

	public void setRealMargin(String realMargin) {
		this.realMargin = realMargin;
	}

	@XmlElement(name = "sideMargine")
	public String getSideMargine() {
		return sideMargine;
	}

	public void setSideMargine(String sideMargine) {
		this.sideMargine = sideMargine;
	}

	@XmlElement(name = "sideMargineTwo")
	public String getSideMargineTwo() {
		return sideMargineTwo;
	}

	public void setSideMargineTwo(String sideMargineTwo) {
		this.sideMargineTwo = sideMargineTwo;
	}

	@XmlElement(name = "widthOfEntrance")
	public String getWidthOfEntrance() {
		return widthOfEntrance;
	}

	public void setWidthOfEntrance(String widthOfEntrance) {
		this.widthOfEntrance = widthOfEntrance;
	}

	@XmlElement(name = "areaOfBasement")
	public String getAreaOfBasement() {
		return areaOfBasement;
	}

	public void setAreaOfBasement(String areaOfBasement) {
		this.areaOfBasement = areaOfBasement;
	}

	@XmlElement(name = "capacityOfUnderGroundTank")
	public String getCapacityOfUnderGroundTank() {
		return capacityOfUnderGroundTank;
	}

	public void setCapacityOfUnderGroundTank(String capacityOfUnderGroundTank) {
		this.capacityOfUnderGroundTank = capacityOfUnderGroundTank;
	}

	@XmlElement(name = "capacityOFOverHeadTank")
	public String getCapacityOFOverHeadTank() {
		return capacityOFOverHeadTank;
	}

	public void setCapacityOFOverHeadTank(String capacityOFOverHeadTank) {
		this.capacityOFOverHeadTank = capacityOFOverHeadTank;
	}

	@XmlElement(name = "locationOfTransferRoom")
	public String getLocationOfTransferRoom() {
		return locationOfTransferRoom;
	}

	public void setLocationOfTransferRoom(String locationOfTransferRoom) {
		this.locationOfTransferRoom = locationOfTransferRoom;
	}

	@XmlElement(name = "acPlant")
	public String getAcPlant() {
		return acPlant;
	}

	public void setAcPlant(String acPlant) {
		this.acPlant = acPlant;
	}

	@XmlElement(name = "fireFightingSystemNBC")
	public String getFireFightingSystemNBC() {
		return fireFightingSystemNBC;
	}

	public void setFireFightingSystemNBC(String fireFightingSystemNBC) {
		this.fireFightingSystemNBC = fireFightingSystemNBC;
	}

	@XmlElement(name = "east")
	public String getEast() {
		return east;
	}

	public void setEast(String east) {
		this.east = east;
	}

	@XmlElement(name = "west")
	public String getWest() {
		return west;
	}

	public void setWest(String west) {
		this.west = west;
	}

	@XmlElement(name = "north")
	public String getNorth() {
		return north;
	}

	public void setNorth(String north) {
		this.north = north;
	}

	@XmlElement(name = "south")
	public String getSouth() {
		return south;
	}

	public void setSouth(String south) {
		this.south = south;
	}

	@XmlElement(name = "electricPump")
	public String getElectricPump() {
		return electricPump;
	}

	public void setElectricPump(String electricPump) {
		this.electricPump = electricPump;
	}

	@XmlElement(name = "electricPumpCapacity")
	public String getElectricPumpCapacity() {
		return electricPumpCapacity;
	}

	public void setElectricPumpCapacity(String electricPumpCapacity) {
		this.electricPumpCapacity = electricPumpCapacity;
	}

	@XmlElement(name = "dieselPump")
	public String getDieselPump() {
		return dieselPump;
	}

	public void setDieselPump(String dieselPump) {
		this.dieselPump = dieselPump;
	}

	@XmlElement(name = "dieselPumpCapacity")
	public String getDieselPumpCapacity() {
		return dieselPumpCapacity;
	}

	public void setDieselPumpCapacity(String dieselPumpCapacity) {
		this.dieselPumpCapacity = dieselPumpCapacity;
	}

	@XmlElement(name = "jockyPump")
	public String getJockyPump() {
		return jockyPump;
	}

	public void setJockyPump(String jockyPump) {
		this.jockyPump = jockyPump;
	}

	@XmlElement(name = "jockyPumpCapacity")
	public String getJockyPumpCapacity() {
		return jockyPumpCapacity;
	}

	public void setJockyPumpCapacity(String jockyPumpCapacity) {
		this.jockyPumpCapacity = jockyPumpCapacity;
	}

	@XmlElement(name = "boosterPump")
	public String getBoosterPump() {
		return boosterPump;
	}

	public void setBoosterPump(String boosterPump) {
		this.boosterPump = boosterPump;
	}

	@XmlElement(name = "boosterPumpCapacity")
	public String getBoosterPumpCapacity() {
		return boosterPumpCapacity;
	}

	public void setBoosterPumpCapacity(String boosterPumpCapacity) {
		this.boosterPumpCapacity = boosterPumpCapacity;
	}

	@XmlElement(name = "numInternalStaircaseProvided")
	public String getNumInternalStaircaseProvided() {
		return numInternalStaircaseProvided;
	}

	public void setNumInternalStaircaseProvided(String numInternalStaircaseProvided) {
		this.numInternalStaircaseProvided = numInternalStaircaseProvided;
	}

	@XmlElement(name = "numberOfExternal")
	public String getNumberOfExternal() {
		return numberOfExternal;
	}

	public void setNumberOfExternal(String numberOfExternal) {
		this.numberOfExternal = numberOfExternal;
	}

	@XmlElement(name = "noLift")
	public String getNoLift() {
		return noLift;
	}

	public void setNoLift(String noLift) {
		this.noLift = noLift;
	}

	@XmlElement(name = "fireDepartmentWiseLogin")
	public String getFireDepartmentWiseLogin() {
		return fireDepartmentWiseLogin;
	}

	public void setFireDepartmentWiseLogin(String fireDepartmentWiseLogin) {
		this.fireDepartmentWiseLogin = fireDepartmentWiseLogin;
	}

	@XmlElement(name = "fireSubDepartmentWiseLogin")
	public String getFireSubDepartmentWiseLogin() {
		return fireSubDepartmentWiseLogin;
	}

	public void setFireSubDepartmentWiseLogin(String fireSubDepartmentWiseLogin) {
		this.fireSubDepartmentWiseLogin = fireSubDepartmentWiseLogin;
	}

//	@XmlElement(name = "floorName")
//	public String getFloorName() {
//		return floorName;
//	}
//
//	public void setFloorName(String floorName) {
//		this.floorName = floorName;
//	}
//
//	@XmlElement(name = "fireFloorTypes")
//	public String getFireFloorTypes() {
//		return fireFloorTypes;
//	}
//
//	public void setFireFloorTypes(String fireFloorTypes) {
//		this.fireFloorTypes = fireFloorTypes;
//	}
//
//	@XmlElement(name = "residArea")
//	public String getResidArea() {
//		return residArea;
//	}
//
//	public void setResidArea(String residArea) {
//		this.residArea = residArea;
//	}
//
//	@XmlElement(name = "primumAr")
//	public String getPrimumAr() {
//		return primumAr;
//	}
//
//	public void setPrimumAr(String primumAr) {
//		this.primumAr = primumAr;
//	}
//
//	@XmlElement(name = "commArea")
//	public String getCommArea() {
//		return commArea;
//	}
//
//	public void setCommArea(String commArea) {
//		this.commArea = commArea;
//	}
//
//	@XmlElement(name = "otherUse")
//	public String getOtherUse() {
//		return otherUse;
//	}
//
//	public void setOtherUse(String otherUse) {
//		this.otherUse = otherUse;
//	}
//
//	@XmlElement(name = "totalFees")
//	public String getTotalFees() {
//		return totalFees;
//	}
//
//	public void setTotalFees(String totalFees) {
//		this.totalFees = totalFees;
//	}

	@XmlElement(name = "formPCertificatePdf")
	public String getFormPCertificatePdf() {
		return formPCertificatePdf;
	}

	public void setFormPCertificatePdf(String formPCertificatePdf) {
		this.formPCertificatePdf = formPCertificatePdf;
	}

	@XmlElement(name = "nmcTaxReciptPdf")
	public String getNmcTaxReciptPdf() {
		return nmcTaxReciptPdf;
	}

	public void setNmcTaxReciptPdf(String nmcTaxReciptPdf) {
		this.nmcTaxReciptPdf = nmcTaxReciptPdf;
	}

	@XmlElement(name = "coveringLetterPdf")
	public String getCoveringLetterPdf() {
		return coveringLetterPdf;
	}

	public void setCoveringLetterPdf(String coveringLetterPdf) {
		this.coveringLetterPdf = coveringLetterPdf;
	}

	@XmlElement(name = "buildingPlanPdf")
	public String getBuildingPlanPdf() {
		return buildingPlanPdf;
	}

	public void setBuildingPlanPdf(String buildingPlanPdf) {
		this.buildingPlanPdf = buildingPlanPdf;
	}

	@XmlElement(name = "userMobileNumber")
	public long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

	@XmlElement(name = "result")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@XmlElement(name = "response")
	public long getResponse() {
		return response;
	}

	public void setResponse(long response) {
		this.response = response;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement(name = "responseStatus")
	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	
	private List<FireDetailsRestDTO> tableData;

	@XmlElement(name = "tableData")
	public List<FireDetailsRestDTO> getTableData() {
	    return tableData;
	}

	public void setTableData(List<FireDetailsRestDTO> tableData) {
	    this.tableData = tableData;
	}

	@XmlElement(name = "widthInternalStaircaseProvided")
	public String getWidthInternalStaircaseProvided() {
		return widthInternalStaircaseProvided;
	}

	public void setWidthInternalStaircaseProvided(String widthInternalStaircaseProvided) {
		this.widthInternalStaircaseProvided = widthInternalStaircaseProvided;
	}

	@XmlElement(name = "fromInternalStaricase")
	public String getFromInternalStaricase() {
		return fromInternalStaricase;
	}

	public void setFromInternalStaricase(String fromInternalStaricase) {
		this.fromInternalStaricase = fromInternalStaricase;
	}

	@XmlElement(name = "widthOfExternal")
	public String getWidthOfExternal() {
		return widthOfExternal;
	}

	public void setWidthOfExternal(String widthOfExternal) {
		this.widthOfExternal = widthOfExternal;
	}

	@XmlElement(name = "fromExternalStaricase")
	public String getFromExternalStaricase() {
		return fromExternalStaricase;
	}

	public void setFromExternalStaricase(String fromExternalStaricase) {
		this.fromExternalStaricase = fromExternalStaricase;
	}

	@XmlElement(name = "noLiftType")
	public String getNoLiftType() {
		return noLiftType;
	}

	public void setNoLiftType(String noLiftType) {
		this.noLiftType = noLiftType;
	}

    

}
