<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
<script src="bootstrap-3.3.7-dist/js/jquery.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="source/css/add.css">
</head>
<body>
<div>
	<div class="alert alert-warning alert-dismissible" role="alert" style="display: ${message==null?'none':'block'}">
  		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  		<strong>${message}！</strong>
	</div>
	<hr>
	<div class="discription">
		<h2>Add Page</h2>
		<a href="SelectController"><button type="button" class="btn btn-default" style="float: right">Return</button></a>
	</div>
	<div class="list">
		<%-- form表单 --%>
		<form class="form-horizontal" action="AddStudentController" method="post">
  			<div class="form-group">
    			<label for="inputEmail3" class="col-sm-2 control-label">Name</label>
    			<div class="col-sm-10">
     	 			<input type="text" class="form-control" id="inputEmail3" placeholder="Name" name="sname">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputPassword3" class="col-sm-2 control-label">Age</label>
    			<div class="col-sm-10">
      				<input type="text" class="form-control" id="inputPassword3" placeholder="Age" name="sage">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputPassword4" class="col-sm-2 control-label">Sex</label>
    			<div class="col-sm-10">
      				<input type="text" class="form-control" id="inputPassword4" placeholder="Sex" name="ssex">
    			</div>
  			</div>
  			<div class="form-group">
    			<label for="inputPassword5" class="col-sm-2 control-label">Phone</label>
    			<div class="col-sm-10">
      				<input type="text" class="form-control" id="inputPassword5" placeholder="Phone" name="sphone">
    			</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
      				<button type="submit" class="btn btn-default">Submit</button>
    			</div>
  			</div>
		</form>
	</div>
</div>
</body>
</html>