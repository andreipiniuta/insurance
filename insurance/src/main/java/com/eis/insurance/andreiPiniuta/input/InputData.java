package com.eis.insurance.andreiPiniuta.input;

import com.eis.insurance.andreiPiniuta.Service.*;
import com.eis.insurance.andreiPiniuta.data.Client;
import com.eis.insurance.andreiPiniuta.data.realEstate.Apartment;
import com.eis.insurance.andreiPiniuta.data.realEstate.HeatingType;
import com.eis.insurance.andreiPiniuta.data.realEstate.House;
import com.eis.insurance.andreiPiniuta.data.realEstate.HouseMaterial;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleCollision;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleComprehensive;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleEngine;
import com.eis.insurance.andreiPiniuta.data.vehicle.VehicleType;

import java.io.IOException;
import java.util.Scanner;

public class InputData {

    public static void addClient () throws IOException {
        Client client = new Client();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first name");
        String firstName = sc.nextLine();
        client.setFirstName(firstName);

        System.out.println("Enter last name");
        String lastName = sc.nextLine();
        client.setLastName(lastName);

        ServiceFactory sf = ServiceFactory.getServiceFactory();
        ClientService cs = sf.getClientService();
        cs.saveClient(client);
        }

    public static void addVehicleCollision () throws IOException {
        VehicleCollision vehicleCollision = new VehicleCollision();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter vehicle age");
            try {
                String vehicleAgeStr = sc.nextLine();
                int vehicleAge = Integer.parseInt(vehicleAgeStr);
                if(vehicleAge < 0 ) {
                    System.out.println("Wrong input");
                    continue;
                }
                vehicleCollision.setVehicleAge(vehicleAge);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }
        while(true) {
            System.out.println("Enter type vehicle: car, truck, suv");
            String vehicleType = sc.nextLine();
            if(vehicleType.equals("car") || vehicleType.equals("truck") || vehicleType.equals("suv")) {
                vehicleCollision.setVehicleType(VehicleType.valueOf(vehicleType));
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
        while(true) {
            System.out.println("Enter vehicle engine: gas, diesel, electro");
            String vehicleEngine = sc.nextLine();;
            if (vehicleEngine.equals("gas") || vehicleEngine.equals("diesel") || vehicleEngine.equals("electro")) {
                vehicleCollision.setVehicleEngine(VehicleEngine.valueOf(vehicleEngine));
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
        while (true) {
            System.out.println("Enter number of drivers");
            try {
                String driversNumberStr = sc.nextLine();
                int driversNumber = Integer.parseInt(driversNumberStr);
                if (driversNumber <= 0){
                    System.out.println("Wrong input");
                    continue;
                }
                vehicleCollision.setDriversNumber(driversNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        ServiceFactory sf = ServiceFactory.getServiceFactory();
        VehicleCollisionService vcl = sf.getVehicleCollisionService();
        vcl.saveVehicleCollision(vehicleCollision);
    }

    public static void addVehicleComprehensive () throws IOException {
        VehicleComprehensive vehicleComprehensive = new VehicleComprehensive();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter vehicle age");
            try {
                String vehicleAgeStr = sc.nextLine();
                int vehicleAge = Integer.parseInt(vehicleAgeStr);
                if (vehicleAge < 0){
                    System.out.println("Wrong input");
                    continue;
                }
                vehicleComprehensive.setVehicleAge(vehicleAge);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            System.out.println("Enter type vehicle: car, truck, suv");
            String vehicleType = sc.nextLine();
            if (vehicleType.equals("car") || vehicleType.equals("truck") || vehicleType.equals("suv")) {
                vehicleComprehensive.setVehicleType(VehicleType.valueOf(vehicleType));
                break;
            } else {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            System.out.println("Enter vehicle engine: gas, diesel, electro");
            String vehicleEngine = sc.nextLine();
            if (vehicleEngine.equals("gas") || vehicleEngine.equals("diesel") ||vehicleEngine.equals("electro")) {
                vehicleComprehensive.setVehicleEngine(VehicleEngine.valueOf(vehicleEngine));
                break;
            } else {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            System.out.println("Enter driving experience");
            try {
                String drivingExperienceStr = sc.nextLine();
                int drivingExperience = Integer.parseInt(drivingExperienceStr);
                if (drivingExperience < 0) {
                    System.out.println("Wrong input");
                    continue;
                }
                vehicleComprehensive.setDrivingExperience(drivingExperience);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        ServiceFactory sf = ServiceFactory.getServiceFactory();
        VehicleComprehensiveService vch = sf.getVehicleComprehensiveService();
        vch.saveVehicleComprehensive(vehicleComprehensive);
    }

    public static void addApartment () throws IOException {
        Apartment apartment = new Apartment();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter size of real estate");
            try {
                String realEstateSizeStr = sc.nextLine();
                double realEstateSize = Double.parseDouble(realEstateSizeStr);
                if (realEstateSize <= 0) {
                    System.out.println("Wrong input");
                    continue;
                }
                apartment.setRealEstateSize(realEstateSize);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            System.out.println("Enter number of residents");
            try {
                String residentNumberStr = sc.nextLine();
                int residentNumber = Integer.parseInt(residentNumberStr);
                if (residentNumber <= 0) {
                    System.out.println("Wrong input");
                    continue;
                }
                apartment.setResidentNumber(residentNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            System.out.println("Enter apartment's floor");
            try {
                String floorNumberStr = sc.nextLine();
                int floorNumber = Integer.parseInt(floorNumberStr);
                if (floorNumber <= 0) {
                    System.out.println("Wrong input");
                    continue;
                }
                apartment.setFloorNumber(floorNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            System.out.println("Enter number of apartments on your floor");
            try {
                String numberApartOneFloorStr = sc.nextLine();
                int numberApartOneFloor = Integer.parseInt(numberApartOneFloorStr);
                if (numberApartOneFloor <= 0) {
                    System.out.println("Wrong input");
                    continue;
                }
                apartment.setNumberApartOneFloor(numberApartOneFloor);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        ServiceFactory sf = ServiceFactory.getServiceFactory();
        ApartmentService as =sf.getApartmentService();
        as.saveApartment(apartment);
    }

    public static void addHouse () throws IOException {
        House house = new House();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter size of real estate");
            try {
                String realEstateSizeStr = sc.nextLine();
                double realEstateSize = Double.parseDouble(realEstateSizeStr);
                if (realEstateSize <= 0) {
                    System.out.println("Wrong input");
                    continue;
                }
                house.setRealEstateSize(realEstateSize);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            System.out.println("Enter number of residents");
            try {
                String residentNumberStr = sc.nextLine();
                int residentNumber = Integer.parseInt(residentNumberStr);
                if (residentNumber <= 0) {
                    System.out.println("Wrong input");
                    continue;
                }
                house.setResidentNumber(residentNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            System.out.println("Enter type of heating: furnace or other");
            String heatingTypeStr = sc.nextLine();
            if (heatingTypeStr.equals("furnace") || heatingTypeStr.equals("other")){
                house.setHeatingType(HeatingType.valueOf(heatingTypeStr));
                break;
            } else {
                System.out.println("Wrong input");
            }
        }

        while (true) {
            System.out.println("House walls: wood or other");
            String houseMaterialStr = sc.nextLine();
            if(houseMaterialStr.equals("wood") || houseMaterialStr.equals("other")) {
                house.setHouseMaterial(HouseMaterial.valueOf(houseMaterialStr));
                break;
            } else {
                System.out.println("Wrong input");
            }
        }

        ServiceFactory sf = ServiceFactory.getServiceFactory();
        HouseService hs = sf.getHouseService();
        hs.saveHouse(house);
    }


}
