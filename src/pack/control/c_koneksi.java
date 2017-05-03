package pack.control;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author Krisna Putra F
 */
public class c_koneksi
{
 public static ResultSet executeQuery(String SQL) throws ClassNotFoundException, SQLException
 {
 ResultSet rs = null;
 Connection koneksi = setKoneksi();
 try 
    {
        Statement st = koneksi.createStatement();
        rs = st.executeQuery(SQL);
    }
 catch (SQLException ex)
    {
        Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
 }
 public static int execute(String SQL) throws SQLException, ClassNotFoundException
 {
    int status = 0;
    Connection koneksi = setKoneksi();
    try 
        {
            Statement st = koneksi.createStatement();
            status = st.executeUpdate(SQL);
        }
    catch(SQLException ex)
        {
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
 }
 public static Connection setKoneksi() throws ClassNotFoundException, SQLException
 {
     String konString = "jdbc:mysql://localhost:3306/toko";
     Connection koneksi = null;
     
     try
        {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection)
            DriverManager.getConnection(konString,"root","");
            System.out.println("Koneksi Berhasil");
        }
     catch(ClassNotFoundException ex)
        {
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        }
        return koneksi;
 }
 public static Object getConnection()
 {
     return null;
 }
 Connection con = null;
 Statement st = null;
 ResultSet rs = null;
 String sql = null;
 
 public c_koneksi() throws SQLException
 {
     try
        {
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/toko","root","");
            st = con.createStatement();
        }
     catch (Exception a)
        {
            JOptionPane.showMessageDialog(null,"Koneksi Database Gagal"+ a);
        }
 }   
}
