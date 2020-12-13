package org.uca.iut.info.s3atdspring.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.uca.iut.info.s3atdspring.model.entity.CourseEntity;
import org.uca.iut.info.s3atdspring.model.entity.EnrolmentEntity;
import org.uca.iut.info.s3atdspring.model.entity.UserEntity;

public interface EnrolmentRepository extends JpaRepository<EnrolmentEntity, Long> {

    List<EnrolmentEntity> findByUser(UserEntity user);

    List<EnrolmentEntity> findByCourse(CourseEntity course);

    @Query("select e.user from EnrolmentEntity e where e.course.code = :courseCode")
    public List<UserEntity> findAllUsersByCourse(@Param("courseCode") String courseCode);
}
