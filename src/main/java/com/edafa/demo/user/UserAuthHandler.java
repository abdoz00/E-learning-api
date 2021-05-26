package com.edafa.demo.user;

import com.edafa.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class UserAuthHandler implements AuthenticationSuccessHandler {

    @Autowired
    ActiveUserStore activeUserStore;
    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        HttpSession session = httpServletRequest.getSession(false);
        if (session != null) {
            LoggedInUser user = new LoggedInUser(authentication.getName(), activeUserStore);
            session.setAttribute("user", user);
        }

        UserRequestHandler.setUserRequests(userService.generateMap());

        System.out.println(authentication.getName());
    }
}