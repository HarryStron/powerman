package com.powerman.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class UserAccount {
    int accountNumber;
    long produced;
    long consumed;
    double ratio;

    protected UserAccount(){}

    public UserAccount(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getProduced() {
        return produced;
    }

    public void setProduced(long produced) {
        this.produced = produced;
    }

    public long getConsumed() {
        return consumed;
    }

    public void setConsumed(long consumed) {
        this.consumed = consumed;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return accountNumber == that.accountNumber &&
                produced == that.produced &&
                consumed == that.consumed &&
                Double.compare(that.ratio, ratio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNumber, produced, consumed, ratio);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("accountNumber", accountNumber)
                .add("produced", produced)
                .add("consumed", consumed)
                .add("ratio", ratio)
                .toString();
    }
}
