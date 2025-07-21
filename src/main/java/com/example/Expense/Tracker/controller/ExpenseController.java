package com.example.Expense.Tracker.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.example.Expense.Tracker.model.Expense;
import com.example.Expense.Tracker.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @PostMapping
    public Expense create(@RequestBody Expense expense) {
        return service.save(expense);
    }

    @GetMapping
    public List<Expense> list(@RequestParam String userId,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return service.getExpenses(userId, from, to);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

