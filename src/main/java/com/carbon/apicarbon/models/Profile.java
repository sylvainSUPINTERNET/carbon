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

    @Column 
    private Long maxLevel;

    @Column 
    private Long currentLevelProgression; // if level 58 and progression 1 means 1 buble on 58 bubble


    
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

    public Profile(Long carbong, Long level, Inventory inventory, Long maxLevel, Long currentLevelProgression) {
        this.carbong = carbong;
        this.level = level;
        this.inventory = inventory;
        this.currentLevelProgression = currentLevelProgression;
        this.maxLevel = maxLevel;
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

    
    public Long getMaxLevel() {
        return this.maxLevel;
    }

    public void setMaxLevel(Long maxLevel) {
        this.maxLevel = maxLevel;
    }

    public Long getCurrentLevelProgression() {
        return this.currentLevelProgression;
    }

    public void setCurrentLevelProgression(Long currentLevelProgression) {
        this.currentLevelProgression = currentLevelProgression;
    };  
    
    
}
