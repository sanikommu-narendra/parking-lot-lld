package org.example.services;

import org.example.dto.ParkingLot;
import org.example.dto.ParkingTicket;
import org.example.dto.parkingSpot.ParkingEvent;
import org.example.dto.parkingSpot.ParkingSpot;
import org.example.dto.vechicles.Vehicle;
import org.example.enums.ParkingEventType;
import org.example.enums.ParkingSpotEnum;
import org.example.exceptions.InvalidTicketException;
import org.example.interfaces.DisplayService;
import org.example.interfaces.Observer;
import org.example.interfaces.ParkingService;
import org.example.parkingStrategies.Strategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingServiceImpl implements ParkingService {
    private Strategy strategy;
    private ParkingLot parkingLot;
    private DisplayService displayService;
    private List<Observer> observers;
    public ParkingServiceImpl(Strategy strategy) {
        this.strategy = strategy;
        this.parkingLot = ParkingLot.getInstance();
        this.displayService = new DisplayServiceImpl();
        this.observers = new ArrayList<>();
    }

    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        ParkingSpotEnum parkingSpotEnum = vehicle.getParkingSpotEnum();
        List<ParkingSpot> freeParkingSpots = parkingLot.getFreeParkingSpots().get(parkingSpotEnum);
        List<ParkingSpot> occupiedParkingSpots = parkingLot.getOccupiedParkingSpots().get(parkingSpotEnum);

        try {
            ParkingSpot parkingSpot = strategy.findParkingSpot(parkingSpotEnum);

            if(parkingSpot.isFree()) {
                synchronized (parkingSpot) {
                    if(parkingSpot.isFree()) {
                        parkingSpot.setFree(false);
                        freeParkingSpots.remove(parkingSpot);
                        occupiedParkingSpots.add(parkingSpot);
                        ParkingTicket parkingTicket = new ParkingTicket(vehicle,parkingSpot);

                        ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.ENTRY, parkingSpotEnum);
                        notifyAllObservers(parkingEvent );

                        return parkingTicket;
                    }
                    return entry(vehicle);
                }
            }
        } catch (Exception  exception) {
            throw new RuntimeException(exception);
        }

        return null;
    }

    private void addParkingSpotInFreeListUsingBinarySearch(List<ParkingSpot> parkingSpots, ParkingSpot parkingSpot) {
        // todo - add using binary search or better use set instead of list in parking lot
        parkingSpots.add(parkingSpot);
    }
    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException {
        if(parkingTicket.getVehicle().equals(vehicle)) {
            ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
            int amount = parkingSpot.getAmount();
            parkingSpot.setFree(true);
            parkingLot.getOccupiedParkingSpots().get(vehicle.getParkingSpotEnum()).remove(parkingSpot);
            addParkingSpotInFreeListUsingBinarySearch(parkingLot.getFreeParkingSpots().get(vehicle.getParkingSpotEnum()), parkingSpot);

            ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.EXIT, vehicle.getParkingSpotEnum() );
            notifyAllObservers(parkingEvent );

            return amount;
        } else {
            throw new InvalidTicketException("Ticket and Vehicle doesn't match");
        }
    }

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void notifyAllObservers(ParkingEvent parkingEvent) {
        for(Observer observer: observers)
            observer.update(parkingEvent);
    }
}
