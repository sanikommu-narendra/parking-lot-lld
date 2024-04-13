package org.example.dto.accounts;

import org.example.dto.ParkingLot;

public class Admin extends Account {
    private ParkingLot parkingLot;


    public Admin(String name, String emailId, String password) {
        super(name, emailId, password);
        parkingLot = ParkingLot.getInstance();
    }
}
