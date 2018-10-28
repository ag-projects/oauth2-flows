package com.gharibi.clientcredentials.service;

import com.gharibi.clientcredentials.web.model.User;

public interface UserService {

    User registerNewUser(User user) throws Exception;
}
