package org.uca.iut.info.s3atdspring.service.data;


public class EnrolmentRequest {

    private Long userId;

    private String courseCode;

    /**
     * Get the userId.
     * 
     * @return Returns the userId.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Set the userId.
     * 
     * @param pUserId The userId to set.
     */
    public void setUserId(Long pUserId) {
        userId = pUserId;
    }

    /**
     * Get the courseCode.
     * 
     * @return Returns the courseCode.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Set the courseCode.
     * 
     * @param pCourseCode The courseCode to set.
     */
    public void setCourseCode(String pCourseCode) {
        courseCode = pCourseCode;
    }
}
