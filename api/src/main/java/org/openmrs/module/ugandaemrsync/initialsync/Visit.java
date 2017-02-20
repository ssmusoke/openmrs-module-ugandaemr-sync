package org.openmrs.module.ugandaemrsync.initialsync;

import java.util.Date;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class Visit {

    private int id;
    private String patient;
    private String visit_type;
    private Date start_datetime;
    private Date stop_datetime;
    private String indication_concept;
    private String location;
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

    public Visit(int id, String patient, String visit_type, Date start_datetime, Date stop_datetime, String indication_concept, String location, String creator, Date date_created, String changed_by, Date date_changed, boolean voided, String voided_by, Date date_voided, String void_reason, String uuid, String facility, String state) {
        this.id = id;
        this.patient = patient;
        this.visit_type = visit_type;
        this.start_datetime = start_datetime;
        this.stop_datetime = stop_datetime;
        this.indication_concept = indication_concept;
        this.location = location;
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

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getVisit_type() {
        return visit_type;
    }

    public void setVisit_type(String visit_type) {
        this.visit_type = visit_type;
    }

    public Date getStart_datetime() {
        return start_datetime;
    }

    public void setStart_datetime(Date start_datetime) {
        this.start_datetime = start_datetime;
    }

    public Date getStop_datetime() {
        return stop_datetime;
    }

    public void setStop_datetime(Date stop_datetime) {
        this.stop_datetime = stop_datetime;
    }

    public String getIndication_concept() {
        return indication_concept;
    }

    public void setIndication_concept(String indication_concept) {
        this.indication_concept = indication_concept;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
