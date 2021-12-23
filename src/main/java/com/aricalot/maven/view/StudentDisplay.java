package com.aricalot.maven.view;

import com.aricalot.maven.dao.SchoolDao;
import com.aricalot.maven.dao.StudentDao;
import com.aricalot.maven.domain.Student;
import java.util.Scanner;

public class StudentDisplay {
    Scanner sc = new Scanner(System.in);
    Scanner s = new Scanner(System.in);
    StudentDao studentDao = new StudentDao();
    SchoolDao schoolDao = new SchoolDao();

    public int studentMenu(){
        System.out.print("1. Add Student\n2. Edit Student\n3. Delete Student\n4. Display Students\n"+
                "Select what you want to do: ");
        return sc.nextInt();
    }

    public Student studentData(){
        System.out.print("Enter Student Name: ");
        String name = s.nextLine();
        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();
        System.out.print("Enter Student Class: ");
        int grade = sc.nextInt();
        System.out.print("Enter Student School_id: ");
        int school_id = s.nextInt();
        if (schoolDao.search(school_id))
            return new Student(name,age,grade,school_id);
        else
            System.out.println("School Id: "+ school_id + " not found in School.");

        return null;
    }

    public void studentInsert(){
        Student student = studentData();
        if (student != null)
            studentDao.insert(student);
    }

    public void studentEdit(){
        System.out.print("Which student do you want to Edit?\nStudent ID: ");
        int id = sc.nextInt();
        boolean found = studentDao.search(id);
        if (!found) {
            System.out.println("Student ID: "+ id +" not Found!");
        } else {
            Student student = studentData();
            if (student != null)
                studentDao.update(student);
        }
    }

    public void studentDelete(){
        System.out.println("which student do you want to delete?");
        int id = sc.nextInt();
        boolean found = studentDao.search(id);
        if (!found) {
            System.out.println("Student ID "+ id +" not Found!");
        } else {
            studentDao.delete(id);
        }
    }

    public void studentDisplay(){
        System.out.println("1. Ascending \n2. Descending ");
        int sortOrder = sc.nextInt();
        if (sortOrder == 1 || sortOrder == 2){
            studentDao.findAll(sortOrder);
        }
        else {
            System.out.println("Please select from menu.");
        }

    }
}
