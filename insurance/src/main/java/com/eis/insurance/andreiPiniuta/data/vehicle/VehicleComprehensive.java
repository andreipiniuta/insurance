package com.eis.insurance.andreiPiniuta.data.vehicle;

import com.eis.insurance.andreiPiniuta.data.vehicle.Vehicle;

public class VehicleComprehensive extends Vehicle {

    private static final int COMPREHENSIVE_RATE = 400;

    private int drivingExperience;
    private double comprehensiveCost;

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public static int getComprehensiveRate() {
        return COMPREHENSIVE_RATE;
    }

    public double calculateComprehensiveCost(){
        return comprehensiveCost = (COMPREHENSIVE_RATE * getVehicleType().getcoeffVehicleType()+
                COMPREHENSIVE_RATE * getVehicleEngine().getcoeff2VehicleEngine())/2-getVehicleAge()*3-drivingExperience*2;
    }

    @Override
    public String printVehicleInfo() {
        return "Vehicle Comprehensive:" +'\n'+ "Vehicle age is " + getVehicleAge()+"." + '\n'+
                "Vehicle type is "+ getVehicleType() + "." + '\n' + "VehicleEngine is "+ getVehicleEngine() +"."+
                '\n' + "Driving experience is " + drivingExperience+".";
    }
}
