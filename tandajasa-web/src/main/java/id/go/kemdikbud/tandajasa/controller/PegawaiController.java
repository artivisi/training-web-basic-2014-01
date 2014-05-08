/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.controller;

import id.go.kemdikbud.tandajasa.dao.PegawaiDao;
import id.go.kemdikbud.tandajasa.domain.Pegawai;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author endy
 */
@Controller
public class PegawaiController {
    
    @Autowired private PegawaiDao pd;
    
    @RequestMapping("/pegawai/list")
    public ModelMap daftarPegawai(){
        System.out.println("Daftar Pegawai");
        List<Pegawai> data = pd.cariSemuaPegawai();
        
        ModelMap mm = new ModelMap();
        mm.addAttribute("daftarPegawai", data);
        return mm;
    }
}
