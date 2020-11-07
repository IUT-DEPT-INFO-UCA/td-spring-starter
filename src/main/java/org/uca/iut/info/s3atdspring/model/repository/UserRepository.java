package org.uca.iut.info.s3atdspring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uca.iut.info.s3atdspring.model.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
