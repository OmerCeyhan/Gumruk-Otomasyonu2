/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.FunctionMapper;
import javax.el.VariableMapper;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

/**
 *
 * @author Brainiac
 *
 */
@ManagedBean(name = "eklecikar")
@SessionScoped
public class EkleCikar implements Serializable {

    @ManagedProperty(value = "#{arac}")
    Arac arac;

    @ManagedProperty(value = "#{surucu}")
    Surucu surucu;

    @ManagedProperty(value = "#{tasima}")
    Tasima tasima;

    @ManagedProperty(value = "#{ihbar}")
    Ihbar ihbar;

    public Ihbar getIhbar() {
        return ihbar;
    }

    public void setIhbar(Ihbar ihbar) {
        this.ihbar = ihbar;
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

    public Tasima getTasima() {
        return tasima;
    }

    public void setTasima(Tasima tasima) {
        this.tasima = tasima;
    }

    public String topluEkleCikar() throws SQLException, NamingException {
        System.out.println("topluEkleCikar Calisti...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");
            PreparedStatement ps = con.prepareStatement(
                    "select plaka from ihbar where plaka=?");
            ps.setString(1, arac.getPlaka());

            ResultSet rs = ps.executeQuery();
            System.out.println("SQL executed...");
            if (rs.next()) // found
            {
                return "ihbarBulundu?faces-redirect=true";
            } else {
                arac.aracEkle();
                surucu.surucuEkle();
                tasima.tasimaEkle();

                return "index?faces-redirect=true";
            }

        } catch (SQLException e) {
            System.err.println(e);
            return "index?faces-redirect=true";
        }
        
    }
}