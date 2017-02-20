package org.openmrs.module.ugandaemrsync.InitalSync;

import java.util.Date;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class PersonName {

    private String id;
    private boolean preferred;
    private String person;
    private String prefix;
    private String given_name;
    private String middle_name;
    private String family_name_prefix;
    private String family_name;
    private String family_name2;
    private String family_name_suffix;
    private String degree;
    private String creator;
    private Date date_created;
    private boolean voided;
    private String voided_by;
    private Date date_voided;
    private String void_reason;
    private String changed_by;
    private Date date_changed;
    private String uuid;
    private String facility;
    private String state;

    public PersonName(String id, boolean preferred, String person, String prefix, String given_name, String middle_name, String family_name_prefix, String family_name, String family_name2, String family_name_suffix, String degree, String creator, Date date_created, boolean voided, String voided_by, Date date_voided, String void_reason, String changed_by, Date date_changed, String uuid, String facility, String state) {
        this.id = id;
        this.preferred = preferred;
        this.person = person;
        this.prefix = prefix;
        this.given_name = given_name;
        this.middle_name = middle_name;
        this.family_name_prefix = family_name_prefix;
        this.family_name = family_name;
        this.family_name2 = family_name2;
        this.family_name_suffix = family_name_suffix;
        this.degree = degree;
        this.creator = creator;
        this.date_created = date_created;
        this.voided = voided;
        this.voided_by = voided_by;
        this.date_voided = date_voided;
        this.void_reason = void_reason;
        this.changed_by = changed_by;
        this.date_changed = date_changed;
        this.uuid = uuid;
        this.facility = facility;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getFamily_name_prefix() {
        return family_name_prefix;
    }

    public void setFamily_name_prefix(String family_name_prefix) {
        this.family_name_prefix = family_name_prefix;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getFamily_name2() {
        return family_name2;
    }

    public void setFamily_name2(String family_name2) {
        this.family_name2 = family_name2;
    }

    public String getFamily_name_suffix() {
        return family_name_suffix;
    }

    public void setFamily_name_suffix(String family_name_suffix) {
        this.family_name_suffix = family_name_suffix;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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
