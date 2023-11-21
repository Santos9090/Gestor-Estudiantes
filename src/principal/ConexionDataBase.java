package principal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionDataBase {
	private Connection con;

	public ConexionDataBase() {
		cargarDriver();
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileReader("conexion.properties"));
			String direccion = propiedades.getProperty("URL");
			con = DriverManager.getConnection(direccion, propiedades.getProperty("USER"), propiedades.getProperty("PWD"));
		} catch (SQLException e) {
			System.out.println("Fallo conexion BD");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

	private void cargarDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Fallo en el Driver");
		}

	}
}
