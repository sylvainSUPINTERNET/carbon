package com.carbon.apicarbon.dto.item;

import java.util.Set;

import com.carbon.apicarbon.dto.effect.EffectDto;
import com.carbon.apicarbon.dto.itemType.ItemTypeDto;

public class ItemDto {
    public long id;

    public Set<EffectDto> effects;
    public Set<ItemTypeDto> itemTypes;

    
    public ItemDto(){}

    public long getId(){
        return this.id;
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
}
