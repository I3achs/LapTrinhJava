/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author xuuan
 */
public class LopHoc {
    private String MaLop, TenLop;

    public LopHoc() {
    }

    public LopHoc(String MaLop) {
        this.MaLop = MaLop;
    }

    public LopHoc(String MaLop, String TenLop) {
        this.MaLop = MaLop;
        this.TenLop = TenLop;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }
    
    
}
