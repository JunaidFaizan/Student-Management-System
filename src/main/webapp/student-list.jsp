<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Student
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Student</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Students</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Student</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>StudentId</th>
						<th>StudentName</th>
						<th>StudentEmail</th>
						<th>StudentPhone</th>
						<th>StudentScore</th>
						<th>StudentCourse</th>
						<th>StudentBatch</th>
						<th>StudentFees</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="student" items="${listStudent}">

						<tr>
							<td><c:out value="${student.student_id}" /></td>
							<td><c:out value="${student.student_name}" /></td>
							<td><c:out value="${student.student_email}" /></td>
							<td><c:out value="${student.student_phone}" /></td>
							<td><c:out value="${student.student_score}" /></td>
							<td><c:out value="${student.student_course}" /></td>
							<td><c:out value="${student.student_batch}" /></td>
							<td><c:out value="${student.student_fees}" /></td>
							<td><a href="edit?student_id=<c:out value='${student.student_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?student_id=<c:out value='${student.student_id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>