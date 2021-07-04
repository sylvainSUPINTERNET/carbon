package com.carbon.apicarbon.dto.classes;

import java.util.List;

import com.carbon.apicarbon.dto.item.ItemDto;
import com.carbon.apicarbon.models.Item;

public class ClassesDto {
    public String name;
    public String description;
    public List<Item> items;

    public ClassesDto(){}

    public ClassesDto(String name, String description, List<Item> itemList){
        this.name = name;
        this.description = description;
        this.items = itemList;
    }

    public List<Item> getItems(){
        return this.items;
    }
    public void setItem(List<Item> itemList) {
        this.items = itemList;
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
