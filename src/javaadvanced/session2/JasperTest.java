package javaadvanced.session2;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class JasperTest {

	public static void main(String[] args) {

		Map<String, Object> parameters = new HashMap<String, Object>();

		JRDataSource dataSource = new JREmptyDataSource();

		try {
			// Sesuaikan alamat file jasper dengan yang ada di local kalian
			JasperPrint jasperPrint = JasperFillManager.fillReport("/home/kakashi/JaspersoftWorkspace/MyReports/Blank_A4.jasper", parameters, dataSource);			
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException e) {
			e.printStackTrace();
		}

	}

}
