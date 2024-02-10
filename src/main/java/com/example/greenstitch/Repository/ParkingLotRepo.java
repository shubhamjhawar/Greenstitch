package com.example.greenstitch.Repository;

import com.example.greenstitch.model.Car;
import com.example.greenstitch.model.ParkingSlot;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ParkingLotRepo {
    Map<String, List<String>> colorMap ;
    private ParkingSlot parkingSlot = null ;
    private void initializeAvailableSlots(PriorityQueue<Integer> newPq,int capacity) {
        for (int i = 1; i <= capacity; i++) {
            newPq.offer(i);
        }
    }

    public ParkingSlot create(int capacity){
        if(parkingSlot == null){
            parkingSlot = ParkingSlot.getInstance();
            parkingSlot.setCapacity(capacity);
            PriorityQueue<Integer> newPq = new PriorityQueue<>();
            initializeAvailableSlots(newPq,capacity);
            parkingSlot.setAvailableSlots(newPq);
            colorMap  =  new HashMap<>();
        }
        return parkingSlot;
    }

    public int parkvehicle(Car car) {
        if(!parkingSlot.isSlotsNotAvailable()) {
            Integer slotNum = parkingSlot.getNearestSlot();
            parkingSlot.addCarinSlot(slotNum, car);
            addtoColorMap(car);
            return slotNum;
        }
        return -1;
    }

    private void addtoColorMap(Car car) {
        String color = car.getColor();
        if(!colorMap.containsKey(color)){
            colorMap.put(color, new ArrayList<>());
        }
        colorMap.get(color).add(car.getRegisNumber());
    }

    public int removevehicle(Integer slotNumber){
         parkingSlot.getAvailableSlots().offer(slotNumber);
         Car car = parkingSlot.getSlot().get(slotNumber);
         colorMap.get(car.getColor()).remove(car.getRegisNumber());
         return slotNumber;
    }

    public Map<Integer, Car> getStatus() {
        return parkingSlot.getSlot();
    }

    public List<String> getRegisNumberwithColor(String color) {
        if(colorMap.containsKey(color) && !colorMap.get(color).isEmpty()){
            return colorMap.get(color);
        }
        return null;
    }
}
