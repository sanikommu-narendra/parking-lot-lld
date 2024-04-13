package org.example.interfaces;

import org.example.dto.parkingSpot.ParkingEvent;

public interface Observer {
    void update( ParkingEvent parkingEvent);
}
