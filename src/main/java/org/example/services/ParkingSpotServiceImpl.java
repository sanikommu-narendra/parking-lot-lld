package org.example.services;

import org.example.dto.ParkingLot;
 import org.example.dto.parkingSpot.ParkingSpot;
import org.example.enums.ParkingSpotEnum;
import org.example.interfaces.DisplayService;
import org.example.interfaces.ParkingSpotService;

import java.lang.reflect.InvocationTargetException;

public class ParkingSpotServiceImpl implements ParkingSpotService {
    private final DisplayService displayService = new DisplayServiceImpl();
    @Override
    public ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floorNum) {
        try {
            ParkingSpot parkingSpot = (ParkingSpot)  parkingSpotEnum.getParkingSpotClass().getConstructor(Integer.class).newInstance(floorNum);
            ParkingLot.getParkingLot().getFreeParkingSpots().get(parkingSpotEnum).add(parkingSpot);
            displayService.update(parkingSpotEnum, 1);

            return parkingSpot;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
