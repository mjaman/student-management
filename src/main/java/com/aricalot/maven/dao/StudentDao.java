package com.aricalot.maven.dao;

import com.aricalot.maven.domain.Student;
import java.sql.*;
import java.util.ArrayList;

public class StudentDao implements BaseDao {
    Connection conn = null;

    @Override
    public void insert(Object o) {
        Student s = (Student) o;
        try {
            conn = ConnectionFactory.getInstance();
            String insertSQL = "INSERT INTO students (name,age, class, school_id) VALUES (?, ?, ? ,?)" ;

            PreparedStatement pst = conn.prepareStatement(insertSQL);
            pst.setString(1,s.getName());
            pst.setInt(2,s.getAge());
            pst.setInt(3,s.getGrade());
            pst.setInt(4,s.getSchool_id());

            int rows = pst.executeUpdate();

            if (rows > 0 ){
                System.out.println("Student Added");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Object o) {
        Student s = (Student) o;
        try{
            conn = ConnectionFactory.getInstance();
            String updateSQL = "UPDATE students SET name = ?, age = ?, class = ?, school_id = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(updateSQL);
            pst.setString(1,s.getName());
            pst.setInt(2,s.getAge());
            pst.setInt(3,s.getGrade());
            pst.setInt(4,s.getSchool_id());
            pst.setInt(5,s.getId());

            int rows = pst.executeUpdate();

            if (rows > 0 ){
                System.out.println("Student ID: " + s.getId() + " Updated");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Object o) {
        Student s = (Student) o;
        try{
            conn = ConnectionFactory.getInstance();

            String deleteSQL = "DELETE FROM students WHERE id =?";
            PreparedStatement pst = conn.prepareStatement(deleteSQL);
            pst.setInt(1,s.getId());
            int rows = pst.executeUpdate();
            if(rows>0){
                System.out.println("Student ID: " + s.getId() + " Deleted Successfully!");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Boolean search(int id){
        boolean found = false;
        try{
            conn = ConnectionFactory.getInstance();
            String findSQL = "SELECT id,name FROM students WHERE id =?";
            PreparedStatement pst = conn.prepareStatement(findSQL);
            pst.setInt(1,id);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                found = true;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return found;
    }

    @Override
    public ArrayList<Object> findAll(int sortOrder) {
        ArrayList<Object> al = new ArrayList<>();
        Student studentData;
        try{
            conn = ConnectionFactory.getInstance();
            String order = "asc";

            if (sortOrder == 1){
                System.out.println("Students in Ascending order are: ");

            }else if(sortOrder == 2){
                System.out.println("Students in Descending order are: ");
                order = "desc";
            }
//            String selectSQL = "SELECT * FROM students ORDER BY name " + order;
            String selectSQL = "SELECT st.id,st.name,st.age,st.class,sc.name AS 'school name'FROM students st JOIN schools sc ON st.school_id = sc.id ORDER BY name " + order;
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(selectSQL);
            while (result.next()){
                studentData =  new Student(
                        result.getInt("id"),
                        result.getString("st.name"),
                        result.getInt("age"),
                        result.getInt("class"),
                        result.getString("school name")
                );
                System.out.println(studentData);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return al;
    }
}
