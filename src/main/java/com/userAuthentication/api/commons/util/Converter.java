package com.userAuthentication.api.commons.util;

import com.userAuthentication.api.model.entities.user.User;
import com.userAuthentication.api.model.request.UserRequestCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    @Autowired
    private PasswordEncrypt passwordEncrypt;

    public User userResquestOfUser(UserRequestCreate userRequestCreate) {

        return User.builder()
                .username(userRequestCreate.getUsername())
                .password(passwordEncrypt.encodePassword(userRequestCreate.getPassword()))
                .email(userRequestCreate.getEmail())
                .firstName(userRequestCreate.getFirstName())
                .lastName(userRequestCreate.getLastName())
                .build();
    }
}
