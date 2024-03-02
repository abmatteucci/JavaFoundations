package JFT13;

import java.util.Scanner;

/*
 * Create a Java program to calculate an employee’s weekly take home pay.
The following information is standard for all employees.
 Basic Hourly Rate: Euro 29.39.
 Overtime Hourly Rate: 1.5 (time and a half).
 Income Tax Payable (@35%), if salary is greater than 2,000 Euro.
 Income Tax Payable (@20%), if salary is less than or equal to 2,000 Euro.
Using a Scanner object, prompt the user to enter the following information.
 Employee Name
 PPS No
 Department
 Hours Worked (basic and any overtime)
The program should display a salary slip for the employee. All numeric data should be
formatted to two decimal places using either a DecimalFormat object or the
System.out.printf() method.
Save your class as JFT13Ex4.java
 */

public class JFT13Ex4 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println(Centralizador.centralizarString("Add new Employee", 60));
        System.out.println();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee PPS No: ");
        String pps = scanner.nextLine();
        System.out.print("Enter Employee Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Basic Hours Worked: ");
        float bWorkedHours = scanner.nextFloat();
        System.out.print("Enter Overtime Hours Worked: ");
        float overtimeHoursWorked = scanner.nextFloat();

        Employee employee = new Employee();
        employee.setName(name);
        employee.setPPSNo(pps);
        employee.setDepartment(department);
        employee.setBasicHourlyRate(29.39f);
        employee.setBasicOvertimeRateMulti(1.5f);
        employee.setHoursWorkedByWeek(bWorkedHours);
        employee.setOvertimeHoursWorked(overtimeHoursWorked);
        employee.generateReport();

        scanner.close();

    }
    
}

class Employee {

    private static int employeeId = 0;
    private int id;
    private String name;
    private String ppsNo;
    private String department;
    private float workedWeekHours = 0;
    private float overtimeHoursWorked = 0;
    private float bHourlyRate = 0;
    private float bOvertimeRateMulti = 0;

    public Employee(String _name, String _ppsNo, String _department, float _bHourly, float _bOvertimeMultiplier){
        this.id = generateEmployeeId();
        this.name = _name;
        this.ppsNo = _ppsNo;
        this.department = _department;
        this.bHourlyRate = _bHourly;
        this.bOvertimeRateMulti = _bOvertimeMultiplier;
    }

    public Employee(String _name, String _ppsNo, String _department, float _bHourly){
        this.id = generateEmployeeId();
        this.name = _name;
        this.ppsNo = _ppsNo;
        this.department = _department;
        this.bHourlyRate = _bHourly;
    }

    public Employee(String _name, String _ppsNo, String _department){
        this.id = generateEmployeeId();
        this.name = _name;
        this.ppsNo = _ppsNo;
        this.department = _department;
    }

    public Employee(String _name, String _ppsNo){
        this.id = generateEmployeeId();
        this.name = _name;
        this.ppsNo = _ppsNo;
    }

    public Employee(){
        this.id = generateEmployeeId();
    }

    // Statics

    private static int generateEmployeeId(){
        return employeeId++;
    }

    private static float calculateIncomeTax(float weekSalary, float weeklyAmountSelector, float incomeTaxMin, float incomeTaxMax){
        if (weekSalary > weeklyAmountSelector){
            return weekSalary * incomeTaxMax;
        } else {
            return weekSalary * incomeTaxMin;
        }
    }

    private static float calculateSelectedTax(float weekSalary, float weeklyAmountSelector){
        if (weekSalary > weeklyAmountSelector){
            return 0.35f;
        } else {
            return 0.20f;
        }
    }

    private static String selectedTaxString(float _tax){
        return "" + _tax * 100 + "%";
    }

    // Getters

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getPPSNo(){
        return this.ppsNo;
    }

    public String getDepartment(){
        return this.department;
    }

    public float getWorkedWeeklyHours(){
        return this.workedWeekHours;
    }

    public float getBHourlyRate(){
        return this.bHourlyRate;
    }

    public float getBOvertimeRateMulti(){
        return this.bOvertimeRateMulti;
    }

    public float getOvertimeHoursWorked(){
        return this.overtimeHoursWorked;
    }

    // Setters

    public void setId(){
        this.id = generateEmployeeId();
    }

