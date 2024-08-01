package com.userAuthentication.api.controller.user;

import com.userAuthentication.api.model.entities.user.User;
import com.userAuthentication.api.model.request.UserRequestCreate;
import com.userAuthentication.api.service.user.IUserService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class UserController {

    private final IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequestCreate user) throws SystemException {

        User response = userService.addUser(user);
        ResponseEntity responseEntity = new ResponseEntity<>(response, HttpStatus.CREATED);
        return responseEntity;
    }

}
