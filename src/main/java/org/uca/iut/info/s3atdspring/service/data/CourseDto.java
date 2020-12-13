package org.uca.iut.info.s3atdspring.service.data;

import org.uca.iut.info.s3atdspring.model.entity.CourseEntity;

public class CourseDto {

    private String code, name, supervisor;

    private int coeff;

    public static CourseDto fromEntity(CourseEntity entity) {

        if (entity == null)
            return new CourseDto();

        final CourseDto dto = new CourseDto();

        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setSupervisor(entity.getSupervisor());
        dto.setCoeff(entity.getCoeff());

        return dto;

    }
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
     * @param pSupervisor The supervisor to set.
     */
    public void setSupervisor(String pSupervisor) {
        supervisor = pSupervisor;
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
