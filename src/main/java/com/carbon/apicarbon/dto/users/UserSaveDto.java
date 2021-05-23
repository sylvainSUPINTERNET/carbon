package com.carbon.apicarbon.dto.users;

public class UserSaveDto {
    public String email;
    public String firstName;
    public String lastName;
    public String provider;

    public UserSaveDto(){}

    public UserSaveDto(String email, String firstName, String lastName, String provider) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.provider = provider;
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
