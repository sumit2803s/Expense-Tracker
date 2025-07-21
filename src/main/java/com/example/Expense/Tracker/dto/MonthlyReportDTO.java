package com.example.Expense.Tracker.dto;

import java.math.BigDecimal;
import java.util.Map;

import com.example.Expense.Tracker.model.Category;


public class MonthlyReportDTO {

    private String month;
    private BigDecimal totalExpenses;
    private Map<Category, BigDecimal> categoryBreakdown;

    // No-args constructor
    public MonthlyReportDTO() {
    }

    // All-args constructor
    public MonthlyReportDTO(String month, BigDecimal totalExpenses, Map<Category, BigDecimal> categoryBreakdown) {
        this.month = month;
        this.totalExpenses = totalExpenses;
        this.categoryBreakdown = categoryBreakdown;
    }

    // Getters and Setters
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(BigDecimal totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Map<Category, BigDecimal> getCategoryBreakdown() {
        return categoryBreakdown;
    }

    public void setCategoryBreakdown(Map<Category, BigDecimal> categoryBreakdown) {
        this.categoryBreakdown = categoryBreakdown;
    }
}

