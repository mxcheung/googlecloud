package com.example.appengine.demos.springboot.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.appengine.demos.springboot.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	List<Transaction> findByAccountNo(String accountNo);
}