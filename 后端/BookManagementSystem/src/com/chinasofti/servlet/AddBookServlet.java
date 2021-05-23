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
import com.chinasofti.entity.Book;
import com.google.gson.Gson;

@WebServlet("/book/add")  // 注解用于标注在一个继承了HttpServlet类
public class AddBookServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决跨域和编码问题
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		
		//得到要新增的消息编号
		String addBookName = request.getParameter("addBookName"); 
		String addBookAuthor = request.getParameter("addBookAuthor"); 
		String addBookPublisher = request.getParameter("addBookPublisher"); 
		
		// 新增操作
		BookDao dao = new BookDao();
		Book book = new Book(1, addBookName, addBookAuthor, addBookPublisher);	
		// 返回新增结果
		int num = dao.addBook(book);   // 返回0表示错误
		
		// 数据封装
		Map map = new HashMap();
		map.put("checkOK", num);
						
		//把数据库得到的数据，组装成json格式
		String json = new Gson().toJson(map);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();		
	}
}
