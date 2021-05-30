package com.carbon.apicarbon.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "Inventories")
@Table(name = "inventories")
public class Inventory {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    private Integer maxSlot;
    
    @ManyToMany
    private List<Item> items;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Inventory() {} 

    public Inventory(Integer maxSlot, List<Item> items) {
        this.maxSlot = maxSlot;
        this.items = items;
    } 

    public void addItem(Item item) {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(item);
        this.items = list; 
    }

    public List<Item> getItems() {
        return this.items;
    }

    public Integer getMaxSlot(){
        return this.maxSlot;
    }

    public void setMaxSlot(Integer maxSlot) {
        this.maxSlot = maxSlot;
    }

}
