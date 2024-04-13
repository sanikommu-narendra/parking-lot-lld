package org.example.dto.parkingSpot.sportDecorator;

import org.example.dto.parkingSpot.ParkingSpot;

public class CarWash extends SpotDecorator {
    public CarWash(ParkingSpot parkingSpot) {
        super(parkingSpot);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingSpot.cost(parkingHours) + 100 ;
    }
}
