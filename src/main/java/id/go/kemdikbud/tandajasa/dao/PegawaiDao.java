/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.dao;

import id.go.kemdikbud.tandajasa.domain.Pegawai;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author endy
 */
public class PegawaiDao {
    private Connection koneksiDatabase;
    
    public void connect(){
        try {
            String username = "belajar";
            String password = "java";
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://localhost/tandajasadb";
            //String driver = "com.mysql.jdbc.Driver";
            //String url = "jdbc:mysql://localhost/tandajasadb";
            
            // inisialisasi driver database
            Class.forName(driver);
            
            // Connect ke database
            koneksiDatabase = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Koneksi ke database gagal");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Database driver tidak ditemukan");
            ex.printStackTrace();
        }
    }
    
    public void disconnect(){
        try {
            koneksiDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void save(Pegawai p){
        try {
            String sql = "insert into pegawai (nip, nama) values (?,?)";
            PreparedStatement ps = koneksiDatabase.prepareStatement(sql);
            ps.setString(1, p.getNip());
            ps.setString(2, p.getNama());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan pada waktu insert");
            ex.printStackTrace();
        }
    }
    
    public List<Pegawai> cariSemuaPegawai(){
        try {
            String sql = "select * from pegawai";
            
            PreparedStatement ps = koneksiDatabase.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Pegawai> hasil = new ArrayList<Pegawai>();
            while(rs.next()){
                Pegawai p = new Pegawai();
                p.setId(rs.getInt("id"));
                p.setNip(rs.getString("nip"));
                p.setNama(rs.getString("nama"));
                hasil.add(p);
            }
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
