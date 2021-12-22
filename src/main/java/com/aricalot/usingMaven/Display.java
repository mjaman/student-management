package com.aricalot.usingMaven;

import com.aricalot.usingMaven.domain.Student;
import java.util.*;

public class Display {
    Scanner sc = new Scanner(System.in);
    Scanner s = new Scanner(System.in);
    StudentManage sm = new StudentManage();

    public int displayMenu(){
        System.out.print("1. Add Names\n2. Edit Names\n3. Delete Names\n4. Display Names\n"+
                "Select what you want to do: ");
        return sc.nextInt();
    }

    public String displayRepeat(){
        System.out.print("Do you want run the operation again? (Y/N): ");
        return sc.next();
    }

    public Student studentData(){
        System.out.print("Enter Student Name: ");
        String name = s.nextLine();
        System.out.print("Enter Student Age: ");
        int age = sc.nextShort();
        System.out.print("Enter Student Class: ");
        int grade = sc.nextShort();
        System.out.print("Enter Student School: ");
        String school = s.nextLine();
        return new Student(name,age,grade,school);
    }

    public void studentInsert(){
        Student st = studentData();
        sm.insertIntoStudent(st.getName(),st.getAge(),st.getGrade(),st.getSchool());
    }

    public void studentEdit(){
        System.out.print("Which student do you want to Edit?\nStudent ID: ");
        int id = sc.nextInt();
        boolean found = sm.findStudent(id);
        if (!found) {
            System.out.println("Student ID: "+ id +" not Found!");
        } else {
            Student st = studentData();
            sm.updateStudent(st.getName(),st.getAge(),st.getGrade(),st.getSchool(),id);
        }
    }

    public void studentDelete(){
        System.out.println("which student do you want to delete?");
        int id = sc.nextInt();
        boolean found = sm.findStudent(id);
        if (!found) {
            System.out.println("Student ID "+ id +" not Found!");
        } else {
            sm.deleteStudent(id);
        }
    }

    public void studentDisplay(){
        System.out.println("1. Ascending \n2. Descending ");
        int order = sc.nextInt();
        if (order == 1 || order == 2){
            ArrayList<Student> al = sm.selectFromStudent(order);
            ListIterator<Student> li = al.listIterator();
            int i = 1;
            while (li.hasNext()){
                System.out.println(i+". "+li.next());
                i++;
            }
        }
        else {
            System.out.println("Please select from menu.");
        }

    }


}
