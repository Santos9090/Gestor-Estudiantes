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

public class RenderCeldas implements TableCellEditor, KeyListener {
	private DefaultCellEditor defaultCellEditor;
	private JTextField textField;
	private JTable table;
	private Inicio tb;

	public RenderCeldas(JTable table, Inicio tb) {
		textField = new JTextField();
		defaultCellEditor = new DefaultCellEditor(textField);
		textField.addKeyListener(this);
		this.table = table;
		this.tb = tb;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return defaultCellEditor.getTableCellEditorComponent(table, value, isSelected, row, column);
	}

	@Override
	public Object getCellEditorValue() {
		return defaultCellEditor.getCellEditorValue();
	}

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

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		return defaultCellEditor.shouldSelectCell(anEvent);
	}

	@Override
	public boolean stopCellEditing() {
		return defaultCellEditor.stopCellEditing();
	}

	@Override
	public void cancelCellEditing() {
		defaultCellEditor.cancelCellEditing();
	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
		defaultCellEditor.addCellEditorListener(l);
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		defaultCellEditor.removeCellEditorListener(l);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			int selectedRow = table.getSelectedRow();
			int selectedColum = table.getSelectedColumn();
			stopCellEditing();
			tb.change(selectedRow, selectedColum);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
