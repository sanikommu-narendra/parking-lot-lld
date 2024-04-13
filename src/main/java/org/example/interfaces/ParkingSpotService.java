package org.example.interfaces;

import org.example.dto.parkingSpot.ParkingSpot;
import org.example.enums.ParkingSpotEnum;

public interface ParkingSpotService {

    ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floorNum);
}
