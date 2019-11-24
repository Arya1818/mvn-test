package com.mvn.test.dao.Impl;

import java.util.HashMap;
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
	public List<PhotoBoardVO> selectBoardList(SqlSession ss, PhotoBoardVO board) {
		
		return ss.selectList("PhotoBoard.selectBoardList",board);
	
	}

	@Override
	public PhotoBoardVO selectBoard(SqlSession ss, int pbNum) {
		
		return ss.selectOne("PhotoBoard.selectBoard");
		
	}

	@Override
	public int insertBoard(SqlSession ss, PhotoBoardVO board) {

		return ss.insert("PhotoBoard.insertBoard", board);
		
	}

	@Override
	public int deleteBoard(SqlSession ss, PhotoBoardVO board) {
		
		int cnt = ss.delete("PhotoBoard.deleteBoard", board);
		return cnt;
	}

	@Override
	public int updateBoard(SqlSession ss, PhotoBoardVO board) {
		
		int cnt = ss.update("PhotoBoard.updateBoard", board);
		return cnt;
		
	}
	
	public static void main(String[] args) {
		PhotoBoardDAO pbdao = new PhotoBoardDAOImpl();
		SqlSession ss = InitServlet.getSqlSession();
		PhotoBoardVO board = new PhotoBoardVO();
		board.setPbTitle("또또??");
		board.setPbContent("또업데이트내용??");
		board.setCreusr(2);	
		board.setPbNum(11);
		//System.out.println(pbdao.selectBoardList(ss, null));
		//System.out.println(pbdao.insertBoard(ss, board));
		System.out.println(pbdao.updateBoard(ss, board));
		//System.out.println(pbdao.deleteBoard(ss, board));
		
	}

}
