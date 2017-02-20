package org.openmrs.module.ugandaemrsync.InitalSync;

import java.util.Date;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class User {

    private int id;
    private String system;
    private String username;
    private String salt;
    private String secret_question;
    private String secret_answer;
    private String creator;
    private String date_created;
    private String changed_by;
    private Date date_changed;
    private String person;
    private boolean retired;
    private String retired_by;
    private Date date_retired;
    private String retire_reason;
    private String uuid;
    private String facility;
    private String state;

    public User(int id, String system, String username, String salt, String secret_question, String secret_answer, String creator, String date_created, String changed_by, Date date_changed, String person, boolean retired, String retired_by, Date date_retired, String retire_reason, String uuid, String facility, String state) {
        this.id = id;
        this.system = system;
        this.username = username;
        this.salt = salt;
        this.secret_question = secret_question;
        this.secret_answer = secret_answer;
        this.creator = creator;
        this.date_created = date_created;
        this.changed_by = changed_by;
        this.date_changed = date_changed;
        this.person = person;
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

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSecret_question() {
        return secret_question;
    }

    public void setSecret_question(String secret_question) {
        this.secret_question = secret_question;
    }

    public String getSecret_answer() {
        return secret_answer;
    }

    public void setSecret_answer(String secret_answer) {
        this.secret_answer = secret_answer;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
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

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
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
