package com.powerman.model;

import com.google.common.base.MoreObjects;

public class MainPowerProvider {
    long profit;

    long reserve;
    long amountToFull;
    long needToProduce;

    long totalReceived;
    long totalProvided;
    long totalProduced;

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    public long getReserve() {
        return reserve;
    }

    public void setReserve(long reserve) {
        this.reserve = reserve;
    }

    public long getAmountToFull() {
        return amountToFull;
    }

    public void setAmountToFull(long amountToFull) {
        this.amountToFull = amountToFull;
    }

    public long getNeedToProduce() {
        return needToProduce;
    }

    public void setNeedToProduce(long needToProduce) {
        this.needToProduce = needToProduce;
    }

    public long getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(long totalReceived) {
        this.totalReceived = totalReceived;
    }

    public long getTotalProvided() {
        return totalProvided;
    }

    public void setTotalProvided(long totalProvided) {
        this.totalProvided = totalProvided;
    }

    public long getTotalProduced() {
        return totalProduced;
    }

    public void setTotalProduced(long totalProduced) {
        this.totalProduced = totalProduced;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("profit", profit)
                .add("reserve", reserve)
                .add("amountToFull", amountToFull)
                .add("needToProduce", needToProduce)
                .add("totalReceived", totalReceived)
                .add("totalProvided", totalProvided)
                .add("totalProduced", totalProduced)
                .toString();
    }
}
