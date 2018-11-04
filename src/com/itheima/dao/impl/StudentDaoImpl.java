package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 这是StudentDao的实现，针对前面定义的规范，做出具体的实现
 * @author 
 */
import com.itheima.dao.StudentDao;
import com.itheima.domain.Student;
import com.itheima.util.JDBCUtil02;
import com.itheima.util.TestUtils;

public class StudentDaoImpl implements StudentDao {
	/**
	 * 查询所有学生
	 * @throws SQLException 
	 */
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu", new BeanListHandler<Student>(Student.class));
		
	}

	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("insert into stu values(null,?,?,?,?,?,?)",
			student.getSname(),
			student.getGender(),
			student.getPhone(),
			student.getBirthday(),
			student.getHobby(),
			student.getPhone()
				);
		
	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("delete from stu where sid=?",sid);
		
	}

	@Override
	public Student findStudentByID(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu where sid = ? ", new BeanHandler<Student>(Student.class),sid);
	}

	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update stu set sname=? , gender=? , phone=? , birthday=? , hobby=? , info=? where sid = ? ", student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getSid()
				);
	}

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
	
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		//这里得判断一下两个都有两个存在一个或者两个都没有的情况，模糊查询
		String sql = "select * from stu where 1=1 ";
		List<String>list = new ArrayList<String>();
		//判断有没有姓名 如果有的就把他主拼到sql语句中
		if(!TestUtils.isEmpty(sname)) {
			sql = sql + " and sname like ?";
			list.add("%"+sname+"%");
 		}
		//判断有没有性别 如果有的就把他主拼到sql语句中
		if(!TestUtils.isEmpty(sgender)) {
			sql = sql + " and gender = ?";
			list.add(sgender);
 		}
	
		return runner.query(sql , new BeanListHandler<Student>(Student.class) ,list.toArray() );
		 
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		//第一个问号代表一页返回多少条记录，第二个，跳过前面的多少条记录。
		//5 0 ---第一页（1-1）*5
		//5 5 ---第二页（1-1）*5
		//5 10 ---第三页（1-1）*5
		//5 15 ---第四页（1-1）*5
		
		return runner.query("select * from stu limit ? offset ?",
				new BeanListHandler<Student>(Student.class) , PAGE_SIZE ,(currentPage-1)*PAGE_SIZE);
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		//用于处理 平均值 ，  总的个数 。 
		Long result = (Long)runner.query("select count(*) from stu " ,new ScalarHandler());
		return result.intValue();
	}

	

}
