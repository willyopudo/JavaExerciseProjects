package com.demos.learn.oop;

public abstract class Person {
    private int age;
    private char gender;
    private String name;

    //Getters

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public char getGender() {
        return gender;
    }

    //Setters
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    //Abstract methods
    public abstract String eat();
    public abstract String eat(String food);

    public String breath(int mode){
        if(mode == 1){
            return "Person on synthetic oxygen";
        }
        return "Person breathing normally";
    }
    public String sleep(){return "Zzzzzzzzz....";}
}
