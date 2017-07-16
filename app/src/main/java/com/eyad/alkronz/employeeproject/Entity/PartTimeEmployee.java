package com.eyad.alkronz.employeeproject.Entity;

/**
 * Created by Eyad on 7/16/2017.
 */

public class PartTimeEmployee extends Employee {

    private double hourFee ;


    public PartTimeEmployee(int id, String name, int age, int imageid , double hourFee) {
        super(id, name, age, imageid);
        setHourFee(  hourFee);
    }

    public double getHourFee() {
        return hourFee;
    }

    public void setHourFee(double hourFee) {
        this.hourFee = hourFee;
    }
}
