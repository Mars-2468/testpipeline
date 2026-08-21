package com.mars.common.model; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

 


/**
 * FileType 
 */
@Entity
@Table(name = "received_mode", schema = "egovrti")
public class ReceivedMode implements java.io.Serializable
{

	@Id
	@Column(name = "received_mode_id", nullable = false, unique = true)
	@SequenceGenerator(name = "recceived_mode_seq", sequenceName = "recceived_mode_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recceived_mode_seq")
    private long receivedModeId;

	@Column(name = "received_mode_name", nullable = false)
    private String receivedModeName;

	
	
	public ReceivedMode()
    {
    }



	public long getReceivedModeId() {
		return receivedModeId;
	}



	public void setReceivedModeId(long receivedModeId) {
		this.receivedModeId = receivedModeId;
	}



	public String getReceivedModeName() {
		return receivedModeName;
	}



	public void setReceivedModeName(String receivedModeName) {
		this.receivedModeName = receivedModeName;
	}

 


}
