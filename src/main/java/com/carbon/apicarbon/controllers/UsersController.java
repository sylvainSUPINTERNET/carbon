package com.carbon.apicarbon.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("users")
public class UsersController {
    
    /**
     * http://localhost:9999/users/me?details=profile,inventory
     * @param principal
     * @param details profile,inventory
     * @return
     */
    @GetMapping("/me") 
    public ResponseEntity<?> test2(@AuthenticationPrincipal OAuth2User principal, @RequestParam(required=false) Optional<List<String>> details) {
        Map<String, Object> resp = new HashMap<>();

        if ( details.isPresent() ) {
            resp.put("userInfos", principal.getAttributes());
            resp.put("userDetailsExpected", details.get());
            return ResponseEntity.ok().body(resp);
        } else {
            resp.put("userInfos", principal.getAttributes());
            return ResponseEntity.ok().body(resp);
        }


      
    }



}
