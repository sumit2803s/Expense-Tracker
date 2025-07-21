package com.example.Expense.Tracker.scheduler;

import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.Expense.Tracker.dto.MonthlyReportDTO;
import com.example.Expense.Tracker.service.ReportService;

@Component
public class MonthlyReportScheduler {

    @Autowired
    private ReportService reportService;

    @Scheduled(cron = "0 0 1 1 * ?") // Every 1st of month at 1 AM
    public void generateReportsForAllUsers() {
        List<String> userIds = List.of("user1", "user2"); // Replace with DB call

        YearMonth lastMonth = YearMonth.now().minusMonths(1);

        for (String userId : userIds) {
            MonthlyReportDTO report = reportService.generateMonthlyReport(userId, lastMonth);
            System.out.println("Generated report for " + userId + ": " + report);
        }
    }
}

