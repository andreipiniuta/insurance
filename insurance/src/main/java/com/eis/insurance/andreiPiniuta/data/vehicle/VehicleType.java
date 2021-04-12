package com.eis.insurance.andreiPiniuta.data.vehicle;

public enum VehicleType {
    car(0.9),
    truck(1.15),
    suv(1.05);
    private double coeffVehicleType;

    VehicleType(double coeffVehicleType) {
        this.coeffVehicleType = coeffVehicleType;
    }

    public double getcoeffVehicleType() {
        return coeffVehicleType;
    }
}
