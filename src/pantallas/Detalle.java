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

/**
 * La clase Detalle representa una ventana de detalle para mostrar información detallada de un estudiante.
 */
public class Detalle extends JFrame {

    private static final long serialVersionUID = -2434606298754248881L;
    private JPanel contentPane;
    private JTable table;
    private JLabel IMG;

    /**
     * Constructor de la clase Detalle.
     *
     * @param id El ID del estudiante del cual se mostrará el detalle.
     */
    public Detalle(int id) {
        setTitle("Detalle");
        setSize(800, 500);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setAlwaysOnTop(true);
        JLabel lblTitulo = new JLabel("Detalle");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        lblTitulo.setBounds(277, 32, 230, 58);
        contentPane.add(lblTitulo);

        table = generarTabla("Select * from estudiantes where ID=" + id);
        contentPane.add(table);
        ImageIcon foto = new ImageIcon("IMGDetalle.png");
        IMG = new JLabel(foto);
        IMG.setBounds(402, 123, 336, 237);
        contentPane.add(IMG);
        setContentPane(contentPane);
        addWindowFocusListener(new WindowFocusListener() {
            public void windowGainedFocus(WindowEvent e) {

            }

            public void windowLostFocus(WindowEvent e) {
                Principal.PantallaCache.setVisible(false);
                Principal.PantallaCache = null;
            }
        });
    }

    /**
     * Genera y retorna una tabla con la información de un estudiante.
     *
     * @param C La consulta SQL para obtener la información del estudiante.
     * @return Una instancia de JTable con la información del estudiante.
     */
    private JTable generarTabla(String C) {
        DefaultTableModel tableModel = crearModelo(C);
        table = new JTable(tableModel);
        table.setGridColor(new Color(0, 0, 0, 0));
        table.setSelectionForeground(new Color(0, 0, 0, 0));
        table.setFont(new Font("Arial", Font.PLAIN, 18));
        table.setBounds(47, 123, 312, 237);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 25));
        table.setRowHeight(40);
        table.getTableHeader().setReorderingAllowed(false);
        table.setBackground(new Color(0, 0, 0, 0));
        table.setEnabled(false);
        return table;
    }

    /**
     * Crea y retorna el modelo de tabla con la información de un estudiante.
     *
     * @param C La consulta SQL para obtener la información del estudiante.
     * @return Un DefaultTableModel con la información del estudiante.
     */
    private DefaultTableModel crearModelo(String C) {
        Vector<Vector<String>> data = new Vector<>();
        ResultSet consulta = null;
        Vector<String> columns = new Vector<>();
        try {
            java.sql.Statement st = Principal.BD.getCon().createStatement();
            consulta = st.executeQuery(C);
            columns.add("Datos");
            columns.add("Informacion");
            for (int i = 0; i < 4; i++) {
                Vector<String> row = new Vector<>();
                data.add(row);
            }
            data.get(0).add("ID");
            data.get(1).add("Nombre");
            data.get(2).add("Edad");
            data.get(3).add("Curso");
            while (consulta.next()) {
                for (int i = 1; i <= 4; i++) {
                    data.get(i - 1).add(consulta.getString(i));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DefaultTableModel tableModel = new DefaultTableModel(data, columns);
        return tableModel;
    }
}
