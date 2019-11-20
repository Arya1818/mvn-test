package com.mvn.test.service.Impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.session.SqlSession;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.FileTestDAO;
import com.mvn.test.dao.Impl.FileTestDAOImpl;
import com.mvn.test.service.FileTestService;
import com.mvn.test.vo.FileTestVO;

public class FileTestServiceImpl implements FileTestService {
	private FileTestDAO ftdao = new FileTestDAOImpl();
	private String path = "C:\\Users\\Administrator\\git\\mvn-test\\mvn-test\\WebContent\\img";
	
	@Override
	public Map<String, String> insertFileTest(Map<String, Object> param) {
		SqlSession ss = InitServlet.getSqlSession();
		
		try {
			String ftName = (String)param.get("ftName");
			String ftId = (String)param.get("ftId");
			FileItem fi = (FileItem)param.get("ftFile");
			
			Map<String,String> fileTest = new HashMap<>();
			fileTest.put("ftName", ftName);
			fileTest.put("ftId", ftName);
			fileTest.put("ftFile", "/img/" + fi.getName()); //file이름
			
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
	public List<Map<String, String>> getFileList() {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ftdao.selectFileList(ss);
		}catch(Exception e){
			ss.rollback();
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;	
	}

	@Override
	public FileTestVO getFile(FileTestVO file) {
		
		return ftdao.selectOneFile(file);
	}
	
}
