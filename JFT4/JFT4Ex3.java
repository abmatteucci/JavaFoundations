package JFT4;
/*
Write a Java program to calculate an employee’s weekly take home pay. Make use of
variables as part of your solution. Save the program as JFT4Ex3.java.

Employee Name
PPS No
Department
Hours Worked (basic)
Hours Worked (overtime)
Basic hourly rate of pay (29.35)
Overtime hourly rate of pay @1.5 (time and a half)
Gross Pay
Income Tax Payable (assume rate is 35%).
Net Pay

*/


public class JFT4Ex3 {
    public static void main(String[] args){
        
        System.out.println("JFT4Ex3: Calculating an employee\u2019s weekly take home pay.");
        String repeated = new String(new char[20]).replace("\0", "*");
        Employee employee = new Employee("John Smith", "9818501UA", "IT", 50.5f, 13.5f, 29.35f, 1.5f, 0.35f);
        System.out.println(repeated + "Salary Report" + repeated);
        System.out.println(repeated + "Employee Details" + repeated);
        System.out.println("Employee Name: " + employee.employeeName);
        System.out.println("Employee PPS No.: " + employee.employeePPSNumber);
        System.out.println("Employee Department: " + employee.associatedDepartment);
        System.out.println();
        System.out.println(repeated + "Hours Worked" + repeated);
        System.out.println("No. basic hours worked: " + employee.basicWorkedHours);
        System.out.println("The hourly rate of basic pay is at " + employee.basicByHour + " euro.");
        System.out.println("Basic salary: " + employee.calculateBasicSalary());
        System.out.println("No. of overtime hours worked: " + employee.overtimeWorkedHours);
        System.out.println("The hourly rate of overtime pay is: " + employee.overtimeRate);
        System.out.println("Overtime salary: " + employee.calculateOvertimeSalary());
        System.out.println();
        System.out.println(repeated + "Take Home Pay" + repeated);
        System.out.println("Gross Pay: " + employee.getGrossPay());
        System.out.println("Income Tax Playable at: " + employee.incomeTaxPlayable + " is: " + employee.getIncomeTaxPlayableValue());
        System.out.println("Net Pay: " + employee.getNetPay());
    }
}

class Employee {

    /*
    Employee Name
    PPS No
    Department
    Hours Worked (basic)
    Hours Worked (overtime)
    Basic hourly rate of pay (29.35)
    Overtime hourly rate of pay @1.5 (time and a half)
    Gross Pay
    Income Tax Payable (assume rate is 35%).
    Net Pay
     */
    String employeeName;
    String employeePPSNumber;
    String associatedDepartment;
    float basicWorkedHours;
    float overtimeWorkedHours;
    float basicByHour;
    float overtimeRate;
    float grossPay;
    float incomeTaxPlayable;
    float netPay;

    public Employee(String employeeName, 
                    String employeePPSNumber, 
                    String associatedDepartment,
                    float basicWorkedHours, 
                    float overtimeWorkedHours,
                    float basicByHour,
                    float overtimeRate,
                    float incomeTaxPlayable) {
        this.employeeName = employeeName;
        this.employeePPSNumber = employeePPSNumber;
        this.associatedDepartment = associatedDepartment;
        this.basicWorkedHours = basicWorkedHours;
        this.overtimeWorkedHours = overtimeWorkedHours;
        this.basicByHour = basicByHour;
        this.overtimeRate = overtimeRate;
        this.incomeTaxPlayable = incomeTaxPlayable;
    }

    public String getEmployeeName(){
        return this.employeeName;
    }

    public String getEmployeePPSNumber(){
        return this.employeePPSNumber;
    }

    public String getAssociatedDepartment(){
        return this.associatedDepartment;
    }

    public float getBasicWorkedHours(){
        return (float) this.basicWorkedHours;
    }

    public float getOvertimeWorkedHours(){
        return (float) this.overtimeWorkedHours;
    }

    public float getBasicByHour(){
        return (float) this.basicByHour;
    }

    public float getOvertimeRate(){
        return (float) this.overtimeRate;
    }

    public float calculateBasicSalary(){
        return (float) (this.basicWorkedHours * this.basicByHour);
    }

    public float calculateOvertimeSalary(){
        return (float) (this.overtimeWorkedHours * this.overtimeRate * this.basicByHour);
    }

    public float getGrossPay(){
        float sumGrossPay = this.calculateBasicSalary() + this.calculateOvertimeSalary();
        this.grossPay = sumGrossPay;
        return this.grossPay;
    }

    public float getIncomeTaxPlayable(){
        return this.incomeTaxPlayable;
    }

    public float getIncomeTaxPlayableValue(){
        return (float) (this.getGrossPay() * this.incomeTaxPlayable);
    }

    public float getNetPay(){
        this.netPay = (float) this.getGrossPay() - this.getIncomeTaxPlayableValue();
        return this.netPay;
    }
}