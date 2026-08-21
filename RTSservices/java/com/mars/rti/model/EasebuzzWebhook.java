package com.mars.rti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="easebuzzwebhook", schema = "egovrti")
public class EasebuzzWebhook {

	@Id
	@Column(name = "easebuzzWebhookid", nullable = false, unique = true)
	@SequenceGenerator(name = "easebuzzwebhook_easebuzzwebhookid_seq", sequenceName = "easebuzzwebhook_easebuzzwebhookid_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "easebuzzwebhook_easebuzzwebhookid_seq")
	private long easebuzzWebhookid;
    private String txnid;
    private String firstname;
    private String email;
    private String phone;
    private String key;
    private String mode;
    private String status;
    private String unmappedstatus;
    private String cardCategory;
    private String addedon;
    private String payment_source;
    private String PG_TYPE;
    private String bank_ref_num;
    private String bankcode;
    private String error;
    private String name_on_card;
    private String cardnum;
    private String issuing_bank;
    private String card_type;
    private String easepayid;
    private String amount;
    private String net_amount_debit;
    private String cash_back_percentage;
    private String deduction_percentage;
    private String productinfo;
    private String hash;
    private String surl;
    private String furl;
    private String error_Message;
    private String merchant_logo;
    private String upi_va;
	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUnmappedstatus() {
		return unmappedstatus;
	}
	public void setUnmappedstatus(String unmappedstatus) {
		this.unmappedstatus = unmappedstatus;
	}
	public String getCardCategory() {
		return cardCategory;
	}
	public void setCardCategory(String cardCategory) {
		this.cardCategory = cardCategory;
	}
	public String getAddedon() {
		return addedon;
	}
	public void setAddedon(String addedon) {
		this.addedon = addedon;
	}
	public String getPayment_source() {
		return payment_source;
	}
	public void setPayment_source(String payment_source) {
		this.payment_source = payment_source;
	}
	public String getPG_TYPE() {
		return PG_TYPE;
	}
	public void setPG_TYPE(String pG_TYPE) {
		PG_TYPE = pG_TYPE;
	}
	public String getBank_ref_num() {
		return bank_ref_num;
	}
	public void setBank_ref_num(String bank_ref_num) {
		this.bank_ref_num = bank_ref_num;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getName_on_card() {
		return name_on_card;
	}
	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	public String getIssuing_bank() {
		return issuing_bank;
	}
	public void setIssuing_bank(String issuing_bank) {
		this.issuing_bank = issuing_bank;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getEasepayid() {
		return easepayid;
	}
	public void setEasepayid(String easepayid) {
		this.easepayid = easepayid;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getNet_amount_debit() {
		return net_amount_debit;
	}
	public void setNet_amount_debit(String net_amount_debit) {
		this.net_amount_debit = net_amount_debit;
	}
	public String getCash_back_percentage() {
		return cash_back_percentage;
	}
	public void setCash_back_percentage(String cash_back_percentage) {
		this.cash_back_percentage = cash_back_percentage;
	}
	public String getDeduction_percentage() {
		return deduction_percentage;
	}
	public void setDeduction_percentage(String deduction_percentage) {
		this.deduction_percentage = deduction_percentage;
	}
	public String getProductinfo() {
		return productinfo;
	}
	public void setProductinfo(String productinfo) {
		this.productinfo = productinfo;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getSurl() {
		return surl;
	}
	public void setSurl(String surl) {
		this.surl = surl;
	}
	public String getFurl() {
		return furl;
	}
	public void setFurl(String furl) {
		this.furl = furl;
	}
	public String getError_Message() {
		return error_Message;
	}
	public void setError_Message(String error_Message) {
		this.error_Message = error_Message;
	}
	public String getMerchant_logo() {
		return merchant_logo;
	}
	public void setMerchant_logo(String merchant_logo) {
		this.merchant_logo = merchant_logo;
	}
	public String getUpi_va() {
		return upi_va;
	}
	public void setUpi_va(String upi_va) {
		this.upi_va = upi_va;
	}

    
}

