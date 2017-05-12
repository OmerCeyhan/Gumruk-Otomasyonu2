package dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class Database {
 
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}/*
try{ 
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        try{
        Connection con = DriverManager.getConnection
        ("jdbc:derby://localhost:1527/HastaneDB","Genel","genel");
        
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM DOKTOR");
        
        while (rs.next()) {
        int dtc = rs.getInt("DTC");
        String dadi = rs.getString("DADI");
        String dsoyadi = rs.getString("DSOYADI");
        String duzmanlik = rs.getString("DUZMANLIK");
        System.out.println("Doktor TC:"+dtc+"  Doktor Adı:"+dadi+"  Doktor Soyadı:"+dsoyadi+"  Uzmanlığı:"+duzmanlik);
         
        }
        
        }catch(SQLException e){
            System.err.println(e);
        }                 

*/