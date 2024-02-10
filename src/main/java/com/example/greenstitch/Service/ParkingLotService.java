package com.example.greenstitch.Service;

import com.example.greenstitch.Exceptions.ParkingServerException;
import com.example.greenstitch.model.Car;
import com.example.greenstitch.model.ParkingSlot;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ParkingLotService {

    public ParkingSlot createParkingLot(int capacity) throws ParkingServerException;

    public String parkVehicle(Car car) throws Exception;

    public  String leaveVehicle(int slotNumber) throws Exception;

    public Map<Integer, Car> getStatus() throws Exception;

    List<String> getRegisNumberwithcolor(String color) throws Exception;
}
