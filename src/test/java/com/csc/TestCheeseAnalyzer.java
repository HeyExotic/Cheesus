package com.csc;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TestCheeseAnalyzer {

    @Test
    void testCountPasteurizedCheeses() {
        List<CheeseRecord> records = Arrays.asList(
                new CheeseRecord("pasteurized", 0, 40.0, "cow"),
                new CheeseRecord("raw", 1, 42.0, "goat"),
                new CheeseRecord("pasteurized", 1, 45.0, "ewe")
        );

        CheeseDataProcessor processor = new CheeseDataProcessor();
        assertEquals(2, processor.countPasteurizedCheeses(records));
    }

    @Test
    void testCountRawMilkCheeses() {
        List<CheeseRecord> records = Arrays.asList(
                new CheeseRecord("pasteurized", 0, 40.0, "cow"),
                new CheeseRecord("raw", 1, 42.0, "goat"),
                new CheeseRecord("raw", 1, 45.0, "ewe")
        );

        CheeseDataProcessor processor = new CheeseDataProcessor();
        assertEquals(2, processor.countRawMilkCheeses(records));
    }

    @Test
    void testCountOrganicHighMoistureCheeses() {
        List<CheeseRecord> records = Arrays.asList(
                new CheeseRecord("pasteurized", 1, 42.0, "cow"),
                new CheeseRecord("raw", 0, 43.0, "goat"),
                new CheeseRecord("pasteurized", 1, 40.0, "ewe")
        );

        CheeseDataProcessor processor = new CheeseDataProcessor();
        assertEquals(1, processor.countOrganicHighMoistureCheeses(records));
    }

    @Test
    void testFindMostCommonMilkType() {
        List<CheeseRecord> records = Arrays.asList(
                new CheeseRecord("pasteurized", 0, 40.0, "cow"),
                new CheeseRecord("raw", 1, 42.0, "goat"),
                new CheeseRecord("pasteurized", 1, 45.0, "cow")
        );

        CheeseDataProcessor processor = new CheeseDataProcessor();
        assertEquals("cow", processor.findMostCommonMilkType(records));
    }
}