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
@Table(name = "ganesh_mandap_permission", schema = "egovrti")
public class GaneshMandapPermission {

	@Id
	@Column(name = "ganesh_mandap_permission_id", nullable = false, unique = true)
	@SequenceGenerator(name = "ganesh_mandap_permission_seq", sequenceName = "ganesh_mandap_permission_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ganesh_mandap_permission_seq")
	private long ganeshMandapPermissionId;

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

	@Column(name = "address", nullable = true)
	private String address;

	@Column(name = "pincode", nullable = true)
	private int pinCode;

	@Column(name = "email_id", nullable = true)
	private String email;

	@Column(name = "mobile_no", nullable = true)
	private String mobileNo;

	@Column(name = "aadhar_no", nullable = true)
	private String aadharNo;

	@Column(name = "zone_no", nullable = true)
	private String zoneNo;

	@Column(name = "ward_no", nullable = true)
	private String wardNo;

	@Column(name = "address_for_institution", nullable = true)
	private String addressforInstitution;
	
	@Column(name = "venue_address", nullable = true)
	private String venueAddress;
	
	@Column(name = "registration_no", nullable = true)
	private String registrationNo;
	
	@Column(name = "height", nullable = true)
	private String height;
	
	@Column(name = "gate_length", nullable = true)
	private String gateLength;
	
	@Column(name = "gate_breadth", nullable = true)
	private String gateBreadth;
	
	@Column(name = "adv_length", nullable = true)
	private String advLength;
	
	@Column(name = "adv_breadth", nullable = true)
	private String advBreadth;
	
	@Column(name = "noOf_devotes", nullable = true)
	private String noOfDevotes;

	
	
	@Column(name = "total_size", nullable = true)
	private String totalSize;
	
	@Column(name = "adv_total_size", nullable = true)
	private String advtotalSize;
	
	
	@Column(name = "gate_total_size", nullable = true)
	private String gatetotalSize;
//	
	@Column(name = "fees", nullable = true)
	private double fees;
	
//	@Column(name = "exhibitions", nullable = true)
//	private String exhibitions;
	
	@Column(name = "event_date", nullable = true)
	private String eventDate;

//	@Column(name = "reason_for_certificate", nullable = true)
//	private String reasonForCertificate;

	@Column(name = "pavilion_length", nullable = true)
	private String pavilionLength;

	@Column(name = "pavilion_breadth", nullable = true)
	private String pavilionBreadth;

	@Column(name = "pavilion_start_date", nullable = true)
	private String pavilionStartDate;

	@Column(name = "pavilion_end_date", nullable = true)
	private String pavilionEndDate;

	@Transient
	private String filesPath;

	@Column(name = "rti_application_ref_id", nullable = true)
	private String rtiapplrefno;

	@Column(name = "rti_ref_id", nullable = true)
	private long rti_ref_id;

	@Column(name="fire_noc")
	private String fireNoc;
	
	@Column(name="traffic_noc")
	private String trafficNoc;

	@Column(name="police_noc")
	private String policeNoc;
	
	//Terms and Conditions
	@Column(name = "idol", nullable = true)
	private String idol;
	
	@Column(name = "fireproof", nullable = true)
	private String fireproof;
	
	@Column(name = "vehicle", nullable = true)
	private String vehicle;
	
	@Column(name = "building", nullable = true)
	private String building;
	
	@Column(name = "evacuation", nullable = true)
	private String evacuation;
	
	@Column(name = "firecrackers", nullable = true)
	private String firecrackers;
	
	@Column(name = "wiring", nullable = true)
	private String wiring;
	
	@Column(name = "generators", nullable = true)
	private String generators;
	
	@Column(name = "extinguisher", nullable = true)
	private String extinguisher;
	
	@Column(name = "trained", nullable = true)
	private String trained;
	
	@Column(name = "pavilionfighting", nullable = true)
	private String pavilionfighting;
	
	@Column(name = "ganesh_visarjan", nullable = true)
	private String ganeshVisarjan;
	
	@Column(name = "ganeshimmersion", nullable = true)
	private String ganeshimmersion;
	
	@Column(name = "ploiceremarks", nullable = true)
	private String ploiceremarks;
	
	@Column(name = "trafficremarks", nullable = true)
	private String trafficremarks;
	
	@Column(name = "fireremarks", nullable = true)
	private String fireremarks;
	
	@Column(name = "route", nullable = true)
	private String route;
	
	@Column(name = "police_station", nullable = true)
	private String policeStation;
	
	@Column(name = "loudspeaker", nullable = true)
	private String loudspeaker;
	
	@Column(name = "powersupply", nullable = true)
	private String powersupply;
	
	@Column(name = "metal", nullable = true)
	private String metal;
	
	@Column(name = "fromdate", nullable = true)
	private String fromdate;
	
	@Column(name = "todate", nullable = true)
	private String todate;
	
	@Column(name = "cleaningfees", nullable = true)
	private double cleaningfees;
	
	@Column(name="re_upload_flag")
	private String reUploadFlag;

	public long getGaneshMandapPermissionId() {
		return ganeshMandapPermissionId;
	}

	public void setGaneshMandapPermissionId(long ganeshMandapPermissionId) {
		this.ganeshMandapPermissionId = ganeshMandapPermissionId;
	}

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

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public String getAddressforInstitution() {
		return addressforInstitution;
	}

	public void setAddressforInstitution(String addressforInstitution) {
		this.addressforInstitution = addressforInstitution;
	}

