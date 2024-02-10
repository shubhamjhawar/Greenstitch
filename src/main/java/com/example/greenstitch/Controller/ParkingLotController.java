package com.example.greenstitch.Controller;


import com.example.greenstitch.Exceptions.ParkingServerException;
import com.example.greenstitch.Service.ParkingLotService;
import com.example.greenstitch.Service.ParkingLotServiceImpl;
import com.example.greenstitch.model.Car;
import com.example.greenstitch.model.ParkingSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ParkingLotController {

    private ParkingLotService plsvc;

    public ParkingLotController(ParkingLotService plsvc) {
        this.plsvc = plsvc;
    }

    public void processCommands() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] commandParts = input.split("\\s+");

            try {
                switch (commandParts[0]) {
                    case "create_parking_lot":
                        int capacity = Integer.parseInt(commandParts[1]);
                        plsvc.createParkingLot(capacity);
                        System.out.println("Created a parking lot with " + capacity + " spaces");
                        break;

                    case "park":
                        String registrationNumber = commandParts[1];
                        String color = commandParts[2];
                        Car car = new Car(color,registrationNumber);
                        String parkMessage = plsvc.parkVehicle(car);
                        System.out.println(parkMessage);
                        break;

                    case "leave":
                        int slotNumber = Integer.parseInt(commandParts[1]);
                        String leaveMessage = plsvc.leaveVehicle(slotNumber);
                        System.out.println(leaveMessage);
                        break;

                    case "status":
                        Map<Integer, Car> statusMap = plsvc.getStatus();
                        System.out.println("Slot No. Registration No Colour");
                        for (Map.Entry<Integer, Car> entry : statusMap.entrySet()) {
                            Car parkedCar = entry.getValue();
                            System.out.println(entry.getKey() + " " + parkedCar.getRegisNumber() + " " + parkedCar.getColor());
                        }
                        break;

                    case "registration_numbers_for_cars_with_colour":
                        String targetColor = commandParts[1];
                        List<String> registrationNumbers = plsvc.getRegisNumberwithcolor(targetColor);
                        System.out.println(String.join(", ", registrationNumbers));
                        break;

                    case "exit":
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid command. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotServiceImpl();
        ParkingLotController controller = new ParkingLotController(parkingLotService);
        controller.processCommands();
    }
}


//@RestController
//public class ParkingLotController {
//
//
//    @Autowired
//    private ParkingLotService plsvc;
//
//   public String CreateParkingLot(int capacity) throws Exception{
//       try{
//           ParkingSlot parkingSlot = plsvc.createParkingLot(capacity);
//       }catch (Exception e) {
//           throw new ParkingServerException("Internal Server Error, Contact Administrator");
//       }
//       return "Created a parking lot with" + capacity + "spaces";
//   }
//
//   public String parkVehicle(Car car) throws Exception{
//       try{
//           String message = plsvc.parkvehicle(car);
//           return message;
//       }catch (Exception e) {
//          throw new Exception("Not able to park vehicle");
//       }
//   }
//
//   public String leaveVehicle(int slotNumber) throws Exception{
//       try{
//           String message = plsvc.removevehicle(slotNumber);
//           return message;
//       }catch (Exception e) {
//           throw new ParkingServerException("Internal Server Error, Contact Administrator");
//       }
//   }
//
//   public Map<Integer,Car> getStatus() throws Exception{
//       try{
//           Map<Integer,Car> carsInSlot  = plsvc.getStatus();
//           return carsInSlot;
//       }catch (Exception e) {
//           throw new ParkingServerException("Internal Server Error, Contact Administrator");
//       }
//   }
//
//   public List<String> getRegisNumberwithcolor(String color) throws Exception{
//       try{
//           List<String> regisNumbers = plsvc.getRegisNumberwithcolor(color);
//           return regisNumbers;
//       }catch (Exception e) {
//           throw new ParkingServerException("Internal Server Error, Contact Administrator");
//       }
//   }
//}
