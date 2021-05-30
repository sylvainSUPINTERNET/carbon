package com.carbon.apicarbon.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "Items")
@Table(name = "items")
public class Item implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    private String name;

    @Column
    private String uuid;

    @Column
    private Long unitPrice;

    @Column
    private Long levelRequired;

    @Column
    private String mediaUrl;

    @Column
    private Integer maxStack;
    
    @Column
    private String description;

    @Column
    private boolean isConsumable;

    @ManyToMany
    private List<Effect> effects;

    @ManyToMany
    private List<ItemType> itemType;

    
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Item(){}
    /**
     * 
     * @param name
     * @param uuid
     * @param unitPrice
     * @param levelRequired
     * @param mediaUrl
     * @param maxStack
     * @param description
     * @param isConsumable
     * @param effects
     * @param itemType
     */
    public Item(String name, String uuid, Long unitPrice, Long levelRequired, String mediaUrl, Integer maxStack,
            String description, boolean isConsumable, List<Effect> effects, List<ItemType> itemType) {
        this.name = name;
        this.uuid = uuid;
        this.unitPrice = unitPrice;
        this.levelRequired = levelRequired;
        this.mediaUrl = mediaUrl;
        this.maxStack = maxStack;
        this.description = description;
        this.isConsumable = isConsumable;
        this.effects = effects;
        this.itemType = itemType;
    }


    public boolean getIsConsumable() {
        return this.isConsumable;
    }

    public void setIsConsumable(boolean isConsumable) {
       this.isConsumable = isConsumable;
    }

    public List<Effect> addEffect(Effect effect) {
        this.effects.add(effect);
        return this.effects;
    }

    public List<Effect> removeEffect(Effect effect) {
        this.effects.remove(effect);
        return this.effects;
    }


    public Long getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    };

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    };

    public void setUuid(String uuid){
        this.uuid = uuid;
    }
    public String getUuid() {
        return this.uuid;
    } 

    public Long getUnitPrice(){
        return this.unitPrice;
    }
    public void setUnitPrice(Long unitPrice){
        this.unitPrice = unitPrice;
    }

    public Long getLevelRequired() {
        return this.levelRequired;
    }

    public void setLevelRequired(Long levelRequired) {
        this.levelRequired = levelRequired;
    }

    public String getMediaUrl() {
        return this.mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public Integer getMaxStack(){
        return this.maxStack;
    }

    public void setMaxStack(Integer maxStack) {
        this.maxStack = maxStack;
    }

    public void addItemType(ItemType itemType) {
        this.itemType.add(itemType);
    } 
    public List<ItemType> getItemType(){
        return this.itemType;
    }




}
