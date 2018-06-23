package com.powerman.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MainPowerProvider {
    private int totalCapacity;
    private int availablePower;
    private int totalPowerReceived;
    private int totalPowerProvided;
    private int totalPowerProduced;

    // used only for serialization
    @JsonCreator
    public MainPowerProvider(
            @JsonProperty("totalCapacity") int totalCapacity,
            @JsonProperty("availablePower") int availablePower,
            @JsonProperty("totalPowerReceived") int totalPowerReceived,
            @JsonProperty("totalPowerProvided") int totalPowerProvided,
            @JsonProperty("totalPowerProduced") int totalPowerProduced) {
        this.totalCapacity = totalCapacity;
        this.availablePower = availablePower;
        this.totalPowerReceived = totalPowerReceived;
        this.totalPowerProvided = totalPowerProvided;
        this.totalPowerProduced = totalPowerProduced;
    }

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

    public int getAvailablePower() {
        return availablePower;
    }

    public int getRemainingCapacity() {
        return totalCapacity - availablePower;
    }

    public int getRequiredPowerProduction() {
        if (totalCapacity /2 <= availablePower) {
            return 0;
        } else {
            return totalCapacity / 2 - availablePower;
        }
    }

    public long getTotalPowerReceived() {
        return totalPowerReceived;
    }

    public long getTotalPowerProvided() {
        return totalPowerProvided;
    }

    public long getTotalPowerProduced() {
        return totalPowerProduced;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("getAvailablePower", getAvailablePower())
                .add("getRemainingCapacity", getRemainingCapacity())
                .add("getRequiredPowerProduction", getRequiredPowerProduction())
                .add("getTotalPowerReceived", getTotalPowerReceived())
                .add("getTotalPowerProvided", getTotalPowerProvided())
                .add("getTotalPowerProduced", getTotalPowerProduced())
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainPowerProvider that = (MainPowerProvider) o;
        return totalCapacity == that.totalCapacity &&
                availablePower == that.availablePower &&
                totalPowerReceived == that.totalPowerReceived &&
                totalPowerProvided == that.totalPowerProvided &&
                totalPowerProduced == that.totalPowerProduced;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(totalCapacity, availablePower, totalPowerReceived, totalPowerProvided, totalPowerProduced);
    }
}
