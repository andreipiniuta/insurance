package com.eis.insurance.andreiPiniuta.data.realEstate;

public enum HouseMaterial {
    wood(4.8),
    other(0.00);

    private double coeffHouseMaterial;

    HouseMaterial(double coeffHouseMaterial) {
        this.coeffHouseMaterial = coeffHouseMaterial;
    }

    public double getCoeffHouseMaterial() {
        return coeffHouseMaterial;
    }
}
