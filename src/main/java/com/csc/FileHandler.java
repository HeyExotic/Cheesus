package com.csc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public List<CheeseRecord> readCheeseData(String csvFile) throws IOException {
        List<CheeseRecord> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            String[] headers = null;

            if ((line = reader.readLine()) != null) {
                headers = line.split(",");
            }

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length < headers.length) continue;

                String milkTreatmentType = getValue(headers, values, "MilkTreatmentTypeEn");
                String organic = getValue(headers, values, "Organic");
                String moisturePercentStr = getValue(headers, values, "MoisturePercent");
                String milkType = getValue(headers, values, "MilkTypeEn");
                System.out.println("Milk Treatment Type: " + milkTreatmentType);

                if (milkTreatmentType != null && organic != null && moisturePercentStr != null && milkType != null) {
                    try {
                        int isOrganic = Integer.parseInt(organic.trim());
                        double moisturePercent = Double.parseDouble(moisturePercentStr.trim());
                        records.add(new CheeseRecord(milkTreatmentType.trim(), isOrganic, moisturePercent, milkType.trim()));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid row: " + line);
                    }
                }
            }
        }
        return records;
    }

    public void writeResultsToFile(String outputFile, int pasteurizedCount, int rawMilkCount, int organicMoistureCount, String mostCommonMilkType) throws IOException {
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("Number of cheeses using pasteurized milk: " + pasteurizedCount + "\n");
            writer.write("Number of cheeses using raw milk: " + rawMilkCount + "\n");
            writer.write("Number of organic cheeses with moisture > 41.0%: " + organicMoistureCount + "\n");
            writer.write("Most common milk type in Canada: " + mostCommonMilkType + "\n");
        }
    }

    private String getValue(String[] headers, String[] values, String columnName) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].trim().equalsIgnoreCase(columnName)) {
                return values[i].trim();
            }
        }
        throw new IllegalArgumentException("Column not found: " + columnName);
    }
}