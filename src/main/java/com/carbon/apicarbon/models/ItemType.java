package com.carbon.apicarbon.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "ItemsType")
@Table(name = "itemsType")
public class ItemType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    private String name;

        
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public ItemType(){}

    public ItemType(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

    
}