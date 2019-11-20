package com.mvn.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.mvn.test.service.FileTestService;
import com.mvn.test.service.Impl.FileTestServiceImpl;
import com.mvn.test.vo.FileTestVO;

@WebServlet("/file2/*")
public class FileServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileTestService fs = new FileTestServiceImpl();
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		String cmd = request.getRequestURI().substring(7);
		if("fileList".equals(cmd)) {
			response.getWriter().print(gson.toJson(fs.getFileList()));	
		}else if("fileView".equals(cmd)) {
			FileTestVO file = new FileTestVO();
			file.setFtNum(Integer.parseInt(request.getParameter("ftNum")));
			System.out.println(file);
			response.getWriter().print(gson.toJson(file));
		}
		
		System.out.println(gson.toJson(fs.getFileList()));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		int memorySize = 1024 * 1024 * 5; // 5MB
		int totalSize = 1024 * 1024 * 50; // 50MB
		int fileSize = 1024 * 1024 * 10; // 10MB
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		dfif.setSizeThreshold(memorySize);
		dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		sfu.setFileSizeMax(fileSize);
		sfu.setSizeMax(totalSize);
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> fList = sfu.parseRequest(request);
				Map<String,Object> param = new HashMap<>();
				for (FileItem fi : fList) {
					String key = fi.getFieldName();
					if (fi.isFormField()) {
						String value = fi.getString("utf-8");
						param.put(key, value);
						System.out.println(key + value);
					} else {
						param.put(key,fi); //db에선 fi(주소)가 필요한게 아니라 파일명이 필요함. 그래서 service에서 수정해줘야함
						System.out.println(param);
					}
					
				}
				fs.insertFileTest(param);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new ServletException("파일형식잘못됨");

		}
	
	
	}

}
