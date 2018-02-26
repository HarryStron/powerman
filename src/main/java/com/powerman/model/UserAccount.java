package com.powerman.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class UserAccount {
    int accountNumber;
    int producedPower = 0;
    int consumedPower = 0;

    protected UserAccount(){}

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

    public long produced() {
        return producedPower;
    }

    public long consumed() {
        return consumedPower;
    }

    public float ratio() {
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
                .add("accountNumber", accountNumber)
                .add("producedPower", producedPower)
                .add("consumedPower", consumedPower)
                .add("ratio", ratio())
                .toString();
    }
}
