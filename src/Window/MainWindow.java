package Window;

import DAO.*;
import TableModels.*;
import claasses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainWindow {


    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel MainPlane;
    private JButton button4;
    private JButton buttun5;
    private JButton employeeDocsButton;
    private JButton employeeButton;
    private JButton warehouseButton;
    private JButton button10;
    private JButton buttonSale;
    private final tableWindow<group_drug> GropDrugtableWindow;
    private final tableWindow<active_substance> ActiveSubstanceWindow;
    private final tableWindow<manufacturer> ManufacturerWindow;
    private final tableWindow<product> productrWindow;
    private final tableWindow<documents_employer> documents_employerWindow;
    private final tableWindow<employees> employeesWindow;
    private final tableWindow<medicines> medicinesWindow;
    private final tableWindow<warehouse> warehouseWindow;
    private final tableWindow<sale> saleeWindow;
    public MainWindow() {

        GroupDrugDAO groupDrugDAO = new GroupDrugDAO();
        group_drug group_drug = new group_drug();
        List<group_drug> group_drugList = new ArrayList<>();
        group_drugTableModel group_drugTableModel = new group_drugTableModel(group_drugList);
        GropDrugtableWindow = new tableWindow<group_drug>(group_drugTableModel, groupDrugDAO,group_drug);


        ActiveSubstanceDAO activeSubstanceDAO = new ActiveSubstanceDAO();
        active_substance  active_substance = new active_substance();
        List<active_substance> active_substanceList = new ArrayList<>();
        active_substanceTableModel active_substanceTableModel = new active_substanceTableModel(active_substanceList);
        ActiveSubstanceWindow = new tableWindow<active_substance>(active_substanceTableModel, activeSubstanceDAO,active_substance);

        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        manufacturer manufacturer = new manufacturer();
        List<manufacturer> manufacturersList = new ArrayList<>();
        manufacturerTableModel manufacturerTableModel = new manufacturerTableModel(manufacturersList);
        ManufacturerWindow = new tableWindow<manufacturer>(manufacturerTableModel,manufacturerDAO,manufacturer);

        ProductDAO productDAO = new ProductDAO();
        product product = new product();
        List<product> productList = new ArrayList<>();
        productTableModel productTableModel = new productTableModel(productList);
        productrWindow = new tableWindow<product>(productTableModel,productDAO,product);

        MedicinesDao medicinesDAO = new MedicinesDao();
        medicines mediciness = new medicines();
        List<medicines> medicinesList = new ArrayList<>();
        medicinesTableModels medicinesTableModels = new medicinesTableModels(medicinesList);
        medicinesWindow = new tableWindow<medicines>(medicinesTableModels,medicinesDAO,mediciness);

        DocumentsEmployerDao documentsemployerDao = new DocumentsEmployerDao();
        documents_employer documents_employer = new documents_employer();
        List<documents_employer> documents_employerList = new ArrayList<>();
        documents_employerTableModel documents_employerTableModel = new documents_employerTableModel(documents_employerList);
        documents_employerWindow = new tableWindow<documents_employer>(documents_employerTableModel,documentsemployerDao,documents_employer);

        EmployeesDAO employeesDao = new EmployeesDAO();
        employees employees = new employees();
        List<employees> employeesList = new ArrayList<>();
        employeesTableModel employeesTableModel = new employeesTableModel(employeesList);
        employeesWindow = new tableWindow<employees>(employeesTableModel,employeesDao,employees);

        WarehouseDAO warehouseDAO = new WarehouseDAO();
        warehouse warehouse = new warehouse();
        List<warehouse> warehouseList = new ArrayList<>();
        warehouseTableModel warehouseTableModel = new warehouseTableModel(warehouseList);
        warehouseWindow = new tableWindow<warehouse>(warehouseTableModel, warehouseDAO,warehouse);



        SaleDAO saleDAO = new SaleDAO();
        sale sales = new sale();
        List<sale> saleList = new ArrayList<>();
        saleTableModel saleTableModel = new saleTableModel(saleList);
        saleeWindow = new tableWindow<sale>(saleTableModel, saleDAO,sales);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productrWindow.setVisible(true);
                productrWindow.setSize(700, 500);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManufacturerWindow.setVisible(true);
                ManufacturerWindow.setSize(700, 500);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GropDrugtableWindow.setVisible(true);
                GropDrugtableWindow.setSize(700, 500);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActiveSubstanceWindow.setVisible(true);
                ActiveSubstanceWindow.setSize(700, 500);
            }
        });
        employeeDocsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                documents_employerWindow.setVisible(true);
                documents_employerWindow.setSize(700, 500);
            }
        });
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeesWindow.setVisible(true);
                employeesWindow.setSize(700, 500);
            }
        });
        buttun5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicinesWindow.setVisible(true);
                medicinesWindow.setSize(700, 500);
            }
        });
        warehouseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                warehouseWindow.setVisible(true);
                warehouseWindow.setSize(700, 500);
            }
        });
        buttonSale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(saleList);
                saleeWindow.setVisible(true);
                saleeWindow.setSize(700, 500);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("app");
        frame.setContentPane(new MainWindow().MainPlane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.pack();
        frame.setVisible(true);

    }
}
