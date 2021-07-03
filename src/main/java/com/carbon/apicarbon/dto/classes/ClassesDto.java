package com.carbon.apicarbon.dto.classes;

public class ClassesDto {
    public String name;
    public String description;

    public ClassesDto(){}

    public ClassesDto(String name, String description){
        this.name = name;
        this.description = description;
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
