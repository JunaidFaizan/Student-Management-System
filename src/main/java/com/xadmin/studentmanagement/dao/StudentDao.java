package com.xadmin.studentmanagement.dao;
import com.xadmin.studentmanagment.bean.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    
	public String jdbcURL = "jdbc:mysql://localhost:3306/tap_crud";
	public String jdbcUserName = "root";
	public String jdbcPassword = "root";
	public String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	
	private static final String INSERT_STUDENT_SQL = "INSERT INTO student_data" + "  (student_id,student_name,student_email,student_phone,student_score,student_course,student_fees,student_batch) VALUES "
			+ " (?, ?, ?, ? , ? , ? , ? , ?);";

	private static final String SELECT_STUDENT_BY_ID = "select student_id,student_name,student_email,student_phone,student_score,student_course,student_fees,student_batch from student_data where student_id =?";
	private static final String SELECT_ALL_STUDENTS = "select * from student_data";
	private static final String DELETE_STUDENT_SQL = "delete from student_data where student_id = ?;";
	private static final String UPDATE_STUDENTS_SQL = "update student_data set student_id = ?,student_name = ? ,student_email = ?,student_phone = ?,student_score = ?,student_course = ?,student_fees = ?,student_batch = ? where student_id = ?";
	 
	public StudentDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertStudent(Student student) throws SQLException {
		System.out.println(INSERT_STUDENT_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
			preparedStatement.setString(1, student.getStudent_id());
			preparedStatement.setString(2, student.getStudent_name());
			preparedStatement.setString(3, student.getStudent_email());
			preparedStatement.setLong(4, student.getStudent_phone());
			preparedStatement.setDouble(5, student.getStudent_score());
			preparedStatement.setString(6, student.getStudent_course());
			preparedStatement.setInt(7, student.getStudent_fees());
			preparedStatement.setString(8, student.getStudent_batch());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Student selectStudent(String StudentId) {
		Student student = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
			preparedStatement.setString(1, StudentId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_email = rs.getString("student_email");
				Long student_phone = rs.getLong("student_phone");
				Double student_score = rs.getDouble("student_score");
				String student_course = rs.getString("student_course");
				int student_fees = rs.getInt("student_fees");
				String student_batch = rs.getString("student_batch");
			
			 student = new Student(student_id,student_name,student_email,student_phone,student_score,student_course,student_fees,student_batch);
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return student;
	}
	
	public List<Student> selectAllStudent() {

		List<Student> students = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String student_id = rs.getString("student_id");
				String student_name = rs.getString("student_name");
				String student_email = rs.getString("student_email");
				Long student_phone = rs.getLong("student_phone");
				Double student_score = rs.getDouble("student_score");
				String student_course = rs.getString("student_course");
				int student_fees = rs.getInt("student_fees");
				String student_batch = rs.getString("student_batch");
			
			 students.add(new Student(student_id,student_name,student_email,student_phone,student_score,student_course,student_fees,student_batch));
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return students;
	}
	
	public boolean deleteStudent(String StudentId) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL);) {
			statement.setString(1, StudentId);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updateStudent(Student student) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENTS_SQL);) {
			System.out.println("updated USer:"+statement);
			statement.setString(1, student.getStudent_id());
			statement.setString(2, student.getStudent_name());
			statement.setString(3, student.getStudent_email());
			statement.setLong(4, student.getStudent_phone());
			statement.setDouble(5, student.getStudent_score());
			statement.setString(6, student.getStudent_course());
			statement.setInt(7, student.getStudent_fees());
			statement.setString(8, student.getStudent_batch());
			statement.setString(9, student.getStudent_id());

			

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	
	}
}
	

