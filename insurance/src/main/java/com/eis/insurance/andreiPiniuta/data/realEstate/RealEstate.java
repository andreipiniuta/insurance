package com.eis.insurance.andreiPiniuta.data.realEstate;

public abstract class RealEstate {

    private static final int REAL_ESTATE_RATE = 15;

    private int residentNumber;
    private double realEstateSize;

    public int getResidentNumber() {
        return residentNumber;
    }

    public void setResidentNumber(int residentNumber) {
        this.residentNumber = residentNumber;
    }

    public double getRealEstateSize() {
        return realEstateSize;
    }

    public void setRealEstateSize(double realEstateSize) {
        this.realEstateSize = realEstateSize;
    }

    public static int getRealEstateRate() {
        return REAL_ESTATE_RATE;
    }

    public abstract String printRealEstateInfo ();
}

