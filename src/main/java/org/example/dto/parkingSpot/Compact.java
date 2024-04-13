package org.example.dto.parkingSpot;

public class Compact extends ParkingSpot {
    public Compact(Integer floorNum) {
        super(floorNum, 30);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingHours * amount ;
    }
}
