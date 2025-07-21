package com.example.Expense.Tracker.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Expense.Tracker.model.Expense;
import com.example.Expense.Tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepo;

    public Expense save(Expense expense) {
        return expenseRepo.save(expense);
    }

    public List<Expense> getExpenses(String userId, LocalDate start, LocalDate end) {
        return expenseRepo.findByUserIdAndDateBetween(userId, start, end);
    }

    public void delete(Long id) {
        expenseRepo.deleteById(id);
    }
}

