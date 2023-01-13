package service.impl;

import model.Department;
import model.Employee;
import repository.DepartmentData;
import repository.EmployeeData;
import service.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public double getAverageSalary() {
        double sumSalary = EmployeeData.getEmployees().stream().mapToDouble(Employee::getSalary).sum();
        return sumSalary / EmployeeData.getEmployees().size();
    }

    @Override
    public double getAverageSalaryByDepartmentId(int id) {
        List<Employee> employees = getEmployeesByDepartmentId(id);
        double sumSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
        return sumSalary / employees.size();
    }

    @Override
    public double getAllSalary() {
        return EmployeeData.getEmployees().stream().mapToDouble(Employee::getSalary).sum();
    }

    @Override
    public double getAllSalaryByDepartmentId(int id) {
        List<Employee> employees = getEmployeesByDepartmentId(id);
        return employees.stream().mapToDouble(Employee::getSalary).sum();
    }

    @Override
    public Department getDepartmentById(int id) {
        try {
            return DepartmentData.getDepartments().get(id);
        } catch (Exception e) {
            System.out.println("Нет отдела с индексом: " + id);
            return null;
        }
    }

    @Override
    public Department createDepartment(Department department) {
        DepartmentData.addDepartment(department);
        return department;
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(int id) {
        return EmployeeData.getEmployees().stream().filter(employee -> employee.getDepartment().getId() == id).collect(Collectors.toList());
    }

    @Override
    public List<Employee> indexEmployeeSalary(double percent) {
        for (Employee employee : EmployeeData.getEmployees()) {
            employee.setSalary(employee.getSalary() + (employee.getSalary() * percent / 100));
        }
        return EmployeeData.getEmployees();
    }

    @Override
    public List<Employee> indexEmployeeSalaryByDepartmentId(double percent, int departmentId) {
        List<Employee> employees = getEmployeesByDepartmentId(departmentId);
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() + (employee.getSalary() * percent / 100));
        }
        return employees;
    }
}
