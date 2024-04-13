package org.example.dto.parkingSpot.sportDecorator;

import org.example.dto.parkingSpot.ParkingSpot;

public abstract class SpotDecorator extends ParkingSpot {
    protected ParkingSpot parkingSpot;

    public SpotDecorator(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
