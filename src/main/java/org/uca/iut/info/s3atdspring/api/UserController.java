package org.uca.iut.info.s3atdspring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uca.iut.info.s3atdspring.model.entity.UserEntity;
import org.uca.iut.info.s3atdspring.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // private final UserService userService;

    /*
     * public UserController(UserService userService) {
     * this.userService = userService;
     * }
     */

    @GetMapping
    List<UserEntity> getUsers() {
        return userService.getUsers();
    }
}
