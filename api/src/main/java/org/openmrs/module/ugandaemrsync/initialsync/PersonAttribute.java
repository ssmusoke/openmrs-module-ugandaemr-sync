package org.openmrs.module.ugandaemrsync.initialsync;

import java.util.Date;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class PersonAttribute {

    private int id;
    private String person;
    private String value;
    private String person_attribute_type;
    private String creator;
    private Date date_created;
    private String changed_by;
    private Date date_changed;
    private boolean voided;
    private String voided_by;
    private Date date_voided;
    private String void_reason;
    private String uuid;
    private String facility;
    private String state;

    public PersonAttribute(int id, String person, String value, String person_attribute_type, String creator, Date date_created, String changed_by, Date date_changed, boolean voided, String voided_by, Date date_voided, String void_reason, String uuid, String facility, String state) {
        this.id = id;
        this.person = person;
        this.value = value;
        this.person_attribute_type = person_attribute_type;
        this.creator = creator;
        this.date_created = date_created;
        this.changed_by = changed_by;
        this.date_changed = date_changed;
        this.voided = voided;
        this.voided_by = voided_by;
        this.date_voided = date_voided;
        this.void_reason = void_reason;
        this.uuid = uuid;
        this.facility = facility;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPerson_attribute_type() {
        return person_attribute_type;
    }

    public void setPerson_attribute_type(String person_attribute_type) {
        this.person_attribute_type = person_attribute_type;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public String getChanged_by() {
        return changed_by;
    }

    public void setChanged_by(String changed_by) {
        this.changed_by = changed_by;
    }

    public Date getDate_changed() {
        return date_changed;
    }

    public void setDate_changed(Date date_changed) {
        this.date_changed = date_changed;
    }

    public boolean isVoided() {
        return voided;
    }

    public void setVoided(boolean voided) {
        this.voided = voided;
    }

    public String getVoided_by() {
        return voided_by;
    }

    public void setVoided_by(String voided_by) {
        this.voided_by = voided_by;
    }

    public Date getDate_voided() {
        return date_voided;
    }

    public void setDate_voided(Date date_voided) {
        this.date_voided = date_voided;
    }

    public String getVoid_reason() {
        return void_reason;
    }

    public void setVoid_reason(String void_reason) {
        this.void_reason = void_reason;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
