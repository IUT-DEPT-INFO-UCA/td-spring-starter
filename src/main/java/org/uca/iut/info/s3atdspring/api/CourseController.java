package org.uca.iut.info.s3atdspring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.uca.iut.info.s3atdspring.service.CourseService;
import org.uca.iut.info.s3atdspring.service.data.CourseDto;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    List<CourseDto> fetchAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{code}")
    CourseDto getCourseByCode(@PathVariable String code) {
        return courseService.getCourseByCode(code);
    }

    @GetMapping(params = "name")
    CourseDto getCourseByName(@RequestParam(value = "name", required = true) String name) {
        return courseService.getCourseByName(name);
    }

    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        courseService.deleteCourse(code);
    }

    @PostMapping
    public CourseDto createCourse(@RequestBody CourseDto courseInput) {

        return courseService.createCourse(courseInput);
    }

    @PutMapping("/{code}")
    public CourseDto updateCourse(@RequestBody CourseDto courseInput, @PathVariable String code) {

        return courseService.updateCourse(code, courseInput);
    }

}
