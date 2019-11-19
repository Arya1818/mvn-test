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

	@Override
	public int insertUser(UserInfoVO user) {

		SqlSession ss = InitServlet.getSqlSession();
		try {
			int cnt = ss.insert("UserInfo.insertUser", user);
			ss.commit();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return 0;
	}

	@Override
	public int deleteUser(UserInfoVO user) {
		SqlSession ss = InitServlet.getSqlSession();
		try {

			int cnt = ss.delete("UserInfo.deleteUser", user);
			ss.commit();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close(); 
		}
		return 0;
	}

	@Override
	public int updateUser(UserInfoVO user) {
		SqlSession ss = InitServlet.getSqlSession();
		try {

			int cnt = ss.update("UserInfo.updateUser", user);
			ss.commit();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		
		return 0;
	}

	@Override
	public UserInfoVO selectUser(UserInfoVO user) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ss.selectOne("UserInfo.selectUser", user);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}

	public static void main(String[] args) { // 에러테스트
		UserInfoDAO udao = new UserInfoDAOImpl();
		UserInfoVO user = new UserInfoVO();
		user.setUiNum(12);
		//user.setUiId("f1234");
		System.out.println(udao.selectUser(user));
		//Map<String, String> pUser = new HashMap<>();
		// udao.selectUserList(null);
		//System.out.println(udao.selectUserList(pUser));
	}

}
