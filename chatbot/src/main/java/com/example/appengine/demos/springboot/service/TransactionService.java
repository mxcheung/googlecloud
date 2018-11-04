package com.example.appengine.demos.springboot.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.appengine.demos.springboot.model.Transaction;


public interface TransactionService {

	void deposit(Transaction transaction);
	

	Transaction checkbalance(String accountNo);
}