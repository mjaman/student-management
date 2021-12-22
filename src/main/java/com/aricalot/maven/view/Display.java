package com.aricalot.maven.view;

import com.aricalot.maven.dao.StudentDao;
import com.aricalot.maven.domain.Student;
import java.util.*;

public class Display {
    Scanner sc = new Scanner(System.in);
    Scanner s = new Scanner(System.in);
    StudentDao dbm = new StudentDao();

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
        dbm.insert(st);
    }

    public void studentEdit(){
        System.out.print("Which student do you want to Edit?\nStudent ID: ");
        int id = sc.nextInt();
        boolean found = dbm.find(id);
        if (!found) {
            System.out.println("Student ID: "+ id +" not Found!");
        } else {
            Student st = studentData();
            dbm.update(st);
        }
    }

    public void studentDelete(){
        System.out.println("which student do you want to delete?");
        int id = sc.nextInt();
        boolean found = dbm.find(id);
        if (!found) {
            System.out.println("Student ID "+ id +" not Found!");
        } else {
            dbm.delete(id);
        }
    }

    public void studentDisplay(){
        System.out.println("1. Ascending \n2. Descending ");
        int sortOrder = sc.nextInt();
        if (sortOrder == 1 || sortOrder == 2){
            ArrayList<Object> o = dbm.findAll(sortOrder);
            System.out.println(o.size());
            o.forEach(i->{
//            ListIterator<Student> li = al.listIterator();
//            int i = 1;
//            while (li.hasNext()){
                System.out.println(((Student)i).toString());
//                i++;
            });
        }
        else {
            System.out.println("Please select from menu.");
        }

    }


}
