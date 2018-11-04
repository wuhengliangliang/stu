<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加学生页面</title>
</head>
<body>
<h3>添加学生页面</h3>
<form method="post" action="AddServlet">
	<table border="1" width="600">
		<tr>
			<td>姓名</td>
			<td><input type="text" name="sname"></td>
		</tr>
		<tr>
			<td>性别</td>
			  <td>	
				<input type="radio" name="gender" value="男">男
				<input type="radio" name="gender" value="女">女
			  </td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td>生日</td>
			<td><input type="text" name="birthday"></td>
		</tr>
		
		<tr>
			<td>爱好</td>
			<td>
				<input type="checkbox" name="hobby" value="游泳">游泳
				<input type="checkbox" name="hobby" value="写字">写字
				<input type="checkbox" name="hobby" value="看书">看书
				<input type="checkbox" name="hobby" value="打代码">打代码
				<input type="checkbox" name="hobby" value="打篮球">打篮球
			</td>
		</tr>
		
		<tr>
			<td>简介</td>
			<td><textarea name="info" rows="3" cols="20"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="添加"></td>
		</tr>
	 </table>
	</form>
</body>
</html>