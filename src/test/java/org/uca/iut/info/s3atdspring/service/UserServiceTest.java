package org.uca.iut.info.s3atdspring.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.uca.iut.info.s3atdspring.model.entity.UserEntity;
import org.uca.iut.info.s3atdspring.model.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        // tests setup @BeforeEach == before each test case

        final UserEntity user1 = new UserEntity();
        user1.setId(1L);
        user1.setFirstname("tests");
        user1.setLastname("toto");

        final List<UserEntity> list = new ArrayList<UserEntity>();

        list.add(user1);

        when(userRepository.findAll()).thenReturn(list);
    }


    @Test
    void mockServiceReturnsOneUser() {
        assertEquals(1, userService.getUsers().size());
    }

}
