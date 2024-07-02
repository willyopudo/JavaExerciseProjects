package com.demos.learn.oop;

public class Driver {
    public static void main(String[] args) {
        Child child1 = new Child(1,'F',5);
        Child child2 = new Child(5,'M',8);
//        child1.setAge(1);
//        child1.setGender('F');
//        child1.setName("Emilio");
//        child1.setRemainingDaysToClinic(5);
//
//        System.out.println(child1.eat("Porridge"));
//        System.out.println(child1.breastFeed());
//        System.out.println(child1.breath(1));
//        System.out.println(child1.sleep());
//        System.out.println(child1.findClinicDate(2));
        Woman woman = new Woman(26,55);
        woman.setMCycleDays(26);
        woman.setName("Jade");
        woman.setAge(25);


        System.out.println(woman.eat("sugarcane"));
        System.out.println(woman.conceive());
        System.out.println(woman.giveBirth());
        System.out.println(woman.startPeriod(5));
        System.out.println(woman.breath(1));
        System.out.println(woman.sleep());
    }
}
