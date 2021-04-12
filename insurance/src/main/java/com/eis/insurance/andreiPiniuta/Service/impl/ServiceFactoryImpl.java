package com.eis.insurance.andreiPiniuta.Service.impl;

import com.eis.insurance.andreiPiniuta.Service.*;

public class ServiceFactoryImpl extends ServiceFactory {


    @Override
    public ClientService getClientService() {
        return new ClientServiceImpl();
    }

    @Override
    public VehicleCollisionService getVehicleCollisionService() {
        return new VehicleCollisionServiceImpl();
    }

    @Override
    public VehicleComprehensiveService getVehicleComprehensiveService() {
        return new VehicleComprehensiveServiceImpl();
    }

    @Override
    public ApartmentService getApartmentService() {
        return new ApartmentServiceImpl();
    }

    @Override
    public HouseService getHouseService() {
        return new HouseServiceImpl();
    }
}
