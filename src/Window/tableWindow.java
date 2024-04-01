package Window;

import Window.AddWindow.AddObjectWindowGenerator;
import DAO.GenericDAO;
import TableModels.DynamicTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class tableWindow<T> extends JFrame {
    private JPanel tablePlane;
    private JTable table;
    private JButton addButton;
    private JButton button2;
    private JButton updateButton;
    private JButton deliteButton;
    private T clazz; // храним ссылку на класс
    private GenericDAO<T> genericDAO;
    private DynamicTableModel<T> tableModel;
    private List<T> itemList;
    public tableWindow(DynamicTableModel<T> tableModel, GenericDAO<T> Dao, T clazz){
        this.setContentPane(tablePlane);
        this.tableModel = tableModel;
        this.genericDAO = Dao;
        this.clazz = clazz;
        updateData();

        deliteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int[] selectedRows = table.getSelectedRows();
                    for (int row : selectedRows) {
                        // Получить данные из модели таблицы для выделенной строки
                        int delit_id = (int) table.getValueAt(row, 0);
                        // Делайте что-то с полученными данными
                        Dao.deleteById(delit_id);
                        System.out.println("Значение выделенной строки: " + delit_id);

                }
                updateData();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddObjectWindowGenerator<T> addgroup_drug = new AddObjectWindowGenerator<T>(clazz,Dao, tableWindow.this);
                } catch (InstantiationException ex) {
                    throw new RuntimeException(ex);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateData();
            }
        });
    }
    public void updateData() {
        itemList = genericDAO.getAll();
        tableModel.updateData(itemList);
        table.setModel(tableModel);
        System.out.println("update");
    }
}
