package com.userAuthentication.api.repository.user.impl;

import com.userAuthentication.api.model.entities.user.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepoImpl {

    Optional<User> saveUser(User user);

    List<User> findAllUsers();

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUsername(String username);
}
