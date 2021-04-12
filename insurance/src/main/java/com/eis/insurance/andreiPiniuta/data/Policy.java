package com.eis.insurance.andreiPiniuta.data;

import com.eis.insurance.andreiPiniuta.data.realEstate.Apartment;
import com.eis.insurance.andreiPiniuta.data.realEstate.House;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleCollision;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleComprehensive;

public class Policy {
    private Integer ID;
    Client client;
    VehicleCollision vehicleCollision;
    VehicleComprehensive vehicleComprehensive;
    Apartment apartment;
    House house;
    private double totalCost;


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public VehicleCollision getVehicleCollision() {
        return vehicleCollision;
    }

    public void setVehicleCollision(VehicleCollision vehicleCollision) {
        this.vehicleCollision = vehicleCollision;
    }

    public VehicleComprehensive getVehicleComprehensive() {
        return vehicleComprehensive;
    }

    public void setVehicleComprehensive(VehicleComprehensive vehicleComprehensive) {
        this.vehicleComprehensive = vehicleComprehensive;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public double getTotalCost(){
        return totalCost = vehicleCollision.calculateCollisionCost() + vehicleComprehensive.calculateComprehensiveCost() +
                apartment.calculateApartmentCost() + house.calculateHouseCost();
    }

    public void printPolicy(){
        System.out.println(client.printClientInfo() +  '\n' + " " + '\n' + vehicleCollision.printVehicleInfo()
                + '\n' + " " + '\n' + vehicleComprehensive.printVehicleInfo()
                + '\n' + " " + '\n' + apartment.printRealEstateInfo()
                + '\n' + " " + '\n' + house.printRealEstateInfo()
                + '\n' + " " + '\n' + "Total insurance cost is " + (int)getTotalCost() + "$.");
    }

}
