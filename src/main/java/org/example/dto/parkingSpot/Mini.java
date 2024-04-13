package org.example.dto.parkingSpot;

public class Mini extends ParkingSpot {

    public Mini(Integer floorNum) {
        super(floorNum, 20);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingHours * amount;
    }
}
