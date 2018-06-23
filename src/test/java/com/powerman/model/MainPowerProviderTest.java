package com.powerman.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MainPowerProviderTest {
    private static final int POWER = 100;
    private MainPowerProvider powerProvider;

    @Before
    public void setup() {
        powerProvider = new MainPowerProvider(POWER);
    }

    @Test
    public void initialCapacity() {
        assertThat(powerProvider.getRemainingCapacity()).isEqualTo(POWER);
    }

    @Test
    public void remainingCapacity() {
        powerProvider.store(10);
        assertThat(powerProvider.getRemainingCapacity()).isEqualTo(POWER-10);
    }

    @Test
    public void availablePower() {
        powerProvider.store(30);
        assertThat(powerProvider.getAvailablePower()).isEqualTo(30);
    }

    @Test
    public void requiredPowerToReachHalfWay() {
        powerProvider.store(40);
        assertThat(powerProvider.getRequiredPowerProduction()).isEqualTo(10);
    }

    @Test
    public void requiredPowerWhenRemainingPowerIsEnough() {
        powerProvider.store(80);
        assertThat(powerProvider.getRequiredPowerProduction()).isEqualTo(0);
    }

    @Test
    public void totalPowerReceived() {
        powerProvider.store(40);
        powerProvider.store(20);
        assertThat(powerProvider.getTotalPowerReceived()).isEqualTo(60);
    }

    @Test
    public void totalPowerConsumed() {
        powerProvider.consume(40);
        powerProvider.consume(20);
        assertThat(powerProvider.getTotalPowerProvided()).isEqualTo(60);
    }

    @Test
    public void totalPowerProduced() {
        powerProvider.generate(40);
        powerProvider.generate(20);
        assertThat(powerProvider.getTotalPowerProduced()).isEqualTo(60);
    }
}
