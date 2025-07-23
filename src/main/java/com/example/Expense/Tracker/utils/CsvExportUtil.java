package com.example.Expense.Tracker.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.example.Expense.Tracker.model.Expense;
import com.opencsv.CSVWriter;

public class CsvExportUtil {

    public static void writeExpensesToCsv(List<Expense> expenses, Writer writer) throws IOException {
        try (CSVWriter csvWriter = new CSVWriter(writer)) {
            String[] header = { "ID", "Title", "Category", "Amount", "Date" };
            csvWriter.writeNext(header);

            for (Expense e : expenses) {
                csvWriter.writeNext(new String[] {
                        e.getId().toString(),
                        String.valueOf(e.getCategory()),
                        e.getAmount().toString(),
                        e.getDate().toString()
                });
            }
        }
    }
}
