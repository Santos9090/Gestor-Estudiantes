package principal;

import javax.swing.JFrame;
import pantallas.Inicio;
import pantallas.Opciones;

/**
 * La clase Principal contiene el método principal (main) del programa y
 * gestiona la instancia de la clase Inicio, la conexión a la base de datos y la
 * ventana de opciones.
 */
public class Principal {
	/**
	 * La instancia de la clase ConexionDataBase para la conexión a la base de
	 * datos.
	 */
	public static final ConexionDataBase BD = new ConexionDataBase();

	/**
	 * La instancia de la clase Inicio que representa la ventana principal del
	 * programa.º
	 */
	public static Inicio inicio = new Inicio();

	/**
	 * La ventana de opciones que se muestra al hacer clic derecho en una celda de
	 * la tabla en Inicio.
	 */
	public static JFrame PantallaCache = null;

	/**
	 * El método principal (main) del programa, que inicia la ventana principal
	 * (Inicio).
	 *
	 * @param args Los argumentos de línea de comandos (no se utilizan en este
	 *             caso).
	 */
	public static void main(String[] args) {
		inicio.setVisible(true);
	}

	/**
	 * Muestra la ventana de opciones en la posición indicada.
	 *
	 * @param x  La coordenada x de la posición de la ventana de opciones.
	 * @param y  La coordenada y de la posición de la ventana de opciones.
	 * @param id El ID asociado a la fila seleccionada en la tabla.
	 * @return Siempre retorna false.
	 */
	public static boolean opciones(int x, int y, int id) {
		if (PantallaCache == null) {
			PantallaCache = new Opciones(x, y + 50, id);
			PantallaCache.setVisible(true);
		} else {
			PantallaCache.setVisible(false);
			PantallaCache = null;
			PantallaCache = new Opciones(x, y + 50, id);
			PantallaCache.setVisible(true);
		}
		return false;
	}
}
