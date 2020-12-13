package org.uca.iut.info.s3atdspring.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uca.iut.info.s3atdspring.model.entity.CourseEntity;
import org.uca.iut.info.s3atdspring.model.entity.EnrolmentEntity;
import org.uca.iut.info.s3atdspring.model.entity.UserEntity;
import org.uca.iut.info.s3atdspring.model.repository.CourseRepository;
import org.uca.iut.info.s3atdspring.model.repository.EnrolmentRepository;
import org.uca.iut.info.s3atdspring.model.repository.UserRepository;
import org.uca.iut.info.s3atdspring.service.EnrolmentService;
import org.uca.iut.info.s3atdspring.service.data.EnrolmentRequest;
import org.uca.iut.info.s3atdspring.service.data.EnrolmentResponse;

@Service
public class EnrolmentServiceImpl implements EnrolmentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrolmentRepository enrolRepository;

    @Transactional
    public EnrolmentResponse enroll(EnrolmentRequest pRequest) {

        if (pRequest == null || pRequest.getUserId() == null || pRequest.getCourseCode() == null
                || pRequest.getCourseCode().isEmpty()) {

            throw new IllegalArgumentException("missing params");
        }

        final Optional<UserEntity> user = userRepository.findById(pRequest.getUserId());

        if (!user.isPresent()) {
            throw new IllegalArgumentException("user not found");
        }

        final Optional<CourseEntity> course = courseRepository.findById(pRequest.getCourseCode());

        if (!course.isPresent()) {
            throw new IllegalArgumentException("course not found");
        }

        EnrolmentEntity enrolment = new EnrolmentEntity();

        enrolment.setUser(user.get());
        enrolment.setCourse(course.get());

        enrolment.setEnrolmentDate(LocalDate.now());

        enrolment = enrolRepository.save(enrolment);

        final EnrolmentResponse response = new EnrolmentResponse();
        response.setResult(enrolment.getId() != null ? true : false);

        return response;
    }

}
