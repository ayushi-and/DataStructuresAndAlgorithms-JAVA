package TestMixedQuestions;


public class Employee {

    private String employeeName;
    private Double salary;
    private String employeeCode;

    public Employee(String employeeName, Double salary, String  employeeCode) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.employeeCode = employeeCode;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
