/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.kemdikbud.tandajasa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author endy
 */
@Entity
public class Proyek {
    
    @Id @GeneratedValue
    private Integer id;
    
    @Column(nullable = false, unique = true)
    private String kode;
    
    private String nama;
    
    @Column(name = "tanggal_mulai", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tanggalMulai = new Date();
    
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "id_proyek"),
            inverseJoinColumns = @JoinColumn(name = "id_pegawai")
    )
    private Set<Pegawai> daftarAnggota = new HashSet<Pegawai>();
}
