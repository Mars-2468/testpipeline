package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="fire_compliance_certificate", schema= "egovrti")

public class FireComplianceCertificate {

	@Id
	@Column(name = "fire_compliance_certificate_id", nullable = false, unique = true)
	@SequenceGenerator(name = "fire_compliance_certificate_ser_seq", sequenceName = "fire_compliance_certificate_ser_seq",  allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fire_compliance_certificate_ser_seq")
	
	private long firecompliancecertificateid;
	
	public long getFirecompliancecertificateid() {
		return firecompliancecertificateid;
	}

	public void setFirecompliancecertificateid(long firecompliancecertificateid) {
		this.firecompliancecertificateid = firecompliancecertificateid;
	}

	@Column(name = "title", nullable = true)
	private String title;

	@Column(name = "first_name", nullable = true)
	private String firstName;

	@Column(name = "middle_name", nullable = true)
	private String middleName;

	@Column(name = "last_name", nullable = true)
	private String lastName;

	@Column(name = "full_name", nullable = true)
	private String fullName;
		
	@Column(name = "plot_no", nullable = true)
	private String plotno;

	@Column(name = "city_survey_no", nullable = true)
	private String citysurveyno;

	@Column(name = "strret_name", nullable = true)
	private String strretname;
	
	@Column(name = "house_mouza_no", nullable = true)
	private String housemouzano;
	
	@Column(name = "pin_code", nullable = true)
	private long pincode;

	@Column(name = "landmark", nullable = true)
	private String landmark;
	
	@Column(name = "email", nullable = true)
	private String emailid;
	
	@Column(name = "mobile_no", nullable = true)
	private String mobileno;
	
	@Column(name = "provisional_fire_safety_approval", nullable = true)
	private String provisionalFireSafetyApproval;
	
	
	

	
			
	@Column(name = "name_of_power_of_attorney", nullable = true)
	private String nameofpowerofattorney;
	
	@Column(name = "no_of_standby", nullable = true)
	private String noofstandby;
	
	@Column(name = "address_of_power_of_attorney", nullable = true)
	private String addressofpowerofattorney;
	
	@Column(name="permit_no", nullable = true)
	private String permitno;
	
	@Column(name="permitno_date", nullable = true)
	private String permitnodate;
	
	@Column(name="fire_recommendation_no", nullable = true)
	private String firerecommendationno;
	
	@Column(name="fire_recommendation_no_date", nullable = true)
	private String firerecommendationnodate;
	
	public String getFirerecommendationnodate() {
		return firerecommendationnodate;
	}

	public void setFirerecommendationnodate(String firerecommendationnodate) {
		this.firerecommendationnodate = firerecommendationnodate;
	}

	@Column(name="receipt_no", nullable = true)
	private String receiptno;
	
	@Column(name="receipt_no_date", nullable = true)
	private String receiptnodate;
	
	@Column(name="building_name", nullable = true)
	private String buildingname;
	
	@Column(name="address_building", nullable = true)
	private String addressbuilding;
	
	@Column(name="name_address", nullable = true)
	private String nameaddress;
	
	@Column(name="nameaddress_promoter", nullable = true)
	private String nameaddresspromoter;
	
	@Column(name="nameaddress_owner", nullable = true)
	private String nameaddressowner;
	
	@Column(name="type_of_occupancy", nullable = true)
	private String typeofoccupancy;
	
	@Column(name="plot_area", nullable = true)
	private String plotarea;
	
	@Column(name="total_builtup_area", nullable = true)
	private String totalbuiltuparea;
	
	@Column(name="height_of_building", nullable = true)
	private String heightofbuilding;
	
	@Column(name="side_marginal_space", nullable = true)
	private String sidemarginalspace;
	
	@Column(name="rear", nullable = true)
	private String rear;
	
	@Column(name="side1", nullable = true)
	private String side1;
	
	@Column(name="side2", nullable = true)
	private String side2;
	
	@Column(name="width_of_approach", nullable = true)
	private String widthofapproach;
	
	@Column(name="width_of_entrances", nullable = true)
	private String widthofentrance;
	
	@Column(name="vertical_clearance", nullable = true)
	private String verticalclearance;
	
	@Column(name="date_of_sanctioning", nullable = true)
	private String dateofsanctioning;
	
	@Column(name="completion", nullable = true)
	private String completion;
	
	@Column(name="occupancy", nullable = true)
	private String occupancy;
	
	@Column(name="number_of_basements", nullable = true)
	private String numberofbasements;
	
	@Column(name="number_of_floors", nullable = true)
	private String numberoffloors;
	
	@Column(name="area_of_basement", nullable = true)
	private String areaofbasement;
	
	@Column(name="covered_area", nullable = true)
	private String coveredarea;
	
	@Column(name="basement_extends", nullable = true)
	private String basementextends;
	
	@Column(name="type_one", nullable = true)
	private String typeone;
	
	@Column(name="feature_one", nullable = true)
	private String featureone;
	
	@Column(name="type_two", nullable = true)
	private String typetwo;
	
	@Column(name="feature_two", nullable = true)
	private String featuretwo;
	
	@Column(name="type_three", nullable = true)
	private String typethree;
	
	@Column(name="feature_three", nullable = true)
	private String featurethree;
	
	@Column(name="type_four", nullable = true)
	private String typefour;
	
	@Column(name="feature_four", nullable = true)
	private String featurefour;	
	
	@Column(name="capacity_of_ug", nullable = true)
	private String capacityofug;

	@Column(name="capacity_of_terrace", nullable = true)
	private String capacityofterrace;
	
	@Column(name="wet_riser", nullable = true)
	private String wetriser;
	
	@Column(name="dry_riser", nullable = true)
	private String dryriser;
	
	@Column(name="down_comer", nullable = true)
	private String downcomer;
	
	@Column(name="present_arrangement", nullable = true)
	private String presentarrangement;
	
	@Column(name="hydrant_on_floor", nullable = true)
	private String hydrantonfloor;
	
	@Column(name="hydrant_single", nullable = true)
	private String hydrantsingle;
	
	@Column(name="no_hose_reels", nullable = true)
	private String nohosereels;
	
	@Column(name="hose_reel_tubing", nullable = true)
	private String hosereeltubing;
	
	@Column(name="size_bore", nullable = true)
	private String sizebore;
	
	@Column(name="hose_reel_connected", nullable = true)
	private String hosereelconnected;
	
	@Column(name="yard_hydrant", nullable = true)
	private String yardhydrant;
	
	@Column(name="type_of_hoses", nullable = true)
	private String typeofhoses;
	
	@Column(name="size_of_hoses", nullable = true)
	private String sizeofhoses;
	
	@Column(name="length_of_each_hose", nullable = true)
	private String lengthofeachhose;
	
	@Column(name="total_no_hoses", nullable = true)
	private String totalnohoses;
	
	@Column(name="type_of_branch", nullable = true)
	private String typeofbranch;
	
	@Column(name="size_of_nozzle", nullable = true)
	private String sizeofnozzle;
	
	@Column(name="car_parking", nullable = true)
	private String carparking;
	
	@Column(name="sprinkler_system", nullable = true)
	private String sprinklersystem;
	
	@Column(name="no_of_pump", nullable = true)
	private String noofpump;
	
	@Column(name="size_of_suction", nullable = true)
	private String sizeofsuction;
	
	@Column(name="max_head", nullable = true)
	private String maxhead;
	
	@Column(name="output_of_each", nullable = true)
	private String outputofeach;
	
	@Column(name="pump_automatic", nullable = true)
	private String pumpautomatic;
	
	@Column(name="type_of_detectors", nullable = true)
	private String typeofdetectors;
	
	@Column(name="detection_confirm", nullable = true)
	private String detectionconfirm;
	
	@Column(name="installation_confirm", nullable = true)
	private String installationconfirm;
	
	@Column(name="call_boxes", nullable = true)
	private String callboxes;
	
	@Column(name="public_address", nullable = true)
	private String publicaddress;
	
	@Column(name="intercom_system", nullable = true)
	private String intercomsystem;
	
	@Column(name="ac_ducts", nullable = true)
	private String acducts;
	
	@Column(name="fire_control_room", nullable = true)
	private String firecontrolroom;
	
	@Column(name="width_of_stairway", nullable = true)
	private String widthofstairway;
	
	@Column(name="external_staircase", nullable = true)
	private String externalstaircase;
	
	@Column(name="refuge_area_details", nullable = true)
	private String refugeareadetails;	
	
	@Column(name="floors_lift_runs", nullable = true)
	private String floorsliftruns;
	
	@Column(name="doors_lift_runs", nullable = true)
	private String doorsliftruns;
	
	@Column(name="lift_car", nullable = true)
	private String liftcar;
	
	@Column(name="fire_resistance", nullable = true)
	private String fireresistance;
	
	@Column(name="communication_system", nullable = true)
	private String communicationsystem;
	
	@Column(name="fireman_switch", nullable = true)
	private String firemanswitch;
	
	@Column(name="capacity", nullable = true)
	private String capacity;
	
	@Column(name="functionss", nullable = true)
	private String functions;
	
	@Column(name="generator_automatic_action", nullable = true)
	private String generatorautomaticaction;
	
	@Column(name="fire_resisting", nullable = true)
	private String fireresisting;
	
	@Column(name="stair_well", nullable = true)
	private String stairwell;
	
	@Column(name="lift_lobbies_staircases_smoke", nullable = true)
	private String liftlobbiesstaircasessmoke;
	
	@Column(name="exists_direction", nullable = true)
	private String existsdirection;
	
	@Column(name="false_ceiling", nullable = true)
	private String falseceiling;	
	
	@Column(name="construction_ducts_fittings", nullable = true)
	private String constructionductsfittings;
	
	@Column(name="type_of_tining", nullable = true)
	private String typeoftining;
	
	@Column(name="type_of_lagging", nullable = true)
	private String typeoflgging;
	
	@Column(name="false_ceiling_information", nullable = true)
	private String falseceilinginformation;	
	
	@Column(name="plenum", nullable = true)
	private String plenum;
	
	@Column(name="ahu", nullable = true)
	private String ahu;
	
	@Column(name="ducting_isolated_more_then_one", nullable = true)
	private String ductingisolatedmorethenone;	
	
	@Column(name="switchgear_transformer_location", nullable = true)
	private String switchgeartransformerlocation;	
	
	@Column(name="switchgear_transformer_separated", nullable = true)
	private String switchgeartransformerseparated;
	
	@Column(name="resistive_material", nullable = true)
	private String resistivematerial;
	
	@Column(name="bearing_isi", nullable = true)
	private String bearingisi;
	
	@Column(name="emergency_procedures", nullable = true)
	private String emergencyprocedures;	
	
	@Column(name="emergency_organization_exist", nullable = true)
	private String emergencyorganizationexist;
	
	@Column(name="qualified_fire_officer", nullable = true)
	private String qualifiedfireofficer;
	
	@Column(name="lighting_protect", nullable = true)
	private String lightingprotect;
	
	@Column(name="fire_fighting_life", nullable = true)
	private String firefightinglife;
	
	@Column(name = "rti_appl_ref_no", nullable = true )
	private String rtiapplrefno;
                                                                                                   
	@Column(name = "rti_ref_id", nullable = true )                                               
	private long rti_ref_id;
	
	@Column(name = "front", nullable = true )                                               
	private long front;
	
	@Column(name = "Zone_no", nullable = true )                                               
	private int zoneno;
	
	public int getZoneno() {
		return zoneno;
	}

	public void setZoneno(int zoneno) {
		this.zoneno = zoneno;
	}

	public long getFront() {
		return front;
	}

	public void setFront(long front) {
		this.front = front;
	}

	@Transient
	private String filesPath;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}
	
