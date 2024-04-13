package org.example.dto;

import org.example.dto.parkingSpot.ParkingSpot;
import org.example.dto.vechicles.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingTicket  {
    private static final AtomicInteger x = new AtomicInteger(0);

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime timeStamp;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.id = x.incrementAndGet();
        this.timeStamp = LocalDateTime.now();
    }

    public int getParkingHours() {
        // return (int) Duration.between(LocalDateTime.now(), timeStamp).toHours();
        return 2;
    }

}
