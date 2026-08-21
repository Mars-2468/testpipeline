package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "fees_master", schema = "egovcommon")
public class FeesMaster 
{
	@Id
	@Column(name = "fees_master_id" , nullable = false, unique = true)
	@SequenceGenerator(name = "fees_master_seq", sequenceName = "fees_master_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fees_master_seq")
	private long feesMasterId;

	@Column(name = "rti_application_service_id")
	private long rtiapplicationserviceid;
	
	@Column(name = "same_day")
	private double sameDay;
	
	@Column(name = "till_third_day")
	private double tillThirdDay;

	@Column(name = "indian_operated")
	private double indianOperated;
	
	@Column(name = "indian_non_operated")
	private double indianNonOperated;
	
	@Column(name = "breed_operated")
	private double breedOperated;
	
	@Column(name = "breed_non_operated")
	private double breedNonOperated;
	
	@Column(name = "weddingsreceptions")
	private double weddingsreceptions;
	
	@Column(name = "regionandculture")
	private double regionandculture;
	
	@Column(name = "circus_experimental_performances_other_purposes")
	private double circusExperimentalPerformancesOtherPurposes;
	
	@Column(name = "exhibi_commercial")
	private double exhibiCommercial;
	
	@Column(name = "exhibi_charitable_institutions")
	private double exhibiCharitableInstitutions;
	
	@Column(name = "exhibi_government_semigovernment_institutions_corporations")
	private double exhibiGovernmentSemigovernmentInstitutionsCorporations;

	@Column(name="no_of_beds_between_one_to_five")
	private double noOfBeds1To5;
	
	@Column(name="no_of_beds_between_six_to_ten")
	private double noOfBeds6To10;
	
	@Column(name="no_of_beds_between_eleven_to_fifteen")
	private double noOfBeds11To15;
	
	@Column(name="no_of_beds_sixteen_to_twenty")
	private double noOfBeds16To20;
	
	@Column(name="marriage_certificate_before_one_year")
	private double marriageCertificateBeforeOneYear;
	
	@Column(name="marriage_certificate_after_one_year")
	private double marriagecertificateAfterOneYear;
	
	@Column(name="nocfee")
	private double fireNOCFee;
	
	@Column(name="environmentalfee")
	private double fireEnvironmentalFee;
	
	@Column(name="zone_certificate")
	private double zoneCertificate;
	
	public long getFeesMasterId() {
		return feesMasterId;
	}

	public void setFeesMasterId(long feesMasterId) {
		this.feesMasterId = feesMasterId;
	}

	public long getRtiapplicationserviceid() {
		return rtiapplicationserviceid;
	}

	public void setRtiapplicationserviceid(long rtiapplicationserviceid) {
		this.rtiapplicationserviceid = rtiapplicationserviceid;
	}

	public double getSameDay() {
		return sameDay;
	}

	public void setSameDay(double sameDay) {
		this.sameDay = sameDay;
	}

	public double getTillThirdDay() {
		return tillThirdDay;
	}

	public void setTillThirdDay(double tillThirdDay) {
		this.tillThirdDay = tillThirdDay;
	}

	public double getIndianOperated() {
		return indianOperated;
	}

	public void setIndianOperated(double indianOperated) {
		this.indianOperated = indianOperated;
	}

	public double getIndianNonOperated() {
		return indianNonOperated;
	}

	public void setIndianNonOperated(double indianNonOperated) {
		this.indianNonOperated = indianNonOperated;
	}

	public double getBreedOperated() {
		return breedOperated;
	}

	public void setBreedOperated(double breedOperated) {
		this.breedOperated = breedOperated;
	}

	public double getBreedNonOperated() {
		return breedNonOperated;
	}

	public void setBreedNonOperated(double breedNonOperated) {
		this.breedNonOperated = breedNonOperated;
	}

	public double getWeddingsreceptions() {
		return weddingsreceptions;
	}

	public void setWeddingsreceptions(double weddingsreceptions) {
		this.weddingsreceptions = weddingsreceptions;
	}

	public double getRegionandculture() {
		return regionandculture;
	}

	public void setRegionandculture(double regionandculture) {
		this.regionandculture = regionandculture;
	}

	public double getCircusExperimentalPerformancesOtherPurposes() {
		return circusExperimentalPerformancesOtherPurposes;
	}

	public void setCircusExperimentalPerformancesOtherPurposes(double circusExperimentalPerformancesOtherPurposes) {
		this.circusExperimentalPerformancesOtherPurposes = circusExperimentalPerformancesOtherPurposes;
	}

	public double getExhibiCommercial() {
		return exhibiCommercial;
	}

	public void setExhibiCommercial(double exhibiCommercial) {
		this.exhibiCommercial = exhibiCommercial;
	}

	public double getExhibiCharitableInstitutions() {
		return exhibiCharitableInstitutions;
	}

	public void setExhibiCharitableInstitutions(double exhibiCharitableInstitutions) {
		this.exhibiCharitableInstitutions = exhibiCharitableInstitutions;
	}

	public double getExhibiGovernmentSemigovernmentInstitutionsCorporations() {
		return exhibiGovernmentSemigovernmentInstitutionsCorporations;
	}

	public void setExhibiGovernmentSemigovernmentInstitutionsCorporations(
			double exhibiGovernmentSemigovernmentInstitutionsCorporations) {
		this.exhibiGovernmentSemigovernmentInstitutionsCorporations = exhibiGovernmentSemigovernmentInstitutionsCorporations;
	}

	public double getNoOfBeds1To5() {
		return noOfBeds1To5;
	}

	public void setNoOfBeds1To5(double noOfBeds1To5) {
		this.noOfBeds1To5 = noOfBeds1To5;
	}

	public double getNoOfBeds6To10() {
		return noOfBeds6To10;
	}

	public void setNoOfBeds6To10(double noOfBeds6To10) {
		this.noOfBeds6To10 = noOfBeds6To10;
	}

	public double getNoOfBeds11To15() {
		return noOfBeds11To15;
	}

	public void setNoOfBeds11To15(double noOfBeds11To15) {
		this.noOfBeds11To15 = noOfBeds11To15;
	}

	public double getNoOfBeds16To20() {
		return noOfBeds16To20;
	}

	public void setNoOfBeds16To20(double noOfBeds16To20) {
		this.noOfBeds16To20 = noOfBeds16To20;
	}

	public double getMarriageCertificateBeforeOneYear() {
		return marriageCertificateBeforeOneYear;
	}

	public void setMarriageCertificateBeforeOneYear(double marriageCertificateBeforeOneYear) {
		this.marriageCertificateBeforeOneYear = marriageCertificateBeforeOneYear;
	}

	public double getMarriagecertificateAfterOneYear() {
		return marriagecertificateAfterOneYear;
	}

	public void setMarriagecertificateAfterOneYear(double marriagecertificateAfterOneYear) {
		this.marriagecertificateAfterOneYear = marriagecertificateAfterOneYear;
	}

	public double getZoneCertificate() {
		return zoneCertificate;
	}

	public void setZoneCertificate(double zoneCertificate) {
		this.zoneCertificate = zoneCertificate;
	}

	public double getFireNOCFee() {
		return fireNOCFee;
	}

	public void setFireNOCFee(double fireNOCFee) {
		this.fireNOCFee = fireNOCFee;
	}

	public double getFireEnvironmentalFee() {
		return fireEnvironmentalFee;
	}

	public void setFireEnvironmentalFee(double fireEnvironmentalFee) {
		this.fireEnvironmentalFee = fireEnvironmentalFee;
	}


	
	
}
