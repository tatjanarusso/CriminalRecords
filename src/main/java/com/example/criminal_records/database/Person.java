package com.example.criminal_records.database;

public class Person {
    private String foreName = null;
    private String Surname = null;
    private Integer Age = null;
    private Integer Height = null;
    private Integer weight = null;
    private String Crimes = null;

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Integer getHeight() {
        return Height;
    }

    public void setHeight(Integer height) {
        Height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCrimes() {
        return Crimes;
    }

    public void setCrimes(String crimes) {
        Crimes = crimes;
    }
}
