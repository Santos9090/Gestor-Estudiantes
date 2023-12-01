package pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import principal.Principal;

/**
 * La clase Inicio representa la pantalla principal de registro de estudiantes.
 */
public class Inicio extends JFrame {

	private static final long serialVersionUID = -2120984908659307032L;
	private JPanel contentPane, foot;
	private String[] Orders;
	private JTable table;

	/**
	 * Constructor de la clase Inicio.
	 */
	public Inicio() {
		setTitle("Registro");
		contentPane = new JPanel(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int ancho_pantalla = screenSize.width;
		int alto_pantalla = screenSize.height;
		setSize(ancho_pantalla, alto_pantalla);
		setExtendedState(MAXIMIZED_BOTH);
		JTable tabla = generarTabla("Select * from estudiantes");
		JScrollPane scrollPane = new JScrollPane(tabla);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		foot = new JPanel(new GridLayout(1, 3, 20, 0));
		JButton boton1 = crearBoton("Registrar", "Amarillo");
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Principal.PantallaCache != null) {
					Principal.PantallaCache.setVisible(false);
					Principal.PantallaCache = null;
					Principal.PantallaCache = new Registro(Inicio.this);
					Principal.PantallaCache.setVisible(true);
				} else {
					Principal.PantallaCache = new Registro(Inicio.this);
					Principal.PantallaCache.setVisible(true);
				}
			}
		});
		foot.add(boton1);
		JTextField buscador = new JTextField();
		foot.add(buscador);
		JButton boton2 = crearBoton("Buscar", "Naranja");
		JComboBox<String> selector = new JComboBox<String>();
		DefaultComboBoxModel<String> opcions = new DefaultComboBoxModel<>();
		opcions.addElement("ID");
		opcions.addElement("Nombre");
		opcions.addElement("Edad");
		opcions.addElement("Curso");
		selector.setModel(opcions);
		foot.add(selector);
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!buscador.getText().equalsIgnoreCase("")) {
					String query = "select * from estudiantes where " + selector.getSelectedItem() + " Like '%"
							+ buscador.getText() + "%'";
					System.out.println(query);
					tabla.setModel(crearModelo(query));
				} else {
					recargar();
				}
			}
		});
		foot.add(boton2);
		foot.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		contentPane.add(foot, BorderLayout.SOUTH);
		setContentPane(contentPane);
	}

	/**
	 * Genera y retorna una tabla con la información de los estudiantes.
	 *
	 * @param C La consulta SQL para obtener la información de los estudiantes.
	 * @return Una instancia de JTable con la información de los estudiantes.
	 */
	private JTable generarTabla(String C) {
		DefaultTableModel tableModel = crearModelo(C);
		table = new JTable(tableModel);
		table.setGridColor(Color.WHITE);
		table.setSelectionForeground(Color.WHITE);
		table.setFont(new Font("Arial", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 25));
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);
		table.setEnabled(true);
		table.setDefaultEditor(Object.class, new RenderCeldas(table, this));
		return table;
	}

	/**
	 * Crea y retorna el modelo de tabla con la información de los estudiantes.
	 *
	 * @param C La consulta SQL para obtener la información de los estudiantes.
	 * @return Un DefaultTableModel con la información de los estudiantes.
	 */
	private DefaultTableModel crearModelo(String C) {
		Vector<Vector<String>> data = new Vector<>();
		ResultSet consulta = null;
		Vector<String> columns = new Vector<>();
		java.sql.Statement st = null;
		try {
			st = Principal.BD.getCon().createStatement();
			consulta = st.executeQuery(C);
			java.sql.ResultSetMetaData metaData = consulta.getMetaData();
			int columnCount = metaData.getColumnCount();
			Orders = new String[columnCount];
			for (int i = 1; i <= columnCount; i++) {
				columns.add(metaData.getColumnName(i));
				Orders[i - 1] = metaData.getColumnName(i);
			}
			columns.add("");
			while (consulta.next()) {
				Vector<String> row = new Vector<>();
				for (int i = 1; i <= columnCount; i++) {
					row.add(consulta.getString(i));
				}
				row.add("Opciones");
				data.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				consulta.close();
				Principal.BD.cerrarConex();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DefaultTableModel tableModel = new DefaultTableModel(data, columns);
		return tableModel;
	}

	/**
	 * Crea y retorna un botón con el nombre y color especificados.
	 *
	 * @param Nombre El nombre del botón.
	 * @param color  El color del botón ("Amarillo" o "Naranja").
	 * @return Un JButton configurado con el nombre y color especificados.
	 */
	private JButton crearBoton(String Nombre, String color) {
		JButton boton = new JButton(Nombre);
		boton.setPreferredSize(new Dimension(getWidth() / 3, 40));
		boton.setForeground(Color.BLACK);
		boton.setFont(new Font("Arial", Font.BOLD, 16));
		if (color.equalsIgnoreCase("Amarillo")) {
			boton.setBackground(new Color(238, 255, 0));
		} else if (color.equalsIgnoreCase("Naranja")) {
			boton.setBackground(new Color(255, 149, 0));
		}

		return boton;
	}

	/**
	 * Realiza el cambio en la base de datos cuando se modifica una celda en la
	 * tabla.
	 *
	 * @param row   La fila de la celda modificada.
	 * @param colum La columna de la celda modificada.
	 */
	public void change(int row, int colum) {
		TableModel aux = table.getModel();
		String cambio = (String) aux.getValueAt(row, colum);
		String columna = table.getColumnName(colum);
		String id = (String) aux.getValueAt(row, 0);
		java.sql.Statement st = null;
		try {
			st = Principal.BD.getCon().createStatement();
			String query = "UPDATE estudiantes SET " + columna + "  = '" + cambio + "' WHERE ID='" + id + "';";
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(this, "Cambio Realizado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			System.out.println("Fallo en actualizacion de la tabla");
			e.printStackTrace();
		} finally {
			try {
				st.close();
				Principal.BD.cerrarConex();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Recarga la tabla con la información original de los estudiantes.
	 */
	public void recargar() {
		table.setModel(crearModelo("select * from estudiantes"));
	}
}
