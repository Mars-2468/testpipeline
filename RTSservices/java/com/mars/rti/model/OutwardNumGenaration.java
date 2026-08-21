package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "outward_num_genaration", schema = "egovrti")
public class OutwardNumGenaration {
	
	@Id	
    @Column(name="outward_num_genaration_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="outward_num_genaration_seq", sequenceName="outward_num_genaration_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="outward_num_genaration_seq") 
    private long outwardNumGenarationId;
	
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


	public long getOutwardNumGenarationId() {
		return outwardNumGenarationId;
	}

	public void setOutwardNumGenarationId(long outwardNumGenarationId) {
		this.outwardNumGenarationId = outwardNumGenarationId;
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


	public String geNextOutwardNumber()
    {
    	String currOutwardNum = "";
    	
    	if(getPrefixStr()!=null && getPrefixStr().length() >0)
    		currOutwardNum = currOutwardNum + getPrefixStr();
    
    	long currNum=getCurrentNo()+1;
    	setCurrentNo(currNum);
    	currOutwardNum = currOutwardNum + currNum;
    	
    	if(getPostfixStr() !=null && getPostfixStr().length() > 0)
    		currOutwardNum=currOutwardNum+getPostfixStr();
    	
   	    	
    	return currOutwardNum;
    }

}
