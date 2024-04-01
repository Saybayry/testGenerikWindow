package TableModels;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DynamicTableModel<T> extends AbstractTableModel {
    private List<T> itemList;
    private String[] columnNames;

    public DynamicTableModel(List<T> itemList, String[] columnNames) {
        this.itemList = itemList;
        this.columnNames = columnNames;
    }

    public DynamicTableModel() {
    }

    // Реализация методов для получения данных и структуры таблицы

    // Метод для обновления данных в таблице
    public void updateData(List<T> newData) {
        this.itemList = newData;
        fireTableDataChanged(); // Уведомляем таблицу о изменении данных
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}