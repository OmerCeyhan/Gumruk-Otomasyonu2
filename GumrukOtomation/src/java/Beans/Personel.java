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
@ManagedBean(name = "personel")
@SessionScoped
public class Personel implements Serializable{

    private String tcKimlik;
    private String kullaniciAdi;
    private String sifre;
    private String personelAdi;
    private String personelSoyadi;
    private String email;
    private String adres;
    private String dogumTarihi; //DATEFIELD
    private String cinsiyet;
    private String personelTuru;
    private String telefon;

    public String personelEkle() throws SQLException, NamingException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");

            String sql = "INSERT INTO PERSONEL (TC, Kullanici_Adi, Sifre, Personel_Adi, Personel_Soyadi, Email, Adres, Dogum_Tarihi, Cinsiyet, Personel_Turu, Telefon) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, getTcKimlik());
            ps.setString(2, getKullaniciAdi());
            ps.setString(3, getSifre());
            ps.setString(4, getPersonelAdi());
            ps.setString(5, getPersonelSoyadi());
            ps.setString(6, getEmail());
            ps.setString(7, getAdres());
            ps.setString(8, getDogumTarihi()); //DATEFIELD
            ps.setString(9, getCinsiyet());
            ps.setString(10, getPersonelTuru());
            ps.setString(11, getTelefon());

            ps.executeUpdate();
            System.out.println("SQL executed...");
        } catch (SQLException e) {
            System.err.println(e);
        }

        return "index?faces-redirect=true";

    }

    public String getTcKimlik() {
        return tcKimlik;
    }

    public void setTcKimlik(String tcKimlik) {
        this.tcKimlik = tcKimlik;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getPersonelAdi() {
        return personelAdi;
    }

    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }

    public String getPersonelSoyadi() {
        return personelSoyadi;
    }

    public void setPersonelSoyadi(String personelSoyadi) {
        this.personelSoyadi = personelSoyadi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getPersonelTuru() {
        return personelTuru;
    }

    public void setPersonelTuru(String personelTuru) {
        this.personelTuru = personelTuru;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
