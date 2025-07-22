package com.example.Expense.Tracker.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Expense.Tracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserIdAndDateBetween(String userId, LocalDate from, LocalDate to);
    List<Expense> findAllByUserId(String userId);
}

