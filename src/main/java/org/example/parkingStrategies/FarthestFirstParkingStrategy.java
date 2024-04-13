package org.example.parkingStrategies;

import org.example.dto.ParkingLot;
import org.example.dto.parkingSpot.ParkingSpot;
import org.example.enums.ParkingSpotEnum;
import org.example.exceptions.SpotNotFoundException;

import java.util.List;

public class FarthestFirstParkingStrategy implements Strategy  {
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {
        List<ParkingSpot> freeParkingSpots = ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);

        if(freeParkingSpots.isEmpty())
            throw new SpotNotFoundException("Not free spot found in FarthestFirstParkingStrategy");

        return freeParkingSpots.get(freeParkingSpots.size() - 1 );
    }
}
