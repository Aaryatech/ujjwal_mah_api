package com.ujwal.soft.repositories;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujwal.soft.models.MUser;

@Repository
public interface MUserRepo extends JpaRepository<MUser, Integer> {

	/*@Query(value="SELECT * FROM m_user WHERE del_status = 0 and user_id=:id",nativeQuery=true)
	public MUser findUserById(@Param("id") int id);*/
	
	@Transactional
	@Modifying
	@Query(value="update m_user set del_status = 1 where user_id=:id",nativeQuery=true)
	public int deleteUser(@Param("id") int id);
	
	public List<MUser> findAllByDelStatus(int i);
	
	public MUser findByUserIdAndDelStatus(int userId, int delStatus);
	
	public MUser findByUserMobileAndUserPwdAndDelStatus(String usrMob, String userPass, int i);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_user SET del_status=1  WHERE user_id IN(:userIds)",nativeQuery=true)
	public int deleteMultiUsers(@Param("userIds") List<Integer> userIds);
}

