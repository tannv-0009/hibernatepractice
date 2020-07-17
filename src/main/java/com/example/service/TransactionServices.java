package com.example.service;

import com.example.dao.CustomerDAO;
import com.example.dao.TransactionDAO;
import com.example.entity.Customer;
import com.example.entity.Transaction;
import com.example.utils.DateUtil;

import java.util.Calendar;
import java.util.List;

public class TransactionServices {

  private TransactionDAO transactionDAO;
  private CustomerDAO customerDAO;

  public TransactionServices(TransactionDAO transactionDAO, CustomerDAO customerDAO) {
    this.transactionDAO = transactionDAO;
    this.customerDAO=customerDAO;
  }

  public void insertTransaction() {
    Calendar calendar = DateUtil.defaultCalendar();
    calendar.set(Calendar.YEAR, 2019);
    calendar.set(Calendar.MONTH, 11);
    calendar.set(Calendar.DATE, 20);
    Customer customer = new Customer();
    customer.setCusName("abc");
    customer.setCusAddress("HN");
    customer.setCusEmail("abc@gmail.com");
//    customerDAO.create(customer);
    Transaction transaction = new Transaction(customer);
    transaction.setTxnDate(calendar.getTime());
    transaction.setTxnTotal(1000);
    transactionDAO.create(transaction);
    customer.setTransaction(transaction);
    customerDAO.update(customer);
    Transaction transaction1 = transactionDAO.findOne(1);
  }

  public void printAllTransaction() {
    List<Transaction> listTransaction = transactionDAO.findAll();
    listTransaction.forEach(
        transaction -> {
          System.out.println(transaction);
        });
  }
}
