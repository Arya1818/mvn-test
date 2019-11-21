package com.mvn.test.service.Impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.session.SqlSession;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.PhotoBoardDAO;
import com.mvn.test.dao.Impl.PhotoBoardDAOImpl;
import com.mvn.test.service.PhotoBoardService;
import com.mvn.test.vo.PhotoBoardVO;


public class PhotoBoardServiceImpl implements PhotoBoardService {
	private PhotoBoardDAO pbdao = new PhotoBoardDAOImpl();
	private String path = "C:\\Users\\Administrator\\git\\mvn-test\\mvn-test\\WebContent\\img\\";

	@Override
	public List<PhotoBoardVO> getBoardList(Map<String, String> board) {
		
		return pbdao.selectBoardList(board);
	}

	@Override
	public PhotoBoardVO getBoard(PhotoBoardVO board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> insertBoard(PhotoBoardVO board) {
		SqlSession ss = InitServlet.getSqlSession();
		
		try {
			String pbTitle = (String)param.get("pbTitle");
			String pbContent = (String)param.get("pbContent");
			FileItem pbImg1 = (FileItem)param.get("pbImg1");
			FileItem pbImg2 = (FileItem)param.get("pbImg2");
			
			Map<String,String> photoBoard = new HashMap<>();
			photoBoard.put("pbTitle", pbTitle);
			photoBoard.put("pbContent", pbContent);
			photoBoard.put("ftId", ftName);
			photoBoard.put("ftFile", "/img/" + fi.getName()); //file이름
			
			int cnt = ftdao.insertFileTest(ss, fileTest);
			if(cnt!=1) {
				throw new Exception("저장 안됨!");
			}
			File targetFile = new File(path + fi.getName());
			fi.write(targetFile);
			ss.commit();
			
		}catch(Exception e){
			ss.rollback();
			e.printStackTrace();
		}finally {
			ss.close();
		}
		
		return null;
	}

	@Override
	public Map<String, String> deleteBoard(PhotoBoardVO board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> updateBoard(PhotoBoardVO board) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
