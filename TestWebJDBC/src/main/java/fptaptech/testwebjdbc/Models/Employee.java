package fptaptech.testwebjdbc.Models;

public class Employee {
    private String EmployeeCode;
    private String Employeename;
    private String Department;
    private Double salary;

    public Employee(String EmployeeCode, String Employeename, String Department, Double salary) {
        this.EmployeeCode = EmployeeCode;
        this.Employeename = Employeename;
        this.Department = Department;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }

    public String getEmployeename() {
        return Employeename;
    }

    public void setEmployeename(String Employeename) {
        this.Employeename = Employeename;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
                return "Employee{" + "EmployeeCode=" + EmployeeCode + ", Employeename=" + Employeename + ", Department=" + Department + ", salary="+salary +'}';
    }

}
