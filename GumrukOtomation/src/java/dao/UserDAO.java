package dao;
import java.sql.*;
  
public class UserDAO {      
     public static boolean login(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Database.getConnection();
            ps = con.prepareStatement(
                    "select Kullanici_Adi, Sifre from personel where Kullanici_Adi= ? and Sifre= ? ");
            ps.setString(1, username);
            ps.setString(2, password);
  
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(rs.getString("Kullanici_Adi"));
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
            Database.close(con);
        }
    }
}