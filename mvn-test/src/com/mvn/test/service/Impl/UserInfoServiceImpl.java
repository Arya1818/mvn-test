package com.mvn.test.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.dao.Impl.UserInfoDAOImpl;
import com.mvn.test.service.UserInfoService;
import com.mvn.test.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uidao = new UserInfoDAOImpl();

	@Override
	public List<UserInfoVO> getUserList(Map<String, String> pUser) {
		return uidao.selectUserList(pUser);
	}

	@Override
	public UserInfoVO getUser(UserInfoVO user) {
		return uidao.selectUser(user);
	}

	@Override
	public Map<String, String> doSignup(UserInfoVO user) {
		Map<String, String> rMap = new HashMap<String, String>();
		rMap.put("msg", "회원가입실패");
		rMap.put("result", "false");
		if (uidao.insertUser(user) == 1) {
			rMap.put("msg", "회원가입성공");
			rMap.put("result", "true");
		}
		return rMap;
	}

	@Override
	public Map<String, String> deleteUser(UserInfoVO user) {
		Map<String, String> rMap = new HashMap<String, String>();
		rMap.put("msg", "삭제실패");
		rMap.put("result", "false");
		if (uidao.deleteUser(user) == 1) {
			rMap.put("msg", "삭제성공");
			rMap.put("result", "true");
		}
		return rMap;
	}

	@Override
	public Map<String, String> updateUser(UserInfoVO user) {
		Map<String, String> rMap = new HashMap<String, String>();
		rMap.put("msg", "수정실패");
		rMap.put("result", "false");
		if (uidao.updateUser(user) == 1) {
			rMap.put("msg", "수정성공");
			rMap.put("result", "true");
		}
		return rMap;
	}
}
