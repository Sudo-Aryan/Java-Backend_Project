package com.student.manage;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    static Connection con;
    public static Connection connect(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String url = "jdbc:mysql://localhost:3306/student_manage";
            String pass = "root";

            con = DriverManager.getConnection(url,user,pass);
        } catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
