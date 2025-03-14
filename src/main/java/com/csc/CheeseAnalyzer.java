package com.csc;

import java.io.IOException;
import java.util.List;

public class CheeseAnalyzer {

    public static void main(String[] args) {
        String csvFile = "src/main/resources/cheese_data.csv";
        String outputFile = "output.txt";

        try {
            analyzeCheeseData(csvFile, outputFile);
            System.out.println("Results written to " + outputFile);
        } catch (IOException e) {
            System.err.println("An error occurred while reading/writing files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void analyzeCheeseData(String csvFile, String outputFile) throws IOException {
        FileHandler fileHandler = new FileHandler();
        List<CheeseRecord> records = fileHandler.readCheeseData(csvFile);

        CheeseDataProcessor processor = new CheeseDataProcessor();
        int pasteurizedCount = processor.countPasteurizedCheeses(records);
        int rawMilkCount = processor.countRawMilkCheeses(records);
        int organicMoistureCount = processor.countOrganicHighMoistureCheeses(records);
        String mostCommonMilkType = processor.findMostCommonMilkType(records);

        fileHandler.writeResultsToFile(outputFile, pasteurizedCount, rawMilkCount, organicMoistureCount, mostCommonMilkType);
    }
}