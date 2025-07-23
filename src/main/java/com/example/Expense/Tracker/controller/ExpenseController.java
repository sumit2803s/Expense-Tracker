package com.example.Expense.Tracker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import com.example.Expense.Tracker.model.Expense;
import com.example.Expense.Tracker.service.ExpenseService;
import com.example.Expense.Tracker.utils.CsvExportUtil;

import jakarta.servlet.http.HttpServletResponse;

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
    @GetMapping("/export/csv")
    public void exportExpensesToCSV(HttpServletResponse response,
                                    @RequestParam String userId) throws IOException {
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=expenses.csv");

        List<Expense> expenses = service.getAllExpenses(userId);

        try (PrintWriter writer = response.getWriter()) {
            writer.println("Title,Category,Amount,Date");

            for (Expense expense : expenses) {
                writer.printf("%s,%s,%s%n",
                        expense.getCategory(),
                        expense.getAmount(),
                        expense.getDate());
            }
        }
    }


    @GetMapping("/all")
    public List<Expense> getAllExpenses(@RequestParam String userId) {
        return service.getAllExpenses(userId);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

