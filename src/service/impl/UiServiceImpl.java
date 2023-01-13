package service.impl;

import model.Department;
import model.Employee;
import service.DepartmentService;
import service.EmployeeService;
import service.UiService;

import java.util.List;
import java.util.Scanner;

public class UiServiceImpl implements UiService {
    DepartmentService departmentService = new DepartmentServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    public void getStartAppPage() {
        System.out.println("\nЧто вы хотите сделать?");
        System.out.println("1. Работа с сотрудниками");
        System.out.println("2. Работа с отделами");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1 -> getWorkByEmployeesPage();
            case 2 -> getWorkByDepartmentsPage();
            default -> getStartAppPage();
        }
    }

    @Override
    public void getWorkByEmployeesPage() {
        System.out.println("\nМеню работы с сотрудниками");
        System.out.println("Доступные действия:");
        System.out.println("1. Добавить нового сотрудника");
        System.out.println("2. Изменить данные сотрудника");
        System.out.println("3. Удалить сотрудника");
        System.out.println("4. Вывести всех сотрудников");
        System.out.println("5. Вернутся на главную");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1 -> getCreateEmployeePage();
            case 2 -> getUpdateEmployeePage();
            case 3 -> getDeleteEmployeePage();
            case 4 -> getAllEmployeePage();
            case 5 -> getStartAppPage();
        }
    }

    @Override
    public void getWorkByDepartmentsPage() {
        System.out.println("\nМеню работы с отделами");
        System.out.println("Доступные действия:");
        System.out.println("1. Добавить новый отдел");
        System.out.println("2. Вывести всех сотрудников");
        System.out.println("3. Вывести все ФИО сотрудников");
        System.out.println("4. Вывести всех сотрудников отдела");
        System.out.println("5. Работа с зарплатами");
        System.out.println("6. Вернуться на главную");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1 -> getCreateDepartmentPage();
            case 2 -> getAllEmployeePage();
            case 3 -> getAllEmployeeNamePage();
            case 4 -> getAllEmployeeByDepartmentIdPage();
            case 5 -> getWorkBySalaryPage();
            case 6 -> getStartAppPage();
        }
    }

    @Override
    public void getWorkBySalaryPage() {
        System.out.println("\nМеню работы с зарплатами");
        System.out.println("Доступные действия:");
        System.out.println("1. Вывести сотрудника с минимальной зарплатой по всем отделам");
        System.out.println("2. Вывести сотрудника с минимальной зарплатой по отделу");
        System.out.println("3. Вывести сотрудника с максимальной зарплатой по всем отделам");
        System.out.println("4. Вывести сотрудника с максимальной зарплатой по отделу");
        System.out.println("5. Вывести сумму зарплат по всем отделам");
        System.out.println("6. Вывести сумму зарплат по отделу");
        System.out.println("7. Вывести среднюю зарплату по всем отделам");
        System.out.println("8. Вывести среднюю зарплату по отделу");
        System.out.println("9. Проиндексировать зарплаты всех сотрудников");
        System.out.println("10. Проиндексировать зарплаты сотрудников по отделу");
        System.out.println("11. Вернуться на главную");
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1 -> getEmployeeByMinSalaryPage();
            case 2 -> getEmployeeByMinSalaryOnDepartmentPage();
            case 3 -> getEmployeeByMaxSalaryPage();
            case 4 -> getEmployeeByMaxSalaryOnDepartmentPage();
            case 5 -> getSumSalaryEmployeePage();
            case 6 -> getSumSalaryEmployeeOnDepartmentPage();
            case 7 -> getAverageSalaryEmployeePage();
            case 8 -> getAverageSalaryEmployeeOnDepartmentPage();
            case 9 -> getIndexSalaryEmployeePage();
            case 10 -> getIndexSalaryEmployeeOnDepartmentPage();
            case 11 -> getStartAppPage();
        }
    }

    @Override
    public void getAllEmployeePage() {
        System.out.println("\nСписок всех сотрудников:");
        for (Employee employee : employeeService.getAll()) {
            System.out.println(employee);
        }
        getStartAppPage();
    }

    @Override
    public void getAllEmployeeNamePage() {
        System.out.println("\nСписок ФИО всех сотрудников:");
        employeeService.getAllEmployeeName();
        getStartAppPage();
    }

    @Override
    public void getCreateEmployeePage() {
        Employee employee = new Employee();
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите ФИО: ");
        String nameEmployee = in.nextLine();
        employee.setName(nameEmployee);
        Department findDepartment = checkDepartmentById();
        employee.setDepartment(findDepartment);
        findDepartment.addEmployee(employee);
        System.out.print("Введите зарплату сотрудника: ");
        float salaryEmployee = in.nextFloat();
        employee.setSalary(salaryEmployee);
        employeeService.createEmployee(employee);
        System.out.println("Создан сотрудник:");
        System.out.println(employee);
        getStartAppPage();
    }

    @Override
    public void getUpdateEmployeePage() {
        Scanner in = new Scanner(System.in);
        Employee employee = checkEmployeeById();
        System.out.print("\nВведите новое ФИО: ");
        String nameEmployee = in.nextLine();
        employee.setName(nameEmployee);
        Department findDepartment = checkDepartmentById();
        employee.setDepartment(findDepartment);
        findDepartment.addEmployee(employee);
        System.out.print("Введите новую зарплату сотрудника: ");
        float salaryEmployee = in.nextFloat();
        employee.setSalary(salaryEmployee);
        System.out.println("Данные сотрудника обновлены:");
        System.out.println(employee);
        getStartAppPage();
    }

    @Override
    public void getDeleteEmployeePage() {
        Employee employee = checkEmployeeById();
        System.out.println("Сотрудник: " + employee.getName() + " удален!");
        employeeService.deleteById(employee.getId());
        getStartAppPage();
    }

    @Override
    public void getCreateDepartmentPage() {
        Department department = new Department();
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите название отдела: ");
        String name = in.nextLine();
        department.setName(name);
        departmentService.createDepartment(department);
        System.out.println("Создан отдел:");
        System.out.println(department);
        getStartAppPage();
    }

    @Override
    public void getAllEmployeeByDepartmentIdPage() {
        Scanner in = new Scanner(System.in);
        Department findDepartment = checkDepartmentById();
        System.out.println(departmentService.getEmployeesByDepartmentId(findDepartment.getId()));
        getStartAppPage();
    }

    @Override
    public void getEmployeeByMinSalaryPage() {
        System.out.println("\nСотрудник с минимальной зарплатой:");
        System.out.println(employeeService.getMinSalary());
        getStartAppPage();
    }

    @Override
    public void getEmployeeByMinSalaryOnDepartmentPage() {
        Scanner in = new Scanner(System.in);
        Department findDepartment = checkDepartmentById();
        System.out.println("\nСотрудник с минимальной зарплатой из отдела " + findDepartment.getId() + ":");
        System.out.println(employeeService.getMinSalaryByDepartmentId(findDepartment.getId()));
        getStartAppPage();
    }

    @Override
    public void getEmployeeByMaxSalaryPage() {
        System.out.println("\nСотрудник с максимальной зарплатой:");
        System.out.println(employeeService.getMaxSalary());
        getStartAppPage();
    }

    @Override
    public void getEmployeeByMaxSalaryOnDepartmentPage() {
        Scanner in = new Scanner(System.in);
        Department findDepartment = checkDepartmentById();
        System.out.println("\nСотрудник с максимальной зарплатой из отдела " + findDepartment.getId() + ":");
        System.out.println(employeeService.getMinSalaryByDepartmentId(findDepartment.getId()));
        getStartAppPage();
    }

    @Override
    public void getSumSalaryEmployeePage() {
        System.out.println("\nСумма всех зарплат: " + departmentService.getAllSalary());
        getStartAppPage();
    }

    @Override
    public void getSumSalaryEmployeeOnDepartmentPage() {
        Department findDepartment = checkDepartmentById();
        System.out.println("\nСумма всех зарплат по отделу " + findDepartment.getId() +": " + departmentService.getAllSalaryByDepartmentId(findDepartment.getId()));
        getStartAppPage();
    }

    @Override
    public void getAverageSalaryEmployeePage() {
        System.out.println("\nСредняя зарплата по всем отделам: " + departmentService.getAverageSalary());
        getStartAppPage();
    }

    @Override
    public void getAverageSalaryEmployeeOnDepartmentPage() {
        Department findDepartment = checkDepartmentById();
        System.out.println("\nСредняя зарплата по отделу " + findDepartment.getId() +": " + departmentService.getAverageSalaryByDepartmentId(findDepartment.getId()));
        getStartAppPage();
    }

    @Override
    public void getIndexSalaryEmployeePage() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите процент индексации: ");
        double percent = in.nextDouble();
        List<Employee> employees = departmentService.indexEmployeeSalary(percent);
        System.out.println("Зарплаты с учетом индексации на " + percent + "%:");
        System.out.println(employees);
        getStartAppPage();
    }

    @Override
    public void getIndexSalaryEmployeeOnDepartmentPage() {
        Scanner in = new Scanner(System.in);
        Department findDepartment = checkDepartmentById();
        System.out.println("Введите процент индексации: ");
        double percent = in.nextDouble();
        List<Employee> employees = departmentService.indexEmployeeSalaryByDepartmentId(percent, findDepartment.getId());
        System.out.println("Зарплаты с учетом индексации на " + percent + "%:");
        System.out.println(employees);
        getStartAppPage();
    }

    private Department checkDepartmentById() {
        Scanner in = new Scanner(System.in);
        Department findDepartment;
        do {
            System.out.print("\nВведите Id отдела: ");
            int departmentId = in.nextInt();
            findDepartment = departmentService.getDepartmentById(departmentId);
        } while (findDepartment == null);
        return findDepartment;
    }

    private Employee checkEmployeeById() {
        Scanner in = new Scanner(System.in);
        Employee employee;
        do {
            System.out.print("\nВведите Id сотрудника: ");
            int employeeId = in.nextInt();
            employee = employeeService.getById(employeeId);
        } while (employee == null);
        return employee;
    }
}
