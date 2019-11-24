package com.mvn.test.service.Impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.session.SqlSession;

import com.mvn.test.common.ServletFileUtil;
import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.PhotoBoardDAO;
import com.mvn.test.dao.Impl.PhotoBoardDAOImpl;
import com.mvn.test.service.PhotoBoardService;
import com.mvn.test.vo.PhotoBoardVO;


public class PhotoBoardServiceImpl implements PhotoBoardService {
	
	private PhotoBoardDAO pbdao = new PhotoBoardDAOImpl();
	private String path = "C:\\Users\\Administrator\\git\\mvn-test\\mvn-test\\WebContent\\img\\";
	
	@Override
	public List<PhotoBoardVO> getBoardList(PhotoBoardVO board) {
		
		SqlSession ss = InitServlet.getSqlSession();
		
		try {
			return pbdao.selectBoardList(ss, board);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}
		

	@Override
	public PhotoBoardVO getBoard(int pbNum) {
		SqlSession ss = InitServlet.getSqlSession();
		return pbdao.selectBoard(ss, pbNum);
	}

	@Override
	public Map<String, String> insertBoard(Map<String,Object> param) {
		
		PhotoBoardVO pb = new PhotoBoardVO();
		pb.setPbTitle((String)param.get("pbTitle"));
		pb.setPbContent((String)param.get("pbContent"));
		pb.setCreusr(Integer.parseInt((String)param.get("creusr")));
		SqlSession ss = InitServlet.getSqlSession();
		
		Map<String,String> rMap = new HashMap<>();
		rMap.put("msg","실패");
		rMap.put("result","false");
		
		try {
			if(param.get("pbImg1")!=null) {
				FileItem fi = (FileItem)param.get("pbImg1");
				String fileName = ServletFileUtil.saveFile(fi);
				pb.setPbImg1(fileName);
			}
			if(param.get("pbImg2")!=null) {
				FileItem fi = (FileItem)param.get("pbImg2");
				String fileName = ServletFileUtil.saveFile(fi);
				pb.setPbImg2(fileName);
			}
			int cnt = pbdao.insertBoard(ss, pb);
			if(cnt==1) {
				rMap.put("msg","성공");
				rMap.put("result","true");
			}
			ss.commit();
			
		}catch(Exception e){
			ss.rollback();
			e.printStackTrace();
		}finally {
			ss.close();
		}
		System.out.println(pb);
		return rMap;
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
