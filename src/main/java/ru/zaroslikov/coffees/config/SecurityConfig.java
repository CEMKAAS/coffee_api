package ru.zaroslikov.coffees.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import ru.zaroslikov.coffees.security.AuthProviderImpl;


@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    private final AuthProviderImpl authProvider;

    @Autowired
    public SecurityConfig (AuthProviderImpl authProvider){
        this.authProvider = authProvider;
    }


    protected void configure (AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authProvider);
    }

}
