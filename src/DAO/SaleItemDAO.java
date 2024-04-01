package DAO;

import claasses.manufacturer;
import claasses.saleItem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleItemDAO {


    private Connection connection;

    public SaleItemDAO() {
        try {
            this.connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<saleItem> getAll() {
        List<saleItem> items = new ArrayList<>();
        String sql = "SELECT sale_id, warehouse_id,quantity";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                saleItem item = new saleItem();
                WarehouseDAO WDAO = new WarehouseDAO();
                item.setItem( WDAO.getById(resultSet.getInt("warehouse_id")));
                item.setQuality(resultSet.getInt("quantity"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }


    public List<saleItem> getAllBySaleID(int id) {
        List<saleItem> items = new ArrayList<>();
        String sql = "SELECT sale_id, warehouse_id,quantity where sale_id = id";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                saleItem item = new saleItem();
                WarehouseDAO WDAO = new WarehouseDAO();
                item.setItem( WDAO.getById(resultSet.getInt("warehouse_id")));
                item.setQuality(resultSet.getInt("quantity"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }


}
