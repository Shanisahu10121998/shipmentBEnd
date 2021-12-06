package com.shipmenttracking.shipmenttracking.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;


@Data
@Entity
@Table(name="USER")
public class User implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "first_name",length = 100,nullable = false)
    private String firstName;
    @Column(name = "last_name",length = 100,nullable = false)
    private String lastName;
    @Column(name = "contact_number",length = 15,nullable = false)
    private String contactNumber;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "address",nullable = false)
    private String address;
    @Column(name = "password",nullable = false,length = 40)
    private String password;

    @ManyToOne(cascade = {CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name = "role_id_fd")
    private Role role;




}