	public String getVenueAddress() {
		return venueAddress;
	}

	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getGateLength() {
		return gateLength;
	}

	public void setGateLength(String gateLength) {
		this.gateLength = gateLength;
	}

	public String getAdvLength() {
		return advLength;
	}

	public void setAdvLength(String advLength) {
		this.advLength = advLength;
	}

	public String getAdvBreadth() {
		return advBreadth;
	}

	public void setAdvBreadth(String advBreadth) {
		this.advBreadth = advBreadth;
	}

	public String getNoOfDevotes() {
		return noOfDevotes;
	}

	public void setNoOfDevotes(String noOfDevotes) {
		this.noOfDevotes = noOfDevotes;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getPavilionLength() {
		return pavilionLength;
	}

	public void setPavilionLength(String pavilionLength) {
		this.pavilionLength = pavilionLength;
	}

	public String getPavilionBreadth() {
		return pavilionBreadth;
	}

	public void setPavilionBreadth(String pavilionBreadth) {
		this.pavilionBreadth = pavilionBreadth;
	}

	public String getPavilionStartDate() {
		return pavilionStartDate;
	}

	public void setPavilionStartDate(String pavilionStartDate) {
		this.pavilionStartDate = pavilionStartDate;
	}

	public String getPavilionEndDate() {
		return pavilionEndDate;
	}

	public void setPavilionEndDate(String pavilionEndDate) {
		this.pavilionEndDate = pavilionEndDate;
	}

	public String getFilesPath() {
		return filesPath;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
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

	public String getIdol() {
		return idol;
	}

	public void setIdol(String idol) {
		this.idol = idol;
	}

	public String getFireproof() {
		return fireproof;
	}

	public void setFireproof(String fireproof) {
		this.fireproof = fireproof;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getEvacuation() {
		return evacuation;
	}

	public void setEvacuation(String evacuation) {
		this.evacuation = evacuation;
	}

	public String getFirecrackers() {
		return firecrackers;
	}

	public void setFirecrackers(String firecrackers) {
		this.firecrackers = firecrackers;
	}

	public String getWiring() {
		return wiring;
	}

	public void setWiring(String wiring) {
		this.wiring = wiring;
	}

	public String getGenerators() {
		return generators;
	}

	public void setGenerators(String generators) {
		this.generators = generators;
	}

	public String getExtinguisher() {
		return extinguisher;
	}

	public void setExtinguisher(String extinguisher) {
		this.extinguisher = extinguisher;
	}

	public String getTrained() {
		return trained;
	}

	public void setTrained(String trained) {
		this.trained = trained;
	}

	public String getPavilionfighting() {
		return pavilionfighting;
	}

	public void setPavilionfighting(String pavilionfighting) {
		this.pavilionfighting = pavilionfighting;
	}

	public String getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
	}

	public String getAdvtotalSize() {
		return advtotalSize;
	}

	public void setAdvtotalSize(String advtotalSize) {
		this.advtotalSize = advtotalSize;
	}

	public String getGatetotalSize() {
		return gatetotalSize;
	}

	public void setGatetotalSize(String gatetotalSize) {
		this.gatetotalSize = gatetotalSize;
	}

	public String getGateBreadth() {
		return gateBreadth;
	}

	public void setGateBreadth(String gateBreadth) {
		this.gateBreadth = gateBreadth;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getFireNoc() {
		return fireNoc;
	}

	public void setFireNoc(String fireNoc) {
		this.fireNoc = fireNoc;
	}

	public String getTrafficNoc() {
		return trafficNoc;
	}

	public void setTrafficNoc(String trafficNoc) {
		this.trafficNoc = trafficNoc;
	}

	public String getPoliceNoc() {
		return policeNoc;
	}

	public void setPoliceNoc(String policeNoc) {
		this.policeNoc = policeNoc;
	}

	public String getGaneshVisarjan() {
		return ganeshVisarjan;
	}

	public void setGaneshVisarjan(String ganeshVisarjan) {
		this.ganeshVisarjan = ganeshVisarjan;
	}

	public String getGaneshimmersion() {
		return ganeshimmersion;
	}

	public void setGaneshimmersion(String ganeshimmersion) {
		this.ganeshimmersion = ganeshimmersion;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public String getPloiceremarks() {
		return ploiceremarks;
	}

	public void setPloiceremarks(String ploiceremarks) {
		this.ploiceremarks = ploiceremarks;
	}

	public String getTrafficremarks() {
		return trafficremarks;
	}

	public void setTrafficremarks(String trafficremarks) {
		this.trafficremarks = trafficremarks;
	}

	public String getFireremarks() {
		return fireremarks;
	}

	public void setFireremarks(String fireremarks) {
		this.fireremarks = fireremarks;
	}

	public String getLoudspeaker() {
		return loudspeaker;
	}

	public void setLoudspeaker(String loudspeaker) {
		this.loudspeaker = loudspeaker;
	}

	public String getPowersupply() {
		return powersupply;
	}

	public void setPowersupply(String powersupply) {
		this.powersupply = powersupply;
	}

	public String getMetal() {
		return metal;
	}

	public void setMetal(String metal) {
		this.metal = metal;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public double getCleaningfees() {
		return cleaningfees;
	}

	public void setCleaningfees(double cleaningfees) {
		this.cleaningfees = cleaningfees;
	}

	public String getReUploadFlag() {
		return reUploadFlag;
	}

	public void setReUploadFlag(String reUploadFlag) {
		this.reUploadFlag = reUploadFlag;
	}

    
	
	

}
