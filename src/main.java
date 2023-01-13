import model.Department;
import model.Employee;
import repository.DepartmentData;
import repository.EmployeeData;
import service.UiService;
import service.impl.UiServiceImpl;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
//        Department department1 = new Department("1", new ArrayList<>());
//        Department department2 = new Department("2", new ArrayList<>());
//
//        Employee employee1 = new Employee("Artem", department1, 1000F);
//        department1.addEmployee(employee1);
//        Employee employee2 = new Employee("Viktor", department2, 2000F);
//        department2.addEmployee(employee2);
//
//        System.out.println(employee1.getId());
//        System.out.println(employee2.getId());
//
//        System.out.println(department1.getEmployees().toString());

        DepartmentData.getInstance();
        EmployeeData.getInstance();
        UiService uiService = new UiServiceImpl();
        uiService.getStartAppPage();
    }
}
