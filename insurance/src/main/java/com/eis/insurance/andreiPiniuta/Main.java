package com.eis.insurance.andreiPiniuta;

import com.eis.insurance.andreiPiniuta.input.InputData;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException {
        Scanner sc =new Scanner(System.in);
        String input ="";
        System.out.println("Press 0 - Exit");
        System.out.println("Press 1 - Add client info");
        System.out.println("Press 2 - Add vehicle Collision info");
        System.out.println("Press 3 - Add vehicle Comprehensive info");
        System.out.println("Press 4 - Add apartment info");
        System.out.println("Press 5 - Add house info");
        System.out.println("Press 6 - Save and print policy");
        System.out.println("Press 7 - Print policy info (all or by part) by ID");

        Files.createDirectory(Paths.get("D:/insurance"));
        Files.createDirectory(Paths.get("D:/policy"));
        Path clientPath = Paths.get("D:/insurance/ClientJson.json");
        Path vehicleCollisionPath = Paths.get("D:/insurance/VehicleCollisionJson.json");
        Path vehicleComprehensivePath = Paths.get("D:/insurance/VehicleComprehensiveJson.json");
        Path apartmentPath = Paths.get("D:/insurance/ApartmentJson.json");
        Path housePath = Paths.get("D:/insurance/HouseJson.json");
        Path policyPath = Paths.get("D:/policy/PolicyXml.xml");

        while (true) {
            System.out.println("Choose command");
            input = sc.nextLine();
            switch (input){
                case("0"):
                        Files.deleteIfExists(clientPath);
                        Files.deleteIfExists(vehicleCollisionPath);
                        Files.deleteIfExists(vehicleComprehensivePath);
                        Files.deleteIfExists(apartmentPath);
                        Files.deleteIfExists(housePath);
                        Files.deleteIfExists(Paths.get("D:/insurance"));
                        Files.deleteIfExists(Paths.get("D:/policy/PolicyXml.xml"));
                        Files.deleteIfExists(Paths.get("D:/policy"));
                    System.out.println("Program is closed. Files and folders deleted");
                    System.exit(0);
                    break;
                case("1"):
                    if (Files.exists(clientPath)) {
                        System.out.println("You have already set client info");
                        continue;
                    }
                    System.out.println("Please enter client info");
                    InputData.addClient();
                    break;
                case("2"):
                    if (Files.exists(vehicleCollisionPath)){
                        System.out.println("You have already set vehicle collision info");
                        continue;
                    }
                    System.out.println("Please enter vehicle collision info");
                    InputData.addVehicleCollision();
                    break;
                case("3"):
                    if (Files.exists(vehicleComprehensivePath)) {
                        System.out.println("You have already set vehicle comprehensive info");
                        continue;
                    }
                    System.out.println("Please enter vehicle comprehensive info");
                    InputData.addVehicleComprehensive();
                    break;
                case("4"):
                    if (Files.exists(apartmentPath)) {
                        System.out.println("You have already set apartment info");
                        continue;
                    }
                    System.out.println("Please enter apartment info");
                    InputData.addApartment();
                    break;
                case("5"):
                    if (Files.exists(housePath)) {
                        System.out.println("You have already set house info");
                        continue;
                    }
                    System.out.println("Please enter house info");
                    InputData.addHouse();
                    break;
                case("6"):
                    if ((Files.exists(clientPath) && Files.exists(vehicleCollisionPath) && Files.exists(vehicleComprehensivePath) &&
                    Files.exists(apartmentPath) && Files.exists(housePath))) {
                        FillPolicy.saveAndPrintPolicy();
                        break;
                    } else{
                        System.out.println("You have no set full info for policy");
                        continue;
                    }
                case("7"):
                    if (!Files.exists(policyPath)) {
                        System.out.println("No info in data base");
                        continue;
                    }
                    FillPolicy.readByIDPolicy();
                    break;
            }
        }
    }
}
