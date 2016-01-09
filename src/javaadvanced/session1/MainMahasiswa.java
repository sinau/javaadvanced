package javaadvanced.session1;

import javaadvanced.session1.datasource.DatabaseDataSource;
import javaadvanced.session1.model.Mahasiswa;
import javaadvanced.session1.service.MahasiswaService;

public class MainMahasiswa {

	public static void main(String[] args) {
		DatabaseDataSource mysql = new DatabaseDataSource();
		
		MahasiswaService mahasiswaService = new MahasiswaService();
		mahasiswaService.setDataSource(mysql.getMysqlDataSource());
		
		Mahasiswa m = new Mahasiswa();
		m.setNim("12345678");
		m.setNama("Joni");
		m.setNohp("08738272726");
		
		mahasiswaService.saveOrUpdate(m, false);
		
		mysql.closeMysqlConnection();
	}

}
