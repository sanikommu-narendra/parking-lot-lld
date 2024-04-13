package org.example.dto.parkingSpot;

public class Large extends ParkingSpot {
    public Large(Integer floorNum) {
        super(floorNum, 40);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingHours * amount;
    }
}
