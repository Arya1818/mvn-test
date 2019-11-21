package com.mvn.test.dao.Impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.PhotoBoardDAO;
import com.mvn.test.vo.PhotoBoardVO;

public class PhotoBoardDAOImpl implements PhotoBoardDAO {
	
	private static SqlSessionFactory ssf;

	@Override
	public List<PhotoBoardVO> selectBoardList(Map<String, String> board) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ss.selectList("PhotoBoard.selectBoardList");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public PhotoBoardVO selectBoard(PhotoBoardVO user) {
		
		SqlSession ss = InitServlet.getSqlSession();
		try {
			int cnt = ss.selectOne("PhotoBoard.selectBoard");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public int insertBoard(PhotoBoardVO board) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			int cnt = ss.insert("PhotoBoard.insertBoard");
			ss.commit();
			return cnt;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return 0;
	}

	@Override
	public int deleteBoard(PhotoBoardVO user) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			int cnt = ss.insert("PhotoBoard.deleteBoard");
			ss.commit();
			return cnt;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return 0;
	}

	@Override
	public int updateBoard(PhotoBoardVO user) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			int cnt = ss.insert("PhotoBoard.updateBoard");
			ss.commit();
			return cnt;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return 0;
	}
	public static void main(String[] args) {
		PhotoBoardDAO pbdao = new PhotoBoardDAOImpl();
		//PhotoBoardVO pb = new PhotoBoardVO();
		//System.out.println(pb);
		
		
		System.out.println(pbdao.insertBoard(null));
	}

}
