package com.powerman;

import com.powerman.Database.AccountStore;
import com.powerman.model.MainPowerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public AccountStore accountStore() {
        return new AccountStore();
    }

    @Bean
    public MainPowerProvider powerProvider() {
        return new MainPowerProvider();
    }
}
