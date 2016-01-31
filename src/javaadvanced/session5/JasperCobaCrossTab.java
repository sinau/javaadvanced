package javaadvanced.session5;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class JasperCobaCrossTab {

	public static void main(String[] args) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		MysqlDataSource mysqlDataSource = new MysqlDataSource();
		mysqlDataSource.setUser("root");
		mysqlDataSource.setPassword("root");
		mysqlDataSource.setDatabaseName("sinau");
		mysqlDataSource.setServerName("localhost");
		mysqlDataSource.setPortNumber(3306);
		
		try {
			// Sesuaikan alamat file jasper dengan yang ada di local kalian
			JasperPrint jasperPrint = JasperFillManager.fillReport("/home/kakashi/JaspersoftWorkspace/MyReports/cobacrosstab.jasper", parameters, mysqlDataSource.getConnection());			
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				mysqlDataSource.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
