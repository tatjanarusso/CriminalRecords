package com.example.criminal_records;

public class Person {
    public String forename = null;
    public String surname = null;
    public Integer age = null;
    public Integer height = null;
    public Integer weight = null;
    public String comCrimes = null;
    public String weapon = null;
    public String sentence = null;

    public String getForeName() {
        return forename;
    }

    public void setForeName(String foreName) {
        this.forename = foreName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCrimes() {
        return comCrimes;
    }

    public void setCrimes(String crimes) {
        comCrimes = crimes;
    }

    public String getWeapon() { return weapon; }

    public void setWeapon(String weapon) { this.weapon = weapon; }

    public String getSentence() { return sentence; }

    public void setSentence(String sentence) { this.sentence = sentence; }
}
