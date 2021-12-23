package com.aricalot.maven.control;

import com.aricalot.maven.view.StudentDisplay;

public class StudentController {
    StudentDisplay studentDisplay = new StudentDisplay();
    public void Student(){
        int menu = studentDisplay.studentMenu();
        switch (menu) {
            case 1: //add
                studentDisplay.studentInsert();
                break;
            case 2: //Edit
                studentDisplay.studentEdit();
                break;
            case 3: //Delete
                studentDisplay.studentDelete();
                break;
            case 4: //Display
                studentDisplay.studentDisplay();
                break;
            default:
                System.out.println("Please select form the menu.");
        }
    }
}
