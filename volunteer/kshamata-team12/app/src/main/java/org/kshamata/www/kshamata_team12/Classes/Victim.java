package org.kshamata.www.kshamata_team12.Classes;

/**
 * Created by vikas on 7/8/2017.
 */

public class Victim {
    String id;
    String name;
    String age;
    String skills;
    String EduLvlAfter;
    String EduLvlJoin;
    String photo;
    String Location;
    String jobJoin;
    String salaryJoin;
    String jobNow;

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEduLvlAfter() {
        return EduLvlAfter;
    }

    public void setEduLvlAfter(String eduLvlAfter) {
        EduLvlAfter = eduLvlAfter;
    }

    public String getJobNow() {
        return jobNow;
    }

    public void setJobNow(String jobNow) {
        this.jobNow = jobNow;
    }

    public String getSalaryNow() {
        return salaryNow;
    }

    public void setSalaryNow(String salaryNow) {
        this.salaryNow = salaryNow;
    }

    String salaryNow;
    String FormsId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEduLvlJoin() {
        return EduLvlJoin;
    }

    public void setEduLvlJoin(String eduLvlJoin) {
        EduLvlJoin = eduLvlJoin;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getJobJoin() {
        return jobJoin;
    }

    public void setJobJoin(String jobJoin) {
        this.jobJoin = jobJoin;
    }

    public String getSalaryJoin() {
        return salaryJoin;
    }

    public void setSalaryJoin(String salaryJoin) {
        this.salaryJoin = salaryJoin;
    }

    public String getFormsId() {
        return FormsId;
    }

    public void setFormsId(String formsId) {
        FormsId = formsId;
    }

}
