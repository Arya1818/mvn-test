package com.mvn.test.dao.Impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvn.test.controller.InitServlet;
import com.mvn.test.dao.FileTestDAO;
import com.mvn.test.vo.FileTestVO;

public class FileTestDAOImpl implements FileTestDAO {

	public static void main(String[] args) {
		FileTestDAO fdao = new FileTestDAOImpl();
		SqlSession ss = InitServlet.getSqlSession();
		System.out.println(fdao.selectFileList(ss));
	}

	@Override
	public int insertFileTest(SqlSession ss, Map<String, String> fileTest) {

		return ss.insert("FileTest.insertFileTest", fileTest);

	}

	@Override
	public List<Map<String, String>> selectFileList(SqlSession ss) {

		return ss.selectList("FileTest.selectFileList");

	}

	@Override
	public FileTestVO selectOneFile(FileTestVO file) {
		SqlSession ss = InitServlet.getSqlSession();
		try {
			return ss.selectOne("FileTest.selectOneFile");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}
}
