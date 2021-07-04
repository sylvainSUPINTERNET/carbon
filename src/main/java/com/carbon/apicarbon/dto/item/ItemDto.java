package com.carbon.apicarbon.dto.item;

import java.util.Set;

import com.carbon.apicarbon.dto.effect.EffectDto;
import com.carbon.apicarbon.dto.itemType.ItemTypeDto;

public class ItemDto {
    public long id;
    public String uuid;
    public Long unitPrice;
    public Long levelRequired;
    public String mediaUrl;
    public Integer maxStack;
    public String description;
    public boolean isConsumable;
    public String quality;
    public Set<EffectDto> effects;
    public Set<ItemTypeDto> itemTypes;

    
    public ItemDto(){}

    public long getId(){
        return this.id;
    }

    
    public String getQuality() {
        return this.quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }


    public void setId(long id) {
        this.id = id;
    }

    public Set<EffectDto> getEffects() {
        return this.effects;
    }

    public void setEffects(Set<EffectDto> effects) {
        this.effects = effects;
    }

    public Set<ItemTypeDto> getItemTypes() {
        return this.itemTypes;
    }

    public void setItemTypes(Set<ItemTypeDto> itemTypes) {
        this.itemTypes = itemTypes;
    }
    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
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

    public Integer getMaxStack() {
        return this.maxStack;
    }

    public void setMaxStack(Integer maxStack) {
        this.maxStack = maxStack;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsConsumable() {
        return this.isConsumable;
    }

    public void setIsConsumable(boolean isConsumable) {
        this.isConsumable = isConsumable;
    }

}
