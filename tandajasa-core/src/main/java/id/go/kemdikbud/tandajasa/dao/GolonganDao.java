/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.dao;

import id.go.kemdikbud.tandajasa.domain.Golongan;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author endy
 */
@Repository @Transactional
public class GolonganDao {
    @Autowired private SessionFactory sessionFactory;
    
    public List<Golongan> semuaGolongan(){
        return sessionFactory.getCurrentSession()
                .createQuery("select g from Golongan g order by g.kode")
                .list();
    }

    public Golongan cariById(Integer id) {
        if(id == null){
            return null;
        }
        return (Golongan) sessionFactory.getCurrentSession().get(Golongan.class, id);
    }
}
