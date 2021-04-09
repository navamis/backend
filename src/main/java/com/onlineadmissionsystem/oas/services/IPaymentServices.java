package com.onlineadmissionsystem.oas.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineadmissionsystem.oas.entities.Payment;

@Service
public interface IPaymentServices {
	public Payment addPayment(Payment payment);
	
	public List<Payment> viewAllPaymentDetails();
	
	public  List<Payment> getPaymentDetailsByEmail (String emailId);
	
	
	public  Payment getPaymentDetailsByPaymentId (int paymentId); 
	
	public  List<Payment> getPaymentDetailsByApplicationId(int applicationId);
	
	public List<Payment> getPayementDetailsByStatus(String paymentStatus);
	
	public Payment deletePaymentById(int paymentById);
	
	public Payment  updatePaymentDetails(Payment payment);

}
