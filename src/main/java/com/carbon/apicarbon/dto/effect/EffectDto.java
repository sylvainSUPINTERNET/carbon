package com.carbon.apicarbon.dto.effect;

public class EffectDto {
    public long id;
    public String name;
    public String description;
    public EffectDto(){}

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
