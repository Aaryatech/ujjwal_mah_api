package com.ujwal.soft.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MGetCustomerDetails {

	@Id
	private int custId;
	private String custName;
	private int compId; 
	private String compName;
	private String custAddress;
	private String custPhone;
	/*private String custGstn;
	private String custPan;*/
	private String custEmail;
	private String custVehNo;
	private String custVinNo;
	private String custRegisNo;
	private String custModelNo;
	//private String custState;
	private int custDelStatus;
	private int modelId;
	private String modelName;
	
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	/*public String getCustState() {
		return custState;
	}
	public void setCustState(String custState) {
		this.custState = custState;
	}*/
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	/*public String getCustGstn() {
		return custGstn;
	}
	public void setCustGstn(String custGstn) {
		this.custGstn = custGstn;
	}
	public String getCustPan() {
		return custPan;
	}
	public void setCustPan(String custPan) {
		this.custPan = custPan;
	}*/
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustVehNo() {
		return custVehNo;
	}
	public void setCustVehNo(String custVehNo) {
		this.custVehNo = custVehNo;
	}
	
	public String getCustRegisNo() {
		return custRegisNo;
	}
	public void setCustRegisNo(String custRegisNo) {
		this.custRegisNo = custRegisNo;
	}
   
	public String getCustVinNo() {
		return custVinNo;
	}
	public void setCustVinNo(String custVinNo) {
		this.custVinNo = custVinNo;
	}
	public String getCustModelNo() {
		return custModelNo;
	}
	public void setCustModelNo(String custModelNo) {
		this.custModelNo = custModelNo;
	}
	public int getCustDelStatus() {
		return custDelStatus;
	}
	public void setCustDelStatus(int custDelStatus) {
		this.custDelStatus = custDelStatus;
	}
	
	/*@Override
	public String toString() {
		return "MCustomer [custId=" + custId + ", custName=" + custName + ", compId=" + compId + ", custAddress="
				+ custAddress + ", custPhone=" + custPhone + ", custGstn=" + custGstn + ", custPan=" + custPan
				+ ", custEmail=" + custEmail + ", custVehNo=" + custVehNo + ", custChasiNo=" + custChasiNo
				+ ", custRegisNo=" + custRegisNo + ", custRoNo=" + custRoNo + ", custState=" + custState
				+ ", custDelStatus=" + custDelStatus + ", exInt1=" + exInt1 + ", exInt2=" + exInt2 + ", exInt3="
				+ exInt3 + ", extVar1=" + extVar1 + ", extVar2=" + extVar2 + ", extVar3=" + extVar3 + ", exBool1="
				+ exBool1 + ", exBool2=" + exBool2 + ", exDate1=" + exDate1 + ", exDate2=" + exDate2 + "]";
	}*/
	
	
	
	

}
