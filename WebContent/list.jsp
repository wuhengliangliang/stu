<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<title>学生列表</title>
<script type="text/javascript">
	function doDelete(sid){
		/*如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet.
		如何知道用户点击的是确定
		如何在js的方法中请求servlet.
		*/
		var flag = confirm("是否确定删除？");
		if(flag){
			//表明了确定。访问servlet.在当前标签页上打开超链接，
			window.location.href="DeleteServlet?sid="+sid;
		
			}
		}
</script>
<body>
<form action="SearchStudentServlet" method="post">
	<table align="center" border="10" height="800" width="1100">
		<tr>
			<td colspan="8">
				&nbsp;&nbsp;&nbsp;&nbsp;
				按姓名查询：<input type="text" name="sname"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				按性别查询：<select name="sgender">
							<option value="">--请选择--
							<option value="男">男
							<option value="女">女
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" value="查询">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="add.jsp">添加</a>
			</td>	
		</tr>
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="stu">
			<tr align="center">
				<td>${stu.sid}</td>
				<td>${stu.sname}</td>
				<td>${stu.gender}</td>
				<td>${stu.phone}</td>
				<td>${stu.birthday}</td>
				<td>${stu.hobby}</td>
				<td>${stu.info}</td>
				<td><a href="EditServlet?sid=${stu.sid}">更新</a> <a href="#" onclick="doDelete(${stu.sid})">删除</a></td> 
				</tr>
			</c:forEach>
		</table> 
	</form>
</body>
</html>