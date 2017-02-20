package org.openmrs.module.ugandaemrsync.initialsync;

import java.util.Date;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class EncounterRole {

    private int id;
    private String name;
    private String description;
    private String creator;
    private Date date_created;
    private String changed_by;
    private Date date_changed;
    private boolean retired;
    private String retired_by;
    private Date date_retired;
    private String retire_reason;
    private String uuid;
    private String facility;
    private String state;

    public EncounterRole(int id, String name, String description, String creator, Date date_created, String changed_by, Date date_changed, boolean retired, String retired_by, Date date_retired, String retire_reason, String uuid, String facility, String state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creator = creator;
        this.date_created = date_created;
        this.changed_by = changed_by;
        this.date_changed = date_changed;
        this.retired = retired;
        this.retired_by = retired_by;
        this.date_retired = date_retired;
        this.retire_reason = retire_reason;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public String getRetired_by() {
        return retired_by;
    }

    public void setRetired_by(String retired_by) {
        this.retired_by = retired_by;
    }

    public Date getDate_retired() {
        return date_retired;
    }

    public void setDate_retired(Date date_retired) {
        this.date_retired = date_retired;
    }

    public String getRetire_reason() {
        return retire_reason;
    }

    public void setRetire_reason(String retire_reason) {
        this.retire_reason = retire_reason;
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
