package demo.authoriztion.server.service;

import demo.authoriztion.server.web.model.User;

public interface UserService {

    User registerNewUser(User user) throws Exception;
}
