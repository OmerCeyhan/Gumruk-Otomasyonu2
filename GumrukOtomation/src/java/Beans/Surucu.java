/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Brainiac
 */
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
@ManagedBean(name = "surucu")
@SessionScoped
public class Surucu implements Serializable{

  

    private String pasaportNo;
    private String ad;
    private String soyad;
    private String uyruk;
    
    public String surucuEkle() throws SQLException, NamingException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");

            String sql = "INSERT INTO SURUCU (Pasaport_No, Ad, Soyad, Uyruk) values(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, getPasaportNo());
            ps.setString(2, getAd());
            ps.setString(3, getSoyad());
            ps.setString(4, getUyruk());
            

            ps.executeUpdate();
            System.out.println("SQL executed...");
        } catch (SQLException e) {
            System.err.println(e);
        }

        return "index?faces-redirect=true";
    }
    
    
    public String getPasaportNo() {
        return pasaportNo;
    }

    public void setPasaportNo(String pasaportNo) {
        this.pasaportNo = pasaportNo;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getUyruk() {
        return uyruk;
    }

    public void setUyruk(String uyruk) {
        this.uyruk = uyruk;
    }
    
}

