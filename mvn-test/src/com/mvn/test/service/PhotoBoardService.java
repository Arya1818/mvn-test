package com.mvn.test.service;

import java.util.List;
import java.util.Map;

import com.mvn.test.vo.PhotoBoardVO;

public interface PhotoBoardService {
	public List<PhotoBoardVO> getBoardList(PhotoBoardVO board);
	public PhotoBoardVO getBoard(int pbNum);
	public Map<String,String> insertBoard(Map<String,Object> param);
	public Map<String,String> deleteBoard(PhotoBoardVO board);
	public Map<String,String> updateBoard(PhotoBoardVO board);

}
