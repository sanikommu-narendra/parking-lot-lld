package org.example.services;

import org.example.dto.DisplayBoard;
import org.example.dto.parkingSpot.ParkingEvent;
import org.example.enums.ParkingEventType;
import org.example.enums.ParkingSpotEnum;
import org.example.interfaces.DisplayService;
import org.example.interfaces.Observer;

public class DisplayServiceImpl implements DisplayService, Observer {
//    @Override
//    public void update(ParkingSpotEnum parkingSpotEnum, int change) {
//        int currentCount = DisplayBoard.getInstance().getFreeSpots().get(parkingSpotEnum);
//        int newCount = currentCount + 1;
//        DisplayBoard.getInstance().getFreeSpots().replace(parkingSpotEnum, newCount);
//    }

    @Override
    public void update(ParkingEvent parkingEvent) {
        int currentCount = DisplayBoard.getInstance().getFreeSpots().get(parkingEvent.getParkingSpotEnum());
        int change = 0;
        if(parkingEvent.getParkingEventType().equals(ParkingEventType.ENTRY)) {
            change = 1;
        } else {
            change = -1;
        }
        int newCount = currentCount + change;
        DisplayBoard.getInstance().getFreeSpots().replace(parkingEvent.getParkingSpotEnum(), newCount);
    }
}
