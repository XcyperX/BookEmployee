package service.impl;

import model.Employee;
import repository.EmployeeData;
import service.DepartmentService;
import service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeServiceImpl implements EmployeeService {
    DepartmentService departmentService = new DepartmentServiceImpl();
    @Override
    public Employee getById(int id) {
        try {
            return EmployeeData.getEmployees().stream().filter(employee -> employee.getId() == id).findFirst().orElseThrow();
        } catch (Exception e) {
            System.out.println("Нет сотрудника с id: " + id);
            return null;
        }
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeData.addEmployee(employee);
        return employee;
    }

    @Override
    public Employee updateById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        EmployeeData.removeByEmployee(getById(id));
    }

    @Override
    public List<Employee> getAll() {
        return EmployeeData.getEmployees();
    }

    @Override
    public void getAllEmployeeName() {
        for (Employee employee : EmployeeData.getEmployees()) {
            System.out.println(employee.getName());
        }
    }

    @Override
    public Employee getMinSalary() {
        return getMinSalary(EmployeeData.getEmployees());
    }

    @Override
    public Employee getMinSalaryByDepartmentId(int id) {
        return getMinSalary(departmentService.getEmployeesByDepartmentId(id));
    }

    @Override
    public Employee getMaxSalary() {
        return getMaxSalary(EmployeeData.getEmployees());
    }

    @Override
    public Employee getMaxSalaryByDepartmentId(int id) {
        return getMaxSalary(departmentService.getEmployeesByDepartmentId(id));
    }

    private Employee getMinSalary(List<Employee> employees) {
        return employees.stream().min(Comparator.comparing(Employee::getSalary)).orElseThrow(NoSuchElementException::new);
    }

    private Employee getMaxSalary(List<Employee> employees) {
        return employees.stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow(NoSuchElementException::new);
    }
}
