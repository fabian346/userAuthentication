package com.userAuthentication.api.service.user.strategy;

import com.userAuthentication.api.repository.user.impl.IUserRepoImpl;
import jakarta.transaction.SystemException;
import org.springframework.stereotype.Component;

@Component
public class ValidateEmail implements IFieldValidation {

    private final IUserRepoImpl iUserRepo;

    public ValidateEmail(IUserRepoImpl iUserRepo) {
        this.iUserRepo = iUserRepo;
    }

    @Override
    public void validateField(String fieldValue) throws SystemException {
        if (iUserRepo.findUserByEmail(fieldValue).isPresent()) {
            throw new SystemException("Not possible create user, this email already exist!: " + fieldValue);
        }
    }
}
