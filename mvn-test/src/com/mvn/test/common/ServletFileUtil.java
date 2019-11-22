package com.mvn.test.common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ServletFileUtil {
	private static final String path = "C:\\Users\\Administrator\\git\\mvn-test\\mvn-test\\WebContent\\img\\";
	private static final int memorySize = 1024 * 1024 * 5; // 5MB
	private static final int totalSize = 1024 * 1024 * 400; // 50MB
	private static final int fileSize = 1024 * 1024 * 400; // 10MB
	private static final DiskFileItemFactory dfif = new DiskFileItemFactory();
	private static final ServletFileUpload sfu;
	static {
		dfif.setSizeThreshold(memorySize);
		dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));
		sfu = new ServletFileUpload(dfif);
		sfu.setFileSizeMax(fileSize);
		sfu.setSizeMax(totalSize);
	}

	public static Map<String, Object> parseRequest(HttpServletRequest request) throws ServletException {
		Map<String, Object> param = new HashMap<>();

		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> fList = sfu.parseRequest(request);
				for (FileItem fi : fList) {
					String key = fi.getFieldName();
					if (fi.isFormField()) {
						String value = fi.getString("utf-8");
						param.put(key, value);
						// System.out.println(key + value);
					} else {
						param.put(key, fi); // db에선 fi(주소)가 필요한게 아니라 파일명이 필요함. 그래서 service에서 수정해줘야함
						// System.out.println(param);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new ServletException("파일형식잘못됨");
		}
		return param;
	}
	public static String saveFile(FileItem fi) throws Exception {
		String fileName = fi.getName();
		fileName = System.nanoTime()	+ fileName.substring(fileName.lastIndexOf("."));
		File f = new File(path + fileName);
		fi.write(f);
		return fileName;
	}
}
