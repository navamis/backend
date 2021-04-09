package com.onlineadmissionsystem.oas.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class University 
{
	public int getUniversityId() {
		return universityId;
	}



	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int universityId;
	String name;
	
	

	
	@OneToMany(cascade = CascadeType.PERSIST)
	List<College> college;
	
	
	public University() {}
	


	public University(String name,  ArrayList<College> college) {
		super();
		this.name = name;
	
		this.college = college;
	}


//
//	public int getUniversityid() {
//		return universityId;
//	}
//
//
//
//	public void setUniversityid(int universityid) {
//		this.universityId = universityid;
//	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	



	public List<College> getCollege() {
		return college;
	}



	public void setCollege(List<College> list) {
		this.college = list;
	}




		

}
