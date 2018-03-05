package com.powerman.model;

import com.google.common.base.MoreObjects;

public class MainPowerProvider {
    private int totalCapacity;
    private int availablePower;
    private int totalPowerReceived;
    private int totalPowerProvided;
    private int totalPowerProduced;

    public MainPowerProvider(int capacity) {
        totalCapacity = capacity;
        availablePower = 0;
        totalPowerReceived = 0;
        totalPowerProvided = 0;
        totalPowerProduced = 0;
    }

    public void store(int power) {
        availablePower += power;
        totalPowerReceived += power;
    }

    public void generate(int power) {
        availablePower += power;
        totalPowerProduced += power;
    }

    public void consume(int power) {
        availablePower -= power;
        totalPowerProvided += power;
    }

    public int availablePower() {
        return availablePower;
    }

    public int remainingCapacity() {
        return totalCapacity - availablePower;
    }

    public int requiredPowerProduction() {
        if (totalCapacity /2 <= availablePower) {
            return 0;
        } else {
            return totalCapacity / 2 - availablePower;
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
