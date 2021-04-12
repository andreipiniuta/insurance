package com.eis.insurance.andreiPiniuta.Service;


import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleCollision;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface VehicleCollisionService {

    void saveVehicleCollision(VehicleCollision vehicleCollision) throws IOException;

    VehicleCollision readVehicleCollision () throws IOException;
}
