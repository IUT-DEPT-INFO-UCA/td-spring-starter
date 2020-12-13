package org.uca.iut.info.s3atdspring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.uca.iut.info.s3atdspring.model.entity.UserEntity;
import org.uca.iut.info.s3atdspring.service.UserService;
import org.uca.iut.info.s3atdspring.service.data.UserDto;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(params = { "lastname", "firstname" })
    List<UserEntity> getUsersByLastNameAndFirstName(@RequestParam(value = "lastname", required = true) String lastname,
            @RequestParam(value = "firstname", required = true) String firstname) {
        return userService.getUsersByLastNameAndFirstName(lastname, firstname);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserDto request) {

        return userService.createUser(request);
    }

    @PutMapping("/{id}")
    public boolean updateUser(@RequestBody UserDto request, @PathVariable Long id) {

        return userService.updateUser(id, request);
    }
}
