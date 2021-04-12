package com.eis.insurance.andreiPiniuta.data.vehicle;

public enum VehicleEngine {
    gas(1.01),
    diesel(1.15),
    electro(0.55);

    private double coeff2VehicleEngine;

    VehicleEngine(double coeff2VehicleEngine) {
        this.coeff2VehicleEngine = coeff2VehicleEngine;
    }

    public double getcoeff2VehicleEngine() {
        return coeff2VehicleEngine;
    }
}