    public void setName(String _name){
        this.name = _name;
    }

    public void setPPSNo(String _ppsNo){
        this.ppsNo = _ppsNo;
    }

    public void setHoursWorkedByWeek(float _workedHours){
        this.workedWeekHours = _workedHours;
    }

    public void setDepartment(String _department){
        this.department = _department;
    }

    public void setBasicHourlyRate(float _bHourly){
        this.bHourlyRate = _bHourly;
    }

    public void setBasicOvertimeRateMulti(float _bOvertimeMultiplier){
        this.bOvertimeRateMulti = _bOvertimeMultiplier;
    }

    public void setOvertimeHoursWorked(float _overtimeHoursWorked){
        this.overtimeHoursWorked = _overtimeHoursWorked;
    }

    // Methods

    // public String getSelectedTax(float _salary){

    // }


    public void generateReport(){
        String endLine = new String(new char[60]).replace("\0", "*");
        String title = Centralizador.centralizarString(" Salary Report ", 60);
        String session1 = Centralizador.centralizarString(" Employee Details ", 60);
        String session2 = Centralizador.centralizarString(" Hours Worked ", 60);
        String session3 = Centralizador.centralizarString(" Take Home Pay ", 60);
        float _minTax = 0.20f;
        float _maxTax = 0.35f;

        System.out.println(title);
        System.out.println();
        System.out.println(session1);
        System.out.println();
        System.out.printf("Employee Name: %s%n", this.getName());
        System.out.printf("Employee PPS No: %s%n", this.getPPSNo());
        System.out.printf("Employee Department: %s%n", this.getDepartment());
        System.out.println();
        System.out.println(session2);
        System.out.println();
        System.out.printf("%nNo. of basic hours worked: %.2f%n", this.getWorkedWeeklyHours());
        System.out.printf("The hourly rate of basic pay is at %.2f euro.%n", this.getBHourlyRate());
        System.out.printf("Basic Salary: %.2f%n", (this.getBHourlyRate() * this.getWorkedWeeklyHours()));
        System.out.printf("No. of overtime hours worked: %.2f%n", this.getOvertimeHoursWorked());
        System.out.printf("The hourly rate of overtime pay is at %.2f.%n", this.getBOvertimeRateMulti());

        float _baseSalary = (this.getBHourlyRate() * this.getWorkedWeeklyHours());
        float _overtimeSalary = (this.getBOvertimeRateMulti() * this.getOvertimeHoursWorked() * this.getBHourlyRate());
        float _grossSalary = _baseSalary + _overtimeSalary;
        float _incomePayableTax = Employee.calculateIncomeTax(_grossSalary, 2000f, _minTax, _maxTax);

        System.out.printf("Overtime salary: %.2f.%n", _overtimeSalary);
        System.out.println();
        System.out.println(session3);
        System.out.println();
        System.out.printf("Gross Pay: %.2f%n", _grossSalary);
        
        float _aplicableTax = Employee.calculateSelectedTax(_grossSalary, 2000f);                         
        System.out.printf("Income Tax Payable at: %s is: %.2f%n", 
                            Employee.selectedTaxString(_aplicableTax), 
                            Employee.calculateIncomeTax(_grossSalary,2000f,_minTax, _maxTax));
        System.out.printf("Net Pay: %.2f%n", (_grossSalary - _incomePayableTax));
        System.out.println();
        System.out.println(endLine);
    }
}

// Report line headers utilities

class Centralizador {

    public static String centralizarString(String entrada, int lineLen) {
        int comprimentoTotal = lineLen;

        if (entrada.length() >= comprimentoTotal) {
            // Se a entrada já for mais longa ou igual ao comprimento desejado,
            // simplesmente retorne a entrada sem modificação
            return entrada;
        } else {
            int espacosAntes = (comprimentoTotal - entrada.length()) / 2;
            int espacosDepois = comprimentoTotal - entrada.length() - espacosAntes;

            // Construa a nova string centralizada com "*"
            StringBuilder centralizado = new StringBuilder();
            for (int i = 0; i < espacosAntes; i++) {
                centralizado.append("*");
            }
            centralizado.append(entrada);
            for (int i = 0; i < espacosDepois; i++) {
                centralizado.append("*");
            }

            return centralizado.toString();
        }
    }
}