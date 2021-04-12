package com.eis.insurance.andreiPiniuta.Service.impl;

import com.eis.insurance.andreiPiniuta.Service.VehicleComprehensiveService;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleComprehensive;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleEngine;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleType;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VehicleComprehensiveServiceImpl implements VehicleComprehensiveService {
    @Override
    public void saveVehicleComprehensive(VehicleComprehensive vehicleComprehensive) throws IOException {
        Path dest =Files.createFile(Paths.get("D:/insurance/VehicleComprehensiveJson.json"));
        FileWriter writer = new FileWriter(String.valueOf(dest));
        JSONWriter jsonwriter = new JSONWriter(writer);
        jsonwriter.object();
        jsonwriter.key("vehicleAge").value(vehicleComprehensive.getVehicleAge());
        jsonwriter.key("vehicleType").value(vehicleComprehensive.getVehicleType());
        jsonwriter.key("vehicleEngine").value(vehicleComprehensive.getVehicleEngine());
        jsonwriter.key("drivingExperience").value(vehicleComprehensive.getDrivingExperience());
        jsonwriter.endObject();
        writer.close();
    }

    @Override
    public VehicleComprehensive readVehicleComprehensive() throws IOException {
        VehicleComprehensive vehicleComprehensive = new VehicleComprehensive();
        if (Files.exists(Paths.get("D:/insurance/VehicleComprehensiveJson.json"))) {
            FileReader reader = new FileReader("D:/insurance/VehicleComprehensiveJson.json");
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject comprehensiveObject = (JSONObject)tokener.nextValue();
            Integer vehicleAge = comprehensiveObject.getInt("vehicleAge");
            String vehicleTypeStr = comprehensiveObject.getString("vehicleType");
            VehicleType vehicleType = VehicleType.valueOf(vehicleTypeStr);
            String vehicleEngineStr = comprehensiveObject.getString("vehicleEngine");
            VehicleEngine vehicleEngine = VehicleEngine.valueOf(vehicleEngineStr);
            Integer drivingExperience = comprehensiveObject.getInt("drivingExperience");

            vehicleComprehensive.setVehicleAge(vehicleAge);
            vehicleComprehensive.setVehicleType(vehicleType);
            vehicleComprehensive.setVehicleEngine(vehicleEngine);
            vehicleComprehensive.setDrivingExperience(drivingExperience);
            reader.close();

        } else {
            System.out.println("NO Vehicle Comprehensive INFO");
            return null;
        }
        return vehicleComprehensive;
    }
}
