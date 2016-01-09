package javaadvanced.session1.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javaadvanced.session1.model.Mahasiswa;

public interface MahasiswaDAO {

	public void setConnection(Connection connection) throws SQLException;
	
	public Mahasiswa saveOrUpdate(Mahasiswa mahasiswa, boolean isUpdate) throws SQLException;
	public Mahasiswa delete(Mahasiswa mahasiswa) throws SQLException;
	public Mahasiswa getById(String nim) throws SQLException;
	public List<Mahasiswa> getAll() throws SQLException;
	
}
