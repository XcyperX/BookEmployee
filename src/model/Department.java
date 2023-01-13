package model;

import constant.Constants;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private final int id = Constants.getInstance().getDepartmentId();
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> addEmployee(Employee employee) {
        this.employees.add(employee);
        return employees;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | Название: " + name + " | Список сотрудников отдела: " + employees.toString();
    }
}
