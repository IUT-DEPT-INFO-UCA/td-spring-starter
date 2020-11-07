package org.uca.iut.info.s3atdspring.service;

import java.util.List;

import org.uca.iut.info.s3atdspring.model.entity.UserEntity;

public interface UserService {

    public List<UserEntity> getUsers();
}
