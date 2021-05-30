package com.carbon.apicarbon.dto.users;

import com.carbon.apicarbon.models.Profile;

public class UserSaveDto {
    public String email;
    public String firstName;
    public String lastName;
    public String provider;
    public Profile profile;

    public UserSaveDto(){}

    public UserSaveDto(String email, String firstName, String lastName, String provider, Profile profile) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.provider = provider;
        this.profile = profile;
    }

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

}
