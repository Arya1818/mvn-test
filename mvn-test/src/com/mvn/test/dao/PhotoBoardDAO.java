package com.mvn.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.vo.PhotoBoardVO;

public interface PhotoBoardDAO {
	public List<PhotoBoardVO> selectBoardList(Map<String, String> board);
	public PhotoBoardVO selectBoard(PhotoBoardVO user);
	public int insertBoard(PhotoBoardVO board);
	public int deleteBoard(PhotoBoardVO user);
	public int updateBoard(PhotoBoardVO user);
	

}
