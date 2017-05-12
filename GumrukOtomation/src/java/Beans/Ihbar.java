/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Brainiac
 */
@ManagedBean(name = "ihbar")
@SessionScoped
public class Ihbar implements Serializable {

    private String ihbarNo;
    private String plaka;
    private String ihbarSebebi;
    private String ihbarTarihi;
    private String ihbarSayisi;
    private String bulunacakIhbar;

    public String ihbarEkle() throws SQLException, NamingException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");

            String sql = "INSERT INTO IHBAR (Ihbar_No, Plaka, Ihbar_Sebebi, Ihbar_Tarihi, Ihbar_Sayisi) values(?, ?, ?, ?, ?)";//IHBAR TARIHI DATE FIELD.
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, getIhbarNo());
            ps.setString(2, getPlaka());
            ps.setString(3, getIhbarSebebi());
            ps.setString(4, getIhbarTarihi()); //IHBAR TARIHI DATE FIELD.
            ps.setString(5, getIhbarSayisi());

            ps.executeUpdate();
            System.out.println("SQL executed...");
        } catch (SQLException e) {
            System.err.println(e);
        }

        return "index?faces-redirect=true";
    }

    public String aracSil() throws SQLException, NamingException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");

            String sql = "DELETE FROM IHBAR WHERE Ihbar_No=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, getBulunacakIhbar());

            ps.executeUpdate();
            System.out.println("SQL executed...");
        } catch (SQLException e) {
            System.err.println(e);
        }

        return "index?faces-redirect=true";
    }
    
    public String ihbarliMi(){
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");
           PreparedStatement ps = con.prepareStatement(
                    "select * from ihbar where plaka=?");
            ps.setString(1, getPlaka());
  
  
            ResultSet rs = ps.executeQuery();
            System.out.println("SQL executed...");
            if (rs.next()) // found
            {
                return "ihbarBulundu?faces-redirect=true";
            }
            else {
                return "ihbarBulunamadi?faces-redirect=true";
            }     
            
          
        } catch (SQLException e) {
            System.err.println(e);
        }

        return "index?faces-redirect=true";
    }

    public String getBulunacakIhbar() {
        return bulunacakIhbar;
    }

    public void setBulunacakIhbar(String bulunacakIhbar) {
        this.bulunacakIhbar = bulunacakIhbar;
    }
    
    public String getIhbarNo() {
        return ihbarNo;
    }

    public void setIhbarNo(String ihbarNo) {
        this.ihbarNo = ihbarNo;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getIhbarSebebi() {
        return ihbarSebebi;
    }

    public void setIhbarSebebi(String ihbarSebebi) {
        this.ihbarSebebi = ihbarSebebi;
    }

    public String getIhbarTarihi() {
        return ihbarTarihi;
    }

    public void setIhbarTarihi(String ihbarTarihi) {
        this.ihbarTarihi = ihbarTarihi;
    }

    public String getIhbarSayisi() {
        return ihbarSayisi;
    }

    public void setIhbarSayisi(String ihbarSayisi) {
        this.ihbarSayisi = ihbarSayisi;
    }

}
