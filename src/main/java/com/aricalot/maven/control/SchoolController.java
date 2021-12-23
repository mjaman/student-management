package com.aricalot.maven.control;

import com.aricalot.maven.view.SchoolDisplay;

public class SchoolController {
    public void School(){
        SchoolDisplay schoolDisplay = new SchoolDisplay();
        int menu = schoolDisplay.schoolMenu();
        switch (menu) {
            case 1: //add
                schoolDisplay.schoolInsert();
                break;
            case 2: //Edit
                schoolDisplay.schoolEdit();
                break;
            case 3: //Delete
                schoolDisplay.schoolDelete();
                break;
            case 4: //Display
                schoolDisplay.schoolDisplay();
                break;
            default:
                System.out.println("Please select form the menu.");
        }
    }
}
