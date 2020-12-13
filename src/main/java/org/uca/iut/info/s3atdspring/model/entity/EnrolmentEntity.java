package org.uca.iut.info.s3atdspring.model.entity;

import static javax.persistence.GenerationType.AUTO;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "enrolments")
@SequenceGenerator(name = "ENROLMENTS_SEQ", sequenceName = "ENROLMENTS_SEQ")
public class EnrolmentEntity {

    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GeneratedValue(strategy = AUTO, generator = "ENROLMENTS_SEQ")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "COURSE_CODE", nullable = false)
    private CourseEntity course;

    private LocalDate enrolmentDate;

    /**
     * Get the id.
     *
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the id.
     *
     * @param pId The id to set.
     */
    public void setId(Long pId) {
        id = pId;
    }

    /**
     * Get the user.
     *
     * @return Returns the user.
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * Set the user.
     *
     * @param pUser The user to set.
     */
    public void setUser(UserEntity pUser) {
        user = pUser;
    }

    /**
     * Get the course.
     *
     * @return Returns the course.
     */
    public CourseEntity getCourse() {
        return course;
    }

    /**
     * Set the course.
     *
     * @param pCourse The course to set.
     */
    public void setCourse(CourseEntity pCourse) {
        course = pCourse;
    }

    /**
     * Get the enrolmentDate.
     *
     * @return Returns the enrolmentDate.
     */
    public LocalDate getEnrolmentDate() {
        return enrolmentDate;
    }

    /**
     * Set the enrolmentDate.
     *
     * @param pEnrolmentDate The enrolmentDate to set.
     */
    public void setEnrolmentDate(LocalDate pEnrolmentDate) {
        enrolmentDate = pEnrolmentDate;
    }
}
