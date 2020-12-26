package com.ujwal.soft.models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class GetModelsForBill {
	@Id
	private int modelId;
	private String modelName;
	private String modelNo;
	
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
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	
	
}
