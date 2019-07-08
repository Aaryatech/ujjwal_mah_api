package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujwal.soft.models.BillDetails;

public interface BillDetailRepo extends JpaRepository<BillDetails, Integer>{

	List<BillDetails> findByBillHeaderIdAndDelStatus(int billHeadId, int i);

}
