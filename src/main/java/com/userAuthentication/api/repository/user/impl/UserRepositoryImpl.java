package com.userAuthentication.api.repository.user.impl;

import com.userAuthentication.api.model.entities.user.User;
import com.userAuthentication.api.repository.user.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryImpl implements IUserRepoImpl{

    private final IUserRepository iUserRepository;

    public UserRepositoryImpl(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public Optional<User> saveUser(User user) {
        return Optional.of(iUserRepository.save(user));
    }

    @Override
    public List<User> findAllUsers() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = iUserRepository.findUserByEmail(email);
        return user;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        Optional<User> user = iUserRepository.findUserByUsername(username);
        return user;
    }
}
