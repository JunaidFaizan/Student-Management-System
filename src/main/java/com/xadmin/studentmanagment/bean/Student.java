package com.xadmin.studentmanagment.bean;


public class Student{
	
	private String student_id;
	
	private String student_name;
	
	private String student_email;
	
	private long   student_phone;
	
	private double student_score;
	
	private String student_course;
	
	private int student_fees;
	
	private String student_batch;

	
	
	public Student() {
		super();
	}



	public Student(String student_id, String student_name, String student_email, long student_phone,
			double student_score, String student_course, int student_fees, String student_batch) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_email = student_email;
		this.student_phone = student_phone;
		this.student_score = student_score;
		this.student_course = student_course;
		this.student_fees = student_fees;
		this.student_batch = student_batch;
	}



	public String getStudent_id() {
		return student_id;
	}



	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}



	public String getStudent_name() {
		return student_name;
	}



	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}



	public String getStudent_email() {
		return student_email;
	}



	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}



	public long getStudent_phone() {
		return student_phone;
	}



	public void setStudent_phone(long student_phone) {
		this.student_phone = student_phone;
	}



	public double getStudent_score() {
		return student_score;
	}



	public void setStudent_score(double student_score) {
		this.student_score = student_score;
	}



	public String getStudent_course() {
		return student_course;
	}



	public void setStudent_course(String student_course) {
		this.student_course = student_course;
	}



	public int getStudent_fees() {
		return student_fees;
	}



	public void setStudent_fees(int student_fees) {
		this.student_fees = student_fees;
	}



	public String getStudent_batch() {
		return student_batch;
	}



	public void setStudent_batch(String student_batch) {
		this.student_batch = student_batch;
	}

	
}