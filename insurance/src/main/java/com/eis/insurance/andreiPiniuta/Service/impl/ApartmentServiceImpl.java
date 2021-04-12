package com.eis.insurance.andreiPiniuta.Service.impl;

import com.eis.insurance.andreiPiniuta.Service.ApartmentService;
import com.eis.insurance.andreiPiniuta.data.realEstate.Apartment;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApartmentServiceImpl implements ApartmentService {
    @Override
    public void saveApartment(Apartment apartment) throws IOException {
        Path dest =Files.createFile(Paths.get("D:/insurance/ApartmentJson.json"));
        FileWriter writer = new FileWriter(String.valueOf(dest));
        JSONWriter jsonwriter = new JSONWriter(writer);
        jsonwriter.object();
        jsonwriter.key("residentNumber").value(apartment.getResidentNumber());
        jsonwriter.key("realEstateSize").value(apartment.getRealEstateSize());
        jsonwriter.key("floorNumber").value(apartment.getFloorNumber());
        jsonwriter.key("numberApartOneFloor").value(apartment.getNumberApartOneFloor());
        jsonwriter.endObject();
        writer.close();
    }

    @Override
    public Apartment readApartment() throws IOException {
        Apartment apartment = new Apartment();
        if(Files.exists(Paths.get("D:/insurance/ApartmentJson.json"))){
            FileReader reader = new FileReader("D:/insurance/ApartmentJson.json");
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject apartmentObject = (JSONObject)tokener.nextValue();
            Integer residentNumber = apartmentObject.getInt("residentNumber");
            Double realEstateSize = apartmentObject.getDouble("realEstateSize");
            Integer floorNumber = apartmentObject.getInt("floorNumber");
            Integer numberApartOneFloor = apartmentObject.getInt("numberApartOneFloor");

            apartment.setResidentNumber(residentNumber);
            apartment.setRealEstateSize(realEstateSize);
            apartment.setFloorNumber(floorNumber);
            apartment.setNumberApartOneFloor(numberApartOneFloor);
            reader.close();
        }else {
            System.out.println("NO APARTMENT INFO");
            return null;
        }
        return apartment;
    }
}
