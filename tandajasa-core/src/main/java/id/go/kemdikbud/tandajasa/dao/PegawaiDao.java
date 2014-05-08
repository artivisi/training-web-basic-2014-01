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
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author endy
 */
@Repository
@Transactional
public class PegawaiDao {
    @Autowired
    private SessionFactory sessionFactory;
    
    public void save(Pegawai p){
        sessionFactory.getCurrentSession().saveOrUpdate(p);
    }
    
    public List<Pegawai> cariSemuaPegawai(){
        return sessionFactory.getCurrentSession()
                .createQuery("select p from Pegawai p order by p.nip")
                .list();
    }
    
    public Pegawai cariById(Integer id) {
        if(id == null){
            return null;
        }
        
        return (Pegawai) sessionFactory.getCurrentSession().get(Pegawai.class, id);
    }
}
