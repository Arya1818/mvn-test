package com.mvn.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.PhotoBoardVO;

public interface PhotoBoardDAO {
	List<PhotoBoardVO> selectBoardList(SqlSession ss, PhotoBoardVO board);
	public PhotoBoardVO selectBoard(SqlSession ss, int pbNum);
	public int insertBoard(SqlSession ss, PhotoBoardVO board);
	public int deleteBoard(SqlSession ss, PhotoBoardVO board);
	public int updateBoard(SqlSession ss, PhotoBoardVO board);
	

}
