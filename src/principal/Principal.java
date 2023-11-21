package principal;

import javax.swing.JFrame;
import pantallas.Inicio;
import pantallas.Opciones;

public class Principal {
	public static final ConexionDataBase BD = new ConexionDataBase();
	public static Inicio inicio = new Inicio();
	public static JFrame PantallaCache = null;

	public static void main(String[] args) {
		inicio.setVisible(true);

	}

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
