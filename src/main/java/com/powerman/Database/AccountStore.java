package com.powerman.Database;

import com.powerman.model.UserAccount;
import java.util.HashMap;

public class AccountStore {
    private HashMap<Integer, UserAccount> userMap = new HashMap();

    public void addAccount(UserAccount userAccount) {
        userMap.put(userAccount.getAccountNumber(), userAccount);
    }

    public UserAccount getAccount(int accountId) {
        return userMap.get(accountId);
    }
}
