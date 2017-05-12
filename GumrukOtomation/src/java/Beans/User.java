/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//bu arada ben daha hala bizim db'nin hangi db olduğundan emin değilim. mysql değilse ne?
//güzel soru :D abi bi sn bi mysql kuralım açık arkada db demek istedim

/**
 * neyse dur da java db bağlantsına bakalım...
 * @author Brainiac
 */
@ManagedBean(name="user")
@SessionScoped
public class User {
//aslında zaten onu yapacağız. fakat bundan önce bi db'yi açmamız lazım ki set edilen değerleri db'ye yazalım. ben mi yanlış anlıyorum?
    //tamam kafandakini bi yapalım.. senin dediğini yapalım bi. connectionu açıp içine de veri kaydedemez miyiz aynı metodda?? yapabilliriz evet.
    //üstad java kodlarını metodun içine yazmamız lazım.. farketmez db bağlantısını burada da açabiliriz. benim bildiğim..bak napalım biliyomusn. set metodları çalışıyo şuanki örnekte.yani kaydet butonuna basınca set metodunu kullanıyo.bitanesinin içine user kaydı koyalım orada çalışssın
    
    private int id;
    private String isim;
    private String soyisim;
    private String email;
    private String kullaniciAdi;
    private String sifre;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
       /* Connection conn;
        Properties connectionProps = new Properties();
        connectionProps.put("username", "root");
        connectionProps.put("password", "omer1996");//yapalım bişeyler :)
        String name="Jerome Dcruz";
        String contactno="9773523568";
        Statement stmt=(Statement)conn.createStatement();

        String insert="INSERT INTO info PERSONEL('"+name+"','"+contactno+"');";
        stmt.executeUpdate(insert);*/
    
    }
    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
}
