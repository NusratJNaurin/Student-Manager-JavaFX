package com.example.studentmanager;

import java.util.ArrayList;
import java.util.Collections;

public class TestApp {
    public static ArrayList<Student> students = new ArrayList<>();
    static void main() {
        Student s1 = new Student("Ayesha Khan","Computer Science",3.6);
        Student s2 = new Student("Sara Albuainain","Computer Science",3.2);
        Student s3 = new Student("Fatima Khanam","Computer Engineering",4);
        Student s4 = new Student("Afra Sayem","Mechatronics",3.8);

        Collections.addAll(students, s1, s2, s3, s4);
        for (Student s: students) System.out.println(s);
    }
}
