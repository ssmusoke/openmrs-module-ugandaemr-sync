package org.openmrs.module.ugandaemrsync.InitalSync;

import java.util.Date;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class EncounterProvider {

    private int id;
    private String encounter;
    private String provider;
    private String encounter_role;
    private String creator;
    private Date date_created;
    private String changed_by;
    private Date date_changed;
    private boolean voided;
    private String date_voided;
    private String voided_by;
    private String void_reason;
    private String uuid;
    private String facility;
    private String state;


    public EncounterProvider(int id, String encounter, String provider, String encounter_role, String creator, Date date_created, String changed_by, Date date_changed, boolean voided, String date_voided, String voided_by, String void_reason, String uuid, String facility, String state) {
        this.id = id;
        this.encounter = encounter;
        this.provider = provider;
        this.encounter_role = encounter_role;
        this.creator = creator;
        this.date_created = date_created;
        this.changed_by = changed_by;
        this.date_changed = date_changed;
        this.voided = voided;
        this.date_voided = date_voided;
        this.voided_by = voided_by;
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

    public String getEncounter() {
        return encounter;
    }

    public void setEncounter(String encounter) {
        this.encounter = encounter;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getEncounter_role() {
        return encounter_role;
    }

    public void setEncounter_role(String encounter_role) {
        this.encounter_role = encounter_role;
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

    public String getDate_voided() {
        return date_voided;
    }

    public void setDate_voided(String date_voided) {
        this.date_voided = date_voided;
    }

    public String getVoided_by() {
        return voided_by;
    }

    public void setVoided_by(String voided_by) {
        this.voided_by = voided_by;
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
