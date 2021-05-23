package com.chinasofti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chinasofti.dao.BookDao;
import com.google.gson.Gson;

@WebServlet("/books/del")
public class DelBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决跨域和编码问题
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		
		// 得到要删除的消息编号
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		// 删除操作
		BookDao dao = new BookDao();
				
		// 删除结果返回判断
		int num = dao.deleteBook(mid);
		
		// 数据封装，并返回
		Map map = new HashMap();
		map.put("checkOK", num);
		
		//把数据库得到的数据，组装成json格式
		 String json = new Gson().toJson(map);
		 PrintWriter out = response.getWriter();
		 out.println(json);
		 out.close();
	}
}
