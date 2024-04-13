package org.example.parkingStrategies;

import org.example.dto.parkingSpot.ParkingSpot;
import org.example.enums.ParkingSpotEnum;
import org.example.exceptions.SpotNotFoundException;

public interface Strategy {
    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException;
}
