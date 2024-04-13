package org.example.enums;

import org.example.dto.parkingSpot.Compact;
import org.example.dto.parkingSpot.Large;
import org.example.dto.parkingSpot.Mini;

public enum ParkingSpotEnum {
    MINI(Mini.class),
    COMPACT(Compact.class),
    LARGE(Large.class);

    private Class parkingSpot;

    ParkingSpotEnum(Class parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Class getParkingSpotClass() {
        return this.parkingSpot;
    }
}
