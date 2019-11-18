package com.mvn.test.controller;

import java.io.InputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.eclipse.jdt.internal.compiler.batch.Main;

import com.mvn.test.dao.Impl.UserInfoDAOImpl;


@WebServlet(name="InitServlet", urlPatterns= {"/init"}, loadOnStartup = 1) //프리로딩:서버켜질때무조건읽힘
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static SqlSessionFactory ssf;
    
    static {
    	String path = "/config/mybatis-config.xml";
		InputStream is = UserInfoDAOImpl.class.getResourceAsStream(path);

		ssf = new SqlSessionFactoryBuilder().build(is);
    }
   
   public static SqlSession getSqlSession() {
	   return ssf.openSession();
	   
   }
}
