package JFT2;
/*
    Write a Java program to determine the average age of five students who are attending a training
    course. Let’s assume the ages are: 24 45 21 52 30 (note, the answer is 34).
*/

import java.util.ArrayList;

public class JFT2Ex5 {
    public static void main(String[] args){
        
        int[] studentAges = {24, 45, 21, 52, 30};
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < studentAges.length; i++){
            Student student = new Student();
            student.setAge(studentAges[i]);
            students.add(student);
        }
        int ageSum = 0;
        for (int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            ageSum += (int) student.getAge();
        }
        int ageAverage = (int) (ageSum / students.size()); 
        System.out.println("The average age of all students is: " + ageAverage);

    }
}

class Student{
    private int age;

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
}
