package com.example.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.dao.UserDAO;
import com.example.entity.Address;
import com.example.entity.User;
import com.example.utils.DateUtil;

public class UserServices {
	
	private UserDAO userDao;

	public UserServices(UserDAO userDao) {
		this.userDao=userDao;
	}
	
	

	public void insertUser(String userName) {
		Calendar calendar = DateUtil.defaultCalendar();
	    calendar.set(Calendar.YEAR, 2019);
	    calendar.set(Calendar.MONTH, 11);
	    calendar.set(Calendar.DATE, 20);
		User user= makeTestUser(userName, calendar.getTime(), getListAddress());
		userDao.create(user);
		          
	}
	
	public void deleteUserById(int id) {
	
		userDao.deleteById(id);;
		          
	}
	
	
	 public User makeTestUser(String name, Date dateOfBirth, List<Address> address)
	  {
		    User user = new User();
		    user.setName(name);
		    user.setAddress(address);
		    user.setDateOfBirth(dateOfBirth);
		    return user;
		    
	  }
	 
	 
	  public static List<Address> getListAddress()
	  {
		  List<Address> address= new ArrayList<Address>();
		  
		  address.add(new Address("ADD 1"));
		  address.add(new Address("ADD 2"));
		  address.add(new Address("ADD 3"));
		  return address;
	  }



	public void printAllUsers() {
		List<User> listUser=userDao.findAll();
		listUser.forEach(user->{
				System.out.println(user);
		} );
		
    }

//	 Calendar calendar = DateUtil.defaultCalendar();
//	    calendar.set(Calendar.YEAR, 2019);
//	    calendar.set(Calendar.MONTH, 11);
//	    calendar.set(Calendar.DATE, 20);
//	
//	userDao.create(User.with("test username", calendar.getTime(), getListAddress()));
	

}
