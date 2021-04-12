package com.eis.insurance.andreiPiniuta.data.realEstate;

public enum HeatingType {
    furnace(8.5),
    other(0.00);

    private double coeffHeatingType;

    HeatingType(double coeffHeatingType) {
        this.coeffHeatingType = coeffHeatingType;
    }

    public double getCoeffHeatingType() {
        return coeffHeatingType;
    }
}
