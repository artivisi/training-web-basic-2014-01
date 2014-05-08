/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author endy
 */
@Entity
@Table(name = "pegawai")
public class Pegawai {
    @Id @GeneratedValue
    private Integer id;
    private String nip;
    private String nama;
    //private UnitKerja unitKerja;
    
    @ManyToOne
    @JoinColumn(name = "id_golongan", nullable = false)
    private Golongan golongan;
    
    @ManyToMany(mappedBy = "daftarAnggota")
    private List<Proyek> daftarProyek = new ArrayList<Proyek>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    /*
    public UnitKerja getUnitKerja() {
        return unitKerja;
    }

    public void setUnitKerja(UnitKerja unitKerja) {
        this.unitKerja = unitKerja;
    }
    */

    public Golongan getGolongan() {
        return golongan;
    }

    public void setGolongan(Golongan golongan) {
        this.golongan = golongan;
    }
}