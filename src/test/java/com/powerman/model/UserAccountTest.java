package com.powerman.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class UserAccountTest {
    private UserAccount userAccount;

    @Before
    public void setup() {
        userAccount = new UserAccount(123);
    }

    @Test
    public void accountNumber() {
        assertThat(userAccount.getAccountNumber()).isEqualTo(123);
    }

    @Test
    public void produced() {
        userAccount.produce(20);
        userAccount.produce(10);
        assertThat(userAccount.getProducedPower()).isEqualTo(30);
    }

    @Test
    public void consumed() {
        userAccount.consume(50);
        assertThat(userAccount.getConsumedPower()).isEqualTo(50);
    }

    @Test
    public void ratio() {
        userAccount.produce(40);
        userAccount.consume(30);
        assertThat(userAccount.getRatio()).isEqualTo((float) 40/30);
    }
}
