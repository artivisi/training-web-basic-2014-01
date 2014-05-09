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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author endy
 */
@Entity
@Table(name = "pegawai")
public class Pegawai {
    @Id @GeneratedValue
    private Integer id;
    
    @NotNull @NotEmpty @Size(max = 10) @Pattern(regexp = "^[0-9]*$")
    private String nip;
    
    @NotNull @NotEmpty @Size(min = 3)
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
