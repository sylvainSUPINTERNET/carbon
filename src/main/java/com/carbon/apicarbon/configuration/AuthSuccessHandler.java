package com.carbon.apicarbon.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carbon.apicarbon.configuration.constants.OAuth2Provider;
import com.carbon.apicarbon.dto.users.UserSaveDto;
import com.carbon.apicarbon.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

// https://www.javadevjournal.com/spring/spring-security-success-handler/

@Component
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler  {

    @Autowired
    UserService userService;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
     
        String targetUrl = super.determineTargetUrl(request, response);

        
        UserSaveDto userDto = createOrUpdateUser(this.getProviderName(request.getRequestURI()), authentication);

        this.userService.saveOrUpdate(userDto);

        // TODO if error => invalidate session
        // TODO if error request is redirect to /error => create controller for this one

        redirectStrategy.sendRedirect(request, response, targetUrl);

        /* TODO => get access token for furthr usage (api provider)
        SecurityContext securityContext = SecurityContextHolder.getContext();
            OAuth2AuthenticationToken oauth2Token = (OAuth2AuthenticationToken) 
        securityContext.getAuthentication();

        OAuth2AuthorizedClient client = clientService
                    .loadAuthorizedClient(oauth2Token.getAuthorizedClientRegistrationId(), 
        oauth2Token.getName());

        refreshToken = client.getRefreshToken().getTokenValue();
        */
    }

    public String getProviderName (String requestUri) {
        String[] splitted = requestUri.split("/");
        return splitted[splitted.length - 1];
    }

    public UserSaveDto createOrUpdateUser(String provider, Authentication authentication) {
        UserSaveDto userSaveDto = new UserSaveDto();

        if ( provider.equals(OAuth2Provider.OAUTH2_GOOGLE_PROVIDER) ) {            
            userSaveDto.setEmail((String)((OAuth2User) authentication.getPrincipal()).getAttributes().get("email"));
            userSaveDto.setFirstName((String)((OAuth2User) authentication.getPrincipal()).getAttributes().get("given_name"));
            userSaveDto.setLastName((String)((OAuth2User) authentication.getPrincipal()).getAttributes().get("family_name"));
            userSaveDto.setProvider(OAuth2Provider.OAUTH2_GOOGLE_PROVIDER);
        }

        return userSaveDto;
  
    }

}



/*

*/