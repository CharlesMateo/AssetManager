package com.pluralsight;

public class House extends Asset{
    private String address;
    private int condition;  // 1 = excellent, 2 = good, 3 = fair, 4 = poor
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public double getValue() {
        double valuePerSquareFoot = switch (condition) {
            case 1 -> 180.00;  // excellent
            case 2 -> 130.00;  // good
            case 3 -> 90.00;   // fair
            default -> 80.00;  // poor
        };

        return (valuePerSquareFoot * squareFoot) + (0.25 * lotSize);
    }
}
