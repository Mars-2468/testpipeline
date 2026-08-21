package com.mars.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "reg_num_genaration", schema = "egovrti")
public class RegNumGenaration  implements java.io.Serializable {

	@Id	
    @Column(name="reg_num_genaration_id", nullable=false ,unique=true)	
    @SequenceGenerator(name="reg_num_genaration_seq", sequenceName="reg_num_genaration_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="reg_num_genaration_seq") 
    private long regNumGenarationId;
	
	@Column(name="entity_name", nullable=false ,unique=true)	
    private String entityName = "";
	
	@Column(name="reset_param", nullable=true ,unique=true)	
    private String resetParam = "";
	
	@Column(name="prefix_str", nullable=true ,unique=true)	
    private String prefixStr = "";
	
	@Column(name="postfix_str", nullable=true ,unique=true)	
    private String postfixStr = "";
    
    @Column(name="current_no", nullable=false ,unique=true)
    private long currentNo = 0;
    
    public RegNumGenaration() {
    }

	
    public RegNumGenaration(String entityName, long currentNo) {
        this.entityName = entityName;
        this.currentNo = currentNo;
    }
    public RegNumGenaration(String entityName, String resetParam, String prefixStr, String postfixStr, long currentNo) {
       this.entityName = entityName;
       this.resetParam = resetParam;
       this.prefixStr = prefixStr;
       this.postfixStr = postfixStr;
       this.currentNo = currentNo;
    }
   
    public long getRegNumGenarationId() {
        return this.regNumGenarationId;
    }
    
    public void setRegNumGenarationId(long regNumGenarationId) {
        this.regNumGenarationId = regNumGenarationId;
    }
    public String getEntityName() {
        return this.entityName;
    }
    
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    public String getResetParam() {
        return this.resetParam;
    }
    
    public void setResetParam(String resetParam) {
        this.resetParam = resetParam;
    }
    public String getPrefixStr() {
        return this.prefixStr;
    }
    
    public void setPrefixStr(String prefixStr) {
        this.prefixStr = prefixStr;
    }
    public String getPostfixStr() {
        return this.postfixStr;
    }
    
    public void setPostfixStr(String postfixStr) {
        this.postfixStr = postfixStr;
    }
    public long getCurrentNo() {
        return this.currentNo;
    }
    
    public void setCurrentNo(long currentNo) {
        this.currentNo = currentNo;
    }

	public String getNexRegNumber()
    {
    	String currRegNum = "";
    	
    	if(getPrefixStr()!=null && getPrefixStr().length() >0)
    	currRegNum = currRegNum + getPrefixStr();
    	
    	/*if(getResetParam() != null && getResetParam().length() > 0)
    		currRegNum=currRegNum+getResetParam();*/
    	
    	long currNum=getCurrentNo()+1;
    	setCurrentNo(currNum);
    	currRegNum = currRegNum + currNum;
    	
   	  if(getPostfixStr() !=null && getPostfixStr().length() > 0)
    		currRegNum=currRegNum+getPostfixStr();
    	
    	return currRegNum;
    }

}


