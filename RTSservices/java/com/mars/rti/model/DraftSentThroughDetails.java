package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table; 

@Entity
@Table(name = "draft_sent_through_details", schema = "egovrti")
public class DraftSentThroughDetails {
	 
	
	@Id	
	@Column(name="draft_sent_through_details_id", nullable = false, unique = true)	
	@SequenceGenerator(name="draft_sent_through_details_seq", sequenceName="draft_sent_through_details_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="draft_sent_through_details_seq") 
	private long draftSentThroughDetailsId;
	
	@ManyToOne
	@JoinColumn(name = "draft_sent_through_id")
	private DraftSentThrough draftSentThrough;
 	
	@Column(name = "draft_field_name")
	private  String  draftFieldName; 
	
	@Column(name = "draft_field_value")
	private  String draftFieldValue;

	public long getDraftSentThroughDetailsId() {
		return draftSentThroughDetailsId;
	}

	public void setDraftSentThroughDetailsId(long draftSentThroughDetailsId) {
		this.draftSentThroughDetailsId = draftSentThroughDetailsId;
	}

	public DraftSentThrough getDraftSentThrough() {
		return draftSentThrough;
	}

	public void setDraftSentThrough(DraftSentThrough draftSentThrough) {
		this.draftSentThrough = draftSentThrough;
	}

	public String getDraftFieldName() {
		return draftFieldName;
	}

	public void setDraftFieldName(String draftFieldName) {
		this.draftFieldName = draftFieldName;
	}

	public String getDraftFieldValue() {
		return draftFieldValue;
	}

	public void setDraftFieldValue(String draftFieldValue) {
		this.draftFieldValue = draftFieldValue;
	}	 


	
	
		
	
}

