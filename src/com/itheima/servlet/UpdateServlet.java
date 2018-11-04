package com.itheima.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;

public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
		try {
			
			//1、获取客户端提交上来的数据
			String a =request.getParameter("sid");
			
			int sid = Integer.parseInt(a);
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			//这种方式只能拿到其中一个爱好  String hobby = request.getParameter("hobby");
			String info = request.getParameter("info");
			String birthday = request.getParameter("birthday");
			//想要拿到所有的爱好：
			String [] h = request.getParameterValues("hobby");
			String hobby = Arrays.toString(h);
			hobby=hobby.substring(1,hobby.length()-1);
			//2、添加到数据库
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(sid ,sname, gender, phone, hobby, info, date);
			//更新数据库数据
			StudentService service = new StudentServiceImpl();
			service.update(student);
			//3.跳转页面
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
