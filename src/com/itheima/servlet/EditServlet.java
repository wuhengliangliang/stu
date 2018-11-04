package com.itheima.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;

/**
 * 处理单个学生的更新，查询一个学生的信息
 * @author Administrator
 *
 */
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、接收id
			String a=request.getParameter("sid");
			
			int sid = Integer.parseInt(a);
			//2、查询学生数据
			StudentService service = new StudentServiceImpl();
			Student student = service.findStudentByID(sid);
			//3、显示数据
			//存数据
			request.setAttribute("stu", student);
			//跳转页面
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
