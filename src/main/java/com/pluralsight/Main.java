package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        // Adding some houses and vehicles
        assets.add(new House("My house", "2020-06-15", 200000, "123 Main St", 1, 2000, 5000));
        assets.add(new House("Vacation home", "2018-07-10", 150000, "456 Beach Ave", 2, 1500, 4000));
        assets.add(new Vehicle("Tom's truck", "2021-08-22", 30000, "Ford F-150", 2021, 15000));
        assets.add(new Vehicle("Family car", "2015-05-30", 20000, "Toyota Camry", 2015, 120000));

        // Displaying asset details
        for (Asset asset : assets) {
            String details = "Description: " + asset.getDescription() +
                    "\nAcquired on: " + asset.getDateAcquired() +
                    "\nOriginal Cost: $" + asset.getOriginalCost() +
                    "\nCurrent Value: $" + String.format("%.2f", asset.getValue());

            if (asset instanceof House) {
                House house = (House) asset;
                details += "\nAddress: " + house.getAddress();
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                details += "\nMake/Model: " + vehicle.getMakeModel() + ", Year: " + vehicle.getYear();
            }

            System.out.println(details + "\n");
        }
    }
}