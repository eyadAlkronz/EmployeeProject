package com.eyad.alkronz.employeeproject.Entity;

/**
 * Created by Eyad on 7/16/2017.
 */


public class Employee {
    private  String name ;
    private int age ;
    private int id ;
    private  int imageid;


    public Employee(int id  , String name , int age  , int imageid ){
        setAge(age);
        setId(id);
        setName(name);
        setImageid(imageid);
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public int getImageid() {
        return imageid;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}