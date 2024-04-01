package TableModels;

import claasses.documents_employer;
import claasses.group_drug;

import java.util.List;

public class documents_employerTableModel extends DynamicTableModel<documents_employer> {
    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int DESCRIPTION_COL = 2;

    private final String[] columnNames = new String[]{"id","passport","phone"};
    private List<documents_employer> documents_employers;

    public documents_employerTableModel(List<documents_employer> theDocuments_employer) {
        this.documents_employers=theDocuments_employer;
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public int getRowCount() {
        return this.documents_employers.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        documents_employer tempDocuments_employers = this.documents_employers.get(rowIndex);
        switch (columnIndex){
            case ID_COL:
                return tempDocuments_employers.getId();
            case NAME_COL:
                return tempDocuments_employers.getPassport();
            case DESCRIPTION_COL:
                return tempDocuments_employers.getPhone();
            default:
                return "-";
        }
    }
    public void updateData(List<documents_employer> newData) {
        // Обновление данных в модели таблицы
        this.documents_employers = newData;
        fireTableDataChanged(); // Уведомление о изменении данных
    }
    // Дополнительные методы, если необходимо
}
