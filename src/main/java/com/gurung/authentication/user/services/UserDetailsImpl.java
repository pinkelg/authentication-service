package com.gurung.authentication.user.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gurung.authentication.user.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Author: Pinkel Gurung
 * Date: 6/25/22
 * Time: 10:01 PM
 */

@Getter
@AllArgsConstructor

public class UserDetailsImpl implements UserDetails {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;

    public UserDetailsImpl(UserModel userModel) {
        this.id=userModel.getId();
        this.email=userModel.getEmail();
        this.password=userModel.getPassword();
        this.firstName= userModel.getFirstName();
        this.middleName = userModel.getMiddleName();
        this.lastName = userModel.getLastName();
    }

    private Collection<? extends GrantedAuthority> authorities;


    public UserDetailsImpl getUser() {
        List<GrantedAuthority> authorities = new ArrayList<>();
//        List<GrantedAuthority> authorities = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
//                .collect(Collectors.toList());

        return new UserDetailsImpl(
                this.getId(),
                this.getEmail(),
                this.getPassword(),
                this.getFirstName(),
                this.getMiddleName(),
                this.getLastName(),authorities
        );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<GrantedAuthority>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
