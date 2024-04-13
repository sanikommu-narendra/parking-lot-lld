package org.example.dto.vechicles;

import org.example.enums.ParkingSpotEnum;

public class Car extends Vehicle {
    public Car() {
        super(ParkingSpotEnum.COMPACT);
    }
}
