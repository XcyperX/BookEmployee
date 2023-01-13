package constant;

public class Constants {
    private static Constants constants;
    private static int employeeId = -1;
    private static int departmentId = -1;

    public static synchronized Constants getInstance() {
        if (constants == null) {
            constants = new Constants();
        }
        return constants;
    }

    private Constants() {

    }

    public int getEmployeeId() {
        Constants.employeeId++;
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        Constants.employeeId = employeeId;
    }

    public int getDepartmentId() {
        Constants.departmentId++;
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        Constants.departmentId = departmentId;
    }
}
