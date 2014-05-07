package id.go.kemdikbud.tandajasa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RiwayatJabatan {
	
	@Id @GeneratedValue
	private Integer IdJabatan;
	private Integer IdPegawai;
	private String NamaJabatan;
//	private Date TmtJabatan;
	
	
	public Integer getIdJabatan() {
		return IdJabatan;
	}
	public void setIdJabatan(Integer idJabatan) {
		IdJabatan = idJabatan;
	}
	public Integer getIdPegawai() {
		return IdPegawai;
	}
	public void setIdPegawai(Integer idPegawai) {
		IdPegawai = idPegawai;
	}
	public String getNamaJabatan() {
		return NamaJabatan;
	}
	public void setNamaJabatan(String namaJabatan) {
		NamaJabatan = namaJabatan;
	}
	/*public Date getTmtJabatan() {
		return TmtJabatan;
	}
	public void setTmtJabatan(Date tmtJabatan) {
		TmtJabatan = tmtJabatan;
	}*/
	
	
	

}
