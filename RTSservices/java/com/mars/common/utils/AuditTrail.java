package com.mars.common.utils;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AUDIT_TRAIL", schema = "egovfts")
public class AuditTrail implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id	
    @Column(name="AUDIT_TRAIL_ID", nullable=false ,unique=true)	
    @SequenceGenerator(name="AUDIT_TRAIL_SEQ", sequenceName="AUDIT_TRAIL_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="AUDIT_TRAIL_SEQ") 
    private long auditTrailId;

    @Column(name = "ENTITY_ID", unique = true, nullable = false)
    private String entityId;

    @Column(name = "ENTITY_NAME", unique = true, nullable = false)
    private String entityName;

    @Column(name = "ENTITY_PROPERTY", unique = true, nullable = false)
    private String propertyName;

    @Column(name = "ENTITY_PROPERTY_OLD_VALUE", unique = true, nullable = false)
    private String oldPropValue;

    @Column(name = "ENTITY_PROPERTY_NEW_VALUE", unique = true, nullable = false)
    private String newPropValue;

    @Column(name = "OPERATION_TYPE", unique = true, nullable = false)
    private String operationType;

    @Column(name = "ACTOR_NAME", unique = true, nullable = false)
    private String actorName;

    @Column(name = "TRANSACTION_TIME", unique = true, nullable = false)
    private String transactionTime;
    
    @Column(name = "TRANSACTION_DATE", unique = true, nullable = false)
    private String transactionDate;
    
    @Column(name = "TENANCYID", unique = true, nullable = true)
    private Integer tenancyId;

    public String getActorName()
    {
	return actorName;
    }

    public void setActorName(String actorName)
    {
	this.actorName = actorName;
    }

    public String getEntityId()
    {
	return entityId;
    }

    public void setEntityId(String entityId)
    {
	this.entityId = entityId;
    }

    public String getEntityName()
    {
	return entityName;
    }

    public void setEntityName(String entityName)
    {
	this.entityName = entityName;
    }

    public String getNewPropValue()
    {
	return newPropValue;
    }

    public void setNewPropValue(String newPropValue)
    {
	this.newPropValue = newPropValue;
    }

    public String getOldPropValue()
    {
	return oldPropValue;
    }

    public void setOldPropValue(String oldPropValue)
    {
	this.oldPropValue = oldPropValue;
    }

    public String getOperationType()
    {
	return operationType;
    }

    public void setOperationType(String operationType)
    {
	this.operationType = operationType;
    }

    public String getPropertyName()
    {
	return propertyName;
    }

    public void setPropertyName(String propertyName)
    {
	this.propertyName = propertyName;
    }

    public String getTransactionTime()
    {
	return transactionTime;
    }

    public void setTransactionTime(String transactionTime)
    {
	this.transactionTime = transactionTime;
    }

    public AuditTrail(String entityId, String entityName, String propertyName, String oldPropValue, String newPropValue, String operationType, String actorName, String transactionTime)
    {
	super();
	this.entityId = entityId;
	this.entityName = entityName;
	this.propertyName = propertyName;
	this.oldPropValue = oldPropValue;
	this.newPropValue = newPropValue;
	this.operationType = operationType;
	this.actorName = actorName;
	this.transactionTime = transactionTime;
    }

    public AuditTrail(){
	
    }

    public long getAuditTrailId()
    {
        return auditTrailId;
    }

    public void setAuditTrailId(long auditTrailId)
    {
        this.auditTrailId = auditTrailId;
    }

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getTenancyId() {
		return tenancyId;
	}

	public void setTenancyId(Integer tenancyId) {
		this.tenancyId = tenancyId;
	}

	
}
