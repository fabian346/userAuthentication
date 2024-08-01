package com.userAuthentication.api.service.user;

import com.userAuthentication.api.model.entities.user.User;
import com.userAuthentication.api.model.request.UserRequestCreate;
import jakarta.transaction.SystemException;

import java.util.Optional;

public interface IUserService {

    User addUser(UserRequestCreate user) throws SystemException;
}
