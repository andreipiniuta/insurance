package com.eis.insurance.andreiPiniuta.Service.impl;

import com.eis.insurance.andreiPiniuta.Service.VehicleCollisionService;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleCollision;
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

public class VehicleCollisionServiceImpl implements VehicleCollisionService {
    @Override
    public void saveVehicleCollision(VehicleCollision vehicleCollision) throws IOException {
        Path dest =Files.createFile(Paths.get("D:/insurance/VehicleCollisionJson.json"));
        FileWriter writer = new FileWriter(String.valueOf(dest));
        JSONWriter jsonwriter = new JSONWriter(writer);
        jsonwriter.object();
        jsonwriter.key("vehicleAge").value(vehicleCollision.getVehicleAge());
        jsonwriter.key("vehicleType").value(vehicleCollision.getVehicleType());
        jsonwriter.key("vehicleEngine").value(vehicleCollision.getVehicleEngine());
        jsonwriter.key("driversNumber").value(vehicleCollision.getDriversNumber());
        jsonwriter.endObject();
        writer.close();
    }

    @Override
    public VehicleCollision readVehicleCollision() throws IOException {
        VehicleCollision vehicleCollision = new VehicleCollision();
        if(Files.exists(Paths.get("D:/insurance/VehicleCollisionJson.json"))){
            FileReader reader = new FileReader("D:/insurance/VehicleCollisionJson.json");
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject collisionObject = (JSONObject)tokener.nextValue();
            Integer vehicleAge = collisionObject.getInt("vehicleAge");
            String vehicleTypeStr = collisionObject.getString("vehicleType");
            VehicleType vehicleType = VehicleType.valueOf(vehicleTypeStr);
            String vehicleEngineStr = collisionObject.getString("vehicleEngine");
            VehicleEngine vehicleEngine = VehicleEngine.valueOf(vehicleEngineStr);
            Integer driversNumber = collisionObject.getInt("driversNumber");

            vehicleCollision.setVehicleAge(vehicleAge);
            vehicleCollision.setVehicleType(vehicleType);
            vehicleCollision.setVehicleEngine(vehicleEngine);
            vehicleCollision.setDriversNumber(driversNumber);
            reader.close();
        } else {
            System.out.println("NO Vehicle Collision INFO");
            return  null;
        }
        return vehicleCollision;
    }
}
