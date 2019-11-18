package com.mvn.test.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.UserInfoDAO;
import com.mvn.test.vo.UserInfoVO;

public class UserInfoDAOImpl implements UserInfoDAO {

	private static SqlSessionFactory ssf;

	@Override
	public List<UserInfoVO> selectUserList(Map<String, String> pUser) {

		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ss.selectList("UserInfo.selectUserList"); // 쿼리문실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}

		return null;
	}

	public static void main(String[] args) { // 에러테스트
		UserInfoDAO udao = new UserInfoDAOImpl();
		Map<String, String> pUser = new HashMap<>();
		// udao.selectUserList(null);
		System.out.println(udao.selectUserList(pUser));
	}
}
