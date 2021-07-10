package com.carbon.apicarbon.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.carbon.apicarbon.dto.classes.ClassesDto;
import com.carbon.apicarbon.repositories.ItemRepository;
import com.carbon.apicarbon.services.ClassesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ClassesController {

    @Autowired
    ClassesService classesService;

    @GetMapping("/classes") 
    public ResponseEntity<List<ClassesDto>> getClasses(@AuthenticationPrincipal OAuth2User principal) {
        return ResponseEntity.ok().body(this.classesService.getClasses());  
    }
    
    @PutMapping("/classes/{classeName}")
    public ResponseEntity<?> joinClasse(@AuthenticationPrincipal OAuth2User principal, @PathVariable String classeName){
        if ( this.classesService.joinClasse(principal.getAttribute("email"), classeName) ) {
            Map<String, String> resp = new HashMap<String, String>();
            resp.put("message", "Join classe " + classeName + " with success");
            return ResponseEntity.ok().body(resp);
        } else {
            return ResponseEntity.badRequest().body("Error while trying to join classe");
        }
    }
}
