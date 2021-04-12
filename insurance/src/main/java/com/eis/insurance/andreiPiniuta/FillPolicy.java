package com.eis.insurance.andreiPiniuta;

import com.eis.insurance.andreiPiniuta.Service.*;
import com.eis.insurance.andreiPiniuta.data.Client;
import com.eis.insurance.andreiPiniuta.data.Policy;
import com.eis.insurance.andreiPiniuta.data.realEstate.Apartment;
import com.eis.insurance.andreiPiniuta.data.realEstate.HeatingType;
import com.eis.insurance.andreiPiniuta.data.realEstate.House;
import com.eis.insurance.andreiPiniuta.data.realEstate.HouseMaterial;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleCollision;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleComprehensive;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleEngine;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleType;
import com.eis.insurance.andreiPiniuta.db.IDGenerator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FillPolicy {
    public static Policy createPolicy() throws ParserConfigurationException, SAXException, IOException {
        ServiceFactory sf = ServiceFactory.getServiceFactory();

        ClientService cs = sf.getClientService();
        ApartmentService as = sf.getApartmentService();
        HouseService hs = sf.getHouseService();
        VehicleCollisionService vcl = sf.getVehicleCollisionService();
        VehicleComprehensiveService vch = sf.getVehicleComprehensiveService();

        Policy policy = new Policy();

        policy.setID(IDGenerator.getGenerator().getNewID());
        policy.setClient(cs.readClient());
        policy.setVehicleCollision(vcl.readVehicleCollision());
        policy.setVehicleComprehensive(vch.readVehicleComprehensive());
        policy.setApartment(as.readApartment());
        policy.setHouse(hs.readHouse());
        return policy;
    }

    public static void printPolicy() throws IOException, ParserConfigurationException, SAXException {
        FillPolicy.createPolicy().printPolicy();
    }

    public static void saveAndPrintPolicy() throws TransformerException, IOException, ParserConfigurationException, SAXException {
        Policy createdPolicy = FillPolicy.createPolicy();
        Path destination = Paths.get("D:/policy/PolicyXml.xml");
        //запись xml с нуля
            if (!Files.exists(destination)) {
                Files.createFile(Paths.get(destination.toString()));

                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.newDocument();
                Element rootTag = document.createElement("policy-db");

                FillPolicy.saveInternalXMLData(createdPolicy,document, rootTag);

                document.appendChild(rootTag);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource dom = new DOMSource(document);
                StreamResult streamResult = new StreamResult(destination.toString());

                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                transformer.transform(dom, streamResult);
//запись xml если уже xml есть и он с данными
            } else {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document document = dBuilder.parse(destination.toString());
                Element rootTag = document.getDocumentElement();

                FillPolicy.saveInternalXMLData(createdPolicy, document, rootTag);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource dom = new DOMSource(document);
                StreamResult streamResult = new StreamResult(destination.toString());

                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                transformer.transform(dom, streamResult);
            }
        createdPolicy.printPolicy();

        System.out.println("");
        System.out.println("Policy is saved");
        Files.deleteIfExists(Paths.get("D:/insurance/ClientJson.json"));
        Files.deleteIfExists(Paths.get("D:/insurance/VehicleCollisionJson.json"));
        Files.deleteIfExists(Paths.get("D:/insurance/VehicleComprehensiveJson.json"));
        Files.deleteIfExists(Paths.get("D:/insurance/ApartmentJson.json"));
        Files.deleteIfExists(Paths.get("D:/insurance/HouseJson.json"));
    }

    public static void saveInternalXMLData (Policy createdPolicy, Document document, Element rootTag) {
        Element policyTag = document.createElement("policy");

        Element IDTag = document.createElement("ID");
        IDTag.setTextContent(createdPolicy.getID().toString());

        Element clientTag = document.createElement("client");
        Element firstNameTag = document.createElement("firstName");
        firstNameTag.setTextContent(createdPolicy.getClient().getFirstName());
        Element lastNameTag = document.createElement("lastName");
        lastNameTag.setTextContent(createdPolicy.getClient().getLastName());

        Element vehicleCollisionTag = document.createElement("vehicleCollision");
        Element vehicleAgeTag = document.createElement("vehicleAge");
        vehicleAgeTag.setTextContent(Integer.toString(createdPolicy.getVehicleCollision().getVehicleAge()));
        Element vehicleTypeTag = document.createElement("vehicleType");
        vehicleTypeTag.setTextContent(createdPolicy.getVehicleCollision().getVehicleType().toString());
        Element vehicleEngineTag = document.createElement("vehicleEngine");
        vehicleEngineTag.setTextContent(createdPolicy.getVehicleCollision().getVehicleEngine().toString());
        Element driversNumberTag = document.createElement("driversNumber");
        driversNumberTag.setTextContent(Integer.toString(createdPolicy.getVehicleCollision().getDriversNumber()));

        Element vehicleComprehensiveTag = document.createElement("vehicleComprehensive");
        Element vehicleAgeComTag = document.createElement("vehicleAge");
        vehicleAgeComTag.setTextContent(Integer.toString(createdPolicy.getVehicleComprehensive().getVehicleAge()));
        Element vehicleTypeComTag = document.createElement("vehicleType");
        vehicleTypeComTag.setTextContent(createdPolicy.getVehicleComprehensive().getVehicleType().toString());
        Element vehicleEngineComTag = document.createElement("vehicleEngine");
        vehicleEngineComTag.setTextContent(createdPolicy.getVehicleComprehensive().getVehicleEngine().toString());
        Element drivingExperienceTag = document.createElement("drivingExperience");
        drivingExperienceTag.setTextContent(Integer.toString(createdPolicy.getVehicleComprehensive().getDrivingExperience()));

        Element apartmentTag = document.createElement("apartment");
        Element residentNumberTag = document.createElement("residentNumber");
        residentNumberTag.setTextContent(Integer.toString(createdPolicy.getApartment().getResidentNumber()));
        Element realEstateSizeTag = document.createElement("realEstateSize");
        realEstateSizeTag.setTextContent(Double.toString(createdPolicy.getApartment().getRealEstateSize()));
        Element floorNumberTag = document.createElement("floorNumber");
        floorNumberTag.setTextContent(Integer.toString(createdPolicy.getApartment().getFloorNumber()));
        Element numberApartOneFloorTag = document.createElement("numberApartOneFloor");
        numberApartOneFloorTag.setTextContent(Integer.toString(createdPolicy.getApartment().getNumberApartOneFloor()));

        Element houseTag = document.createElement("house");
        Element residentNumber2Tag = document.createElement("residentNumber");
        residentNumber2Tag.setTextContent(Integer.toString(createdPolicy.getHouse().getResidentNumber()));
        Element realEstateSize2Tag = document.createElement("realEstateSize");
        realEstateSize2Tag.setTextContent(Double.toString(createdPolicy.getHouse().getRealEstateSize()));
        Element heatingTypeTag = document.createElement("heatingType");
        heatingTypeTag.setTextContent(createdPolicy.getHouse().getHeatingType().toString());
        Element houseMaterialTag = document.createElement("houseMaterial");
        houseMaterialTag.setTextContent(createdPolicy.getHouse().getHouseMaterial().toString());

        clientTag.appendChild(firstNameTag);
        clientTag.appendChild(lastNameTag);

        vehicleCollisionTag.appendChild(vehicleAgeTag);
        vehicleCollisionTag.appendChild(vehicleTypeTag);
        vehicleCollisionTag.appendChild(vehicleEngineTag);
        vehicleCollisionTag.appendChild(driversNumberTag);

        vehicleComprehensiveTag.appendChild(vehicleAgeComTag);
        vehicleComprehensiveTag.appendChild(vehicleTypeComTag);
        vehicleComprehensiveTag.appendChild(vehicleEngineComTag);
        vehicleComprehensiveTag.appendChild(drivingExperienceTag);

        apartmentTag.appendChild(residentNumberTag);
        apartmentTag.appendChild(realEstateSizeTag);
        apartmentTag.appendChild(floorNumberTag);
        apartmentTag.appendChild(numberApartOneFloorTag);

        houseTag.appendChild(residentNumber2Tag);
        houseTag.appendChild(realEstateSize2Tag);
        houseTag.appendChild(heatingTypeTag);
        houseTag.appendChild(houseMaterialTag);

        policyTag.appendChild(IDTag);
        policyTag.appendChild(clientTag);
        policyTag.appendChild(vehicleCollisionTag);
        policyTag.appendChild(vehicleComprehensiveTag);
        policyTag.appendChild(apartmentTag);
        policyTag.appendChild(houseTag);

        rootTag.appendChild(policyTag);
    }

    public static void readByIDPolicy() throws ParserConfigurationException, IOException, SAXException {
        Path destination = Paths.get("D:/policy/PolicyXml.xml");
        Scanner scanner = new Scanner(System.in);
        Integer intputID = 0;
        String inputObject = null;
        while (true) {
            System.out.println("Enter policy ID number");
            try {
                String inputIDStr = scanner.nextLine();
                intputID = Integer.parseInt(inputIDStr);
                if (intputID <= 0){
                    System.out.println("Wrong input");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            System.out.println("Enter type info for printing: collision, comprehensive, apartment, house, all");
            inputObject = scanner.nextLine();
            if (inputObject.equals("collision") || inputObject.equals("comprehensive") ||
               inputObject.equals("apartment") || inputObject.equals("house") || inputObject.equals("all")) {
                break;
            } else {
                System.out.println("Wrong input" );
            }
        }

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(destination.toString());

        Element rootTag = document.getDocumentElement();
        NodeList policyList = rootTag.getElementsByTagName("policy");
        int size = policyList.getLength();
        if (intputID > size) {
            System.out.println("ID is not exist. Try one more time command N7");
            return;
        }
        for (int i = 0; i < size; i++){
            Element policyTag = (Element) policyList.item(i);
            Element IDTag = (Element) policyTag.getElementsByTagName("ID").item(0);
            String IDString = IDTag.getTextContent();
            int ID = Integer.parseInt(IDString);
            if(ID != intputID){
               continue;
            }

            Element clientTag = (Element) policyTag.getElementsByTagName("client").item(0);
            Element firstNameTag = (Element) clientTag.getElementsByTagName("firstName").item(0);
            String firstName = firstNameTag.getTextContent();
            Element lastNameTag = (Element) clientTag.getElementsByTagName("lastName").item(0);
            String lastName = lastNameTag.getTextContent();

            Client readClient = new Client();
            readClient.setFirstName(firstName);
            readClient.setLastName(lastName);

            Element vehicleCollisionTag = (Element) policyTag.getElementsByTagName("vehicleCollision").item(0);
            Element vehicleAgeTag = (Element) vehicleCollisionTag.getElementsByTagName("vehicleAge").item(0);
            String vehicleAgeStr = vehicleAgeTag.getTextContent();
            int vehicleAge = Integer.parseInt(vehicleAgeStr);
            Element vehicleTypeTag = (Element) vehicleCollisionTag.getElementsByTagName("vehicleType").item(0);
            String vehicleType = vehicleTypeTag.getTextContent();
            Element vehicleEngineTag = (Element) vehicleCollisionTag.getElementsByTagName("vehicleEngine").item(0);
            String vehicleEngine = vehicleEngineTag.getTextContent();
            Element driversNumberTag = (Element) vehicleCollisionTag.getElementsByTagName("driversNumber").item(0);
            String driversNumberStr = driversNumberTag.getTextContent();
            int driversNumber = Integer.parseInt(driversNumberStr);

            VehicleCollision readVehicleCollision =new VehicleCollision();
            readVehicleCollision.setVehicleAge(vehicleAge);
            readVehicleCollision.setVehicleType(VehicleType.valueOf(vehicleType));
            readVehicleCollision.setVehicleEngine(VehicleEngine.valueOf(vehicleEngine));
            readVehicleCollision.setDriversNumber(driversNumber);


            Element vehicleComprehensiveTag = (Element) policyTag.getElementsByTagName("vehicleComprehensive").item(0);
            Element vehicleAgeTag2 = (Element) vehicleComprehensiveTag.getElementsByTagName("vehicleAge").item(0);
            String vehicleAge2Str = vehicleAgeTag2.getTextContent();
            int vehicleAge2 = Integer.parseInt(vehicleAge2Str);
            Element vehicleTypeTag2 = (Element) vehicleComprehensiveTag.getElementsByTagName("vehicleType").item(0);
            String vehicleType2 = vehicleTypeTag2.getTextContent();
            Element vehicleEngineTag2 = (Element) vehicleComprehensiveTag.getElementsByTagName("vehicleEngine").item(0);
            String vehicleEngine2 = vehicleEngineTag2.getTextContent();
            Element drivingExperienceTag = (Element) vehicleComprehensiveTag.getElementsByTagName("drivingExperience").item(0);
            String drivingExperienceStr = drivingExperienceTag.getTextContent();
            int drivingExperience = Integer.parseInt(drivingExperienceStr);

            VehicleComprehensive readVehicleComprehensive = new VehicleComprehensive();
            readVehicleComprehensive.setVehicleAge(vehicleAge2);
            readVehicleComprehensive.setVehicleType(VehicleType.valueOf(vehicleType2));
            readVehicleComprehensive.setVehicleEngine(VehicleEngine.valueOf(vehicleEngine2));
            readVehicleComprehensive.setDrivingExperience(drivingExperience);

            Element apartmentTag = (Element) policyTag.getElementsByTagName("apartment").item(0);
            Element residentNumberTag = (Element) apartmentTag.getElementsByTagName("residentNumber").item(0);
            String residentNumberStr = residentNumberTag.getTextContent();
            int residentNumber = Integer.parseInt(residentNumberStr);
            Element realEstateSizeTag = (Element) apartmentTag.getElementsByTagName("realEstateSize").item(0);
            String realEstateSizeStr = realEstateSizeTag.getTextContent();
            double realEstateSize = Double.parseDouble(realEstateSizeStr);
            Element floorNumberTag = (Element) apartmentTag.getElementsByTagName("floorNumber").item(0);
            String floorNumberStr = floorNumberTag.getTextContent();
            int floorNumber = Integer.parseInt(floorNumberStr);
            Element numberApartOneFloorTag = (Element) apartmentTag.getElementsByTagName("numberApartOneFloor").item(0);
            String numberApartOneFloorStr = numberApartOneFloorTag.getTextContent();
            int numberApartOneFloor = Integer.parseInt(numberApartOneFloorStr);

            Apartment readApartment = new Apartment();
            readApartment.setResidentNumber(residentNumber);
            readApartment.setRealEstateSize(realEstateSize);
            readApartment.setFloorNumber(floorNumber);
            readApartment.setNumberApartOneFloor(numberApartOneFloor);

            Element houseTag = (Element) policyTag.getElementsByTagName("house").item(0);
            Element residentNumberTag2 = (Element) houseTag.getElementsByTagName("residentNumber").item(0);
            String residentNumber2Str = residentNumberTag2.getTextContent();
            int residentNumber2 = Integer.parseInt(residentNumber2Str);
            Element realEstateSizeTag2 = (Element) houseTag.getElementsByTagName("realEstateSize").item(0);
            String realEstateSize2Str = realEstateSizeTag2.getTextContent();
            double realEstateSize2 = Double.parseDouble(realEstateSize2Str);
            Element heatingTypeTag = (Element) houseTag.getElementsByTagName("heatingType").item(0);
            String heatingType = heatingTypeTag.getTextContent();
            Element houseMaterialTag = (Element) houseTag.getElementsByTagName("houseMaterial").item(0);
            String houseMaterial = houseMaterialTag.getTextContent();

            House readHouse = new House();
            readHouse.setResidentNumber(residentNumber2);
            readHouse.setRealEstateSize(realEstateSize2);
            readHouse.setHeatingType(HeatingType.valueOf(heatingType));
            readHouse.setHouseMaterial(HouseMaterial.valueOf(houseMaterial));

            Policy readPolicy = new Policy();
            readPolicy.setID(ID);
            readPolicy.setClient(readClient);
            readPolicy.setVehicleCollision(readVehicleCollision);
            readPolicy.setVehicleComprehensive(readVehicleComprehensive);
            readPolicy.setApartment(readApartment);
            readPolicy.setHouse(readHouse);

            switch (inputObject) {
                case ("collision"):
                    System.out.println(readClient.printClientInfo());
                    System.out.println("");
                    System.out.println(readVehicleCollision.printVehicleInfo());
                    break;
                case ("comprehensive"):
                    System.out.println(readClient.printClientInfo());
                    System.out.println("");
                    System.out.println(readVehicleComprehensive.printVehicleInfo());
                    break;
                case ("apartment"):
                    System.out.println(readClient.printClientInfo());
                    System.out.println("");
                    System.out.println(readApartment.printRealEstateInfo());
                    break;
                case ("house"):
                    System.out.println(readClient.printClientInfo());
                    System.out.println("");
                    System.out.println(readHouse.printRealEstateInfo());
                    break;
                case ("all"):
                    System.out.println(readClient.printClientInfo());
                    System.out.println("");
                    readPolicy.printPolicy();
                    break;
            }
        }
    }
}
