package com.agharibi.client.web.controller;

import com.agharibi.client.web.model.User;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class MainController {

    public static final String USERS_URL = "http://localhost:8081/um-webapp-resource-server/api/users";

    private OAuth2RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list() {
        List<User> users = restTemplate.getForObject(USERS_URL, List.class);
        return new ModelAndView("list", "users", users);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(User user) {
        MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
        param.add("email", user.getEmail());
        param.add("password", user.getPassword());
        User created = restTemplate.postForObject(USERS_URL, param, User.class);
        System.out.println(created);
        return "redirect:/user";
    }

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(@ModelAttribute User user) {
        return "form";
    }
}
