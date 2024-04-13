package org.example.dto.parkingSpot;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ParkingSpot {
    private static final AtomicInteger x = new AtomicInteger(0);
    private int id;
    private int floorNum;
    private int amount;
    private boolean isFree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public ParkingSpot(int floorNum, int amount) {
        this.floorNum = floorNum;
        this.amount = amount;
        this.id = x.incrementAndGet();
        this.isFree = true;
    }
}
