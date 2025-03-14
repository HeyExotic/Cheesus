package com.csc;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CheeseDataProcessor {

    public int countPasteurizedCheeses(List<CheeseRecord> records) {
        int count = 0;
        for (CheeseRecord record : records) {
            if ("pasteurized".equalsIgnoreCase(record.getMilkTreatmentType())) {
                count++;
            }
        }
        return count;
    }

    public int countRawMilkCheeses(List<CheeseRecord> records) {
        int count = 0;
        for (CheeseRecord record : records) {
            if ("raw milk".equalsIgnoreCase(record.getMilkTreatmentType())) {
                count++;
            }
        }
        return count;
    }

    public int countOrganicHighMoistureCheeses(List<CheeseRecord> records) {
        int count = 0;
        for (CheeseRecord record : records) {
            if (record.getOrganic() == 1 && record.getMoisturePercent() > 41.0) {
                count++;
            }
        }
        return count;
    }

    public String findMostCommonMilkType(List<CheeseRecord> records) {
        Map<String, Integer> milkTypeCounts = new HashMap<>();
        for (CheeseRecord record : records) {
            String milkType = record.getMilkType();
            milkTypeCounts.put(milkType, milkTypeCounts.getOrDefault(milkType, 0) + 1);
        }

        return milkTypeCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Unknown");
    }
}