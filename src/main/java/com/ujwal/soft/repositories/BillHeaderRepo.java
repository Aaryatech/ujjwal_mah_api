package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujwal.soft.models.BillDetails;
import com.ujwal.soft.models.BillHeader;

public interface BillHeaderRepo extends JpaRepository<BillHeader, Integer>{

	BillHeader findByBillHeaderIdAndDelStatus(int billHeadId, int i);

	//void getBillDetailList(List<BillDetails> billDetList);


}
