package org.uca.iut.info.s3atdspring.service.users.data;


public class UserData {

    private Long id;

    private String firstname;

    private String lastname;


    public UserData() {
        super();
    }

    public UserData(Long pId, String pFirstname, String pLastname) {
        super();
        id = pId;
        firstname = pFirstname;
        lastname = pLastname;
    }

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

}
