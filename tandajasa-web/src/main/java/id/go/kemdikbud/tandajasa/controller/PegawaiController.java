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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping(value = "/pegawai/form", method = RequestMethod.GET)
    public ModelMap tampilkanForm(@RequestParam(required = false)Integer id){
        ModelMap mm = new ModelMap();
        mm.addAttribute("pegawai", new Pegawai());
        
        if(id != null){
            Pegawai p = pd.cariById(id);
            if(p != null){
                mm.addAttribute("pegawai", p);
                System.out.println("Pegawai : "+p.getNama());
            }
        }
        
        return mm;
    }
}
