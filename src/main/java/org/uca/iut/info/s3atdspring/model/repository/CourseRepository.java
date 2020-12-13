package org.uca.iut.info.s3atdspring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uca.iut.info.s3atdspring.model.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {

    public CourseEntity findByName(String name);

}
