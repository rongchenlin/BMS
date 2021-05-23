package com.chinasofti.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chinasofti.dao.UserDao;
import com.chinasofti.entity.User;
import com.google.gson.Gson;

@WebServlet("/user/login.do")
@MultipartConfig
public class UserLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("uid");
		String pwd = request.getParameter("upwd");
		System.out.println(id+pwd);
		
		Map map = new HashMap();
		UserDao dao = new UserDao();
		User u = dao.getUserById(id);
		if(u!=null && u.getPwd().equals(pwd)){
			u.setPwd(null);
			request.getSession().setAttribute("loginUser", u);  // ±£´æsession
			map.put("user", u);
		}
		String jsonStr = new Gson().toJson(map);
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
		out.close();	
	}
}
