package com.example.demomvc.model;

import com.example.demomvc.validators.Prefix;

import javax.validation.constraints.*;

public class Student {
    @NotNull(message = "is required")
    @Size(min=3, message = "size should be greater then 3")
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String language;
    @Max(value = 110, message = "you cant be so old")
    @Min(value = 0, message = "your cant be so yong")
    private int age;
    @Pattern(regexp = "%[a-zA-Z0-9]{5}", message = "only 5 digits/chars")
    private String postalCode;
    @Prefix
    private String test;
    @Prefix(value = "noTest", message = "message should start with noTest")
    private String noTest;

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    private String[] operatingSystems;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Student() {

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
