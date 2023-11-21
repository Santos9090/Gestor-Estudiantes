package pantallas;

import javax.swing.*;

import principal.Principal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;

public class Opciones extends JFrame {

	private static final long serialVersionUID = -8867431187218175243L;

	public Opciones(int x, int y, int id) {
		setAlwaysOnTop(true);
		setUndecorated(true);
		setBounds(x, y, 89, 90);
		JPanel contentpane = new JPanel();
		contentpane.setBackground(new Color(0, 0, 0, 0));
		contentpane.setLayout(new GridLayout(3, 1, 0, 0));
		setBackground(new Color(0, 0, 0, 0));
		JButton opcion1 = new JButton("Detalle");
		JButton opcion2 = new JButton("Eliminar");
		JButton cancelar = new JButton("Cancelar");
		opcion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.PantallaCache.setVisible(false);
				Principal.PantallaCache = new Detalle(id);
				Principal.PantallaCache.setVisible(true);
			}
		});

		opcion2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					java.sql.Statement st = Principal.BD.getCon().createStatement();
					String query = "DELETE FROM estudiantes WHERE id=" + id;
					st.executeUpdate(query);
					Principal.inicio.recargar();
					Principal.PantallaCache.setVisible(false);
					Principal.PantallaCache = null;
				} catch (SQLException e1) {
					System.out.println("Fallo en actualizacion de la tabla");
					e1.printStackTrace();
				}
			}
		});
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Principal.PantallaCache instanceof Opciones) {
					Principal.PantallaCache.setVisible(false);
					Principal.PantallaCache = null;
				}
			}
		});

		contentpane.add(opcion1);
		contentpane.add(opcion2);
		contentpane.add(cancelar);
		setContentPane(contentpane);
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {

			}

			public void windowLostFocus(WindowEvent e) {
				if (Principal.PantallaCache instanceof Opciones) {
					Principal.PantallaCache.setVisible(false);
					Principal.PantallaCache = null;
				}
			}
		});
	}
}
