package com.userAuthentication.api.service.user.impl;

import com.userAuthentication.api.commons.util.Converter;
import com.userAuthentication.api.model.entities.user.User;
import com.userAuthentication.api.model.request.UserRequestCreate;
import com.userAuthentication.api.repository.user.impl.IUserRepoImpl;
import com.userAuthentication.api.service.user.IUserService;
import com.userAuthentication.api.service.user.strategy.IFieldValidation;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final IUserRepoImpl iUserRepo;
    private final IFieldValidation emailValidation;
    private final IFieldValidation usernameValidation;
    private final Converter converter;

    @Autowired
    public UserService(IUserRepoImpl iUserRepo, Converter converter,
                       @Qualifier("validateEmail") IFieldValidation iFieldValidation,
                       @Qualifier("validateUsername") IFieldValidation usernameValidation) {
        this.iUserRepo = iUserRepo;
        this.emailValidation = iFieldValidation;
        this.usernameValidation = usernameValidation;
        this.converter = converter;
    }

    @Override
    public User addUser(UserRequestCreate user) throws SystemException {

        emailValidation.validateField(user.getEmail());
        usernameValidation.validateField(user.getUsername());
        User userResponse = converter.userResquestOfUser(user);
        return iUserRepo.saveUser(userResponse).get();

    }
}
