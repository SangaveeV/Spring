package com.sangavee.expenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sangavee.expenseTracker.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
