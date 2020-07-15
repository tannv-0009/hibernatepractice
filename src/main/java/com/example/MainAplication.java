package com.example;
import com.example.dao.UserDAO;
import com.example.service.UserServices;

public class MainAplication {

  public static void main(String[] args) {
	 
    try {
    	UserDAO userDao =new UserDAO();
    	UserServices userServices=new UserServices(userDao);
    	userServices.insertUser("test userName "+((int)(Math.random()*100)));

    	userServices.printAllUsers();
    	
    	
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}



