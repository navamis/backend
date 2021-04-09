package com.onlineadmissionsystem.oas.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class College {
	
	
	
		@Id
		@SequenceGenerator(name="collegeRegId",allocationSize=1)
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int collegeRegId;
		
		
		   private String collegeName;
		 

			@OneToOne(cascade = CascadeType.PERSIST)
			@JoinColumn(name = "addressId")
		    private Address address;
		 
		
		 
		 
		 public College() {
			 
		 }




		public College(String collegeName, Address address) {
			super();
			this.collegeName = collegeName;
			this.address = address;
		}




		public College(int collegeRegId, String collegeName, Address address) {
			super();
			this.collegeRegId = collegeRegId;
			this.collegeName = collegeName;
			this.address = address;
		}




		public int getCollegeRegId() {
			return collegeRegId;
		}




		public void setCollegeRegId(int collegeRegId) {
			this.collegeRegId = collegeRegId;
		}




		public String getCollegeName() {
			return collegeName;
		}




		public void setCollegeName(String collegeName) {
			this.collegeName = collegeName;
		}




		public Address getAddress() {
			return address;
		}




		public void setAddress(Address address) {
			this.address = address;
		}

}