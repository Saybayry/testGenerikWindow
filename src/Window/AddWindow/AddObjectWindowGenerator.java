package Window.AddWindow;

import DAO.GenericDAO;
import claasses.GenerigSimpleGuideClass;
import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import Window.tableWindow;


public class AddObjectWindowGenerator<T>{
    private GenericDAO<T>  Dao;
    private tableWindow<T> parentWindow;
    public AddObjectWindowGenerator(Object obj, GenericDAO<T> Dao, tableWindow<T> parentWindow) throws InstantiationException, IllegalAccessException {
        this.parentWindow= parentWindow;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.Dao =Dao;

        System.out.println(obj);
        // Получаем все поля класса
        Field[] fields = obj.getClass().getDeclaredFields();
        // поля в на старнице
        JComponent[] textFields = new JComponent[fields.length];

        // Создаем панель для размещения текстовых полей
        JPanel panel = new JPanel(new GridLayout(fields.length, 2));

        // Для каждого поля создаем метку и текстовое поле
        for (int i = 0; i < fields.length; i++) {


            Field field = fields[i];
            field.setAccessible(true); // Разрешаем доступ к приватным полям
            JLabel label = new JLabel(field.getName());


            // пропускаем id
            if (field.getName().equals("id")) {
                continue;
            }
            System.out.println(field.getName());
            // если поле один из наших классов то реализуем выпадающий список
            if (GenerigSimpleGuideClass.class.isAssignableFrom(field.getType())){
                Class<GenerigSimpleGuideClass> classFiled = (Class<GenerigSimpleGuideClass>) field.getType();
                // Создаем новый экземпляр объекта этого класса
                GenerigSimpleGuideClass instance = classFiled.newInstance();

                GenericDAO<?> instanceDao = instance.getDao();

                List<?> instanceList = instanceDao.getAll();


                JComboBox comboBox = new JComboBox();

                Object[] instanceArray = instanceList.toArray(new Object[0]);

                comboBox.setModel(new DefaultComboBoxModel<>(instanceArray));
                panel.add(label);
                panel.add(comboBox);
                textFields[i] = comboBox;

            } else if (Date.class.isAssignableFrom(field.getType())) {
                DatePicker datePicker = new DatePicker();
                panel.add(label);
                panel.add(datePicker);
                textFields[i] = datePicker;
            }

            // если нет то текстовое меню можно предусмотреть другие варианты например для чисел
            else {
                JTextField textField = new JTextField(10);
                try {
                    // Устанавливаем значение текстового поля на основе значения поля объекта
                    if (field.get(obj) != null){
                        textField.setText(String.valueOf(field.get(obj)));
                    }
                    else {
                        textField.setText("");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                // Добавляем метку и текстовое поле на панель
                panel.add(label);
                panel.add(textField);
                textFields[i] = textField;
            }


        }



        JButton buttonSave = new JButton("Сохранить");
        panel.add(buttonSave);
        JButton buttonCancel = new JButton("Отмена");
        panel.add(buttonCancel);

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < fields.length; i++) {
                        Field field = fields[i];
                        field.setAccessible(true);
                        String fieldName = field.getName();
                        System.out.println("----------------");

                        System.out.println(fieldName);

                        if (!fieldName.equals("id")) { // Пропускаем поле "id"
                            if(String.class.isAssignableFrom(field.getType())){
                                JTextField textField = (JTextField) textFields[i]; // Получаем соответствующее текстовое поле из массива
                                // Извлекаем значение из текстового поля и устанавливаем его в поле объекта
                                field.set(obj, textField.getText());
                            } else if (BigDecimal.class.isAssignableFrom(field.getType())) {
                                JTextField textField = (JTextField) textFields[i];
                                BigDecimal filed_Value =BigDecimal.valueOf(Long.parseLong(textField.getText()));
                                field.set(obj, filed_Value);
                            } else if (GenerigSimpleGuideClass.class.isAssignableFrom(field.getType())) {
                                JComboBox comboBox = (JComboBox) textFields[i];
                                System.out.println(comboBox);
                                System.out.println((GenerigSimpleGuideClass) comboBox.getSelectedItem());
                                field.set(obj, comboBox.getSelectedItem());
                                System.out.println("вот производиьель");
                            } else if (Date.class.isAssignableFrom(field.getType())) {
                                DatePicker  datePiker = (DatePicker)  textFields[i];
                                Date d = Date.valueOf(datePiker.getDate());
                                field.set(obj,d);
                            }
                        }

                        System.out.println("----------------");

                    }
                    System.out.println(obj);
                    Dao.insert((T) obj);
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }

                parentWindow.updateData();
                frame.dispose();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        // Добавляем панель на окно
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }
}