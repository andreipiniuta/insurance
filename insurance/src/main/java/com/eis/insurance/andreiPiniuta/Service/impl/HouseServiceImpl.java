package com.eis.insurance.andreiPiniuta.Service.impl;

import com.eis.insurance.andreiPiniuta.Service.HouseService;
import com.eis.insurance.andreiPiniuta.data.realEstate.HeatingType;
import com.eis.insurance.andreiPiniuta.data.realEstate.House;
import com.eis.insurance.andreiPiniuta.data.realEstate.HouseMaterial;
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

public class HouseServiceImpl implements HouseService {
    @Override
    public void saveHouse(House house) throws IOException {
        Path dest =Files.createFile(Paths.get("D:/insurance/HouseJson.json"));
        FileWriter writer = new FileWriter(String.valueOf(dest));
        JSONWriter jsonwriter = new JSONWriter(writer);
        jsonwriter.object();
        jsonwriter.key("residentNumber").value(house.getResidentNumber());
        jsonwriter.key("realEstateSize").value(house.getRealEstateSize());
        jsonwriter.key("heatingType").value(house.getHeatingType());
        jsonwriter.key("houseMaterial").value(house.getHouseMaterial());
        jsonwriter.endObject();
        writer.close();
    }

    @Override
    public House readHouse() throws IOException {
        House house = new House();
        if(Files.exists(Paths.get("D:/insurance/HouseJson.json"))) {
            FileReader reader = new FileReader("D:/insurance/HouseJson.json");
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject apartmentObject = (JSONObject) tokener.nextValue();
            Integer residentNumber = apartmentObject.getInt("residentNumber");
            Double realEstateSize = apartmentObject.getDouble("realEstateSize");
            String heatingTypeStr = apartmentObject.getString("heatingType");
            HeatingType heatingType = HeatingType.valueOf(heatingTypeStr);
            String houseMaterialStr = apartmentObject.getString("houseMaterial");
            HouseMaterial houseMaterial = HouseMaterial.valueOf(houseMaterialStr);

            house.setResidentNumber(residentNumber);
            house.setRealEstateSize(realEstateSize);
            house.setHeatingType(heatingType);
            house.setHouseMaterial(houseMaterial);
            reader.close();
        } else {
            System.out.println("NO HOUSE INFO");
            return null;
        }
        return house;
    }
}
