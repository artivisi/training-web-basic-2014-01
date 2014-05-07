package id.go.kemdikbud.tandajasa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UnitKerja{
	@Id @GeneratedValue
	private Integer id;
	private String kode;
	private String nama;

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getKode(){
		return this.kode;
	}

	public void setKode(String kode){
		this.kode = kode;
	}

	public String getNama(){
		return this.nama;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

}