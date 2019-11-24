package com.mvn.test.controller;

import java.io.BufferedReader;
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
import com.mvn.test.common.ServletFileUtil;
import com.mvn.test.service.PhotoBoardService;
import com.mvn.test.service.Impl.PhotoBoardServiceImpl;
import com.mvn.test.vo.PhotoBoardVO;


@WebServlet(name="PBController", urlPatterns= {"/board/*"})
public class PBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhotoBoardService pbs = new PhotoBoardServiceImpl();
	private Gson gson = new Gson();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String cmd = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		//    views/board/list
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(pbs.getBoardList(null));	
		}else if("view".equals(cmd)) {
			json = gson.toJson(pbs.getBoard(Integer.parseInt(request.getParameter("pbNum"))));
		}
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		response.setContentType("application/json;charset=utf-8");
		String json = "";
		if("insert".equals(cmd)) {
			Map<String,Object> param = ServletFileUtil.parseRequest(request);
			Map<String,String> rMap = pbs.insertBoard(param);
		}else if ("delete".equals(cmd)) {
			json = g.toJson(pbs.deleteBoard(Integer.parseInt(request.getParameter("pbNum"))));
		} else if ("update".equals(cmd)) {
			Map<String, Object> param = ServletFileUtil.parseRequest(request);
			param.put("pbNum", request.getParameter("pbNum"));
	

		}
	}
}
