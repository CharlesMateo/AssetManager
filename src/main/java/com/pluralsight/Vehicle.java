package com.pluralsight;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public int getYear() {
        return year;
    }

    @Override
    public double getValue() {
        int currentYear = java.time.Year.now().getValue();
        int age = currentYear - year;
        double depreciation;

        if (age <= 3) depreciation = 0.03;
        else if (age <= 6) depreciation = 0.06;
        else if (age <= 10) depreciation = 0.08;
        else depreciation = 1000.00 / getOriginalCost();

        double value = getOriginalCost() * (1 - depreciation * age);

        if (odometer > 100000) {
            value *= 0.75;  // Reduce final value by 25% if over 100,000 miles
        }

        if (!makeModel.toLowerCase().contains("honda") && !makeModel.toLowerCase().contains("toyota")) {
            value -= 1000.00;
        }

        return value;
    }
}
