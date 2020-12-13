package org.uca.iut.info.s3atdspring.service;

import java.util.List;

import org.uca.iut.info.s3atdspring.service.data.CourseDto;

public interface CourseService {

    public List<CourseDto> getAllCourses();

    public CourseDto getCourseByCode(String courseCode);

    public CourseDto getCourseByName(String name);

    public CourseDto createCourse(CourseDto input);

    public void deleteCourse(String courseCode);

    public CourseDto updateCourse(String code, CourseDto input);

}
