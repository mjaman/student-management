package com.aricalot.usingMaven;

import com.aricalot.usingMaven.domain.Student;
import java.sql.*;
import java.util.ArrayList;

public class StudentManage {
    Connection conn = null;
    public void connectDatabase(){
        final String dbURL = "jdbc:mysql://localhost:3306/student_data";
        final String dbUsername = "root";
        final String dbPassword = "";
        try {
            conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void insertIntoStudent(String name, int age, int grade, String school) {
        try {
            connectDatabase();
            String insertSQL = "INSERT INTO students (name,age, class, school) VALUES (?, ?, ? ,?)" ;

            PreparedStatement pst = conn.prepareStatement(insertSQL);
            pst.setString(1,name);
            pst.setInt(2,age);
            pst.setInt(3,grade);
            pst.setString(4,school);

            int rows = pst.executeUpdate();

            if (rows > 0 ){
                System.out.println("New Student Added");
            }
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Student> selectFromStudent(int order){
        ArrayList<Student> al = new ArrayList<>();
        Student studentData;
        try{
            connectDatabase();
            String selectSQL = null;
            if (order == 1){
                System.out.println("Students in Ascending order are: ");
                selectSQL = "SELECT * FROM students ORDER BY name asc";
            }else if(order == 2){
                System.out.println("Students in Descending order are: ");
                selectSQL = "SELECT * FROM students ORDER BY name desc";
            }
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(selectSQL);
            while (result.next()){
                studentData =  new Student(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getInt("age"),
                    result.getInt("class"),
                    result.getString("school")
                );
                al.add(studentData);
            }
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return al;
    }

    public boolean findStudent(int id){
        boolean found = false;
        String a ="''; show databases; truncate student";
        try{
            connectDatabase();
            String findSQL = "SELECT id,name FROM students WHERE id =?";
            PreparedStatement pst = conn.prepareStatement(findSQL);
            pst.setInt(1,id);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                found = true;
            }
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return found;
    }

    public void updateStudent(String name, int age, int grade, String school, int id){
        try{
            connectDatabase();
            String updateSQL = "UPDATE students SET name = ?, age = ?, class = ?, school = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(updateSQL);
            pst.setString(1,name);
            pst.setInt(2,age);
            pst.setInt(3,grade);
            pst.setString(4,school);
            pst.setInt(5,id);

            int rows = pst.executeUpdate();

            if (rows > 0 ){
                System.out.println("Student ID: " + id + " Updated");
            }
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteStudent(int id){
        try{
            connectDatabase();

            String deleteSQL = "DELETE FROM students WHERE id =?";
            PreparedStatement pst = conn.prepareStatement(deleteSQL);
            pst.setInt(1,id);
            int rows = pst.executeUpdate();
            if(rows>0){
                System.out.println("Student ID: " + id + " Deleted Successfully!");
            }
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }




}
