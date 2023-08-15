package JFT6;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
The following table shows the grades that a teacher could give a student on a test.
• Create a Java program, which contains a variable storing a student’s grade.
• The variable should be of type float. Store a value of 45.00.
• Determine the appropriate grade.
• Save the program as JFT6Ex8.java

A 85 – 100%
B 70 – 84%
C 55 – 69%
D 40 – 54%
E 25 – 39%
F 10 – 24%
No Grade 0 – 9% 
 */

public class JFT6Ex8 {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        String repeated = new String(new char[20]).replace("\0", "*");
        String repeated_blank = new String(new char[10]).replace("\0", " ");
        
        Boolean active = true;

        Student s1 = new Student("Théo", "Matteucci");
        Student s2 = new Student("Sarah", "Matteucci");
        Student s3 = new Student("Bruno", "Silva");
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        ArrayList<Course> courses = new ArrayList<>();
        Course filosofia = new Course("Filosofia", "Antonio Matteucci");
        Course sociologia = new Course("Sociologia", "Antonio Matteucci");
        filosofia.setStudentsList(students);
        filosofia.setQtyGrades(3);
        sociologia.setStudentsList(students);
        sociologia.setQtyGrades(3);
        
        courses.add(filosofia);
        courses.add(sociologia);

        // Generate Grades for each course in course array.
        for (Course c : courses){
            // Generate Grades
            c.insertGrade(generateGrade(c.students, c));
        }

        while (active){
            
            System.out.println(repeated + "Bem-vindo ao nosso Sistema de Gestão Escolar!" + repeated);
            System.out.println(repeated + "Cadastro dos Estudantes " + repeated);
            System.out.println();
            System.out.println("Resumo: Cursos: " + courses.size());
            System.out.println("Insira o comando: ");
            System.out.println("Para ver o resumo de todos os cursos 'R'," + 
                            "\npara ver o resumo de um curso 'RE' e" + 
                            "\npara sair digite 'S'.");
            
            String inputStr = scanner.next();
            System.out.println();
            scanner.nextLine();
            
            
            switch (inputStr) {
                case "R":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Resumo de cursos");
                    System.out.println(repeated + repeated + repeated);
                    resumeAllCourses(courses);                    
                    break;
                case "RE":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Resumo por curso");
                    System.out.println(repeated + repeated + repeated);
                    System.out.println();
                    resumeCourse(courses);
                    break;
                case "S":
                    active = false;
                    System.out.println("Obrigado pela preferência! Até breve.");
                    break;

                default:
                    break;
            
            }
        
        }
        scanner.close();
    }

    private static Date parseStringToDate(String date){
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data = formatoData.parse(date);
            return data;
        } catch (ParseException e) {
            System.out.println("Erro ao converter a data. Verifique o formato da String (dd/MM/yyyy).");
            return null;
        }

    }
    // Gerando notas automaticamente. For test purpose only.
    private static ArrayList<Grade> generateGrade(ArrayList<Student> students, Course course){
        Random random = new Random();
        ArrayList<Grade> gr = new ArrayList<>();
        for (Student student : students){
            for (int i = 0; i < course.qtyGrades; i++){
                int rd = random.nextInt(100);
                Grade grade = new Grade(i + 1, 
                                        "obj" + (i + 1), 
                                        course.id, 
                                        student.id, 
                                        (float) (rd / 100f));
                // System.out.println("Nota: " + grade.grade);
                gr.add(grade);
            }
        }
        //System.out.println("Qty. Grades registred: " + gr.size());
        return gr;
    }

    private static void resumeAllCourses(ArrayList<Course> courses){
        String repeated_blank = new String(new char[10]).replace("\0", " ");
        for (Course c : courses){
            float average = generateFloatGeneralCourseAverage(c.grades);
            System.out.println("Course name: " + c.courseName + repeated_blank +
                                "Students qty.: " + c.students.size() + repeated_blank +
                                "Grades Average: " + average + repeated_blank +
                                "Concept Average: " + generateConcept(average));
        }
    }

    private static void resumeCourse(ArrayList<Course> courses){
        String repeated_blank = new String(new char[10]).replace("\0", " ");
        String repeated = new String(new char[20]).replace("\0", "*");
        for (Course c : courses){
            float average = generateFloatGeneralCourseAverage(c.grades);
            System.out.println("Course id: " + c.id + repeated_blank +
                                "Course name: " + c.courseName + repeated_blank +
                                "Students qty.: " + c.students.size() + repeated_blank +
                                "Concept Average: " + generateConcept(average));
        }
        System.out.println();
        System.out.print("Insira o id do curso para proceguir: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        //scanner.close();
        for (Course c : courses){
            if (c.id == option){
                System.out.println(repeated + repeated + repeated);
                System.out.println("Course Name: " + c.courseName + repeated_blank +
                                    "Teacher Name: " + c.teacherName + repeated_blank);
                System.out.println(repeated + repeated + repeated);
                System.out.println(repeated + "Students List" + repeated);
                System.out.println();
                for (Student student : c.students){
                    float studentAverage = generateFloatGeneralCourseAverage(
                                        c.getGradesArrayByStudentId(student.id));
                    System.out.println("id: " + student.id + repeated_blank +
                                "Name: " + student.firstName + " " + student.lastName + repeated_blank +
                                "Grades qty.: " + c.getGradesArrayByStudentId(student.id).size() + repeated_blank +
                                "Average: " + studentAverage + repeated_blank +
                                "Concept: " + generateConcept(studentAverage));
                }
            }
        }
        System.out.println();
    }

    private static float generateFloatGeneralCourseAverage(ArrayList<Grade> grades){
        float gradeValue = 0;
        for (Grade gr : grades){
            gradeValue += gr.grade;
        }
        return (gradeValue / grades.size());
    }

    private static String generateConcept(float gradeValue){
        if (gradeValue >= 0.85f){
            return (String) "A"; 
        } else if (gradeValue >= 0.7f & gradeValue <= 0.84f){
            return (String) "B";
        } else if (gradeValue >= 0.55f & gradeValue <= 0.69f){
            return (String) "C";
        } else if(gradeValue >= 0.4f & gradeValue <= 0.54f){
            return (String) "D";
        } else if(gradeValue >= 0.25f & gradeValue <= 0.39f){
            return (String) "E";
        } else if(gradeValue >= 0.1f & gradeValue <= 0.24f){
            return (String) "F";
        } else {
            return (String) "No grade";
        }
    }
}

