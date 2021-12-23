package com.aricalot.maven;

import com.aricalot.maven.control.SchoolController;
import com.aricalot.maven.control.StudentController;
import com.aricalot.maven.view.Display;
import com.aricalot.maven.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        String exit = "Y";
        Display display = new Display();
        int mainMenu = display.mainMenu();

        while (exit.equalsIgnoreCase("Y")) {

            SchoolController schoolController = new SchoolController();
            StudentController studentController = new StudentController();
            switch (mainMenu){
                case 1:
                    schoolController.School();
                    break;
                case 2:
                    studentController.Student();
                    break;
                default:
                    System.out.println("select form menu");
            }


            exit = display.displayRepeat();
        }
        System.out.println("Thank You!!");
        Connection connection = ConnectionFactory.getInstance();
        connection.close();
    }
}