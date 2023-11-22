package pantallas;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

import principal.Principal;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventObject;

/**
 * La clase RenderCeldas implementa TableCellEditor y KeyListener para
 * personalizar la edición de celdas en una JTable.
 */
public class RenderCeldas implements TableCellEditor, KeyListener {
	private DefaultCellEditor defaultCellEditor;
	private JTextField textField;
	private JTable table;
	private Inicio tb;

	/**
	 * Constructor de la clase RenderCeldas.
	 *
	 * @param table La tabla en la que se aplicará el renderizado de celdas.
	 * @param tb    La instancia de la clase Inicio para notificar los cambios en la
	 *              tabla.
	 */
	public RenderCeldas(JTable table, Inicio tb) {
		textField = new JTextField();
		defaultCellEditor = new DefaultCellEditor(textField);
		textField.addKeyListener(this);
		this.table = table;
		this.tb = tb;
	}

	/**
	 * Obtiene el componente de la celda para mostrar durante la edición.
	 *
	 * @param table      La tabla que contiene la celda.
	 * @param value      El valor de la celda a ser editada.
	 * @param isSelected Indica si la celda está seleccionada.
	 * @param row        El índice de la fila de la celda.
	 * @param column     El índice de la columna de la celda.
	 * @return El componente de la celda para mostrar durante la edición.
	 */
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return defaultCellEditor.getTableCellEditorComponent(table, value, isSelected, row, column);
	}

	/**
	 * Obtiene el valor actual de la celda editada.
	 *
	 * @return El valor actual de la celda editada.
	 */
	@Override
	public Object getCellEditorValue() {
		return defaultCellEditor.getCellEditorValue();
	}

	/**
	 * Determina si la celda es editable.
	 *
	 * @param anEvent El evento que inicia la edición.
	 * @return true si la celda es editable, false de lo contrario.
	 */
	@Override
	public boolean isCellEditable(EventObject anEvent) {
		if (table.getSelectedColumn() == 0) {
			return false;
		} else if (table.getSelectedColumn() == table.getColumnCount() - 1) {
			Point clickPoint = table.getMousePosition();
			if (clickPoint != null) {
				int x = clickPoint.x;
				int y = clickPoint.y;
				return Principal.opciones(x, y,
						Integer.parseInt((String) table.getModel().getValueAt(table.getSelectedRow(), 0)));
			} else {
				return false;
			}
		} else {
			return defaultCellEditor.isCellEditable(anEvent);
		}
	}

	/**
	 * Determina si la celda debe ser seleccionada.
	 *
	 * @param anEvent El evento que inicia la selección de la celda.
	 * @return true si la celda debe ser seleccionada, false de lo contrario.
	 */
	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		return defaultCellEditor.shouldSelectCell(anEvent);
	}

	/**
	 * Detiene la edición de la celda.
	 *
	 * @return true si la edición se detiene correctamente, false de lo contrario.
	 */
	@Override
	public boolean stopCellEditing() {
		return defaultCellEditor.stopCellEditing();
	}

	/**
	 * Cancela la edición de la celda.
	 */
	@Override
	public void cancelCellEditing() {
		defaultCellEditor.cancelCellEditing();
	}

	/**
	 * Agrega un escucha de eventos de edición de celdas.
	 *
	 * @param l El escucha de eventos de edición de celdas.
	 */
	@Override
	public void addCellEditorListener(CellEditorListener l) {
		defaultCellEditor.addCellEditorListener(l);
	}

	/**
	 * Elimina un escucha de eventos de edición de celdas.
	 *
	 * @param l El escucha de eventos de edición de celdas.
	 */
	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		defaultCellEditor.removeCellEditorListener(l);
	}

	/**
	 * Maneja el evento de tecla presionada durante la edición de la celda.
	 *
	 * @param e El evento de tecla.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			int selectedRow = table.getSelectedRow();
			int selectedColumn = table.getSelectedColumn();
			stopCellEditing();
			tb.change(selectedRow, selectedColumn);
		}
	}

	/**
	 * Maneja el evento de tecla tipeada durante la edición de la celda.
	 *
	 * @param e El evento de tecla tipeada.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Maneja el evento de tecla liberada durante la edición de la celda.
	 *
	 * @param e El evento de tecla liberada.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}
}
