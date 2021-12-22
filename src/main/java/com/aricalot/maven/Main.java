package com.aricalot.maven;

import com.aricalot.maven.dao.ConnectionFactory;
import com.aricalot.maven.view.Display;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        String exit = "Y";
        while (exit.equalsIgnoreCase("Y")) {
            Display display = new Display();

            int menu = display.displayMenu();
            switch (menu) {
                case 1: //add
                    display.studentInsert();
                    break;
                case 2: //Edit
                    display.studentEdit();
                    break;
                case 3: //Delete
                    display.studentDelete();
                    break;
                case 4: //Display
                    display.studentDisplay();
                    break;
                default:
                    System.out.println("Please select form the menu.");
            }
            exit = display.displayRepeat();
        }
        System.out.println("Thank You!!");
        Connection connection = ConnectionFactory.getInstance();
        connection.close();
    }
}