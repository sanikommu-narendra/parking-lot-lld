package org.example.dto;

import org.example.enums.ParkingSpotEnum;

import java.util.HashMap;
import java.util.Map;

public class DisplayBoard {
    private static DisplayBoard displayBoard;
    private Map<ParkingSpotEnum, Integer> freeSpots;

    private DisplayBoard() {
        this.freeSpots = new HashMap<>();
        freeSpots.put(ParkingSpotEnum.MINI, 0);
        freeSpots.put(ParkingSpotEnum.COMPACT, 0);
        freeSpots.put(ParkingSpotEnum.LARGE, 0);
    }

    public static DisplayBoard getInstance() {
        if(displayBoard == null) {
            displayBoard = new DisplayBoard();
        }

        return displayBoard;
    }

    public Map<ParkingSpotEnum, Integer> getFreeSpots() {
        return freeSpots;
    }
}
