package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ujwal.soft.models.UserBean;

@Repository
public interface GetUserRepo extends JpaRepository<UserBean, Integer> {

	@Query(value="SELECT u.user_id, u.del_status, u.user_name, u.user_mobile, u.user_email, l.location_name, c.comp_name, c.comp_id, u.company_id, u.location_id"
			+ " FROM m_user u, m_location l, m_company c\r\n" + 
			"WHERE u.del_status=0 AND u.company_id=c.comp_id AND u.location_id=l.location_id ORDER BY u.user_id DESC",nativeQuery=true)
	public List<UserBean> findUserByDelStatus();

}
