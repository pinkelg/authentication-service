package com.gurung.authentication.User;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name="ACCOUNT")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @CreationTimestamp
    private Instant CreatedTimestamp;

    @UpdateTimestamp
    private Instant ModifiedTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instant getCreatedTimestamp() {
        return CreatedTimestamp;
    }

    public void setCreatedTimestamp(Instant createdTimestamp) {
        CreatedTimestamp = createdTimestamp;
    }

    public Instant getModifiedTimestamp() {
        return ModifiedTimestamp;
    }

    public void setModifiedTimestamp(Instant modifiedTimestamp) {
        ModifiedTimestamp = modifiedTimestamp;
    }
}
