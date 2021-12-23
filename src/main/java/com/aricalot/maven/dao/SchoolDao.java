package com.aricalot.maven.dao;

import com.aricalot.maven.domain.School;
import java.sql.*;
import java.util.ArrayList;

public class SchoolDao implements BaseDao {
    Connection conn = null;

    @Override
    public void insert(Object o) {
        School s = (School) o;
        try {
            conn = ConnectionFactory.getInstance();
            String insertSQL = "INSERT INTO school (name,address, contact, logo) VALUES (?, ?, ? ,?)" ;

            PreparedStatement pst = conn.prepareStatement(insertSQL);
            pst.setString(1,s.getName());
            pst.setString(2,s.getAddress());
            pst.setInt(3,s.getContact());
            pst.setString(4,s.getLogo());

            int rows = pst.executeUpdate();

            if (rows > 0 ){
                System.out.println("School Added");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Object o) {
        School s = (School) o;
        try{
            conn = ConnectionFactory.getInstance();
            String updateSQL = "UPDATE schools SET name = ?, age = ?, class = ?, school = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(updateSQL);
            pst.setString(1,s.getName());
            pst.setString(2,s.getAddress());
            pst.setInt(3,s.getContact());
            pst.setString(4,s.getLogo());
            pst.setInt(5,s.getId());

            int rows = pst.executeUpdate();

            if (rows > 0 ){
                System.out.println("School ID: " + s.getId() + " Updated");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Object o) {
        School s = (School) o;
        try{
            conn = ConnectionFactory.getInstance();

            String deleteSQL = "DELETE FROM schools WHERE id =?";
            PreparedStatement pst = conn.prepareStatement(deleteSQL);
            pst.setInt(1,s.getId());
            int rows = pst.executeUpdate();
            if(rows>0){
                System.out.println("School ID: " + s.getId() + " Deleted Successfully!");
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
            String findSQL = "SELECT id FROM schools WHERE id =?";
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
        School schoolData;
        try{
            conn = ConnectionFactory.getInstance();
            String selectSQL = null;
            if (sortOrder == 1){
                System.out.println("Schools in Ascending order are: ");
                selectSQL = "SELECT * FROM schools ORDER BY name asc";
            }else if(sortOrder == 2){
                System.out.println("Schools in Descending order are: ");
                selectSQL = "SELECT * FROM schools ORDER BY name desc";
            }
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(selectSQL);
            while (result.next()){
                schoolData =  new School(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("address"),
                        result.getInt("contact"),
                        result.getString("logo")
                );
                System.out.println(schoolData);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return al;
    }
}
