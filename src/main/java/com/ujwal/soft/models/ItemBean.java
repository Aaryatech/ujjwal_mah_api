package com.ujwal.soft.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemBean {
	
	@Id
	private int billDetailId;
	private int partId;
	private String partName;
	private String hsnCode;
	private float taxPer;
	private float cgst;
	private float sgst;
	private float igst;	
	private float qty;
	private float totalTax;
	private float taxableAmount;
	private float cgstPer;
	private float sgstPer;
	 
	
	public float getCgstPer() {
		return cgstPer;
	}
	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}
	public float getSgstPer() {
		return sgstPer;
	}
	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}
	public int getBillDetailId() {
		return billDetailId;
	}
	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
	}

	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	public float getCgst() {
		return cgst;
	}
	public void setCgst(float cgst) {
		this.cgst = cgst;
	}
	public float getSgst() {
		return sgst;
	}
	public void setSgst(float sgst) {
		this.sgst = sgst;
	}
	public float getIgst() {
		return igst;
	}
	public void setIgst(float igst) {
		this.igst = igst;
	}
	public float getQty() {
		return qty;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	public float getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}
	public float getTaxableAmount() {
		return taxableAmount;
	}
	public void setTaxableAmount(float taxableAmount) {
		this.taxableAmount = taxableAmount;
	}
	public float getTaxPer() {
		return taxPer;
	}
	public void setTaxPer(float taxPer) {
		this.taxPer = taxPer;
	}
	@Override
	public String toString() {
		return "ItemBean [billDetailId=" + billDetailId + ", partId=" + partId + ", partName=" + partName + ", hsnCode="
				+ hsnCode + ", taxPer=" + taxPer + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst + ", qty="
				+ qty + ", totalTax=" + totalTax + ", taxableAmount=" + taxableAmount + "]";
	}
	
	
	
	
}
