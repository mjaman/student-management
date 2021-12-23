package com.aricalot.maven.view;

import java.util.Scanner;

public class Display {
    Scanner sc = new Scanner(System.in);

    public int mainMenu(){
        System.out.print("1. School\n2. Student\nWhich table do you want to operate on:");
        return sc.nextInt();
    }

    public String displayRepeat(){
        System.out.print("Do you want run the operation again? (Y/N): ");
        return sc.next();
    }
}
