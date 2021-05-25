package com.carbon.apicarbon.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity(name = "Users")
@Table(name = "users")
public class Users implements Serializable {
    @Id 
    @GeneratedValue
    long id;

    @Column ( name = "email", nullable = false)
    public String email;

    @Column ( name = "firstName", nullable = false)
    public String firstName;

    @Column ( name = "lastName", nullable = false)
    public String lastName;

    @Column ( name = "provider", nullable = true)
    public String provider;

    @OneToOne
    @JoinColumn(name = "profile")
    private Profile profile;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Users(){}

    public Users(String email, String firstName, String lastName, String provider){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.provider = provider;
    }
    public String getProvider () {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }


    

}
