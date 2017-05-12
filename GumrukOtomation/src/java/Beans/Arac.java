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
import java.sql.Statement;
import java.sql.Time;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Brainiac
 */
@ManagedBean(name = "arac")
@SessionScoped
public class Arac implements Serializable{

    private String plaka;
    private String aracCinsi;
    private String ulkesi;
    private String firma;
    private String model;
    private String bulunacakArac;
    
    //jdbc:derby://localhost:1527/gumrukotomasyon [APP on APP]

    public String getBulunacakArac() {
        return bulunacakArac;
    }

    public void setBulunacakArac(String bulunacakArac) {
        this.bulunacakArac = bulunacakArac;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getAracCinsi() {
        return aracCinsi;
    }

    public void setAracCinsi(String aracCinsi) {
        this.aracCinsi = aracCinsi;
    }

    public String getUlkesi() {
        return ulkesi;
    }

    public void setUlkesi(String ulkesi) {
        this.ulkesi = ulkesi;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String aracEkle() throws SQLException, NamingException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");

            String sql = "INSERT INTO ARAC (Plaka, Arac_Cinsi, Ulkesi, Firma, Model) values(?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
  
            ps.setString(1, getPlaka());
            ps.setString(2, getAracCinsi());
            ps.setString(3, getUlkesi());
            ps.setString(4, getFirma());
            ps.setString(5, getModel());

            ps.executeUpdate();
            System.out.println("SQL executed...");
        } catch (SQLException e) {
            System.err.println(e);
        }

        return "index?faces-redirect=true";
        // check whether dataSource was injected by the server
        /*if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        // obtain a connection from the connection pool
        Connection connection = dataSource.getConnection();

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        }

        try {
            // create a PreparedStatement to insert a new address book entry
            PreparedStatement addEntry
                    = connection.prepareStatement("INSERT INTO ARAC (Plaka, Arac_Cinsi, Ulkesi, Firma, Model) values(?, ?, ?, ?, ?)");

            // specify the PreparedStatement's arguments
            addEntry.setString(1, getPlaka());
            addEntry.setString(2, getAracCinsi());
            addEntry.setString(3, getUlkesi());
            addEntry.setString(4, getFirma());
            addEntry.setString(5, getModel());

            addEntry.executeUpdate(); // insert the entry
            return "home"; // go back to index.xhtml home page
        } // end try
        finally {
            connection.close(); // return this connection to pool
        } // end finally

         */
    }

    public String aracSil() throws SQLException, NamingException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");

            String sql = "DELETE FROM ARAC WHERE Plaka=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, getBulunacakArac());

            ps.executeUpdate();
            System.out.println("SQL executed...");
        } catch (SQLException e) {
            System.err.println(e);
        }

        return "index?faces-redirect=true";
    }
    
    public ResultSet findArac(){
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");
           PreparedStatement ps = con.prepareStatement(
                    "select * from arac where plaka=?");
            ps.setString(1, getPlaka());
  
  
            ResultSet rs = ps.executeQuery();
            System.out.println("SQL executed...");
            if (rs.next()) // found
            {
                return rs;
            }     
            
          
        } catch (SQLException e) {
            System.err.println(e);
        }

        return null;
    }
}
