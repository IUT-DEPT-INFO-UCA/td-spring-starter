package org.uca.iut.info.s3atdspring.model.entity;

import static javax.persistence.GenerationType.AUTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = AUTO, generator = "USER_SEQ")
    private Long id;

    private String firstname;

    private String lastname;


    @OneToMany(mappedBy = "user", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    private List<EnrolmentEntity> enrolments;

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
     * Get the firstname.
     *
     * @return Returns the firstname.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the firstname.
     *
     * @param pFirstname The firstname to set.
     */
    public void setFirstname(String pFirstname) {
        firstname = pFirstname;
    }

    /**
     * Get the lastname.
     *
     * @return Returns the lastname.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the lastname.
     *
     * @param pLastname The lastname to set.
     */
    public void setLastname(String pLastname) {
        lastname = pLastname;
    }

    /**
     * Get the enrolments.
     *
     * @return Returns the enrolments.
     */
    /*
     * public List<EnrolmentEntity> getEnrolments() {
     * return enrolments;
     * }
     */

    /**
     * Set the enrolments.
     *
     * @param pEnrolments The enrolments to set.
     */
    /*
     * public void setEnrolments(List<EnrolmentEntity> pEnrolments) {
     * enrolments = pEnrolments;
     * }
     */
}
