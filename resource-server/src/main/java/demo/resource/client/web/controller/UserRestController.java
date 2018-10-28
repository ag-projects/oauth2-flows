package demo.resource.client.web.controller;

import demo.resource.client.persistence.UserRepository;
import demo.resource.client.service.UserService;
import demo.resource.client.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @RequestMapping("{id}")
    public User view(@PathVariable("id") User user) {
        return user;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid User user) throws Exception {
        return userService.registerNewUser(user);
    }

    @RequestMapping(value = "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) throws Exception {
        userRepository.deleteById(id);
    }

}
