/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import newpackage.DatabaseHelper;

/**
 *
 * @author xuuan
 */
public class LopHoc2 {
    Connection conn = null;
    PreparedStatement sttm = null;
    public int add(LopHoc lop){
        try{
            String sSQL = "insert LopHoc(MaLop, TenLop)" +
                            "values (?,?)";
            conn = DatabaseHelper.getDBConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, lop.getMaLop());
            sttm.setString(2, lop.getTenLop());
            if(sttm.executeUpdate()>0){
                System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e){
            System.out.println("Error: "+e.toString());
        }
        return 0;
    }
}
