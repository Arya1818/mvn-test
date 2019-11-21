package com.mvn.test.service;

import java.util.List;
import java.util.Map;

import com.mvn.test.vo.PhotoBoardVO;

public interface PhotoBoardService {
	public List<PhotoBoardVO> getBoardList(Map<String,String> board);
	public PhotoBoardVO getBoard(PhotoBoardVO board);
	public Map<String,String> insertBoard(PhotoBoardVO board);
	public Map<String,String> deleteBoard(PhotoBoardVO board);
	public Map<String,String> updateBoard(PhotoBoardVO board);
}
