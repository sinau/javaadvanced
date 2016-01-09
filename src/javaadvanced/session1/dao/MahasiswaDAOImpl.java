package javaadvanced.session1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaadvanced.session1.model.Mahasiswa;

public class MahasiswaDAOImpl implements MahasiswaDAO {

	private Connection connection;
	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement getByIdStatement;
	private PreparedStatement getAllStatement;
	
	private final String INSERT_QUERY = "insert into mahasiswa(nim,nama,nohp) values(?,?,?)";
	private final String UPDATE_QUERY = "update mahasiswa set nama=?, nohp=? where nim=?";
	private final String DELETE_QUERY = "delete from mahasiswa where nim=?";
	private final String GET_BY_ID_QUERY = "select nim,nama,nohp from mahasiswa where nim=?";
	private final String GET_ALL_QUERY = "select nim,nama,nohp from mahasiswa";
	
	public void setConnection(Connection connection) throws SQLException{
		this.connection = connection;
		insertStatement = this.connection.prepareStatement(INSERT_QUERY);
		updateStatement = this.connection.prepareStatement(UPDATE_QUERY);
		deleteStatement = this.connection.prepareStatement(DELETE_QUERY);
		getByIdStatement = this.connection.prepareStatement(GET_BY_ID_QUERY);
		getAllStatement = this.connection.prepareStatement(GET_ALL_QUERY);
	}
	
	@Override
	public Mahasiswa saveOrUpdate(Mahasiswa mahasiswa, boolean isUpdate) throws SQLException {
		if (!isUpdate) {
			insertStatement.setString(1, mahasiswa.getNim());
			insertStatement.setString(2, mahasiswa.getNama());
			insertStatement.setString(3, mahasiswa.getNohp());
			insertStatement.executeUpdate();
		} else {
			updateStatement.setString(1, mahasiswa.getNama());
			updateStatement.setString(2, mahasiswa.getNohp());
			updateStatement.setString(3, mahasiswa.getNim());
			updateStatement.executeUpdate();
		}
		
		return mahasiswa;
	}

	@Override
	public Mahasiswa delete(Mahasiswa mahasiswa) throws SQLException {
		deleteStatement.setString(1, mahasiswa.getNim());
		deleteStatement.executeUpdate();
		
		return mahasiswa;
	}

	@Override
	public Mahasiswa getById(String nim) throws SQLException {
		getByIdStatement.setString(1, nim);
		ResultSet rs = getByIdStatement.executeQuery();
		
		if (rs.next()) {
			Mahasiswa mahasiswa = new Mahasiswa();
			mahasiswa.setNim(rs.getString("nim"));
			mahasiswa.setNama(rs.getString("nama"));
			mahasiswa.setNohp(rs.getString("nohp"));
			
			return mahasiswa;
		}
		
		return null;
	}

	@Override
	public List<Mahasiswa> getAll() throws SQLException {
		List<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
		ResultSet rs = getAllStatement.executeQuery();
		while(rs.next()){
			Mahasiswa m = new Mahasiswa();
			m.setNim(rs.getString("nim"));
			m.setNama(rs.getString("nama"));
			m.setNohp(rs.getString("nohp"));
			
			mahasiswa.add(m);
		}
		
		return mahasiswa;
	}

}
