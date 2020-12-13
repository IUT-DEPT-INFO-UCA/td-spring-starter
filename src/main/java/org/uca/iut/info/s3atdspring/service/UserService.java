package org.uca.iut.info.s3atdspring.service;

import java.util.List;

import org.uca.iut.info.s3atdspring.model.entity.UserEntity;
import org.uca.iut.info.s3atdspring.service.data.UserDto;

public interface UserService {

    public List<UserEntity> getUsers();

    public UserEntity getUserById(Long userId);

    public List<UserEntity> getUsersByLastNameAndFirstName(String lastName, String firstName);

    public UserEntity createUser(UserDto userDto);

    public boolean updateUser(Long userId, UserDto userDto);

    public void deleteUser(Long userId);
}
