/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author xuuan
 */
public class DatabaseHelper {
    public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=test;user=sa;password=11111;"
            + " encrypt=true;trustServerCertificate=true";
    public static Connection getDBConnection(){
        Connection conn = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e){
            System.out.println("Chua co driver!"+e.toString());
        }
        try{
            conn = DriverManager.getConnection(connectionUrl);
            return conn;
        } catch (Exception e){
            System.out.println("Loi connect"+e.toString());
        }
        return null;
    }
}
