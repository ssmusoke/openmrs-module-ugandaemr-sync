package org.openmrs.module.ugandaemrsync.initialsync;

import java.util.Date;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class Encounter {
    private int id;
    private String encounter_type;
    private String patient;
    private String location;
    private String form;
    private Date encounter_datetime;
    private String creator;
    private Date date_created;
    private int voided;
    private String voided_by;
    private Date date_voided;
    private String void_reason;
    private String changed_by;
    private Date date_changed;
    private String visit;
    private String uuid;
    private String facility;
    private String state;

    public Encounter(int id, String encounter_type, String patient, String location, String form, Date encounter_datetime, String creator, Date date_created, int voided, String voided_by, Date date_voided, String void_reason, String changed_by, Date date_changed, String visit, String uuid, String facility, String state) {
        this.id = id;
        this.encounter_type = encounter_type;
        this.patient = patient;
        this.location = location;
        this.form = form;
        this.encounter_datetime = encounter_datetime;
        this.creator = creator;
        this.date_created = date_created;
        this.voided = voided;
        this.voided_by = voided_by;
        this.date_voided = date_voided;
        this.void_reason = void_reason;
        this.changed_by = changed_by;
        this.date_changed = date_changed;
        this.visit = visit;
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

    public String getEncounter_type() {
        return encounter_type;
    }

    public void setEncounter_type(String encounter_type) {
        this.encounter_type = encounter_type;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Date getEncounter_datetime() {
        return encounter_datetime;
    }

    public void setEncounter_datetime(Date encounter_datetime) {
        this.encounter_datetime = encounter_datetime;
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

    public int getVoided() {
        return voided;
    }

    public void setVoided(int voided) {
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

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
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
