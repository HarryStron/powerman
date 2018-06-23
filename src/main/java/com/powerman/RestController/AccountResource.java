package com.powerman.RestController;

import com.powerman.Database.AccountStore;
import com.powerman.model.MainPowerProvider;
import com.powerman.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<MainPowerProvider> getMasterAccount() {
        return ResponseEntity.ok(mainPowerProvider);
    }

    @RequestMapping(value = "/account/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<UserAccount> getAccount(@PathVariable("accountId") int accountId) {
        return ResponseEntity.ok(accountStore.getAccount(accountId));
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createAccount(@RequestBody int accountId, UriComponentsBuilder b) {
        UserAccount account = new UserAccount(accountId);
        accountStore.addAccount(account);
        UriComponents uriComponents = b.path("/account/{id}").buildAndExpand(account.getAccountNumber());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
