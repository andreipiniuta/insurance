package com.eis.insurance.andreiPiniuta.data.vehicle;

import com.eis.insurance.andreiPiniuta.data.vehicle.Vehicle;

public class VehicleCollision extends Vehicle {

    private static final int COLLISION_RATE = 20;

    private int driversNumber;
    private double collisionCost;

    public int getDriversNumber() {
        return driversNumber;
    }

    public void setDriversNumber(int driversNumber) {
        this.driversNumber = driversNumber;
    }

    public static int getCollisionRate() {
        return COLLISION_RATE;
    }

    public double calculateCollisionCost(){
        return collisionCost = (COLLISION_RATE * getVehicleType().getcoeffVehicleType()+
                COLLISION_RATE * getVehicleEngine().getcoeff2VehicleEngine())/2-getVehicleAge()*3+driversNumber*10;
    }

    @Override
    public String printVehicleInfo() {
        return "Vehicle Collision:" +'\n'+ "Vehicle age is " + getVehicleAge() + "." + '\n' +
                "Vehicle type is " + getVehicleType() + "." + '\n' + "Engine is " + getVehicleEngine() + "." +
                '\n' + "Maximum drivers is "+driversNumber + ".";
    }
}
