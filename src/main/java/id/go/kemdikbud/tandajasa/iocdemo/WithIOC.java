package id.go.kemdikbud.tandajasa.iocdemo;

import id.go.kemdikbud.tandajasa.domain.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WithIOC {

	public static void main(String[] xyz){
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("classpath:ioc-demo.xml");

		Pegawai xx = (Pegawai) ctx.getBean("p");
		System.out.println("ID : "+xx.getId());
		System.out.println("Nama : "+xx.getNama());
		System.out.println("Unit Kerja : "+xx.getUnitKerja().getNama());
		
	}

}