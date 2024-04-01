//ProductDAO
package DAO;


import claasses.group_drug;
import claasses.manufacturer;
import claasses.product;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements GenericDAO<product> {
    private Connection connection;

    public ProductDAO() {
        try {
            this.connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<product> getAll() {
        List<product> drugs = new ArrayList<>();
        String sql = "SELECT id, name, price, manufacturer  FROM product";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                product drug = new product();
                drug.setName(resultSet.getString("name"));
                drug.setId(resultSet.getInt("id"));
                drug.setPrice(resultSet.getBigDecimal("price"));
                int idManufacter = resultSet.getInt("manufacturer");
                ManufacturerDAO MDAO = new ManufacturerDAO();
                drug.setManufacturer(MDAO.getById(idManufacter));
                drugs.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drugs;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM product WHERE ID = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public product getById(int id) {
        String sql = "SELECT id, name, price,manufacturer FROM product where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    product prd = new product();
                    prd.setName(resultSet.getString("name"));
                    prd.setId(resultSet.getInt("id"));
                    prd.setPrice(resultSet.getBigDecimal("price"));
                    int idManufacter = resultSet.getInt("manufacturer");
                    ManufacturerDAO MDAO = new ManufacturerDAO();
                    prd.setManufacturer(MDAO.getById(idManufacter));
                    return prd;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Если ничего не найдено, возвращаем null
    }



    @Override
    public void insert(product pr) {
        String sql = "INSERT INTO product (name, price, manufacturer) VALUES ( ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pr.getName());
            statement.setBigDecimal(2, pr.getPrice());
            manufacturer mf = pr.getManufacturer();
            System.out.println("проверяем обект в дао");
            System.out.println(mf);
            statement.setInt(3, mf.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}