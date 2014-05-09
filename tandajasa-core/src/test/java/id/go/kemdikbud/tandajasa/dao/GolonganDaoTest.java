/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.dao;

import id.go.kemdikbud.tandajasa.domain.Golongan;
import java.io.File;
import javax.sql.DataSource;
import java.sql.Connection;
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
public class GolonganDaoTest {

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
            Logger.getLogger(GolonganDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testCariSemua(){
        Long jumlahRecord = 2L;
        
        GolonganDao pd = (GolonganDao)ctx.getBean("golonganDao");
        List<Golongan> hasil = pd.semuaGolongan();
        
        Assert.assertEquals(new Long(jumlahRecord), new Long(hasil.size()));
    }
    
    @Test
    public void testCariById(){
        GolonganDao pd = (GolonganDao)ctx.getBean("golonganDao");
        Assert.assertNotNull(pd.cariById(99));
    }
}
