package org.openmrs.module.ugandaemrsync.InitalSync;

import java.util.Date;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class Person {

    private int id;
    private String gender;
    private Date birthdate;
    private boolean birthdate_estimated;
    private boolean dead;
    private Date death_date;
    private String cause_of_death;
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
    private boolean deathdate_estimated;
    private Date birthtime;


    public Person(int id, String gender, Date birthdate, boolean birthdate_estimated, boolean dead, Date death_date, String cause_of_death, String creator, Date date_created, String changed_by, Date date_changed, boolean voided, String voided_by, Date date_voided, String void_reason, String uuid, String facility, String state, boolean deathdate_estimated, Date birthtime) {
        this.id = id;
        this.gender = gender;
        this.birthdate = birthdate;
        this.birthdate_estimated = birthdate_estimated;
        this.dead = dead;
        this.death_date = death_date;
        this.cause_of_death = cause_of_death;
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
        this.deathdate_estimated = deathdate_estimated;
        this.birthtime = birthtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isBirthdate_estimated() {
        return birthdate_estimated;
    }

    public void setBirthdate_estimated(boolean birthdate_estimated) {
        this.birthdate_estimated = birthdate_estimated;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Date getDeath_date() {
        return death_date;
    }

    public void setDeath_date(Date death_date) {
        this.death_date = death_date;
    }

    public String getCause_of_death() {
        return cause_of_death;
    }

    public void setCause_of_death(String cause_of_death) {
        this.cause_of_death = cause_of_death;
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

    public boolean isDeathdate_estimated() {
        return deathdate_estimated;
    }

    public void setDeathdate_estimated(boolean deathdate_estimated) {
        this.deathdate_estimated = deathdate_estimated;
    }

    public Date getBirthtime() {
        return birthtime;
    }

    public void setBirthtime(Date birthtime) {
        this.birthtime = birthtime;
    }
}
