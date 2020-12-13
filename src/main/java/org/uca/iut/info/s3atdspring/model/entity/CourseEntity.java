package org.uca.iut.info.s3atdspring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class CourseEntity {

    @Id
    @Column(length = 5)
    private String code;

    @Column(unique = true, nullable = false)
    private String name;

    private String supervisor;

    @Column(name = "coefficient")
    private int coeff;

    /**
     * Get the code.
     *
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the code.
     *
     * @param pCode The code to set.
     */
    public void setCode(String pCode) {
        code = pCode;
    }

    /**
     * Get the name.
     *
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     *
     * @param pName The name to set.
     */
    public void setName(String pName) {
        name = pName;
    }

    /**
     * Get the supervisor.
     *
     * @return Returns the supervisor.
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * Set the supervisor.
     *
     * @param pSuperviseur The supervisor to set.
     */
    public void setSupervisor(String pSuperviseur) {
        supervisor = pSuperviseur;
    }


    /**
     * Get the coeff.
     *
     * @return Returns the coeff.
     */
    public int getCoeff() {
        return coeff;
    }


    /**
     * Set the coeff.
     *
     * @param pCoeff The coeff to set.
     */
    public void setCoeff(int pCoeff) {
        coeff = pCoeff;
    }

}
