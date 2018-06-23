package com.powerman.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccount {
    private int accountNumber;
    private int producedPower = 0;
    private int consumedPower = 0;

    @JsonCreator
    public UserAccount(@JsonProperty("accountNumber") int accountNumber,
                       @JsonProperty("producedPower") int producedPower,
                       @JsonProperty("consumedPower") int consumedPower) {
        this.accountNumber = accountNumber;
        this.producedPower = producedPower;
        this.consumedPower = consumedPower;
    }

    public UserAccount(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void produce(int power) {
        producedPower += power;
    }

    public void consume(int power) {
        consumedPower += power;
    }

    public long getProducedPower() {
        return producedPower;
    }

    public long getConsumedPower() {
        return consumedPower;
    }

    public float getRatio() {
        return (float)producedPower / consumedPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return accountNumber == that.accountNumber &&
                producedPower == that.producedPower &&
                consumedPower == that.consumedPower;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNumber, producedPower, consumedPower);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("getAccountNumber", accountNumber)
                .add("producedPower", producedPower)
                .add("consumedPower", consumedPower)
                .add("getRatio", getRatio())
                .toString();
    }
}
