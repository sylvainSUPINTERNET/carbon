package com.carbon.apicarbon.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.carbon.apicarbon.dto.classes.ClassesDto;
import com.carbon.apicarbon.staticEnum.ClassEnum;

import org.springframework.stereotype.Service;

@Service
public class ClassesService {

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

    public List<ClassesDto> getClasses() {
        List<ClassesDto> resp = new ArrayList<ClassesDto>();
        Stream.of(ClassEnum.values()).forEach( valueEnum -> {
            ClassesDto newClasse = new ClassesDto(valueEnum.name(), this.getDescriptionForClass(valueEnum.name()));
             resp.add(newClasse);
        });
        return resp;
    }
    
}
