package com.carbon.apicarbon.dto.itemType;

public class ItemTypeDto {
    public long id;
    public String name;

    public ItemTypeDto(){}

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

}
