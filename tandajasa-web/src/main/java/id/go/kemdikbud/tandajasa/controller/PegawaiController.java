/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.controller;

import id.go.kemdikbud.tandajasa.dao.GolonganDao;
import id.go.kemdikbud.tandajasa.dao.PegawaiDao;
import id.go.kemdikbud.tandajasa.domain.Golongan;
import id.go.kemdikbud.tandajasa.domain.Pegawai;
import id.go.kemdikbud.tandajasa.editor.GolonganEditor;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author endy
 */
@Controller
public class PegawaiController {
    
    @Autowired private PegawaiDao pegawaiDao;
    @Autowired private GolonganDao golonganDao;
    
    @InitBinder
    public void setupConverter(WebDataBinder binder){
        binder.registerCustomEditor(Golongan.class, new GolonganEditor(golonganDao));
        
    }
    
    @RequestMapping("/pegawai/list")
    public ModelMap daftarPegawai(@RequestParam(required = false) String search){
        System.out.println("Daftar Pegawai");
        List<Pegawai> data = new ArrayList<Pegawai>();
        data.addAll(pegawaiDao.cariSemuaPegawai(search));
        
        ModelMap mm = new ModelMap();
        mm.addAttribute("daftarPegawai", data);
        return mm;
    }
    
    @ModelAttribute("daftarGolongan")
    public List<Golongan> daftarGolongan(){
        return golonganDao.semuaGolongan();
    }
    
    @RequestMapping(value = "/pegawai/form", method = RequestMethod.GET)
    public ModelMap tampilkanForm(@RequestParam(required = false)Integer id){
        ModelMap mm = new ModelMap();
        mm.addAttribute("pegawai", new Pegawai());
        
        if(id != null){
            Pegawai p = pegawaiDao.cariById(id);
            if(p != null){
                mm.addAttribute("pegawai", p);
                System.out.println("Pegawai : "+p.getNama());
            }
        }
        
        return mm;
    }
    
    @RequestMapping(value = "/pegawai/form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Pegawai pegawai, BindingResult errors, SessionStatus status){
        if(errors.hasErrors()){
            return "/pegawai/form";
        }
        
        pegawaiDao.save(pegawai);
        status.setComplete();
        return "redirect:list";
    }
}
