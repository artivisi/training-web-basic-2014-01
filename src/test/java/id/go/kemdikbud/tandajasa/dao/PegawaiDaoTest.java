/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.dao;

import id.go.kemdikbud.tandajasa.domain.Pegawai;
import org.junit.Test;

/**
 *
 * @author endy
 */
public class PegawaiDaoTest {
    
    @Test
    public void testInsert(){
        Pegawai p = new Pegawai();
        p.setNip("123");
        p.setNama("Endy Muhardin");
        
        
        PegawaiDao pd = new PegawaiDao();
        pd.connect();
        pd.save(p);
        pd.disconnect();
    }
}
