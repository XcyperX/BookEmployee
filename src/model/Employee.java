package model;

import constant.Constants;

public class Employee {
    private final int id = Constants.getInstance().getEmployeeId();
    private String name;
    private Department department;
    private double salary;

    public Employee() {
    }

    public Employee(String name, Department department, Float salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | ФИО: " + name + " | Отдел: " + department.getName() + " | Зарплата: " + salary;
    }
}
