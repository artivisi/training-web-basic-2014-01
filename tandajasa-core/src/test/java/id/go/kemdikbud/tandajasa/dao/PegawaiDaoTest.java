/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.dao;

import id.go.kemdikbud.tandajasa.domain.Golongan;
import id.go.kemdikbud.tandajasa.domain.Pegawai;
import java.io.File;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author endy
 */
public class PegawaiDaoTest {

    private static ApplicationContext ctx;

    @BeforeClass
    public static void inisialisasi(){
        ctx = new ClassPathXmlApplicationContext("classpath:tandajasa-ctx.xml");
    }
    
    @Test
    public void testHelloWorld(){
        System.out.println("Hello World");
    }
    
    @Before
    public void resetDatabase(){
        try {
            DataSource ds = ctx.getBean(DataSource.class);
            Connection koneksiDatabase = ds.getConnection();
            DatabaseOperation.CLEAN_INSERT.execute(new DatabaseConnection(koneksiDatabase),
                    new FlatXmlDataSetBuilder().build(new File("src/test/resources/pegawai.xml")));
            koneksiDatabase.close();
        } catch (Exception ex) {
            Logger.getLogger(PegawaiDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testInsert() throws Exception {
        Golongan g = new Golongan();
        g.setId(99);
        
        Pegawai p = new Pegawai();
        p.setNip("123");
        p.setNama("Endy Muhardin");
        p.setGolongan(g);
        
        DataSource ds = ctx.getBean(DataSource.class);
        Connection koneksiDatabase = ds.getConnection();
            
        PreparedStatement ps = koneksiDatabase.prepareStatement("select count(*) as jumlah from pegawai");
        ResultSet rsSebelum = ps.executeQuery();
        Assert.assertTrue(rsSebelum.next());
        Long jumlahRecordSebelum = rsSebelum.getLong(1);
        rsSebelum.close();
        
        PegawaiDao pd = (PegawaiDao)ctx.getBean("pegawaiDao");
        pd.save(p);
        
        ResultSet rsSetelah = ps.executeQuery();
        Assert.assertTrue(rsSetelah.next());
        Long jumlahRecordSetelah = rsSetelah.getLong("jumlah");
        rsSetelah.close();
        
        koneksiDatabase.close();
        Assert.assertEquals(new Long(jumlahRecordSebelum + 1), new Long(jumlahRecordSetelah));
    }
    
    @Test
    public void testCariSemua(){
        Long jumlahRecord = 2L;
        
        PegawaiDao pd = (PegawaiDao)ctx.getBean("pegawaiDao");
        List<Pegawai> hasil = pd.cariSemuaPegawai();
        
        Assert.assertEquals(new Long(jumlahRecord), new Long(hasil.size()));
    }
    
    @Test
    public void testCari(){
        Long jumlahRecord = 1L;
        
        PegawaiDao pd = (PegawaiDao)ctx.getBean("pegawaiDao");
        List<Pegawai> hasil = pd.cariSemuaPegawai("dad");
        
        Assert.assertEquals(new Long(jumlahRecord), new Long(hasil.size()));
    }
    
    @Test
    public void testCariById(){
        PegawaiDao pd = (PegawaiDao)ctx.getBean("pegawaiDao");
        Assert.assertNotNull(pd.cariById(100));
        Assert.assertNull(pd.cariById(1000));
    }
}
