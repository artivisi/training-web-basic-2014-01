package id.go.kemdikbud.tandajasa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UsulHeader {
	@Id @GeneratedValue
	private Integer id_usulan;
	private String nomor_usulan;
	private Integer tipe_usulan;
	
	public Integer getId_usulan() {
		return id_usulan;
	}
	public String getNomor_usulan() {
		return nomor_usulan;
	}
	public Integer getTipe_usulan() {
		return tipe_usulan;
	}
	public void setId_usulan(Integer id_usulan) {
		this.id_usulan = id_usulan;
	}
	public void setNomor_usulan(String nomor_usulan) {
		this.nomor_usulan = nomor_usulan;
	}
	public void setTipe_usulan(Integer tipe_usulan) {
		this.tipe_usulan = tipe_usulan;
	}
}
