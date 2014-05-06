/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.dao;

import id.go.kemdikbud.tandajasa.domain.Pegawai;
import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author endy
 */
@Repository
public class PegawaiDao {
    @Autowired
    private DataSource dataSource;
    
    public void save(Pegawai p){
        try {
            Connection koneksiDatabase = dataSource.getConnection();
            String sql = "insert into pegawai (nip, nama) values (?,?)";
            PreparedStatement ps = koneksiDatabase.prepareStatement(sql);
            ps.setString(1, p.getNip());
            ps.setString(2, p.getNama());
            ps.executeUpdate();
            koneksiDatabase.close();
        } catch (SQLException ex) {
            System.out.println("Terjadi kesalahan pada waktu insert");
            ex.printStackTrace();
        }
    }
    
    public List<Pegawai> cariSemuaPegawai(){
        try {
            String sql = "select * from pegawai";

            Connection koneksiDatabase = dataSource.getConnection();
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
            koneksiDatabase.close();
            return hasil;
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
