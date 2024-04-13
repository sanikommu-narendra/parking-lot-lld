package org.example.dto.vechicles;

import org.example.enums.ParkingSpotEnum;

public class Truck extends Vehicle {
    public Truck() {
        super(ParkingSpotEnum.LARGE);
    }
}
