package com.example.Expense.Tracker.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String description;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Category category;

    private LocalDate date;

    private LocalDateTime createdAt = LocalDateTime.now();

    // No-arg constructor (required by JPA)
    public Expense() {
    }

    // All-args constructor
    public Expense(Long id, String userId, String description, BigDecimal amount, Category category, LocalDate date, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.createdAt = createdAt;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Optional: toString, equals, hashCode

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", category=" + category +
                ", date=" + date +
                ", createdAt=" + createdAt +
                '}';
    }
}
