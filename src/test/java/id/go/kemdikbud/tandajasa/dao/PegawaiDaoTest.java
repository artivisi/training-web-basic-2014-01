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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author endy
 */
public class PegawaiDaoTest {

    private Connection koneksiDatabase;
    
    @Before
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
    
    @After
    public void disconnect(){
        try {
            koneksiDatabase.close();
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testInsert() throws Exception {
        Pegawai p = new Pegawai();
        p.setNip("123");
        p.setNama("Endy Muhardin");
        
        PreparedStatement ps = koneksiDatabase.prepareStatement("select count(*) as jumlah from pegawai");
        ResultSet rsSebelum = ps.executeQuery();
        Assert.assertTrue(rsSebelum.next());
        Long jumlahRecordSebelum = rsSebelum.getLong(1);
        rsSebelum.close();
        
        PegawaiDao pd = new PegawaiDao();
        pd.connect();
        pd.save(p);
        pd.disconnect();
        
        ResultSet rsSetelah = ps.executeQuery();
        Assert.assertTrue(rsSetelah.next());
        Long jumlahRecordSetelah = rsSetelah.getLong("jumlah");
        rsSetelah.close();
        
        Assert.assertEquals(new Long(jumlahRecordSebelum + 1), new Long(jumlahRecordSetelah));
    }
}
