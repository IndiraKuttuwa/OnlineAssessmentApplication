package com.springboot.OnlineAssessmentApplication.testdetails;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestDetails implements Comparable<TestDetails> {

	
	@Id
	private String formattedDate;
	private int testMarks;
	private String email;
	private int totalMarks;
	private String result;
	
	private String assessment;
	
	
	public String getFormattedDate() {
		return formattedDate;
	}
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	public int getTestMarks() {
		return testMarks;
	}
	public void setTestMarks(int testMarks) {
		this.testMarks = testMarks;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public int compareTo(TestDetails o) {
		// TODO Auto-generated method stub
		return this.getFormattedDate().compareTo(o.getFormattedDate());
	}
	
	
	
	
}
