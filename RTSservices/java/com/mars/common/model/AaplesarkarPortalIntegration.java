package com.mars.common.model;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "aaplesarkar_portal_integration", schema = "egovcommon")
@XmlRootElement(name = "user")
public class AaplesarkarPortalIntegration {
    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    @SequenceGenerator(name = "egovcommon.user_seq", sequenceName = "egovcommon.user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.user_seq")
    private long userId;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    // Add other fields as per the parameters

    @XmlElement(name = "Response")
    private String response;

    @XmlElement(name = "UserID")
    private String userIdParam;

    @XmlElement(name = "UsertypeName")
    private String userTypeName;

    @XmlElement(name = "Password")
    private String passwordParam;

    @XmlElement(name = "PasswordChanged")
    private boolean passwordChanged;

    @XmlElement(name = "IsActive")
    private boolean isActive;

    @XmlElement(name = "VerifyStatus")
    private String verifyStatus;

    @XmlElement(name = "EmailID")
    private String emailId;

    @XmlElement(name = "MobileNo")
    private String mobileNo;

    @XmlElement(name = "Salutation")
    private String salutation;

    @XmlElement(name = "FullName")
    private String fullName;

    @XmlElement(name = "FullName_mr")
    private String fullNameMarathi;

    @XmlElement(name = "Age")
    private int age;

    @XmlElement(name = "Gender")
    private String gender;

    @XmlElement(name = "UIDNO")
    private String uidNo;

    @XmlElement(name = "PANNo")
    private String panNo;

    @XmlElement(name = "DOB")
    private String dob;

    @XmlElement(name = "AddrCareOf")
    private String addrCareOf;

    @XmlElement(name = "AddrCareOf_LL")
    private String addrCareOfLL;

    @XmlElement(name = "AddrBuilding")
    private String addrBuilding;

    @XmlElement(name = "AddrBuilding_LL")
    private String addrBuildingLL;

    @XmlElement(name = "AddrStreet")
    private String addrStreet;

    @XmlElement(name = "AddrStreet_LL")
    private String addrStreetLL;

    @XmlElement(name = "AddrLandmark")
    private String addrLandmark;

    @XmlElement(name = "AddrLandmark_LL")
    private String addrLandmarkLL;

    @XmlElement(name = "AddrLocality")
    private String addrLocality;

    @XmlElement(name = "AddrLocality_LL")
    private String addrLocalityLL;

    @XmlElement(name = "PinCode")
    private String pinCode;

    @XmlElement(name = "DistrictID")
    private int districtId;

    @XmlElement(name = "TalukaID")
    private int talukaId;

    @XmlElement(name = "VillageID")
    private int villageId;

    @XmlElement(name = "FatherFullName")
    private String fatherFullName;

    @XmlElement(name = "FatherFullName_mr")
    private String fatherFullNameMarathi;

    @XmlElement(name = "Father_Salutation")
    private String fatherSalutation;

    @XmlElement(name = "TrackId")
    private String trackId;

    // Getters and setters for all fields
}
