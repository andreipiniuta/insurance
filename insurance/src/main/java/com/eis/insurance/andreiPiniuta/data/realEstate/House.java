package com.eis.insurance.andreiPiniuta.data.realEstate;

public class House extends RealEstate {

    private HeatingType heatingType;
    private HouseMaterial houseMaterial;
    private double houseCost;

    public HeatingType getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(HeatingType heatingType) {
        this.heatingType = heatingType;
    }

    public HouseMaterial getHouseMaterial() {
        return houseMaterial;
    }

    public void setHouseMaterial(HouseMaterial houseMaterial) {
        this.houseMaterial = houseMaterial;
    }

    public double calculateHouseCost(){
        return houseCost = getRealEstateRate() * heatingType.getCoeffHeatingType() +
                getRealEstateRate() * houseMaterial.getCoeffHouseMaterial() + getResidentNumber()*2 + getRealEstateSize();
    }

    @Override
    public String printRealEstateInfo() {
        return"House insurance:" + '\n' + "House size is "+ getRealEstateSize() + ". " + '\n' +
                "House has "+ houseMaterial + " walls. " + '\n' +
                "House's heating type is " + heatingType+"." + '\n' +
                "Resident number is " + getResidentNumber() + ".";
    }
}
