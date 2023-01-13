package service;

import model.Department;
import model.Employee;

import java.util.List;

public interface DepartmentService {
    Department getDepartmentById(int id);
    Department createDepartment(Department department);
    List<Employee> getEmployeesByDepartmentId(int id);
    double getAverageSalary();
    double getAverageSalaryByDepartmentId(int id);
    double getAllSalary();
    double getAllSalaryByDepartmentId(int id);
    List<Employee> indexEmployeeSalary(double percent);
    List<Employee> indexEmployeeSalaryByDepartmentId(double percent, int departmentId);
}
