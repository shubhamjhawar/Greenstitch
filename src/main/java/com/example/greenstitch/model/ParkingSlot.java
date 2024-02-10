package com.example.greenstitch.model;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ParkingSlot {
    private int capacity;
    private Map<Integer,Car> slots;
    private PriorityQueue<Integer> availableSlots;

    public static ParkingSlot instance = new ParkingSlot();


    private ParkingSlot(){
        this.slots =  new HashMap<>();
        this.availableSlots = new PriorityQueue<>();

    }
    public static ParkingSlot getInstance(){
        return instance;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<Integer, Car> getSlot() {
        return slots;
    }

    public void setSlot(Map<Integer, Car> slot) {
        this.slots = slot;
    }

    public void addCarinSlot(Integer slotNumber,Car car){
        this.slots.put(slotNumber,car);
    }

    public boolean isSlotsNotAvailable(){
        return this.availableSlots.isEmpty();
    }

    public Integer getNearestSlot(){
        return this.availableSlots.poll();
    }

    public PriorityQueue<Integer> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(PriorityQueue<Integer> availableSlots) {
        this.availableSlots = availableSlots;
    }
}
