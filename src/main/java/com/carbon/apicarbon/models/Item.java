package com.carbon.apicarbon.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Items")
@Table(name = "items")
public class Item implements Serializable {
    @Id 
    @GeneratedValue
    long id;

    @Column
    private Long name;

    @Column
    private String uuid;

    @Column
    private Long level;

    @Column
    private String mediaUrl;

    @Column
    private Integer maxStack;
    
    @Column
    private String description;


}
