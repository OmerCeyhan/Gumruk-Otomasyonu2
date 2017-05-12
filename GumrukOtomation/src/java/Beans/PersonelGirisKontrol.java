/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.Connection;
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
@ManagedBean(name="personelGirisKontrol")
@SessionScoped
public class PersonelGirisKontrol {
    DataSource dataSource;
    
    private String plaka;
    private String aracCinsi;
    private String ulkesi;
    private String firma;
    private String model;
    
    public PersonelGirisKontrol(){
          try {
			Context ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("jdbc:derby://localhost:1527/gumrukotomasyon");
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
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
    
}