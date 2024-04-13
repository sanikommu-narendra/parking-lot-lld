package org.example.interfaces;

import org.example.dto.ParkingTicket;
import org.example.dto.vechicles.Vehicle;
import org.example.exceptions.InvalidTicketException;

public interface ParkingService {
    ParkingTicket entry( Vehicle vehicle);
    int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}
