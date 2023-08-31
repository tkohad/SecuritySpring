package com.example.demo.com.demo.security.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;


@Component
public class CustomAuthentication implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName=authentication.getName();
        String password=authentication.getCredentials().toString();

            if(ObjectUtils.isEmpty(password) || ObjectUtils.isEmpty(userName))
                throw new BadCredentialsException("UserName or Password is Empty");
            if(userName.equalsIgnoreCase("admin") && password.equals("admin"))
                return new UsernamePasswordAuthenticationToken(userName,password, Arrays.asList());
            else
                throw new BadCredentialsException("Invalid username or password");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
