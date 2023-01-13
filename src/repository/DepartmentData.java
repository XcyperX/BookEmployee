package repository;

import model.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentData {
    private static DepartmentData departmentData;
    private static List<Department> departments = new ArrayList<>();

    public static synchronized DepartmentData getInstance() {
        if (departmentData == null) {
            departmentData = new DepartmentData();
        }
        return departmentData;
    }

    private DepartmentData(){}

    public static List<Department> getDepartments() {
        return departments;
    }

    public static List<Department> addDepartment(Department department) {
        DepartmentData.departments.add(department);
        return departments;
    }

    public static void setDepartments(List<Department> departments) {
        DepartmentData.departments = departments;
    }
}
