package com.eis.insurance.andreiPiniuta.Service;

import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleComprehensive;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface VehicleComprehensiveService {

    void saveVehicleComprehensive (VehicleComprehensive vehicleComprehensive) throws IOException;

    VehicleComprehensive readVehicleComprehensive () throws IOException;
}
