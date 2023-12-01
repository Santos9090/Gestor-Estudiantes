package principal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * La clase ConexionDataBase se encarga de establecer la conexión con la base de
 * datos mediante JDBC.
 */
public class ConexionDataBase {
	private Connection con;

	/**
	 * Constructor de la clase, que carga el controlador del driver JDBC y establece
	 * la conexión con la base de datos utilizando las propiedades cargadas desde el
	 * archivo "conexion.properties".
	 */
	public ConexionDataBase() {
		cargarDriver();

	}

	/**
	 * Obtiene la conexión actual con la base de datos.
	 *
	 * @return La conexión con la base de datos.
	 */
	public Connection getCon() {
		Properties propiedades = new Properties();
		try {
			propiedades.load(new FileReader("conexion.properties"));
			String direccion = propiedades.getProperty("URL");
			con = DriverManager.getConnection(direccion, propiedades.getProperty("USER"),
					propiedades.getProperty("PWD"));
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * Carga el controlador del driver JDBC.
	 */
	private void cargarDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Fallo en la carga del controlador JDBC");
		}
	}

	public void cerrarConex() throws SQLException {
		con.close();

	}
}
