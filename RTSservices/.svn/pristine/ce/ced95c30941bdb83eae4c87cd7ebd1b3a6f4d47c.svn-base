package com.mars.rti.controller;

import com.mars.rti.model.FeesMaster;
import com.mars.rti.service.FeesMasterService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeesMasterController {
  @Autowired
  private FeesMasterService feesMasterService;
  
  public double setBirthFeesApplicable(String days, long copies, long serviceId) {
    double amount = 0.0D;
    try {
      if (days != null) {
        int day = Integer.parseInt(days);
        if (day == 1) {
          amount = this.feesMasterService.getFees(serviceId).getSameDay();
        } else {
          amount = this.feesMasterService.getFees(serviceId).getTillThirdDay();
        } 
        amount *= copies;
        return amount;
      } 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    return amount;
  }
  
  @RequestMapping({"/setMarriageFeesApplicable.do"})
  public double setMarriageFeesApplicable(String marriagedate, long serviceId) {
    double fees = 0.0D;
    try {
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date date = new Date();
      long days = checkMarriageCertificateInDays(dateFormat.format(date), marriagedate, 
          dateFormat);
      if (days > 0L) {
        if (days > 365L) {
          fees = this.feesMasterService.getFees(serviceId).getMarriagecertificateAfterOneYear();
        } else {
          fees = this.feesMasterService.getFees(serviceId).getMarriageCertificateBeforeOneYear();
        } 
      } else {
        fees = -1.0D;
      } 
    } catch (Exception ex) {
      fees = -1.0D;
      ex.printStackTrace();
    } 
    return fees;
  }
  
  public static long checkMarriageCertificateInDays(String date2, String date1, DateFormat dateFormat) {
    Date d1 = null;
    Date d2 = null;
    long diffDays = 0L;
    try {
      d1 = dateFormat.parse(date1);
      d2 = dateFormat.parse(date2);
      long diff = d2.getTime() - d1.getTime();
      diffDays = diff / 86400000L;
      return diffDays;
    } catch (Exception e) {
      diffDays = -1L;
      e.printStackTrace();
      return diffDays;
    } 
  }
  
  public double setDogLicenseFeesApplicable(String[] dogType, String[] operated, long serviceId) {
    long fees = 0L;
    String dogtype = null;
    String dogOperated = null;
    try {
      for (int i = 0; i < dogType.length; i++) {
        dogtype = dogType[i];
        dogOperated = operated[i];
        if (dogtype.equals("IndianDog")) {
          if (dogOperated.equals("Operated")) {
            fees = (long)(fees + this.feesMasterService.getFees(serviceId).getIndianOperated());
          } else if (dogOperated.equals("NonOperated")) {
            fees = (long)(fees + this.feesMasterService.getFees(serviceId).getIndianNonOperated());
          } 
        } else if (dogtype.equals("BreedDog")) {
          if (dogOperated.equals("Operated")) {
            fees = (long)(fees + this.feesMasterService.getFees(serviceId).getBreedOperated());
          } else if (dogOperated.equals("NonOperated")) {
            fees = (long)(fees + this.feesMasterService.getFees(serviceId).getBreedNonOperated());
          } 
        } 
      } 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    return fees;
  }
  
  public double setZoneCertificateFees(String calnumber, long serviceId) {
    double fees = 0.0D;
    try {
      if (calnumber != null && !calnumber.isEmpty())
        fees = Double.parseDouble(calnumber) * this.feesMasterService.getFees(serviceId).getZoneCertificate(); 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    return fees;
  }
  
  public double setNursingHomeFees(String no_maternity_beds, String no_other_beds) {
    double fees = 0.0D;
    try {
      FeesMaster feesmaster = new FeesMaster();
      feesmaster = this.feesMasterService.getFees(94L);
      int noOfbedsMertinity = Integer.parseInt(no_maternity_beds);
      int noOfbedsOtherPatient = Integer.parseInt(no_other_beds);
      int total = noOfbedsMertinity + noOfbedsOtherPatient;
      double fixfees = feesmaster.getNoOfBeds1To5();
      if (total > 0) {
        double inputText = total;
        int inputDiv = (int)Math.floor(inputText / 5.0D);
        double inputModule = inputText % 5.0D;
        if (inputModule != 0.0D)
          inputDiv++; 
        fees = inputDiv * fixfees;
      } 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    return fees;
  }
  
  public double setNursingHomeRenewalFees(String maternityPatients, String noBedOPatient) {
    double fees = 0.0D;
    try {
      FeesMaster feesmaster = new FeesMaster();
      feesmaster = this.feesMasterService.getFees(94L);
      int noOfbedsMertinity = Integer.parseInt(maternityPatients);
      int noOfbedsOtherPatient = Integer.parseInt(noBedOPatient);
      int total = noOfbedsMertinity + noOfbedsOtherPatient;
      double fixfees = feesmaster.getNoOfBeds1To5();
      if (total > 0) {
        double inputText = total;
        int inputDiv = (int)Math.floor(inputText / 5.0D);
        double inputModule = inputText % 5.0D;
        if (inputModule != 0.0D)
          inputDiv++; 
        fees = inputDiv * fixfees;
        fees += fees * 0.25D;
      } 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    return fees;
  }
  
  public double setNursingHomeChangeApplicationFees(String sanctionedBedMaternity, String sanctionedBedOther) {
    double fees = 0.0D;
    try {
      FeesMaster feesmaster = new FeesMaster();
      feesmaster = this.feesMasterService.getFees(94L);
      int noOfbedsMertinity = Integer.parseInt(sanctionedBedMaternity);
      int noOfbedsOtherPatient = Integer.parseInt(sanctionedBedOther);
      int total = noOfbedsMertinity + noOfbedsOtherPatient;
      double fixfees = feesmaster.getNoOfBeds1To5();
      if (total > 0) {
        double inputText = total;
        int inputDiv = (int)Math.floor(inputText / 5.0D);
        double inputModule = inputText % 5.0D;
        if (inputModule != 0.0D)
          inputDiv++; 
        fees = inputDiv * fixfees;
        fees += fees * 0.25D;
      } 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    return fees;
  }
  
  public double setFireServiceFees() {
    double result = 0.0D;
    FeesMaster feesmaster = new FeesMaster();
    feesmaster = this.feesMasterService.getFees(93L);
    result = feesmaster.getFireNOCFee() + feesmaster.getFireEnvironmentalFee();
    return result;
  }
}
