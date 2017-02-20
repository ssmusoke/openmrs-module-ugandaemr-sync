package org.openmrs.module.ugandaemrsync.InitalSync;

import java.util.Date;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class Obs {

    private int id;
    private String person;
    private String concept;
    private String encounter;
    private String order;
    private Date obs_datetime;
    private String location;
    private String obs_group;
    private String accession_number;
    private String value_group;
    private boolean value_boolean;
    private String value_coded;
    private String value_coded_name;
    private String value_drug;
    private Date value_datetime;
    private double value_numeric;
    private String value_modifier;
    private String value_text;
    private String value_complex;
    private String comments;
    private String creator;
    private Date date_created;
    private boolean voided;
    private String voided_by;
    private Date date_voided;
    private String void_reason;
    private String uuid;
    private String facility;
    private String state;
    private int previous_version;
    private String form_namespace_and_path;

    public Obs(int id, String person, String concept, String encounter, String order, Date obs_datetime, String location, String obs_group, String accession_number, String value_group, boolean value_boolean, String value_coded, String value_coded_name, String value_drug, Date value_datetime, double value_numeric, String value_modifier, String value_text, String value_complex, String comments, String creator, Date date_created, boolean voided, String voided_by, Date date_voided, String void_reason, String uuid, String facility, String state, int previous_version, String form_namespace_and_path) {
        this.id = id;
        this.person = person;
        this.concept = concept;
        this.encounter = encounter;
        this.order = order;
        this.obs_datetime = obs_datetime;
        this.location = location;
        this.obs_group = obs_group;
        this.accession_number = accession_number;
        this.value_group = value_group;
        this.value_boolean = value_boolean;
        this.value_coded = value_coded;
        this.value_coded_name = value_coded_name;
        this.value_drug = value_drug;
        this.value_datetime = value_datetime;
        this.value_numeric = value_numeric;
        this.value_modifier = value_modifier;
        this.value_text = value_text;
        this.value_complex = value_complex;
        this.comments = comments;
        this.creator = creator;
        this.date_created = date_created;
        this.voided = voided;
        this.voided_by = voided_by;
        this.date_voided = date_voided;
        this.void_reason = void_reason;
        this.uuid = uuid;
        this.facility = facility;
        this.state = state;
        this.previous_version = previous_version;
        this.form_namespace_and_path = form_namespace_and_path;
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

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getEncounter() {
        return encounter;
    }

    public void setEncounter(String encounter) {
        this.encounter = encounter;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Date getObs_datetime() {
        return obs_datetime;
    }

    public void setObs_datetime(Date obs_datetime) {
        this.obs_datetime = obs_datetime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getObs_group() {
        return obs_group;
    }

    public void setObs_group(String obs_group) {
        this.obs_group = obs_group;
    }

    public String getAccession_number() {
        return accession_number;
    }

    public void setAccession_number(String accession_number) {
        this.accession_number = accession_number;
    }

    public String getValue_group() {
        return value_group;
    }

    public void setValue_group(String value_group) {
        this.value_group = value_group;
    }

    public boolean isValue_boolean() {
        return value_boolean;
    }

    public void setValue_boolean(boolean value_boolean) {
        this.value_boolean = value_boolean;
    }

    public String getValue_coded() {
        return value_coded;
    }

    public void setValue_coded(String value_coded) {
        this.value_coded = value_coded;
    }

    public String getValue_coded_name() {
        return value_coded_name;
    }

    public void setValue_coded_name(String value_coded_name) {
        this.value_coded_name = value_coded_name;
    }

    public String getValue_drug() {
        return value_drug;
    }

    public void setValue_drug(String value_drug) {
        this.value_drug = value_drug;
    }

    public Date getValue_datetime() {
        return value_datetime;
    }

    public void setValue_datetime(Date value_datetime) {
        this.value_datetime = value_datetime;
    }

    public double getValue_numeric() {
        return value_numeric;
    }

    public void setValue_numeric(double value_numeric) {
        this.value_numeric = value_numeric;
    }

    public String getValue_modifier() {
        return value_modifier;
    }

    public void setValue_modifier(String value_modifier) {
        this.value_modifier = value_modifier;
    }

    public String getValue_text() {
        return value_text;
    }

    public void setValue_text(String value_text) {
        this.value_text = value_text;
    }

    public String getValue_complex() {
        return value_complex;
    }

    public void setValue_complex(String value_complex) {
        this.value_complex = value_complex;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public int getPrevious_version() {
        return previous_version;
    }

    public void setPrevious_version(int previous_version) {
        this.previous_version = previous_version;
    }

    public String getForm_namespace_and_path() {
        return form_namespace_and_path;
    }

    public void setForm_namespace_and_path(String form_namespace_and_path) {
        this.form_namespace_and_path = form_namespace_and_path;
    }
}