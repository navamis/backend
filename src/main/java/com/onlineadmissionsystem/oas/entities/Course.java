package com.onlineadmissionsystem.oas.entities;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.List;

@Entity
public class Course {
	
	@Id
	@SequenceGenerator(name="course_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "course_sequence")
	private int courseId;
	private String courseName;
	private String eligibility;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branches;
	
	public Course() {
		
	}
	
	public Course(String courseName, String eligibility, List<Branch> branches) {
		this.courseName=courseName;
		this.eligibility=eligibility;
//		this.college=college;
		this.branches=branches;
	}
	
	public Course(int courseId,String courseName, String eligibility,List<Branch> branches) {
		this.courseId=courseId;
		this.courseName=courseName;
		this.eligibility=eligibility;
		this.branches=branches;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", eligibility=" + eligibility
				+ ", branches=" + branches + "]";
	}
	
	

}
