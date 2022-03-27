package com.sangavee.expenseTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangavee.expenseTracker.model.Expense;
import com.sangavee.expenseTracker.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;
	
	@Override
	public List<Expense> findAll() {
		List<Expense> expenses=expenseRepository.findAll();
		return expenses;
	}

	@Override
	public Expense save(Expense expense) {
		expenseRepository.save(expense);
		return expense;
	}

	@Override
	public Expense findById(Long id) {
		if(expenseRepository.findById(id).isPresent()) {
			return expenseRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Expense expense=findById(id);
		expenseRepository.delete(expense);		
	}

}
