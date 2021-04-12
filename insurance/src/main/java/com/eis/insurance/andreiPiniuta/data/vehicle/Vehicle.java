package com.eis.insurance.andreiPiniuta.data.vehicle;

public abstract class Vehicle {
    private int vehicleAge;
    private VehicleType vehicleType;
    private VehicleEngine vehicleEngine;

    public int getVehicleAge() {
        return vehicleAge;
    }

    public void setVehicleAge(int vehicleAge) {
        this.vehicleAge = vehicleAge;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleEngine getVehicleEngine() {
        return vehicleEngine;
    }

    public void setVehicleEngine(VehicleEngine vehicleEngine) {
        this.vehicleEngine = vehicleEngine;
    }



    public abstract String printVehicleInfo ();
}
