package TableModels;

import claasses.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class saleTableModel extends DynamicTableModel<sale>{

    private static final int ID_COL = 0;
    private static final int DATE_SALE_COL = 1;
    private static final int AMOUNT_PRICE_COL = 2;
    private static final int SALE_EMPLOYER_COL = 3;


    private List<sale> saleList;

    private String[] columnNames = new String[]{"id","dateSale","amountPrice","saleEmloyees"};


    public saleTableModel(List<sale> saleList) {
        this.saleList=saleList;
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public int getRowCount() {
        return this.saleList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        sale tempsale = this.saleList.get(rowIndex);
        switch (columnIndex){


            case ID_COL:
                return tempsale.getId();
            case DATE_SALE_COL:
                return tempsale.getDateSale();
            case AMOUNT_PRICE_COL:
                return tempsale.getAmountPrice();
            case SALE_EMPLOYER_COL:
                return tempsale.getSaleEmloyees();

            default:
                return "-";


        }
    }
    public void updateData(List<sale> newData) {
        // Обновление данных в модели таблицы
        this.saleList = newData;
        fireTableDataChanged(); // Уведомление о изменении данных
    }
}
