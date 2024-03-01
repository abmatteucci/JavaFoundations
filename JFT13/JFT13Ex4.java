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

        Employee employee = new Employee();
        employee.generateReport();

        

    }
    
}

class Employee {

    private static int employeeId = 0;
    private int id;
    private String name;
    private String ppsNo;
    private String department;
    private float workedWeekHours = 0;
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

    private static float calculateTax(float weekSalary, float weeklyAmountSelector, float incomeTaxMin, float incomeTaxMax){
        if (weekSalary > weeklyAmountSelector){
            return weekSalary * incomeTaxMax;
        } else {
            return weekSalary * incomeTaxMin;
        }
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

    // Methods



    public void generateReport(){
        // String decorateTitle = new String(new char[20]).replace("\0", "*");
        String title = Centralizador.centralizarString(" Teste ", 60);

        System.out.println(title);
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