package com.telusko.springsecurity.entities;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

    private final User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Default ROLE_USER since DB has no roles
    	System.out.println("Authorities called");
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // always active
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // never locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // credentials always valid
    }

    @Override
    public boolean isEnabled() {
        return true; // user is enabled
    }
}
