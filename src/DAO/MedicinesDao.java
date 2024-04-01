package DAO;

import claasses.active_substance;
import claasses.manufacturer;
import claasses.medicines;
import claasses.product;
import claasses.group_drug;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MedicinesDao implements GenericDAO<medicines> {
        private Connection connection;

        public MedicinesDao() {
            try {
                this.connection = DatabaseConnector.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public List<medicines> getAll() {
            List<medicines> meds = new ArrayList<>();
            String sql = "SELECT id, active_substance, group_drug  FROM medicines ";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    medicines med = new medicines();
                    med.setId(resultSet.getInt("id"));

                    ActiveSubstanceDAO ASDAO = new ActiveSubstanceDAO();
                    med.setActive_substance(ASDAO.getById(resultSet.getInt("active_substance")));

                    GroupDrugDAO GDAO = new GroupDrugDAO();
                    med.setGroup_drug(GDAO.getById(resultSet.getInt("group_drug")));

                    ProductDAO PDAO = new ProductDAO();
                    product pr = PDAO.getById(resultSet.getInt("id"));

                    med.setName(pr.getName());
                    med.setPrice(pr.getPrice());
                    med.setManufacturer(pr.getManufacturer());
                    meds.add(med);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return meds;
        }

        @Override
        public void deleteById(int id) {
            String sql = "DELETE FROM medicines WHERE ID = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String sqlpr = "DELETE FROM product WHERE ID = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sqlpr)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public medicines getById(int id) {
            String sql = "SELECT id, active_substance, group_drug  FROM medicines where id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        medicines med = new medicines();
                        med.setId(resultSet.getInt("id"));
                        ActiveSubstanceDAO ASDAO = new ActiveSubstanceDAO();
                        med.setActive_substance(ASDAO.getById(resultSet.getInt("active_substance")));
                        GroupDrugDAO GDAO = new GroupDrugDAO();
                        med.setGroup_drug(GDAO.getById(resultSet.getInt("group_drug")));
                        ProductDAO PDAO = new ProductDAO();
                        product pr = PDAO.getById(resultSet.getInt("id"));
                        med.setName(pr.getName());
                        med.setPrice(pr.getPrice());
                        med.setManufacturer(pr.getManufacturer());
                        return med;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null; // Если ничего не найдено, возвращаем null
        }


    @Override
        public void insert(medicines med) {
            String sqlpr = "INSERT INTO product (name, price, manufacturer) VALUES ( ?, ?, ?)";
            String sqlmed = "INSERT INTO medicines (id, active_substance, group_drug) VALUES ( ?, ?, ?)";
            try(PreparedStatement statementpr = connection.prepareStatement(sqlpr, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement statementmed = connection.prepareStatement(sqlmed))
             {
                 statementpr.setString(1, med.getName());
                 statementpr.setBigDecimal(2, med.getPrice());
                 manufacturer mf = med.getManufacturer();
                 statementpr.setInt(3, mf.getId());
                 statementpr.executeUpdate();
                 int medId = 0;
                 try (ResultSet generatedKeys = statementpr.getGeneratedKeys()) {
                     if (generatedKeys.next()) {

                         medId = generatedKeys.getInt(1);
                         statementmed.setInt(1,medId);
                         active_substance as = med.getActive_substance();
                         statementmed.setInt(2, as.getId());
                         group_drug gd = med.getGroup_drug();
                         statementmed.setInt(3, gd.getId());
                         statementmed.executeUpdate();
                     }
                 }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }