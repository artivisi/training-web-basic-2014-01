/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author endy
 */
@Entity
public class Pegawai {
    @Id @GeneratedValue
    private Integer id;
    private String nip;
    private String nama;
    //private UnitKerja unitKerja;

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
}
