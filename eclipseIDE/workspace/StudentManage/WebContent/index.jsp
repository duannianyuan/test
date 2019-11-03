<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
<script src="bootstrap-3.3.7-dist/js/jquery.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="source/css/index.css">
</head>
<body>
<%-- 查询表单 --%>
<div>
	<div class="alert alert-warning alert-dismissible" role="alert" style="display: ${message==null?'none':'block'}">
	  	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  	<strong>${message}！</strong>
	</div>
	<hr>
	<div  class="discription">
		<h2>Home</h2>
	</div>
	<div class="search">
		<form class="form-inline" action="SelectController" method="get">
  			<div class="form-group">
    			<label for="exampleInputName2">UserName</label>
    			<input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe" name="sname">
  			</div>
  			<button type="submit" class="btn btn-default">Search</button>
  			&nbsp;&nbsp;&nbsp;&nbsp;
  			<a href="add.jsp"><button type="button" class="btn btn-default">Add</button></a>
  			UserName：${ users.uname }
  			<a href="LogoutController"><button type="button" class="btn btn-default" style="float: right">Logout</button></a>
		</form>
	</div>
	<%-- 展示数据 --%>
	<div class="list">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Age</th>
					<th>Sex</th>
					<th>Phone</th>
					<th>Operating</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${ list }">
					<tr>
						<td>${student.sid}</td>
						<td>${student.sname}</td>
						<td>${student.sage}</td>
						<td>${student.ssex}</td>
						<td>${student.sphone}</td>
						<td>
							<a href="ModifyStudentController?sid=${student.sid}"><button type="button" class="btn btn-info">Modify</button></a>
							<a href="DeleteStudentController?sid=${student.sid}"><button type="button" class="btn btn-danger">Delete</button></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>