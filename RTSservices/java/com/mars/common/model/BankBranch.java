package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * BankBranch 
 */
@Entity
@Table(name = "BANK_BRANCH", schema = "egovcommon")
public class BankBranch implements java.io.Serializable
{

	@Id
	@Column(name = "BANK_BRANCH_ID", nullable = false, unique = true)
	@SequenceGenerator(name = "egovcommon.BANK_BRANCH_SEQ", sequenceName = "egovcommon.BANK_BRANCH_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egovcommon.BANK_BRANCH_SEQ")
    private long bankBranchId;

	@Column(name = "BRANCH_NAME", nullable = false)
    private String branchName;

	@Column(name = "BRANCH_CODE", nullable = true)
  	private String branchCode;

	@Column(name = "STATUS",  nullable = true)
    private Integer status;

	@ManyToOne
	@JoinColumn(name = "BANK_ID", nullable = false)
    private Bank bank = new Bank();
    
	@ManyToOne
	@JoinColumn(name = "CITY_ID",  nullable = true)
    private City city;

	@Column(name = "BRANCH_NAME_RGL", nullable = true)
    private String branchName_rgl;
    
	@Column(name = "ADDRESS1", nullable = true)
    private String address1;
    
	@Column(name = "ADDRESS2", nullable = true)
    private String address2;
    
	@Column(name = "ADDRESS3", nullable = true)
    private String address3;

	@Column(name = "PIN", nullable = true)
	private String pin;
    
	@Column(name = "PHONE", nullable = true)
    private String phone;
    
	@Column(name = "FAX", nullable = true)
    private String fax;
    
	@Column(name = "E_MAIL", nullable = true)
    private String email;
    
	@Column(name = "CONTACT_PERSON", nullable = true)
    private String contactPerson;
    


    public BankBranch()
    {
    }

    public BankBranch(String branchName)
    {
	this.branchName = branchName;
    }

    public BankBranch(String branchName, String branchCode, Integer status, Bank bank)
    {
	this.branchName = branchName;
	this.branchCode = branchCode;
	this.status = status;
	this.bank = bank;
    }

    public BankBranch(Bank bank, City city, String branchName, String branchName_rgl, String address1, String address2, String address3, String pin, String phone, String fax, String email, String contactPerson, int status) {
        this.bank = bank;

        this.city = city;
        this.branchName = branchName;
        this.branchName_rgl = branchName_rgl;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.pin = pin;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.contactPerson = contactPerson;
        this.status = status;
     }
    
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    public long getBankBranchId()
    {
	return this.bankBranchId;
    }

    public void setBankBranchId(long bankBranchId)
    {
	this.bankBranchId = bankBranchId;
    }

    public String getBranchName()
    {
	return this.branchName;
    }

    public void setBranchName(String branchName)
    {
	this.branchName = branchName;
    }

    public String getBranchCode()
    {
	return this.branchCode;
    }

    public void setBranchCode(String branchCode)
    {
	this.branchCode = branchCode;
    }

    public Integer getStatus()
    {
	return this.status;
    }

    public void setStatus(Integer status)
    {
	this.status = status;
    }

    public Bank getBank()
    {
	return this.bank;
    }

    public void setBank(Bank bank)
    {
	this.bank = bank;
    }
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getBranchName_rgl() {
		return branchName_rgl;
	}

	public void setBranchName_rgl(String branchName_rgl) {
		this.branchName_rgl = branchName_rgl;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

}
