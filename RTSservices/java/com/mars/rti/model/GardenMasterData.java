
	package com.mars.rti.model;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.SequenceGenerator;
	import javax.persistence.Table;
	import javax.persistence.Transient;

	@Entity
	@Table(name = "garden_master_data", schema = "egovcommon")
	public class GardenMasterData {
	   
		@Id
		@Column(name = "id", nullable = false, unique = true)
		private long id;
		
	    @Column(name ="tree_name" ,nullable =true)
		public String tree_name;
	
	    
	    @Column(name ="tree_fees" ,nullable =true)
		public String tree_fees;
	    
	    
	    @Column(name ="tree_fees_trimming" ,nullable =true)
	  		public String tree_fees_trimming;
	  	    

		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getTree_name() {
			return tree_name;
		}


		public void setTree_name(String tree_name) {
			this.tree_name = tree_name;
		}


		public String getTree_fees() {
			return tree_fees;
		}


		public void setTree_fees(String tree_fees) {
			this.tree_fees = tree_fees;
		}


		public String getTree_fees_trimming() {
			return tree_fees_trimming;
		}


		public void setTree_fees_trimming(String tree_fees_trimming) {
			this.tree_fees_trimming = tree_fees_trimming;
		}
	
		
		
		

		
		
		
		
		
		
		
	}

