package pantallas;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.Principal;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private static final long serialVersionUID = -2434606298754248881L;
	private JPanel contentPane;
	private JLabel IMG;
	private JTextField Nombre;
	private JTextField Edad;
	private JTextField Curso;

	public Registro(Inicio tb) {
		setSize(800, 532);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setAlwaysOnTop(true);
		JLabel lblTitulo = new JLabel("Registro");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 50));
		lblTitulo.setBounds(277, 32, 230, 58);
		contentPane.add(lblTitulo);
		ImageIcon foto = new ImageIcon("IMGDetalle.png");
		IMG = new JLabel(foto);
		IMG.setBounds(402, 123, 336, 237);
		contentPane.add(IMG);
		setContentPane(contentPane);

		Nombre = new JTextField();
		Nombre.setBounds(140, 123, 208, 36);
		contentPane.add(Nombre);
		Nombre.setColumns(10);

		Edad = new JTextField();
		Edad.setColumns(10);
		Edad.setBounds(140, 220, 208, 36);
		contentPane.add(Edad);

		Curso = new JTextField();
		Curso.setColumns(10);
		Curso.setBounds(140, 324, 208, 36);
		contentPane.add(Curso);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 20));
		lblNombre.setBounds(33, 134, 97, 14);
		contentPane.add(lblNombre);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Arial", Font.BOLD, 20));
		lblEdad.setBounds(33, 231, 97, 14);
		contentPane.add(lblEdad);

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Arial", Font.BOLD, 20));
		lblCurso.setBounds(33, 335, 97, 14);
		contentPane.add(lblCurso);

		JButton btn = new JButton("Registrar");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.sql.Statement st = Principal.BD.getCon().createStatement();
					String query = "INSERT INTO Estudiantes (Nombre,edad,curso) VALUES ('" + Nombre.getText() + "','"
							+ Edad.getText() + "','" + Curso.getText() + "')";
					st.executeUpdate(query);
					Principal.PantallaCache.setVisible(false);
					Principal.PantallaCache = null;
					tb.recargar();
				} catch (SQLException e33) {
					System.out.println("Fallo en actualizacion de la tabla");
					e33.printStackTrace();
				}
			}
		});
		btn.setFont(new Font("Arial", Font.BOLD, 30));
		btn.setBackground(Color.yellow);
		btn.setBounds(33, 401, 705, 70);
		contentPane.add(btn);
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {

			}

			public void windowLostFocus(WindowEvent e) {
				if (Principal.PantallaCache != null) {
					Principal.PantallaCache.setVisible(false);
					Principal.PantallaCache = null;
				}
			}
		});
	}
}