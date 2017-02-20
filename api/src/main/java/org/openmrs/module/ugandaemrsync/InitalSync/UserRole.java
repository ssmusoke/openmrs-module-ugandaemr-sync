package org.openmrs.module.ugandaemrsync.InitalSync;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class UserRole {

    private String id;
    private String role;
    private String facility;
    private String state;

    public UserRole(String id, String role, String facility, String state) {
        this.id = id;
        this.role = role;
        this.facility = facility;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
