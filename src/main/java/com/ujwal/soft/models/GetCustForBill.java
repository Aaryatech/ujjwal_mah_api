package com.ujwal.soft.models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class GetCustForBill {
	@Id
	private int custId;
	private String custName;
	private String custVehNo;
	private String custVinNo;
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
	public String getCustVehNo() {
		return custVehNo;
	}
	public void setCustVehNo(String custVehNo) {
		this.custVehNo = custVehNo;
	}
	public String getCustVinNo() {
		return custVinNo;
	}
	public void setCustVinNo(String custVinNo) {
		this.custVinNo = custVinNo;
	}
	@Override
	public String toString() {
		return "GetCustForBill [custId=" + custId + ", custName=" + custName + ", custVehNo=" + custVehNo
				+ ", custVinNo=" + custVinNo + "]";
	}
	
}
