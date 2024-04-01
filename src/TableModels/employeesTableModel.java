package TableModels;

import claasses.documents_employer;
import claasses.employees;
import claasses.manufacturer;
import claasses.product;

import java.util.List;

public class employeesTableModel extends DynamicTableModel<employees>{

    private static final int ID_COL = 0;
    private static final int FIRST_NAME_COL = 1;
    private static final int LAST_NAME_COL = 2;
    private static final int MIDDLE_NAME_COL = 3;
    private static final int DOCUMENT_COL = 4;
    private List<employees> employeess;
    private String[] columnNames = new String[]{"id","first_name","last_name","middle_name", "documents"};
    public employeesTableModel(List<employees> theGrop_drug) {
        this.employeess=theGrop_drug;
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public int getRowCount() {
        return this.employeess.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        employees tempGroup_drug = this.employeess.get(rowIndex);
        switch (columnIndex){
            case ID_COL:
                return tempGroup_drug.getId();
            case FIRST_NAME_COL:
                return tempGroup_drug.getFirst_name();
            case LAST_NAME_COL:
                return tempGroup_drug.getLast_name();
            case MIDDLE_NAME_COL:
                return tempGroup_drug.getMiddle_name();
            case DOCUMENT_COL:
                documents_employer mf  = tempGroup_drug.getDociments();
                return mf.getPassport();
            default:
                return "-";
        }
    }
    public void updateData(List<employees> newData) {
        // Обновление данных в модели таблицы
        this.employeess = newData;
        fireTableDataChanged(); // Уведомление о изменении данных
    }
}
