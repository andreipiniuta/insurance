package com.eis.insurance.andreiPiniuta.data.realEstate;

public class Apartment extends RealEstate {

    private int floorNumber;
    private int numberApartOneFloor;
    private double apartmentCost;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getNumberApartOneFloor() {
        return numberApartOneFloor;
    }

    public void setNumberApartOneFloor(int numberApartOneFloor) {
        this.numberApartOneFloor = numberApartOneFloor;
    }


    public double calculateApartmentCost(){
        return apartmentCost = getRealEstateRate() + getResidentNumber()*2 + getRealEstateSize() + floorNumber * 0.5+
                numberApartOneFloor *3.5;
    }

    @Override
    public String printRealEstateInfo() {
        return "Apartment insurance:" + '\n' + "Apartment size is " + getRealEstateSize()+ ". " + '\n' +
                "Apartment is on " + floorNumber+"'s floor. " + '\n' +
                "Total aparts on " + floorNumber+"'s floor is " + numberApartOneFloor+"." + '\n' +
                "The resident number is " + getResidentNumber() + ".";
    }
}
