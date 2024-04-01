package DAO;


import claasses.group_drug;
import claasses.manufacturer;
import claasses.product;
import claasses.warehouse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class WarehouseDAO implements GenericDAO<warehouse> {
        private Connection connection;

        public WarehouseDAO() {
            try {
                this.connection = DatabaseConnector.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public List<warehouse> getAll() {
            List<warehouse> warehouseItemList = new ArrayList<>();

            String sql = "SELECT id, batch_number, product, quantity," +
                    "production_date,expiration_date,date_receipt  " +
                    "FROM warehouse";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    warehouse warehouseItem = new warehouse();
                    warehouseItem.setId(resultSet.getInt("id"));
                    warehouseItem.setQuantity(resultSet.getInt("quantity"));
                    warehouseItem.setBatch_number(resultSet.getInt("batch_number"));
                    int idproduct = resultSet.getInt("product");
                    ProductDAO PDAO = new ProductDAO();
                    warehouseItem.setProduct(PDAO.getById(idproduct));
                    warehouseItem.setProduction_date(resultSet.getDate("production_date"));
                    warehouseItem.setExpiration_date(resultSet.getDate("expiration_date"));
                    warehouseItem.setDate_receipt(resultSet.getDate("date_receipt"));
                    warehouseItemList.add(warehouseItem);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return warehouseItemList;
        }

        @Override
        public void deleteById(int id) {
            String sql = "DELETE FROM warehouse WHERE ID = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public warehouse getById(int id) {
            String sql = "SELECT id, " +
                    "batch_number, product, quantity," +
                    "production_date,expiration_date,date_receipt  " +
                    "FROM warehouse " +
                    "where id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        warehouse warehouseItem = new warehouse();
                        warehouseItem.setId(resultSet.getInt("id"));
                        warehouseItem.setQuantity(resultSet.getInt("quantity"));
                        warehouseItem.setBatch_number(resultSet.getInt("batch_number"));
                        int idproduct = resultSet.getInt("product");
                        ProductDAO PDAO = new ProductDAO();
                        warehouseItem.setProduct(PDAO.getById(idproduct));
                        warehouseItem.setProduction_date(resultSet.getDate("production_date"));
                        warehouseItem.setExpiration_date(resultSet.getDate("expiration_date"));
                        warehouseItem.setDate_receipt(resultSet.getDate("date_receipt"));

                        return warehouseItem;

                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null; // Если ничего не найдено, возвращаем null
        }



        @Override
        public void insert(warehouse warehouseItem) {
            String sql = "INSERT INTO warehouse (" +
                    "batch_number, product, quantity, production_date,expiration_date,date_receipt) VALUES ( ?, ?, ? ,? , ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                System.out.println("начинается вставка склада");
                statement.setInt(1, warehouseItem.getBatch_number());
                product pr = warehouseItem.getProduct();
                System.out.println(warehouseItem.getBatch_number());
                System.out.println(warehouseItem.getQuantity());
                statement.setInt(2, pr.getId());
                statement.setInt(3, warehouseItem.getQuantity());

                statement.setDate(4, warehouseItem.getProduction_date());
                statement.setDate(5, warehouseItem.getExpiration_date());
                statement.setDate(6, warehouseItem.getDate_receipt());

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }