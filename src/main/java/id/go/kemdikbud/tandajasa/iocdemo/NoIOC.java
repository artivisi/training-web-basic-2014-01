package id.go.kemdikbud.tandajasa.iocdemo;

import id.go.kemdikbud.tandajasa.domain.*;

public class NoIOC {
	
	public static void main(String[] xx){

		Pegawai p = new Pegawai();
		p.setId(100);
		p.setNip("333");
		p.setNama("Endy Muhardin");

		UnitKerja u = new UnitKerja();
		u.setKode("UK-001");
		u.setNama("Unit Kerja 001");
		//p.setUnitKerja(u);

		System.out.println("ID : "+p.getId());
		System.out.println("Nama : "+p.getNama());
		//System.out.println("Unit Kerja : "+p.getUnitKerja().getNama());
		
		
	}

}