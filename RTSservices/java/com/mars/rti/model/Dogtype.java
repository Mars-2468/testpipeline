package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "dogtype", schema = "egovcommon")
public class Dogtype {

	@Id
	@Column(name = "dogtypeid" , nullable = false, unique = true)
	@SequenceGenerator(name = "dogtype_seq", sequenceName = "dogtype_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dogtype_seq")
	private long dogtypeid;
	
	@Column(name="dogtype")
	private String dogtype;
	
	@Column(name="breedtype")
	private String breedtype;
	
	@Column(name="indiantype")
	private String indiantype;

	public long getDogtypeid() {
		return dogtypeid;
	}

	public void setDogtypeid(long dogtypeid) {
		this.dogtypeid = dogtypeid;
	}

	public String getDogtype() {
		return dogtype;
	}

	public void setDogtype(String dogtype) {
		this.dogtype = dogtype;
	}

	public String getIndiantype() {
		return indiantype;
	}

	public void setIndiantype(String indiantype) {
		this.indiantype = indiantype;
	}

	public String getBreedtype() {
		return breedtype;
	}

	public void setBreedtype(String breedtype) {
		this.breedtype = breedtype;
	}
	
	
}
