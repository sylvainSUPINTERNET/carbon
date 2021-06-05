package com.carbon.apicarbon.dto.users;

import com.carbon.apicarbon.dto.inventories.InventoryDTO;
import com.carbon.apicarbon.models.Profile;

public class UserFullProfileDto {
    public String email;
    public String firstName;
    public String lastName;
    public String provider;
    public Profile profile;
    public InventoryDTO inventory;

    public UserFullProfileDto(){}

    public Profile getProfile() {
        return this.profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    public String getProvider () {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
    
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public InventoryDTO getInventory() {
        return this.inventory;
    }
    public void setInventory(InventoryDTO inventory) {
        this.inventory = inventory;
    }

}
