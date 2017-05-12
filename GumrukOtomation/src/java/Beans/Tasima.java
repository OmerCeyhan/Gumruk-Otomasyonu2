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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
@ManagedBean(name = "tasima")
@SessionScoped
public class Tasima implements Serializable {

    private int siraNo;
    private String plaka;
    private String pasaportNo;
    private String yukCinsi;
    private String miktar;
    private String olcuBirimi;
    private String girisZamani;
    private String cikisZamani;
    private String geldigiYer;
    private String gidecegiYer;
    private String memurTC;

    @ManagedProperty(value = "#{personel}")
    Personel personel;

    @ManagedProperty(value = "#{arac}")
    Arac arac;

    @ManagedProperty(value = "#{surucu}")
    Surucu surucu;

    public String tasimaEkle() throws SQLException, NamingException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");

            String sql = "INSERT INTO TASIMA (Plaka, Pasaport_No, Yuk_Cinsi, Miktar, Olcu_Birimi, Giris_Zamani, Cikis_Zamani, Geldigi_Yer, Gidecegi_Yer, Memur_TC) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
//FOREIGN KEY (Plaka) REFERENCES ARAC(Plaka)
            // ps.setInt(1, getSiraNo());
            ps.setString(1, arac.getPlaka());
            ps.setString(2, surucu.getPasaportNo());
            ps.setString(3, getYukCinsi());
            ps.setString(4, getMiktar());
            ps.setString(5, getOlcuBirimi());
            ps.setString(6, getGirisZamani()); //DATEFIELD
            ps.setString(7, getCikisZamani()); //DATEFIELD
            ps.setString(8, getGeldigiYer());
            ps.setString(9, getGidecegiYer());
            ps.setString(10, personel.getTcKimlik());

            ps.executeUpdate();
            System.out.println("SQL executed...");
        } catch (SQLException e) {
            System.err.println(e);
        }
        return "index?faces-redirect=true";
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    
    public ResultSet girisCikisSorgu(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");
           PreparedStatement ps = con.prepareStatement(
                    "select * from arac,tasima where Giris_Zamani=? and Cikis_Zamani=? and Geldigi_yer=? and Gidecegi_Yer=? and plaka=?");
            ps.setString(1, getGirisZamani());
            ps.setString(1, getCikisZamani());
            ps.setString(1, getGeldigiYer());
            ps.setString(1, getGidecegiYer());
            ps.setString(1, arac.getPlaka());
  
  
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
    
    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public Surucu getSurucu() {
        return surucu;
    }

    public void setSurucu(Surucu surucu) {
        this.surucu = surucu;
    }

    public int getSiraNo() {
        return siraNo;
    }

    public void setSiraNo(int sıraNo) {
        this.siraNo = sıraNo;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getPasaportNo() {
        return pasaportNo;
    }

    public void setPasaportNo(String pasaportNo) {
        this.pasaportNo = pasaportNo;
    }

    public String getYukCinsi() {
        return yukCinsi;
    }

    public void setYukCinsi(String yukCinsi) {
        this.yukCinsi = yukCinsi;
    }

    public String getMiktar() {
        return miktar;
    }

    public void setMiktar(String miktar) {
        this.miktar = miktar;
    }

    public String getOlcuBirimi() {
        return olcuBirimi;
    }

    public void setOlcuBirimi(String olcuBirimi) {
        this.olcuBirimi = olcuBirimi;
    }

    public String getGirisZamani() {
        return girisZamani;
    }

    public void setGirisZamani(String girisZamani) {
        this.girisZamani = girisZamani;
    }

    public String getCikisZamani() {
        return cikisZamani;
    }

    public void setCikisZamani(String cikisZamani) {
        this.cikisZamani = cikisZamani;
    }

    public String getGeldigiYer() {
        return geldigiYer;
    }

    public void setGeldigiYer(String geldigiYer) {
        this.geldigiYer = geldigiYer;
    }

    public String getGidecegiYer() {
        return gidecegiYer;
    }

    public void setGidecegiYer(String gidecegiYer) {
        this.gidecegiYer = gidecegiYer;
    }

    public String getMemurTC() {
        return memurTC;
    }

    public void setMemurTC(String memurTC) {
        this.memurTC = memurTC;
    }

}
/*
CREATE TABLE ARAC (
    Plaka VARCHAR(50) NOT NULL,
    Arac_Cinsi VARCHAR(50) NOT NULL,
    Ulkesi VARCHAR(50) NOT NULL,
    Firma VARCHAR(50) NOT NULL,
    Model VARCHAR(50) NOT NULL,
    PRIMARY KEY (Plaka)
);

CREATE TABLE SURUCU (
    Pasaport_No VARCHAR(50) NOT NULL,
    Ad VARCHAR(50) NOT NULL,
    Soyad VARCHAR(50) NOT NULL,
    Uyruk VARCHAR(50) NOT NULL,
    PRIMARY KEY (Pasaport_No)
);

CREATE TABLE PERSONEL (
    TC VARCHAR(11) NOT NULL,
    Kullanici_Adi VARCHAR(50) NOT NULL,
    Sifre VARCHAR(50) NOT NULL,
    Personel_Adi VARCHAR(50) NOT NULL,
    Personel_Soyadi VARCHAR(50) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Adres VARCHAR(255) NOT NULL,
    Dogum_Tarihi VARCHAR(50) NOT NULL,
    Cinsiyet VARCHAR(5) NOT NULL,
    Personel_Turu VARCHAR(7) NOT NULL,
    Telefon VARCHAR(50) NOT NULL,
    PRIMARY KEY (TC)
);


CREATE TABLE TASIMA (
    Sira_No INT  NOT NULL auto_increment,
    Plaka VARCHAR(50) NOT NULL,
    Pasaport_No VARCHAR(50) NOT NULL,
    Yuk_Cinsi VARCHAR(50) NOT NULL,
    Miktar VARCHAR(50) NOT NULL,
    Olcu_Birimi VARCHAR(50) NOT NULL,
    Giris_Zamani VARCHAR(50) NOT NULL,
    Cikis_Zamani VARCHAR(50) NOT NULL,
    Geldigi_Yer VARCHAR(50) NOT NULL,
    Gidecegi_Yer VARCHAR(50) NOT NULL,
    Memur_TC VARCHAR(11) NOT NULL,
    PRIMARY KEY (Sira_No),
    FOREIGN KEY (Plaka) REFERENCES ARAC(Plaka),
    FOREIGN KEY (Pasaport_No) REFERENCES SURUCU(Pasaport_No)
);

CREATE TABLE IHBAR (
    Ihbar_No VARCHAR(50) NOT NULL,
    Plaka VARCHAR(50) NOT NULL,
    Ihbar_Sebebi VARCHAR(50) NOT NULL,
    Ihbar_Tarihi VARCHAR(50) NOT NULL,
    Ihbar_Sayisi INT NOT NULL,
    PRIMARY KEY (Ihbar_No)
    
);

CREATE TABLE Personel_GirisKontrol (
    Kullanici_Adi VARCHAR(50) NOT NULL,
    Tel VARCHAR(50) NOT NULL,
    Giris_Zamani DATE NOT NULL
);
*/