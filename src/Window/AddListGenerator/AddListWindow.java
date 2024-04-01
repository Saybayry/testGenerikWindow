package Window.AddListGenerator;

import claasses.GenerigSimpleGuideClass;

import javax.swing.*;
import java.util.List;
import java.awt.Dimension;
import java.util.ArrayList;


public class AddListWindow<T extends GenerigSimpleGuideClass> extends JPanel {
        private JList<T> selectedItemsList;
        private DefaultListModel<T> listModel;

        public AddListWindow() {
            listModel = new DefaultListModel<>();
            selectedItemsList = new JList<>(listModel);
            JScrollPane scrollPane = new JScrollPane(selectedItemsList);
            scrollPane.setPreferredSize(new Dimension(200, 100));
            add(scrollPane);
        }

        public void addSelectedItem(T item) {
            listModel.addElement(item);
        }

        public void removeSelectedItem(T item) {
            listModel.removeElement(item);
        }

        public List<T> getSelectedItems() {
            List<T> selectedItems = new ArrayList<>();
            for (int i = 0; i < listModel.getSize(); i++) {
                selectedItems.add(listModel.getElementAt(i));
            }
            return selectedItems;
        }
    }