package com.aricalot.maven.view;

import com.aricalot.maven.dao.SchoolDao;
import com.aricalot.maven.domain.School;
import java.util.Scanner;

public class SchoolDisplay {
    Scanner sc = new Scanner(System.in);
    Scanner s = new Scanner(System.in);
    SchoolDao schoolDao = new SchoolDao();
    public int schoolMenu(){
        System.out.print("1. Add School\n2. Edit School\n3. Delete School\n4. Display Schools\n"+
                "Select what you want to do: ");
        return sc.nextInt();
    }

    public School schoolData(){
        System.out.print("School Name: ");
        String schoolName = s.nextLine();
        System.out.print("School Location: ");
        String address = sc.nextLine();
        System.out.print("School Contact No: ");
        int contact = sc.nextInt();
        System.out.print("School Name: ");
        String schoolLogo = s.nextLine();
        return new School(schoolName,address,contact,schoolLogo);
    }

    public void schoolInsert(){
        School school = schoolData();
        if (school != null)
            schoolDao.insert(school);
    }

    public void schoolEdit(){
        System.out.print("Which school do you want to Edit?\nSchool ID: ");
        int id = sc.nextInt();
        boolean found = schoolDao.search(id);
        if (!found) {
            System.out.println("School ID: "+ id +" not Found!");
        } else {
            School school = schoolData();
            if (school != null)
                schoolDao.update(school);
        }
    }

    public void schoolDelete(){
        System.out.println("which school do you want to delete?");
        int id = sc.nextInt();
        boolean found = schoolDao.search(id);
        if (!found) {
            System.out.println("School ID "+ id +" not Found!");
        } else {
            schoolDao.delete(id);
        }
    }

    public void schoolDisplay(){
        System.out.println("1. Ascending \n2. Descending ");
        int sortOrder = sc.nextInt();
        if (sortOrder == 1 || sortOrder == 2){
            schoolDao.findAll(sortOrder);
        }
        else {
            System.out.println("Please select from menu.");
        }

    }

}
