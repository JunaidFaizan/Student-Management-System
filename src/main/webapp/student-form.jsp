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
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
            <div>
                <a href="https://www.xadmin.net" class="navbar-brand">Student Management Application</a>
            </div>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Students</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${student != null}">
                    <form action="update" method="post">
                </c:if>
                <c:if test="${student == null}">
                    <form action="insert" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${student != null}">Edit Student</c:if>
                        <c:if test="${student == null}">Add New Student</c:if>
                    </h2>
                </caption>
                
                   <fieldset class="form-group">
                    <label>Student Id</label>
                    <input type="text" value="<c:out value='${student.student_id}' />" class="form-control" name="student_id" required="required">
                </fieldset>

                <c:if test="${student != null}">
                    <input type="hidden" name="student_id" value="<c:out value='${student.student_id}' />" />
                </c:if>
             
                <fieldset class="form-group">
                    <label>Student Name</label>
                    <input type="text" value="<c:out value='${student.student_name}' />" class="form-control" name="student_name" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Student Email</label>
                    <input type="text" value="<c:out value='${student.student_email}' />" class="form-control" name="student_email">
                </fieldset>

                <fieldset class="form-group">
                    <label>Student Phone</label>
                    <input type="text" value="<c:out value='${student.student_phone}' />" class="form-control" name="student_phone">
                </fieldset>

                <fieldset class="form-group">
                    <label>Student Score</label>
                    <input type="text" value="<c:out value='${student.student_score}' />" class="form-control" name="student_score">
                </fieldset>

                <fieldset class="form-group">
                    <label>Student Course</label>
                    <input type="text" value="<c:out value='${student.student_course}' />" class="form-control" name="student_course">
                </fieldset>
                
                 <fieldset class="form-group">
                    <label>Student Batch</label>
                    <input type="text" value="<c:out value='${student.student_batch}' />" class="form-control" name="student_batch">
                </fieldset>

                <fieldset class="form-group">
                    <label>Student Fees</label>
                    <input type="text" value="<c:out value='${student.student_fees}' />" class="form-control" name="student_fees">
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
