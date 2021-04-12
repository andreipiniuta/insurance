package com.eis.insurance.andreiPiniuta.Service;

import com.eis.insurance.andreiPiniuta.Service.impl.ServiceFactoryImpl;

public abstract class ServiceFactory {

    public abstract ClientService getClientService();

    public abstract VehicleCollisionService getVehicleCollisionService();

    public abstract VehicleComprehensiveService getVehicleComprehensiveService();

    public abstract ApartmentService getApartmentService();

    public abstract HouseService getHouseService();


    public static ServiceFactory getServiceFactory()
    {
        return new ServiceFactoryImpl();
    }
}
