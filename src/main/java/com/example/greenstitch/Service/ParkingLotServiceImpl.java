package com.example.greenstitch.Service;


import com.example.greenstitch.Exceptions.ParkingServerException;
import com.example.greenstitch.Repository.ParkingLotRepo;
import com.example.greenstitch.model.Car;
import com.example.greenstitch.model.ParkingSlot;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ParkingLotServiceImpl implements ParkingLotService{


    private ParkingLotRepo parkingLotRepository;

    public ParkingLotServiceImpl() {
        parkingLotRepository = new ParkingLotRepo();
    }

    @Override
    public ParkingSlot createParkingLot(int capacity) throws ParkingServerException {
        if(capacity < 0){
            throw new ParkingServerException("Capacity is less than 0, No vehicles can be parked in the created Parking lot");
        }
        return parkingLotRepository.create(capacity);
    }

    @Override
    public String parkVehicle(Car car) throws Exception {
        int slotNumber = parkingLotRepository.parkvehicle(car);
        return "Allocated slot number: " + slotNumber;
    }

    @Override
    public List<String> getRegisNumberwithcolor(String color) throws  Exception{
        return parkingLotRepository.getRegisNumberwithColor(color);
    }

    @Override
    public Map<Integer, Car> getStatus() {
        Map<Integer,Car> slots = parkingLotRepository.getStatus();
        return slots;
    }

    @Override
    public String leaveVehicle(int slotNumber) {
        int SlotNumber = parkingLotRepository.removevehicle(slotNumber);
        return "Slot number " + SlotNumber + " is free";
    }
}
