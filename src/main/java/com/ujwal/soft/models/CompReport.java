package com.ujwal.soft.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CompReport {
	
	@Id
	private int billHeaderId; 
	private String invoiceNo;
	private Date billDate;
	private int custId;
	private int companyId;
	private float taxPer;
	private float taxableAmt;
	private float sgstAmt;
	private float cgstAmt;
	private float igstAmt;
	private float totaTax;
	private float grandTotal;
	private String custName;
	private int locId;
	private int userId;
	private float roundOff;
	private float discAmt;
	private String userName;
	private String compName;
	
	
	public float getDiscAmt() {
		return discAmt;
	}
	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public float getRoundOff() {
		return roundOff;
	}
	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}
	public int getBillHeaderId() {
		return billHeaderId;
	}
	public void setBillHeaderId(int billHeaderId) {
		this.billHeaderId = billHeaderId;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public float getTaxPer() {
		return taxPer;
	}
	public void setTaxPer(float taxPer) {
		this.taxPer = taxPer;
	}
	public float getTaxableAmt() {
		return taxableAmt;
	}
	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}
	public float getSgstAmt() {
		return sgstAmt;
	}
	public void setSgstAmt(float sgstAmt) {
		this.sgstAmt = sgstAmt;
	}
	public float getCgstAmt() {
		return cgstAmt;
	}
	public void setCgstAmt(float cgstAmt) {
		this.cgstAmt = cgstAmt;
	}
	public float getIgstAmt() {
		return igstAmt;
	}
	public void setIgstAmt(float igstAmt) {
		this.igstAmt = igstAmt;
	}
	public float getTotaTax() {
		return totaTax;
	}
	public void setTotaTax(float totaTax) {
		this.totaTax = totaTax;
	}
	public float getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	@Override
	public String toString() {
		return "CompReport [billHeaderId=" + billHeaderId + ", invoiceNo=" + invoiceNo + ", billDate=" + billDate
				+ ", custId=" + custId + ", companyId=" + companyId + ", taxPer=" + taxPer + ", taxableAmt="
				+ taxableAmt + ", sgstAmt=" + sgstAmt + ", cgstAmt=" + cgstAmt + ", igstAmt=" + igstAmt + ", totaTax="
				+ totaTax + ", grandTotal=" + grandTotal + ", custName=" + custName + ", locId=" + locId + ", userId="
				+ userId + ", roundOff=" + roundOff + ", discAmt=" + discAmt + ", userName=" + userName + ", compName="
				+ compName + "]";
	}

	
	
}
