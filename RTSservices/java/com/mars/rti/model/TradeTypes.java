package com.mars.rti.model;
import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.SequenceGenerator;
/*    */ import javax.persistence.Table;

@Entity
@Table(name = "trade_types", schema = "egovrti")
public class TradeTypes {


    @Id
   @Column(name = "id", nullable = false, unique = true)
  @SequenceGenerator(name = "trade_types_seq", sequenceName = "trade_types_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trade_types_seq")
private long Id;
   
@Column(name = "trade_name")
   private String trade_name;
			
  @Column(name = "trade_typefees")
  private String trade_typefees;

public long getId() {
	return Id;
}

public void setId(long id) {
	Id = id;
}

public String getTrade_name() {
	return trade_name;
}

public void setTrade_name(String trade_name) {
	this.trade_name = trade_name;
}

public String getTrade_typefees() {
	return trade_typefees;
}

public void setTrade_typefees(String trade_typefees) {
	this.trade_typefees = trade_typefees;
}
  
  

}