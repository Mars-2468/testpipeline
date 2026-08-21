package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marriage_proof_age", schema="egovcommon")
public class MarriageProofAge {

	@Id
	@Column(name = "age_proof_id", nullable = false, unique = true)
	private long ageProofId;
	
	@Column(name = "age_proof", nullable = false)
    private String ageProof;

	public long getAgeProofId() {
		return ageProofId;
	}

	public void setAgeProofId(long ageProofId) {
		this.ageProofId = ageProofId;
	}

	public String getAgeProof() {
		return ageProof;
	}

	public void setAgeProof(String ageProof) {
		this.ageProof = ageProof;
	}

	
}
