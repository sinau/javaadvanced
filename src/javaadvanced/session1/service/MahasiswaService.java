package javaadvanced.session1.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import javaadvanced.session1.dao.MahasiswaDAO;
import javaadvanced.session1.dao.MahasiswaDAOImpl;
import javaadvanced.session1.model.Mahasiswa;

public class MahasiswaService {

	private MahasiswaDAO mahasiswaDAO;
	private Connection connection;
	
	public void setDataSource(DataSource dataSource){
		try {
			connection = dataSource.getConnection();
			mahasiswaDAO = new MahasiswaDAOImpl();
			mahasiswaDAO.setConnection(connection);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public Mahasiswa saveOrUpdate(Mahasiswa mahasiswa, boolean isUpdate){
		try {
			connection.setAutoCommit(false);
			mahasiswaDAO.saveOrUpdate(mahasiswa, isUpdate);
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException ex) {
			try{
				connection.rollback();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return mahasiswa;
	}
	
	public Mahasiswa delete(Mahasiswa mahasiswa){
		try {
			connection.setAutoCommit(false);
			mahasiswaDAO.delete(mahasiswa);
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException ex) {
			try{
				connection.rollback();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return mahasiswa;
	}
	
	public Mahasiswa getPerson(String nim){
		Mahasiswa mahasiswa = null;
		try {
			mahasiswa = mahasiswaDAO.getById(nim);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mahasiswa;
	}
	
	public List<Mahasiswa> getPersons(){
		try{
			return mahasiswaDAO.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<Mahasiswa>();
	}
	
}
