package com.csc;

public class CheeseRecord {
    private String milkTreatmentType;
    private int organic;
    private double moisturePercent;
    private String milkType;

    public CheeseRecord(String milkTreatmentType, int organic, double moisturePercent, String milkType) {
        this.milkTreatmentType = milkTreatmentType;
        this.organic = organic;
        this.moisturePercent = moisturePercent;
        this.milkType = milkType;
    }

    public String getMilkTreatmentType() {
        return milkTreatmentType;
    }

    public int getOrganic() {
        return organic;
    }

    public double getMoisturePercent() {
        return moisturePercent;
    }

    public String getMilkType() {
        return milkType;
    }
}
