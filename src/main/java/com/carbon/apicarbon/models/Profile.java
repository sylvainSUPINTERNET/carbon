package com.carbon.apicarbon.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "Profiles")
@Table(name = "profiles")
public class Profile implements Serializable {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    private Long carbong;

    @Column
    private Long level;
    
    
    @OneToOne(mappedBy = "profile")
    @JsonBackReference
    private Users user;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;


    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Profile(){}

    public Profile(Long carbong, Long level, Inventory inventory) {
        this.carbong = carbong;
        this.level = level;
        this.inventory = inventory;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setCarbong(Long carbong) {
        this.carbong = carbong;
    }

    public Long getCarbong(){
        return this.carbong;
    }

    public void setLevel(Long level) {
        this.level = level;
    }
    public Long getLevel(){
        return this.level;
    }

    public Users getUser() {
        return this.user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
}
