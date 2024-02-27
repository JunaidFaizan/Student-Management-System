package com.xadmin.studentmanagement.web;
import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.studentmanagement.dao.StudentDao;
import com.xadmin.studentmanagment.bean.*;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	
	public void init() {
		 studentDao = new StudentDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertStudent(request, response);
				break;
			case "/delete":
				deleteStudent(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateStudent(request, response);
				break;
			default:
				listStudent(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Student> listStudent = studentDao.selectAllStudent();
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String student_id = request.getParameter("student_id");
		Student existingStudent = studentDao.selectStudent(student_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String student_id = request.getParameter("student_id");
		String student_name = request.getParameter("student_name");
		String student_email = request.getParameter("student_email");
		Long student_phone = Long.parseLong(request.getParameter("student_phone"));
		Double student_score = Double.parseDouble(request.getParameter("student_score"));
		String student_course = request.getParameter("student_course");
		int student_fees = Integer.parseInt(request.getParameter("student_fees"));
		String student_batch = request.getParameter("student_batch");
		Student newStudent = new Student(student_id,student_name,student_email,student_phone,student_score,student_course,student_fees,student_batch);
		studentDao.insertStudent(newStudent);
		response.sendRedirect("list");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String student_id = request.getParameter("student_id");
		String student_name = request.getParameter("student_name");
		String student_email = request.getParameter("student_email");
		Long student_phone = Long.parseLong(request.getParameter("student_phone"));
		Double student_score = Double.parseDouble(request.getParameter("student_score"));
		String student_course = request.getParameter("student_course");
		int student_fees = Integer.parseInt(request.getParameter("student_fees"));
		String student_batch = request.getParameter("student_batch");
		Student updatedStudent = new Student(student_id,student_name,student_email,student_phone,student_score,student_course,student_fees,student_batch);
		studentDao.updateStudent(updatedStudent);
		response.sendRedirect("list");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String student_id = request.getParameter("student_id");
		studentDao.deleteStudent(student_id);
		response.sendRedirect("list");

	}

}