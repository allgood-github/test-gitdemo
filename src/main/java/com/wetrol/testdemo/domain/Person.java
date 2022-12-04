package com.wetrol.testdemo.domain;


public class Person {

    private String username;
    private MyCar myCar;
    private String pet;

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MyCar getMyCar() {
        return myCar;
    }

    public void setMyCar(MyCar myCar) {
        this.myCar = myCar;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", myCar=" + myCar + '\'' +
                ", pet=" + pet + '\'' +
                '}';
    }
}
