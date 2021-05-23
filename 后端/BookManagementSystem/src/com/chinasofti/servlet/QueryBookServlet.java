package com.chinasofti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.dao.BookDao;
import com.chinasofti.entity.Book;

import com.google.gson.Gson;
@WebServlet("/book/query")
public class QueryBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决跨域问题，需要添加响应头；设置相应报文的字符集
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		
		BookDao dao = new BookDao();
		
		//获取分页的信息、获取图书名称
		int pn = Integer.parseInt(request.getParameter("pn"));
		int rn = Integer.parseInt(request.getParameter("rn"));
		String checkName = request.getParameter("inputName");  // 浏览器返回的参数
	
		// 进行分页获取数据
		List<Book> listByName = dao.getBookList(checkName,pn,rn);	
		int total = dao.count(checkName);    // 数据条数
		
		// 数据封装
		Map map = new HashMap();
		map.put("total",total);
		map.put("listByName", listByName);
			
		//把数据库得到的数据，组装成json格式
		String json = new Gson().toJson(map);	
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
