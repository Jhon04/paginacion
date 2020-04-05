package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con = null;
    
    public  Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagination?useSSL=false", "root", "alumno");
            return con;
        } catch (Exception ex) {
            System.out.println("Error En La Conexion" + ex.getMessage());
            return con;
        }
    }
}
