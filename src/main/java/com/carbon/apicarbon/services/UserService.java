package com.carbon.apicarbon.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.carbon.apicarbon.dto.users.UserSaveDto;
import com.carbon.apicarbon.models.Profile;
import com.carbon.apicarbon.models.Users;
import com.carbon.apicarbon.repositories.ProfileRepository;
import com.carbon.apicarbon.repositories.UserRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    final static Logger logger = LoggerFactory.getLogger(UserService.class);

    UserRepository userRepository;
    ProfileRepository profileRepository;

    ModelMapper modelMapper = new ModelMapper();


    public UserService(UserRepository userRepository, ProfileRepository profileRepository){
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }
    
    @Transactional(rollbackOn = Exception.class) 
    public Users saveOrUpdate(UserSaveDto userSaveDto) {
        
        if ( this.userRepository.findByEmail(userSaveDto.getEmail()).isPresent() ) {
            // DO nothing
            UserService.logger.info("User with same email already exists ( IGNORE CREATE ) ");
            return null;
        } else {
            Profile newProfile = new Profile();
            newProfile.setCarbong((long) 0);
            newProfile.setLevel((long) 0);
            userSaveDto.setProfile(newProfile);
            
            Users newUser = this.modelMapper.map(userSaveDto, Users.class);
            this.userRepository.save(newUser);
            UserService.logger.info("New user created");
            return newUser;
        }
        

    }
    
}
