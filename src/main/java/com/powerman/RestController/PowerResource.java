package com.powerman.RestController;

import com.powerman.Database.AccountStore;
import com.powerman.model.MainPowerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerResource {
    private AccountStore accountStore;
    private MainPowerProvider powerProvider;

    @Autowired
    public PowerResource(AccountStore accountStore, MainPowerProvider powerProvider) {
        this.accountStore = accountStore;
        this.powerProvider = powerProvider;
    }
}
