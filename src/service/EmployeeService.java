package service;

import model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getById(int id);
    Employee createEmployee(Employee employee);
    Employee updateById(int id);
    void deleteById(int id);
    List<Employee> getAll();
    void getAllEmployeeName();
    Employee getMinSalary();
    Employee getMinSalaryByDepartmentId(int id);
    Employee getMaxSalary();
    Employee getMaxSalaryByDepartmentId(int id);
}