class Student{
    String firstName;
    String lastName;
    int id;

    public Student(String firstName, String lastName){
        Random random = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = random.nextInt(100_000);
    }

    public String getStudentName(){
        return (String) this.firstName + " " + this.lastName;
    }

    public int getStudentId(){
        return this.id;
    }
}

class Course{
    Random random = new Random();
    String courseName;
    String teacherName;
    int qtyGrades;
    ArrayList<Student> students;
    int id = random.nextInt(100_000);
    ArrayList<Grade> grades; 

    public Course(String courseName, String teacherName){
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

    public void setQtyGrades(int qtyGrades){
        this.qtyGrades = qtyGrades;
    }

    public void setStudentsList(ArrayList<Student> students){
        this.students = students;
    }

    public int getCourseId(){
        return this.id;
    }

    public void insertGrade(ArrayList<Grade> grades){
        this.grades = grades;
    }

    public int getGradesQtyByStudentId(int studentId){
        int qtyGrades = 0;
        for (Student student : this.students){
            if (student.id == studentId){
                for (Grade gr : this.grades){
                    if (gr.studentId == student.id & gr.courseId == this.id){
                        qtyGrades++;
                    }
                }
            }
        }
        return qtyGrades;
    }

    public ArrayList<Grade> getGradesArrayByStudentId(int studentId){
        ArrayList<Grade> gradesByStudents = new ArrayList<>();
        for (Student student : this.students){
            if (student.id == studentId){
                for (Grade gr : this.grades){
                    if (gr.studentId == student.id & gr.courseId == this.id){
                        gradesByStudents.add(gr);
                    }
                }
            }
        }
        return gradesByStudents;
    }
}

class Grade{
    float grade;
    int id;
    String name;
    int courseId;
    int studentId;

    public Grade(int id, String name, int courseId, int studentId, float grade){
        this.grade = grade;
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public float getGrade(){
        return this.grade;
    }
}
