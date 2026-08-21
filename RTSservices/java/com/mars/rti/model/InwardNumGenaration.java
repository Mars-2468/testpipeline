package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "inward_num_genaration", schema = "egovrti")
public class InwardNumGenaration {
	
	@Id	
    @Column(name="inward_num_genaration_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="inward_num_genaration_seq", sequenceName="inward_num_genaration_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="inward_num_genaration_seq") 
    private long inwardNumGenarationId;
	
	@Column(name="entity_name", nullable=false ,unique=true)	
    private String entityName = "";
	
	@Column(name="reset_param", nullable=true ,unique=true)	
    private String resetParam = "";
	
	@Column(name="prefix_str", nullable=true ,unique=true)	
    private String prefixStr = "";
	
	@Column(name="postfix_str", nullable=true ,unique=true)	
    private String postfixStr = "";
	
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getPrefixStr() {
		return prefixStr;
	}

	public void setPrefixStr(String prefixStr) {
		this.prefixStr = prefixStr;
	}

	public String getPostfixStr() {
		return postfixStr;
	}

	public void setPostfixStr(String postfixStr) {
		this.postfixStr = postfixStr;
	}


	@Column(name="current_no", nullable=false ,unique=true)
    private long currentNo = 0;


	public long getInwardNumGenarationId() {
		return inwardNumGenarationId;
	}

	public void setInwardNumGenarationId(long inwardNumGenarationId) {
		this.inwardNumGenarationId = inwardNumGenarationId;
	}

	public String getResetParam() {
		return this.resetParam;
	}

	public void setResetParam(String resetParam) {
		this.resetParam = resetParam;
	}

	public long getCurrentNo() {
		return this.currentNo;
	}

	public void setCurrentNo(long currentNo) {
		this.currentNo = currentNo;
	}


	public String geNextInwardNumber()
    {
    	String currInwardNum = "";
    	
    	if(getPrefixStr()!=null && getPrefixStr().length() >0)
    		currInwardNum = currInwardNum + getPrefixStr();
    
    	long currNum=getCurrentNo()+1;
    	setCurrentNo(currNum);
    	currInwardNum = currInwardNum + currNum;
    	
    	if(getPostfixStr() !=null && getPostfixStr().length() > 0)
    		currInwardNum=currInwardNum+getPostfixStr();
    	
   	    	
    	return currInwardNum;
    }

}
