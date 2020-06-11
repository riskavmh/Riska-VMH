package ulfabusana;

/**
 * Nama      : Riska Virliana M H
 * NIM / Gol : E31192024 / C
 * Prodi     : Manajemen Informatika
 */

import java.sql.*;

public class koneksi {
    public koneksi() throws SQLException{
        bukakoneksi();
    }
    public Connection bukakoneksi() throws SQLException{
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/pbd", "root", "");
            return con;
        }
        catch(SQLException se) {
            System.out.println("No Connection Open");
            return null;
        }
        catch (Exception ex) {
            System.out.println("Cound not open connection");
            return null;
        }
    }
}
