/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import model.LopHoc;
import newpackage.DatabaseHelper;
import model.LopHoc2;
/**
 *
 * @author xuuan
 */
public class TestDB {
    public static void main(String[] args) {
        Connection conn = DatabaseHelper.getDBConnection();
        LopHoc2 lp2 = new LopHoc2();
        if(conn != null){
            System.out.println("Ket noi thanh cong");
            //add
            LopHoc lop1 = new LopHoc("CNPM2", "Cong nghe phan mem 2");
            lp2.add(lop1);
        } else {
            System.out.println("Ket noi that bai");
        }
    }
}
