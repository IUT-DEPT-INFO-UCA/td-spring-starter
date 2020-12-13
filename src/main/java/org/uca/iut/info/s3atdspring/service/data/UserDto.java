package org.uca.iut.info.s3atdspring.service.data;


public class UserDto {

    private String lastname;

    private String firstname;

    /**
     * Get the lastname.
     * @return Returns the lastname.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the lastname.
     * @param pLastname The lastname to set.
     */
    public void setLastname(String pLastname) {
        lastname = pLastname;
    }

    /**
     * Get the firstname.
     * @return Returns the firstname.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the firstname.
     * @param pFirstname The firstname to set.
     */
    public void setFirstname(String pFirstname) {
        firstname = pFirstname;
    }


}
