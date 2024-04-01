package TableModels;

import claasses.active_substance;
import claasses.group_drug;
import claasses.manufacturer;
import claasses.medicines;

import java.util.List;

public class medicinesTableModels extends DynamicTableModel<medicines> {

    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int PRICE_COL = 2;
    private static final int MANUFACTURER_COL = 3;
    private static final int GROUP_DRUG_COL = 4;
    private static final int ACTIVE_SUBSTANCE_COL = 5;

    private List<medicines> products;
    private String[] columnNames = new String[]{"id","name","price","manufacturer","group_drug","active_substance"};
    public medicinesTableModels(List<medicines> theGrop_drug) {
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
        medicines tempGroup_drug = this.products.get(rowIndex);
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
            case GROUP_DRUG_COL:
                group_drug gd  = tempGroup_drug.getGroup_drug();
                return gd.getName();
            case ACTIVE_SUBSTANCE_COL:
                active_substance as  = tempGroup_drug.getActive_substance();
                return as.getName();
            default:
                return "-";
        }
    }
    public void updateData(List<medicines> newData) {
        // Обновление данных в модели таблицы
        this.products = newData;
        fireTableDataChanged(); // Уведомление о изменении данных
    }
}