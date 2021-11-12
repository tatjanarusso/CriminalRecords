package com.example.criminal_records;

public class Person {
    private String foreName = null;
    private String surname = null;
    private Integer age = null;
    private Integer height = null;
    private Integer weight = null;
    private String comCrimes = null;
    private String weapon = null;
    private String sentence = null;

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        height = height;
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
