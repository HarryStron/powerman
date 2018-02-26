package com.powerman.model;

import com.google.common.base.MoreObjects;

public class MainPowerProvider {
    private static final int TOTAL_CAPACITY = 100;
    int availablePower;
    int totalPowerReceived;
    int totalPowerProvided;
    int totalPowerProduced;

    public MainPowerProvider() {
        availablePower = 0;
        totalPowerReceived = 0;
        totalPowerProvided = 0;
        totalPowerProduced = 0;
    }

    public void store(int power) {
        availablePower += power;
        totalPowerReceived += power;
    }

    public int availablePower() {
        return availablePower;
    }

    public int remainingCapacity() {
        return TOTAL_CAPACITY - availablePower;
    }

    public int requiredPowerProduction() {
        if (TOTAL_CAPACITY/2 <= availablePower) {
            return 0;
        } else {
            return TOTAL_CAPACITY / 2 - availablePower;
        }
    }

    public long totalPowerReceived() {
        return totalPowerReceived;
    }

    public long totalPowerProvided() {
        return totalPowerProvided;
    }

    public long totalPowerProduced() {
        return totalPowerProduced;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("availablePower", availablePower())
                .add("remainingCapacity", remainingCapacity())
                .add("requiredPowerProduction", requiredPowerProduction())
                .add("totalPowerReceived", totalPowerReceived())
                .add("totalPowerProvided", totalPowerProvided())
                .add("totalPowerProduced", totalPowerProduced())
                .toString();
    }
}
