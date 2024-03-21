package apkpustaka;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Client
 */
public class koneksi {
    static Connection konek;
    static ResultSet rs;
    static Statement st;
   
     public koneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            konek = DriverManager.getConnection("jdbc:mysql://localhost:3306/aplikasi_pustaka","root","");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //method ambil data
     public ResultSet ambilData(String sql){
        try {
            st = konek.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
     }
       //method untuk rubah data
    public boolean rubahData(String sql){
        try {
            st = konek.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
}