package org.uca.iut.info.s3atdspring.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uca.iut.info.s3atdspring.model.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {


    List<UserEntity> findByLastname(String lastName);

    List<UserEntity> findByLastnameAndFirstname(String lastName, String firstName);
}
