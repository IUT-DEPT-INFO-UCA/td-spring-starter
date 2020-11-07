package org.uca.iut.info.s3atdspring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uca.iut.info.s3atdspring.model.entity.UserEntity;
import org.uca.iut.info.s3atdspring.model.repository.UserRepository;
import org.uca.iut.info.s3atdspring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUsers() {


        return userRepository.findAll();
    }
}