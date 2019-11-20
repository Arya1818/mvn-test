package com.mvn.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/file")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memSize = 1024 * 1024 * 5; //5MB - 5MB다차면 tmp에 저장. tmp가 여러개 생김 - thread
		int totalSize = 1024 * 1024 * 50; //50MB - 서버에 올릴수 있는 크기
		int fileSize = 1024 * 1024 * 10; //10MB - 서버에 올릴수 있는 파일 하나의 크기
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		dfif.setSizeThreshold(memSize);
		dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		sfu.setFileSizeMax(fileSize);
		sfu.setSizeMax(totalSize);
		if(ServletFileUpload.isMultipartContent(request)){
			try {
				List<FileItem> fList = sfu.parseRequest(request);
				for(FileItem fi:fList) {
					//System.out.println(fi.isFormField()); //input type="file"은 formfield가 아니라서 false가 나옴.
					//System.out.println(fi.getFieldName());
					String key = fi.getFieldName(); //form태그들의 name값들
					if(fi.isFormField()) { //file빼고 나머지가 있을때(true)
						String value = fi.getString("utf-8");
						System.out.println(key + ":" + value); //form태그에서 file,아닌것을 보내도 file은 안가져옴
					}else {
						String path ="C:\\Users\\Administrator\\git\\mvn-test\\mvn-test\\WebContent\\img";
						String fileName = fi.getName(); //업로드한 애 이름 
						File targetFile = new File(path + "\\" + fileName);
						fi.write(targetFile);
					}
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}else {
			throw new ServletException("파일 형식 잘못됨");
		}
		
		//boolean isForm = ServletFileUpload.isMultipartContent(request);
		//System.out.println(isForm); //브라우저에서 파일을 전송할 때 true or false가 찍힘
		
	}

	public static void main(String[] args) {
		String tmp = System.getProperty("java.io.tmpdir"); // system에서 set한적 없음. window가 가지고있는걸 jvm에서 가져오는것.
		System.out.println(tmp);
	}
}

//파일은 request.getParameter(키,밸류)이렇게 못가져옴. 그래서 파일을 읽어들이는 작업이 필요함. 
//우리가 파일을 보내는거니까 file.jsp의 enctype이 multipart/form-data여야 한다. (파일 확장자)
//getName과 getfilename 차이