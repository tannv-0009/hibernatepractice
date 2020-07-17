package com.example;
import com.example.dao.CustomerDAO;
import com.example.dao.TransactionDAO;
import com.example.dao.UserDAO;
import com.example.entity.Transaction;
import com.example.service.TransactionServices;
import com.example.service.UserServices;

public class MainAplication {

  public static void main(String[] args) {
	 
    try {
    	UserDAO userDao =new UserDAO();
    	UserServices userServices=new UserServices(userDao);
    	userServices.insertUser("test userName "+((int)(Math.random()*100)));

    	userServices.printAllUsers();

		TransactionDAO transactionDAO =new TransactionDAO();
		CustomerDAO  customerDAO =new CustomerDAO();
		TransactionServices transactionServices=new TransactionServices(transactionDAO,customerDAO);
		transactionServices.insertTransaction();
		transactionServices.printAllTransaction();
    	
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}