	public String getCitysurveyno() {
		return citysurveyno;
	}
	
	public void setCitysurveyno(String citysurveyno) {
		this.citysurveyno = citysurveyno;
	}
	
	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPlotno() {
		return plotno;
	}

	public void setPlotno(String plotno) {
		this.plotno = plotno;
	}


	public String getStrretname() {
		return strretname;
	}

	public void setStrretname(String strretname) {
		this.strretname = strretname;
	}

	public String getHousemouzano() {
		return housemouzano;
	}

	public void setHousemouzano(String housemouzano) {
		this.housemouzano = housemouzano;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getNameofpowerofattorney() {
		return nameofpowerofattorney;
	}

	public void setNameofpowerofattorney(String nameofpowerofattorney) {
		this.nameofpowerofattorney = nameofpowerofattorney;
	}

	public String getNoofstandby() {
		return noofstandby;
	}

	public void setNoofstandby(String noofstandby) {
		this.noofstandby = noofstandby;
	}

	public String getAddressofpowerofattorney() {
		return addressofpowerofattorney;
	}

	public void setAddressofpowerofattorney(String addressofpowerofattorney) {
		this.addressofpowerofattorney = addressofpowerofattorney;
	}
	public String getPermitno() {
		return permitno;
	}

	public void setPermitno(String permitno) {
		this.permitno = permitno;
	}

	public String getPermitnodate() {
		return permitnodate;
	}

	public void setPermitnodate(String permitnodate) {
		this.permitnodate = permitnodate;
	}

	public String getCapacityofug() {
		return capacityofug;
	}

	public void setCapacityofug(String capacityofug) {
		this.capacityofug = capacityofug;
	}
	public String getFirerecommendationno() {
		return firerecommendationno;
	}

	public void setFirerecommendationno(String firerecommendationno) {
		this.firerecommendationno = firerecommendationno;
	}


	

	public String getReceiptno() {
		return receiptno;
	}

	public void setReceiptno(String receiptno) {
		this.receiptno = receiptno;
	}

	public String getReceiptnodate() {
		return receiptnodate;
	}

	public void setReceiptnodate(String receiptnodate) {
		this.receiptnodate = receiptnodate;
	}

	public String getBuildingname() {
		return buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	public String getAddressbuilding() {
		return addressbuilding;
	}

	public void setAddressbuilding(String addressbuilding) {
		this.addressbuilding = addressbuilding;
	}

	public String getNameaddress() {
		return nameaddress;
	}

	public void setNameaddress(String nameaddress) {
		this.nameaddress = nameaddress;
	}

	public String getNameaddresspromoter() {
		return nameaddresspromoter;
	}

	public void setNameaddresspromoter(String nameaddresspromoter) {
		this.nameaddresspromoter = nameaddresspromoter;
	}

	public String getNameaddressowner() {
		return nameaddressowner;
	}

	public void setNameaddressowner(String nameaddressowner) {
		this.nameaddressowner = nameaddressowner;
	}

	public String getTypeofoccupancy() {
		return typeofoccupancy;
	}

	public void setTypeofoccupancy(String typeofoccupancy) {
		this.typeofoccupancy = typeofoccupancy;
	}

	public String getPlotarea() {
		return plotarea;
	}

	public void setPlotarea(String plotarea) {
		this.plotarea = plotarea;
	}

	public String getTotalbuiltuparea() {
		return totalbuiltuparea;
	}

	public void setTotalbuiltuparea(String totalbuiltuparea) {
		this.totalbuiltuparea = totalbuiltuparea;
	}

	public String getHeightofbuilding() {
		return heightofbuilding;
	}

	public void setHeightofbuilding(String heightofbuilding) {
		this.heightofbuilding = heightofbuilding;
	}

	public String getSidemarginalspace() {
		return sidemarginalspace;
	}

	public void setSidemarginalspace(String sidemarginalspace) {
		this.sidemarginalspace = sidemarginalspace;
	}

	public String getRear() {
		return rear;
	}

	public void setRear(String rear) {
		this.rear = rear;
	}

	public String getSide1() {
		return side1;
	}

	public void setSide1(String side1) {
		this.side1 = side1;
	}

	public String getSide2() {
		return side2;
	}

	public void setSide2(String side2) {
		this.side2 = side2;
	}

	public String getWidthofapproach() {
		return widthofapproach;
	}

	public void setWidthofapproach(String widthofapproach) {
		this.widthofapproach = widthofapproach;
	}

	public String getWidthofentrance() {
		return widthofentrance;
	}

	public void setWidthofentrance(String widthofentrance) {
		this.widthofentrance = widthofentrance;
	}

	public String getVerticalclearance() {
		return verticalclearance;
	}

	public void setVerticalclearance(String verticalclearance) {
		this.verticalclearance = verticalclearance;
	}

	public String getDateofsanctioning() {
		return dateofsanctioning;
	}

	public void setDateofsanctioning(String dateofsanctioning) {
		this.dateofsanctioning = dateofsanctioning;
	}

	public String getCompletion() {
		return completion;
	}

	public void setCompletion(String completion) {
		this.completion = completion;
	}

	public String getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}

	public String getNumberofbasements() {
		return numberofbasements;
	}

	public void setNumberofbasements(String numberofbasements) {
		this.numberofbasements = numberofbasements;
	}

	public String getNumberoffloors() {
		return numberoffloors;
	}

	public void setNumberoffloors(String numberoffloors) {
		this.numberoffloors = numberoffloors;
	}

	public String getAreaofbasement() {
		return areaofbasement;
	}

	public void setAreaofbasement(String areaofbasement) {
		this.areaofbasement = areaofbasement;
	}

	public String getCoveredarea() {
		return coveredarea;
	}

	public void setCoveredarea(String coveredarea) {
		this.coveredarea = coveredarea;
	}

	public String getBasementextends() {
		return basementextends;
	}

	public void setBasementextends(String basementextends) {
		this.basementextends = basementextends;
	}

	public String getTypeone() {
		return typeone;
	}

	public void setTypeone(String typeone) {
		this.typeone = typeone;
	}

	public String getFeatureone() {
		return featureone;
	}

	public void setFeatureone(String featureone) {
		this.featureone = featureone;
	}

	public String getTypetwo() {
		return typetwo;
	}

	public void setTypetwo(String typetwo) {
		this.typetwo = typetwo;
	}

	public String getFeaturetwo() {
		return featuretwo;
	}

	public void setFeaturetwo(String featuretwo) {
		this.featuretwo = featuretwo;
	}

	public String getTypethree() {
		return typethree;
	}

	public void setTypethree(String typethree) {
		this.typethree = typethree;
	}

	public String getFeaturethree() {
		return featurethree;
	}

	public void setFeaturethree(String featurethree) {
		this.featurethree = featurethree;
	}

	public String getTypefour() {
		return typefour;
	}

	public void setTypefour(String typefour) {
		this.typefour = typefour;
	}

	public String getFeaturefour() {
		return featurefour;
	}

	public void setFeaturefour(String featurefour) {
		this.featurefour = featurefour;
	}



	public String getCapacityofterrace() {
		return capacityofterrace;
	}

	public void setCapacityofterrace(String capacityofterrace) {
		this.capacityofterrace = capacityofterrace;
	}

	public String getWetriser() {
		return wetriser;
	}

	public void setWetriser(String wetriser) {
		this.wetriser = wetriser;
	}

	public String getDryriser() {
		return dryriser;
	}

	public void setDryriser(String dryriser) {
		this.dryriser = dryriser;
	}

	public String getDowncomer() {
		return downcomer;
	}

	public void setDowncomer(String downcomer) {
		this.downcomer = downcomer;
	}

	public String getPresentarrangement() {
		return presentarrangement;
	}

	public void setPresentarrangement(String presentarrangement) {
		this.presentarrangement = presentarrangement;
	}

	public String getHydrantonfloor() {
		return hydrantonfloor;
	}

	public void setHydrantonfloor(String hydrantonfloor) {
		this.hydrantonfloor = hydrantonfloor;
	}

	public String getHydrantsingle() {
		return hydrantsingle;
	}

	public void setHydrantsingle(String hydrantsingle) {
		this.hydrantsingle = hydrantsingle;
	}

	public String getNohosereels() {
		return nohosereels;
	}

	public void setNohosereels(String nohosereels) {
		this.nohosereels = nohosereels;
	}

	public String getHosereeltubing() {
		return hosereeltubing;
	}

	public void setHosereeltubing(String hosereeltubing) {
		this.hosereeltubing = hosereeltubing;
	}

	public String getSizebore() {
		return sizebore;
	}

	public void setSizebore(String sizebore) {
		this.sizebore = sizebore;
	}

	public String getHosereelconnected() {
		return hosereelconnected;
	}

	public void setHosereelconnected(String hosereelconnected) {
		this.hosereelconnected = hosereelconnected;
	}

	public String getYardhydrant() {
		return yardhydrant;
	}

	public void setYardhydrant(String yardhydrant) {
		this.yardhydrant = yardhydrant;
	}

	public String getTypeofhoses() {
		return typeofhoses;
	}

	public void setTypeofhoses(String typeofhoses) {
		this.typeofhoses = typeofhoses;
	}

	public String getSizeofhoses() {
		return sizeofhoses;
	}

	public void setSizeofhoses(String sizeofhoses) {
		this.sizeofhoses = sizeofhoses;
	}

	public String getLengthofeachhose() {
		return lengthofeachhose;
	}

	public void setLengthofeachhose(String lengthofeachhose) {
		this.lengthofeachhose = lengthofeachhose;
	}

	public String getTotalnohoses() {
		return totalnohoses;
	}

	public void setTotalnohoses(String totalnohoses) {
		this.totalnohoses = totalnohoses;
	}

	public String getTypeofbranch() {
		return typeofbranch;
	}

	public void setTypeofbranch(String typeofbranch) {
		this.typeofbranch = typeofbranch;
	}

	public String getSizeofnozzle() {
		return sizeofnozzle;
	}

	public void setSizeofnozzle(String sizeofnozzle) {
		this.sizeofnozzle = sizeofnozzle;
	}

	public String getCarparking() {
		return carparking;
	}

	public void setCarparking(String carparking) {
		this.carparking = carparking;
	}

	public String getSprinklersystem() {
		return sprinklersystem;
	}

	public void setSprinklersystem(String sprinklersystem) {
		this.sprinklersystem = sprinklersystem;
	}

	public String getNoofpump() {
		return noofpump;
	}

	public void setNoofpump(String noofpump) {
		this.noofpump = noofpump;
	}

	public String getSizeofsuction() {
		return sizeofsuction;
	}

	public void setSizeofsuction(String sizeofsuction) {
		this.sizeofsuction = sizeofsuction;
	}

	public String getMaxhead() {
		return maxhead;
	}

	public void setMaxhead(String maxhead) {
		this.maxhead = maxhead;
	}

	public String getOutputofeach() {
		return outputofeach;
	}

	public void setOutputofeach(String outputofeach) {
		this.outputofeach = outputofeach;
	}

	public String getPumpautomatic() {
		return pumpautomatic;
	}

	public void setPumpautomatic(String pumpautomatic) {
		this.pumpautomatic = pumpautomatic;
	}

	public String getTypeofdetectors() {
		return typeofdetectors;
	}

	public void setTypeofdetectors(String typeofdetectors) {
		this.typeofdetectors = typeofdetectors;
	}

	public String getDetectionconfirm() {
		return detectionconfirm;
	}

	public void setDetectionconfirm(String detectionconfirm) {
		this.detectionconfirm = detectionconfirm;
	}

	public String getInstallationconfirm() {
		return installationconfirm;
	}

	public void setInstallationconfirm(String installationconfirm) {
		this.installationconfirm = installationconfirm;
	}

	public String getCallboxes() {
		return callboxes;
	}

	public void setCallboxes(String callboxes) {
		this.callboxes = callboxes;
	}

	public String getPublicaddress() {
		return publicaddress;
	}

	public void setPublicaddress(String publicaddress) {
		this.publicaddress = publicaddress;
	}

	public String getIntercomsystem() {
		return intercomsystem;
	}

	public void setIntercomsystem(String intercomsystem) {
		this.intercomsystem = intercomsystem;
	}

	public String getAcducts() {
		return acducts;
	}

	public void setAcducts(String acducts) {
		this.acducts = acducts;
	}

	public String getFirecontrolroom() {
		return firecontrolroom;
	}

	public void setFirecontrolroom(String firecontrolroom) {
		this.firecontrolroom = firecontrolroom;
	}

	public String getWidthofstairway() {
		return widthofstairway;
	}

	public void setWidthofstairway(String widthofstairway) {
		this.widthofstairway = widthofstairway;
	}

	public String getExternalstaircase() {
		return externalstaircase;
	}

	public void setExternalstaircase(String externalstaircase) {
		this.externalstaircase = externalstaircase;
	}

	public String getRefugeareadetails() {
		return refugeareadetails;
	}

	public void setRefugeareadetails(String refugeareadetails) {
		this.refugeareadetails = refugeareadetails;
	}

	public String getFloorsliftruns() {
		return floorsliftruns;
	}

	public void setFloorsliftruns(String floorsliftruns) {
		this.floorsliftruns = floorsliftruns;
	}

	public String getDoorsliftruns() {
		return doorsliftruns;
	}

	public void setDoorsliftruns(String doorsliftruns) {
		this.doorsliftruns = doorsliftruns;
	}

	public String getLiftcar() {
		return liftcar;
	}

	public void setLiftcar(String liftcar) {
		this.liftcar = liftcar;
	}

	public String getFireresistance() {
		return fireresistance;
	}

	public void setFireresistance(String fireresistance) {
		this.fireresistance = fireresistance;
	}

	public String getCommunicationsystem() {
		return communicationsystem;
	}

	public void setCommunicationsystem(String communicationsystem) {
		this.communicationsystem = communicationsystem;
	}

	public String getFiremanswitch() {
		return firemanswitch;
	}

	public void setFiremanswitch(String firemanswitch) {
		this.firemanswitch = firemanswitch;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getFunctions() {
		return functions;
	}

	public void setFunctions(String functions) {
		this.functions = functions;
	}

	public String getGeneratorautomaticaction() {
		return generatorautomaticaction;
	}

	public void setGeneratorautomaticaction(String generatorautomaticaction) {
		this.generatorautomaticaction = generatorautomaticaction;
	}



	public String getFireresisting() {
		return fireresisting;
	}

	public void setFireresisting(String fireresisting) {
		this.fireresisting = fireresisting;
	}

	public String getStairwell() {
		return stairwell;
	}

	public void setStairwell(String stairwell) {
		this.stairwell = stairwell;
	}

	public String getAhu() {
		return ahu;
	}

	public void setAhu(String ahu) {
		this.ahu = ahu;
	}

	public String getLiftlobbiesstaircasessmoke() {
		return liftlobbiesstaircasessmoke;
	}

	public void setLiftlobbiesstaircasessmoke(String liftlobbiesstaircasessmoke) {
		this.liftlobbiesstaircasessmoke = liftlobbiesstaircasessmoke;
	}

	public String getExistsdirection() {
		return existsdirection;
	}

	public void setExistsdirection(String existsdirection) {
		this.existsdirection = existsdirection;
	}

	public String getFalseceiling() {
		return falseceiling;
	}

	public void setFalseceiling(String falseceiling) {
		this.falseceiling = falseceiling;
	}

	public String getConstructionductsfittings() {
		return constructionductsfittings;
	}

	public void setConstructionductsfittings(String constructionductsfittings) {
		this.constructionductsfittings = constructionductsfittings;
	}

	public String getTypeoftining() {
		return typeoftining;
	}

	public void setTypeoftining(String typeoftining) {
		this.typeoftining = typeoftining;
	}

	public String getTypeoflgging() {
		return typeoflgging;
	}

	public void setTypeoflgging(String typeoflgging) {
		this.typeoflgging = typeoflgging;
	}

	public String getFalseceilinginformation() {
		return falseceilinginformation;
	}

	public void setFalseceilinginformation(String falseceilinginformation) {
		this.falseceilinginformation = falseceilinginformation;
	}

	public String getPlenum() {
		return plenum;
	}

	public void setPlenum(String plenum) {
		this.plenum = plenum;
	}

	

	public String getDuctingisolatedmorethenone() {
		return ductingisolatedmorethenone;
	}

	public void setDuctingisolatedmorethenone(String ductingisolatedmorethenone) {
		this.ductingisolatedmorethenone = ductingisolatedmorethenone;
	}

	public String getSwitchgeartransformerlocation() {
		return switchgeartransformerlocation;
	}

	public void setSwitchgeartransformerlocation(String switchgeartransformerlocation) {
		this.switchgeartransformerlocation = switchgeartransformerlocation;
	}

	public String getSwitchgeartransformerseparated() {
		return switchgeartransformerseparated;
	}

	public void setSwitchgeartransformerseparated(String switchgeartransformerseparated) {
		this.switchgeartransformerseparated = switchgeartransformerseparated;
	}

	public String getResistivematerial() {
		return resistivematerial;
	}

	public void setResistivematerial(String resistivematerial) {
		this.resistivematerial = resistivematerial;
	}

	public String getBearingisi() {
		return bearingisi;
	}

	public void setBearingisi(String bearingisi) {
		this.bearingisi = bearingisi;
	}

	public String getEmergencyprocedures() {
		return emergencyprocedures;
	}

	public void setEmergencyprocedures(String emergencyprocedures) {
		this.emergencyprocedures = emergencyprocedures;
	}

	public String getEmergencyorganizationexist() {
		return emergencyorganizationexist;
	}

	public void setEmergencyorganizationexist(String emergencyorganizationexist) {
		this.emergencyorganizationexist = emergencyorganizationexist;
	}

	public String getQualifiedfireofficer() {
		return qualifiedfireofficer;
	}

	public void setQualifiedfireofficer(String qualifiedfireofficer) {
		this.qualifiedfireofficer = qualifiedfireofficer;
	}

	public String getLightingprotect() {
		return lightingprotect;
	}

	public void setLightingprotect(String lightingprotect) {
		this.lightingprotect = lightingprotect;
	}

	public String getFirefightinglife() {
		return firefightinglife;
	}

	public void setFirefightinglife(String firefightinglife) {
		this.firefightinglife = firefightinglife;
	}

	public String getRtiapplrefno() {
		return rtiapplrefno;
	}

	public void setRtiapplrefno(String rtiapplrefno) {
		this.rtiapplrefno = rtiapplrefno;
	}

	public long getRti_ref_id() {
		return rti_ref_id;
	}

	public void setRti_ref_id(long rti_ref_id) {
		this.rti_ref_id = rti_ref_id;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	
	
}
