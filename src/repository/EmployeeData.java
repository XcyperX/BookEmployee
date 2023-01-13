package repository;

import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    private static EmployeeData employeeData;

    private static List<Employee> employees = new ArrayList<>();

    public static synchronized EmployeeData getInstance() {
        if (employeeData == null) {
            employeeData = new EmployeeData();
        }
        return employeeData;
    }

    private EmployeeData(){}

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static List<Employee> addEmployee(Employee employee) {
        EmployeeData.employees.add(employee);
        return employees;
    }

    public static void setEmployees(List<Employee> employees) {
        EmployeeData.employees = employees;
    }

    public static List<Employee> removeByEmployee(Employee employee) {
        EmployeeData.employees.remove(employee);
        return employees;
    }
}
