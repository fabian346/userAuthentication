package com.userAuthentication.api.service.user.strategy;

import jakarta.transaction.SystemException;

public interface IFieldValidation {

    void validateField(String fieldValue) throws SystemException;
}
