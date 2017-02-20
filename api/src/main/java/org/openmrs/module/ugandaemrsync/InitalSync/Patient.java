package org.openmrs.module.ugandaemrsync.InitalSync;

import java.util.Date;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class Patient {

    private int patient_id;
    private String creator;
    private Date date_created;
    private String changed_by;
    private Date date_changed;
    private boolean voided;
    private String voided_by;
    private Date date_voided;
    private String void_reason;
    private String allergy_status;

    public Patient(int patient_id, String creator, Date date_created, String changed_by, Date date_changed, boolean voided, String voided_by, Date date_voided, String void_reason, String allergy_status) {
        this.patient_id = patient_id;
        this.creator = creator;
        this.date_created = date_created;
        this.changed_by = changed_by;
        this.date_changed = date_changed;
        this.voided = voided;
        this.voided_by = voided_by;
        this.date_voided = date_voided;
        this.void_reason = void_reason;
        this.allergy_status = allergy_status;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
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

    public String getAllergy_status() {
        return allergy_status;
    }

    public void setAllergy_status(String allergy_status) {
        this.allergy_status = allergy_status;
    }
}
