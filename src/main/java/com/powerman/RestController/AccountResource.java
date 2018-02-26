package com.powerman.RestController;

import com.powerman.Database.AccountStore;
import com.powerman.model.MainPowerProvider;
import com.powerman.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountResource {
    private MainPowerProvider mainPowerProvider;
    private AccountStore accountStore;

    @Autowired
    public AccountResource(MainPowerProvider mainPowerProvider, AccountStore accountStore) {
        this.mainPowerProvider = mainPowerProvider;
        this.accountStore = accountStore;
    }

    @RequestMapping(value = "/masterAccount", method = RequestMethod.GET)
    public MainPowerProvider getMasterAccount() {
        return mainPowerProvider;
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public UserAccount getAccount(int accountId) {
        return accountStore.getAccount(accountId);
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public void createAccount(int accountId) {
        UserAccount account = new UserAccount(accountId);
        accountStore.addAccount(account);
    }
}
