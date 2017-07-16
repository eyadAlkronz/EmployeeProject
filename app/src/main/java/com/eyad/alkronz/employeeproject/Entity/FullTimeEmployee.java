package com.eyad.alkronz.employeeproject.Entity;

/**
 * Created by Eyad on 7/16/2017.
 */

public class FullTimeEmployee extends Employee {

    private  double monthSalary;

    public FullTimeEmployee(int id, String name, int age, int imageid , double monthSalary) {
        super(id, name, age, imageid);
        setMonthSalary(monthSalary);
     }

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }
}
