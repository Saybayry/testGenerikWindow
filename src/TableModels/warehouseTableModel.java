package TableModels;

import claasses.manufacturer;
import claasses.product;
import claasses.warehouse;

import java.sql.Date;
import java.util.List;

public class warehouseTableModel extends DynamicTableModel<warehouse> {



//    private int id;
//    private int batch_number;

//    private Date production_date;
//    private Date expiration_date;
//    private Date date_receipt;

//    private product product;

//    private int quantity;

        private static final int ID_COL = 0;
        private static final int BACH_NUMBER_COL = 1;
        private static final int PRODUCT_COL = 2;
        private static final int QUANTITY_COL = 3;


        private static final int PRODUCTION_DATE_COL = 4;
        private static final int EXPRIATION_DATE_COLL = 5;
        private static final int DATE_RECEPT_COL = 6;

        private List<warehouse> warehouseList;
        private String[] columnNames = new String[]{"id","batch_number","product","quality", "production_dte","expiration_date", "date_receipt"};
        public warehouseTableModel(List<warehouse> warehouseList) {
            this.warehouseList=warehouseList;
        }

        @Override
        public int getColumnCount() {
            return this.columnNames.length;
        }

        @Override
        public int getRowCount() {
            return this.warehouseList.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            warehouse tempGroup_drug = this.warehouseList.get(rowIndex);
            switch (columnIndex){


                case ID_COL:
                    return tempGroup_drug.getId();
                case BACH_NUMBER_COL:
                    return tempGroup_drug.getBatch_number();
                case PRODUCT_COL:
                    product pr = tempGroup_drug.getProduct();
                    return pr.getName();
                case QUANTITY_COL:
                    return tempGroup_drug.getQuantity();


                case PRODUCTION_DATE_COL:
                    return tempGroup_drug.getProduction_date();
                case EXPRIATION_DATE_COLL:
                    return tempGroup_drug.getExpiration_date();
                case DATE_RECEPT_COL:
                    return tempGroup_drug.getDate_receipt();

                default:
                    return "-";


            }
        }
        public void updateData(List<warehouse> newData) {
            // Обновление данных в модели таблицы
            this.warehouseList = newData;
            fireTableDataChanged(); // Уведомление о изменении данных
        }
    }