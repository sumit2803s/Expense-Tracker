package com.example.Expense.Tracker.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Expense.Tracker.dto.MonthlyReportDTO;
import com.example.Expense.Tracker.model.Category;
import com.example.Expense.Tracker.model.Expense;
import com.example.Expense.Tracker.repository.ExpenseRepository;

@Service
public class ReportService {

    @Autowired
    private ExpenseRepository repo;

    public MonthlyReportDTO generateMonthlyReport(String userId, YearMonth month) {
        LocalDate from = month.atDay(1);
        LocalDate to = month.atEndOfMonth();

        List<Expense> expenses = repo.findByUserIdAndDateBetween(userId, from, to);

        BigDecimal total = expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Map<Category, BigDecimal> breakdown = expenses.stream()
                .collect(Collectors.groupingBy(
                        Expense::getCategory,
                        Collectors.reducing(BigDecimal.ZERO, Expense::getAmount, BigDecimal::add)
                ));

        return new MonthlyReportDTO(month.toString(), total, breakdown);
    }
}

