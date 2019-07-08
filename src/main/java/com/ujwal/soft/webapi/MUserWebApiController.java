package com.ujwal.soft.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.CradentialValidator;
import com.ujwal.soft.models.Info;
import com.ujwal.soft.models.MUser;
import com.ujwal.soft.models.UserBean;
import com.ujwal.soft.repositories.GetUserRepo;
import com.ujwal.soft.repositories.MUserRepo;

@RequestMapping("/ujwal")
@RestController
public class MUserWebApiController {

	@Autowired MUserRepo muser;
	
	@Autowired GetUserRepo userRepo;
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public @ResponseBody List<MUser> getAllUserList(){
		return muser.findAllByDelStatus(0);
		
	}
	
	@RequestMapping(value = "/getAllUsersByDel", method = RequestMethod.GET)
	public @ResponseBody List<UserBean> getAllUserListByDel(){
		return  userRepo.findUserByDelStatus();
		
	}
	
	@RequestMapping(value = "/getUserById", method = RequestMethod.POST)
	public@ResponseBody MUser getUserDetailById(@RequestParam int id) {
		
		return muser.findByUserIdAndDelStatus(id,0);
		
	}
	
	@RequestMapping(value="/insertNewUser", method=RequestMethod.POST)
	public@ResponseBody MUser addNewUser(@RequestBody MUser mUser) {
		return muser.save(mUser);
		
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.POST)
	public @ResponseBody Info deleteUser(@RequestParam int id) {
		
		Info info =new Info();
		int isDelete = muser.deleteUser(id);
		
		if(isDelete!=0) {
			info.setError(false);
			info.setMessage("sucess");
		}else {
			info.setError(true);
			info.setMessage("Fail");
		}
		return info;
		
	}
	

	@RequestMapping(value = { "/loginUser" }, method = RequestMethod.POST)
	public @ResponseBody CradentialValidator loginUser(@RequestParam("usrMob") String usrMob,
			@RequestParam("userPass") String userPass) {

		CradentialValidator loginResponse = new CradentialValidator();
		try {

			MUser mu = muser.findByUserMobileAndUserPwdAndDelStatus(usrMob, userPass, 0);
			if (mu == null) {
				loginResponse.setError(true);
				loginResponse.setMsg("login Failed");
			} else {
				loginResponse.setError(false);
				loginResponse.setMsg("login successfully");
				loginResponse.setMusr(mu);
			}

		} catch (Exception e) {

			e.printStackTrace();
			loginResponse.setError(true);
			loginResponse.setMsg("login Failed");
		}

		return loginResponse;
	}

	
	
	
	@RequestMapping(value = { "/deleteMultiUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiLocation(@RequestParam("userIds") List<Integer> userIds) {
		
		Info info = new Info();

		try {
			int delete = muser.deleteMultiUsers(userIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

}
