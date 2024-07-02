package com.demos.learn.oop;

public class Child extends Person{
    private int remainingDaysToClinic;
    //default constructor
    //public Child() {}

    //Parameterized constructor
    public Child(int age,char gender,int remainingDaysToClinic) {
        this.setGender(gender);
        this.setAge(age);
        this.remainingDaysToClinic = remainingDaysToClinic;
    }

    //Getter
    public int getRemainingDaysToClinic() {
        return remainingDaysToClinic;
    }
    //Setter
    public void setRemainingDaysToClinic(int remainingDaysToClinic) {
        this.remainingDaysToClinic = remainingDaysToClinic;
    }

    @Override
    public String eat() {
        return "Child fed using baby sucker";
    }

    @Override
    public String eat(String food) {
        return "Child fed " + food + " using baby sucker";
    }

    public int findClinicDate(int todayDate){
        return todayDate + this.remainingDaysToClinic;
    }

    public String breastFeed(){
        return "Child is suckling milk...";
    }

    @Override
    public String sleep(){
        return "Child is sleeping in a weird way!";
    }

}
