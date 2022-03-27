package com.sangavee.expenseTracker.service;

import java.util.List;

import com.sangavee.expenseTracker.model.Expense;

public interface ExpenseService {

	List<Expense> findAll();
	
	Expense save(Expense Expense);
	
	Expense findById(Long id);
	
	void delete(Long id);
}
