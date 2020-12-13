package org.uca.iut.info.s3atdspring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uca.iut.info.s3atdspring.model.entity.CourseEntity;
import org.uca.iut.info.s3atdspring.model.repository.CourseRepository;
import org.uca.iut.info.s3atdspring.service.CourseService;
import org.uca.iut.info.s3atdspring.service.data.CourseDto;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseDto getCourseByCode(String courseCode) {

        // test param validity
        final Optional<CourseEntity> result = courseRepository.findById(courseCode);

        if (result.isPresent()) {
            return CourseDto.fromEntity(result.get());
        }

        return null;
    }

    public CourseDto getCourseByName(String name) {

        // test param validity
        final CourseEntity course = courseRepository.findByName(name);

        return CourseDto.fromEntity(course);
    }

    @Transactional
    public CourseDto createCourse(CourseDto input) {

        if (input == null)
            return null;

        // test param validity of mandatory params

        // create new cause the input should be a 'CourseDto'
        CourseEntity newCourse = new CourseEntity();

        newCourse.setCode(input.getCode());
        newCourse.setName(input.getName());
        newCourse.setSupervisor(input.getSupervisor());
        newCourse.setCoeff(input.getCoeff());

        newCourse = courseRepository.save(newCourse);

        return CourseDto.fromEntity(newCourse);
    }

    public List<CourseDto> getAllCourses() {

        final List<CourseDto> result = new ArrayList<CourseDto>();

        final List<CourseEntity> courses = courseRepository.findAll();

        for (final CourseEntity course : courses) {

            result.add(CourseDto.fromEntity(course));
        }

        return result;
    }

    public void deleteCourse(String courseCode) {

        if (courseCode == null || courseCode.isEmpty()) {

            throw new IllegalArgumentException("missing course code");
        }


        courseRepository.deleteById(courseCode);

    }

    public CourseDto updateCourse(String courseCode, CourseDto input) {

        final Optional<CourseEntity> toUpdate = courseRepository.findById(courseCode);

        if (!toUpdate.isPresent()) {

            return null;
        }

        CourseEntity toUpdateEntity = toUpdate.get();

        toUpdateEntity.setCode(input.getCode());
        toUpdateEntity.setName(input.getName());
        toUpdateEntity.setSupervisor(input.getSupervisor());
        toUpdateEntity.setCoeff(input.getCoeff());

        toUpdateEntity = courseRepository.save(toUpdateEntity);

        return CourseDto.fromEntity(toUpdateEntity);
    }

}
