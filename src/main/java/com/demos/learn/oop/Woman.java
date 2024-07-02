package com.demos.learn.oop;

public class Woman extends Person{
    private int mCycleDays;
    private  boolean hasReachedMenopause;

//    public Woman(){
//        super.setGender('F');
//    };
    public Woman(int mCycleDays, int age) {
        this.mCycleDays = mCycleDays;
        super.setGender('F');
        super.setAge(age);
        this.hasReachedMenopause = this.getAge() > 45;
    }
    //getters
    public int getCycleDays() {
        return mCycleDays;
    }
    public boolean hasReachedMenopause() {
        return hasReachedMenopause;
    }
    //setters
    public void setMCycleDays(int mCycleDays) {
        this.mCycleDays = mCycleDays;
    }
    public void setAge(int age) {
        super.setAge(age);
        this.hasReachedMenopause = this.getAge() > 45;
    }
    public String giveBirth(){
       return "Baby delivered successfully";
    }
    public String startPeriod(int date){
        if(date == mCycleDays){
            return "Period starting today";
        }
        return "period date not yet reached";
    }
    public String conceive(){
        if(hasReachedMenopause){
            return "Woman can not give birth";
        }
        return "Woman can still give birth";
    }

    @Override
    public String eat() {
        return "Eating normally";
    }

    @Override
    public String eat(String food) {
        return "Chewing " + food;
    }
}
