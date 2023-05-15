package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insert(Student st) {
        try{

            Connection con = Connector.connect();
            String query = "insert into student_info(sname,sphone,sdept) values(?,?,?)";
            //Prepared Statement
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1,st.getSname());
            pstmt.setString(2,st.getSphone());
            pstmt.setString(3,st.getSdept());

            //execute statement
            pstmt.executeUpdate();
            return true;
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete(int usid) {
        try{

            Connection con = Connector.connect();
            String query = "delete from student_info where sid = ?";
            //Prepared Statement
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1,usid);

            //execute statement
            pstmt.executeUpdate();
            return true;
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void display() {
        try{

            Connection con = Connector.connect();
            String query = "select * from student_info";
            //Simple Statement
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery(query);

            if(result == null){
                System.out.println("Returned an empty set from Database!!!!!");
            } else {
                while (result.next()) {
                    System.out.println("Student ID: " + result.getInt("sid"));
                    System.out.println("Student Name: " + result.getString("sname"));
                    System.out.println("Contact No: " + result.getString("sphone"));
                    System.out.println("Student Dept: " + result.getString("sdept"));

                    System.out.println("----------------------------------------------");
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean update(Student st,int sid) {
        try{

            Connection con = Connector.connect();
            String query = "update student_info set sname=?, sphone=?, sdept=? where sid=?";
            //Prepared Statement
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1,st.getSname());
            pstmt.setString(2,st.getSphone());
            pstmt.setString(3,st.getSdept());
            pstmt.setInt(4,sid);

            //execute statement
            pstmt.executeUpdate();
            return true;
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
