package com.gharibi.clientcredentials.web.controller;

import com.gharibi.clientcredentials.persistence.UserRepository;
import com.gharibi.clientcredentials.service.UserService;
import com.gharibi.clientcredentials.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping
    @ResponseBody
    public List<User> list() {
        return userRepository.findAll();
    }

    @RequestMapping("{id}")
    @ResponseBody
    public User view(@PathVariable("id") User user) {
        return user;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid User user) throws Exception {
        return userService.registerNewUser(user);
    }

    @RequestMapping(value = "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }
}
