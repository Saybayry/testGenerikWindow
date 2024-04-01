package TableModels;

import claasses.manufacturer;
import claasses.product;

import java.util.List;

public class productTableModel extends DynamicTableModel<product> {

    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int PRICE_COL = 2;
    private static final int MANUFACTURER_COL = 3;

    private List<product> products;
    private String[] columnNames = new String[]{"id","name","price","manufacturer"};
    public productTableModel(List<product> theGrop_drug) {
        this.products=theGrop_drug;
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public int getRowCount() {
        return this.products.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        product tempGroup_drug = this.products.get(rowIndex);
        switch (columnIndex){
            case ID_COL:
                return tempGroup_drug.getId();
            case NAME_COL:
                return tempGroup_drug.getName();
            case PRICE_COL:
                return tempGroup_drug.getPrice();
            case MANUFACTURER_COL:
                manufacturer mf  = tempGroup_drug.getManufacturer();
                return mf.getName();
            default:
                return "-";
        }
    }
    public void updateData(List<product> newData) {
        // Обновление данных в модели таблицы
        this.products = newData;
        fireTableDataChanged(); // Уведомление о изменении данных
    }
}
