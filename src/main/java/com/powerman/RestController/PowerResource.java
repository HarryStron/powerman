package com.powerman.RestController;

import com.powerman.Database.AccountStore;
import com.powerman.model.MainPowerProvider;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/power", method = RequestMethod.POST)
    public Response powerIn(int accountId, int power) {
        accountStore.getAccount(accountId).produce(power);
        powerProvider.store(power);
        return Response.created(UriBuilder.fromPath("/" + accountId).build()).build();
    }
}
