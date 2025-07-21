package com.example.Expense.Tracker.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jdk.jfr.Category;
import lombok.Data;

@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue
    private Long id;

    private String userId;
    private String description;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Category category;

    private LocalDate date;
    private LocalDateTime createdAt = LocalDateTime.now();
}
