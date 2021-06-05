package com.carbon.apicarbon.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import static com.carbon.apicarbon.constants.DefaultSettingsInventory.INIT_INVENTORY_MAX_STACK;

import com.carbon.apicarbon.dto.inventories.InventoryDTO;
import com.carbon.apicarbon.dto.item.ItemDto;
import com.carbon.apicarbon.dto.users.UserFullProfileDto;
import com.carbon.apicarbon.dto.users.UserSaveDto;
import com.carbon.apicarbon.models.Inventory;
import com.carbon.apicarbon.models.Item;
import com.carbon.apicarbon.models.Profile;
import com.carbon.apicarbon.models.Users;
import com.carbon.apicarbon.repositories.InventoryRepository;
import com.carbon.apicarbon.repositories.ItemRepository;
import com.carbon.apicarbon.repositories.ProfileRepository;
import com.carbon.apicarbon.repositories.UserRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserService {

    final static Logger logger = LoggerFactory.getLogger(UserService.class);

    UserRepository userRepository;
    ProfileRepository profileRepository;
    ItemRepository itemRepository;
    InventoryRepository inventoryRepository;

    ModelMapper modelMapper = new ModelMapper();


    public UserService(UserRepository userRepository, ProfileRepository profileRepository, ItemRepository itemRepository, InventoryRepository inventoryRepository){
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.itemRepository = itemRepository;
        this.inventoryRepository = inventoryRepository;
    }
    
    @Transactional(rollbackOn = Exception.class) 
    public Users saveOrUpdate(UserSaveDto userSaveDto) {
        
        if ( this.userRepository.findByEmail(userSaveDto.getEmail()).isPresent() ) {
            // DO nothing
            UserService.logger.info("User with same email already exists ( IGNORE CREATE ) ");
            return null;
        } else {

            // Init user / his profile / inventory 
            Profile newProfile = new Profile();
            newProfile.setCarbong((long) 15);
            newProfile.setLevel((long) 1);
            userSaveDto.setProfile(newProfile);


            List<Item> items = this.itemRepository.findByName("Pierre de foyer");
            
            Inventory newInventory = new Inventory(INIT_INVENTORY_MAX_STACK, items);
            this.inventoryRepository.save(newInventory);
            newProfile.setInventory(newInventory);

            Users newUser = this.modelMapper.map(userSaveDto, Users.class);
            this.userRepository.save(newUser);

            newProfile.setUser(newUser);

            this.profileRepository.save(newProfile);

            UserService.logger.info("New user created");
            return newUser;
        }
    }

    public Users getUserFromPrincipal(OAuth2User principal) {
        Optional<Users> optionalUser = this.userRepository.findByEmail(principal.getAttribute("email"));

        if ( optionalUser.isPresent() ) {
            return optionalUser.get();
        } 

        return null;   
    }

    @Transactional
    public UserFullProfileDto testUser(){
        Users user = this.userRepository.findByEmail("test@test.com").get();

        //user.getProfile().getInventory().getItems().get(0).getItemTypes().stream().forEach(type -> System.out.println(type.getName()));
        UserFullProfileDto d = this.modelMapper.map(user, UserFullProfileDto.class);
        
        
        InventoryDTO idto = this.modelMapper.map(user.getProfile().getInventory(), InventoryDTO.class);
        //InventoryDTO idto = this.modelMapper.map(user.getProfile().getInventory().getItems().get(0).getEf, InventoryDTO.class);

        d.setInventory(idto);

        // TODO create DTO 
        // Pour affichage inventaire 
        // Pour affichage items dans l'inventaire
        return d;
    }
    
    
}
