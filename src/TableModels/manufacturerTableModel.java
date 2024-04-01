package TableModels;

import claasses.manufacturer;

import java.util.List;

public class manufacturerTableModel extends DynamicTableModel<manufacturer> {
    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int DESCRIPTION_COL = 2;
    private static final int COUNTRY_COL = 3;

    private String[] columnNames = new String[]{"id","name","description","country"};
    private List<manufacturer> manufacturers;

    public manufacturerTableModel(List<manufacturer> theGrop_drug) {
        this.manufacturers=theGrop_drug;
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public int getRowCount() {
        return this.manufacturers.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        manufacturer tempGroup_drug = this.manufacturers.get(rowIndex);
        switch (columnIndex){
            case ID_COL:
                return tempGroup_drug.getId();
            case NAME_COL:
                return tempGroup_drug.getName();
            case DESCRIPTION_COL:
                return tempGroup_drug.getDescription();
            case COUNTRY_COL:
                return tempGroup_drug.getCountry();
            default:
                return "-";
        }
    }
    public void updateData(List<manufacturer> newData) {
        // Обновление данных в модели таблицы
        this.manufacturers = newData;
        fireTableDataChanged(); // Уведомление о изменении данных
    }
    // Дополнительные методы, если необходимо
}