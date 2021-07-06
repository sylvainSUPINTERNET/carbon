package com.carbon.apicarbon.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import com.carbon.apicarbon.dto.classes.ClassesDto;
import com.carbon.apicarbon.models.Item;
import com.carbon.apicarbon.models.Users;
import com.carbon.apicarbon.repositories.ItemRepository;
import com.carbon.apicarbon.repositories.UserRepository;
import com.carbon.apicarbon.staticEnum.ClassEnum;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepostRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ClassesService() {}

    public String getDescriptionForClass(String classeName) {
        if ( classeName.equals(ClassEnum.Guerrier.name()) ) {
            return "Remember: Life is nothing without valor";
        } else if ( classeName.equals(ClassEnum.Mage.name()) ) {
            return "No matter how learned and knowledgeable, how wise and how wonderful, how powerful and puissant, there is always one more sliver of power, one more bit of knowledge, one more secret to be learned by any mage.";
        } else if (classeName.equals(ClassEnum.Moine.name())) {
            return "... why do we fight? I trust you have learned: to fight out of fear or anger is to fight a war that never ends. Face your fears. Calm your hatreds. Find peace within yourself, so that you may share it with the world around you. These are the greatest treasures in life. Surely they... are worth fighting for.";
        } else {
            return "No description for " + classeName;
        }
    }

    public Item getClasseItem(String classeName) {
        if ( classeName.equals(ClassEnum.Guerrier.name()) ) {
            return this.itemRepository.findByName("Lames de forceur").get(0);
        } else if ( classeName.equals(ClassEnum.Mage.name()) ) {
            return this.itemRepository.findByName("Le bob gucci").get(0);
        } else {
            return this.itemRepository.findByName("Le calepin").get(0);
        }
    }


    public List<ClassesDto> getClasses() {
        List<ClassesDto> resp = new ArrayList<ClassesDto>();
        Stream.of(ClassEnum.values()).forEach( valueEnum -> {
            Item itemClass = this.getClasseItem(valueEnum.name());

            List<Item> itemClassList = new ArrayList<>();
            itemClassList.add(itemClass);

            ClassesDto newClasse = new ClassesDto(valueEnum.name(), this.getDescriptionForClass(valueEnum.name()), itemClassList);
            resp.add(newClasse);
        });
        return resp;
    }
    
    @Transactional(rollbackOn = Exception.class) 
    public boolean joinClasse(String userEmail, String classeName) {
        Optional<Users> userOptional = this.userRepostRepository.findByEmail(userEmail);
    
        if ( !classeName.equals(ClassEnum.Guerrier.name()) && !classeName.equals(ClassEnum.Mage.name()) && !classeName.equals(ClassEnum.Moine.name()) ) {
            return false;
        }
        
        if ( userOptional.isPresent() ) {
            userOptional.get().getProfile().setClasse(classeName);
            this.userRepostRepository.save(userOptional.get());
            return true;
        } else {
            return false;
        }
    }
    
}
