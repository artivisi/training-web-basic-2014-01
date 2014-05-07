package id.go.kemdikbud.tandajasa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD
=======

@Entity
public class UnitKerja{
	@Id @GeneratedValue
	private Integer id;
	private String kode;
	private String nama;
>>>>>>> 1cde111cefaccf06f57b9601a8497604712dd61f

@Entity
public class UnitKerja{
        @Id @GeneratedValue
	private Integer IdUker;
	private String NamaUker;
	private String AlmUker;
        private Integer TelpUker;

	public Integer getIdUker(){
		return this.IdUker;
	}

	public void setIdUker(Integer IdUker){
		this.IdUker = IdUker;
	}

	public String getNamaUker(){
		return this.NamaUker;
	}

	public void setNamaUker(String NamaUker){
		this.NamaUker = NamaUker;
	}

	public String getAlmUker(){
		return this.AlmUker;
	}

	public void setAlmUker(String AlmUker){
		this.AlmUker = AlmUker;
	}
        
        public Integer getTelpUker(){
		return this.TelpUker;
	}

	public void setTelpUker(Integer TelpUker){
		this.TelpUker = TelpUker;
	}
}