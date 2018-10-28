package demo.resource.client.service;

import demo.resource.client.web.model.User;

public interface UserService {

    User registerNewUser(User user) throws Exception;
}
