package DAO;

import claasses.product;
import claasses.sale;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO implements GenericDAO<sale> {


    private Connection connection;

    public SaleDAO() {
        try {
            this.connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<sale> getAll() {
        List<sale> drugs = new ArrayList<>();
        String sql = "SELECT id, date, amount, employee  FROM sale";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                sale drug = new sale();
                drug.setId(resultSet.getInt("id"));
                SaleItemDAO SIDAO = new SaleItemDAO();

                drug.setItems(SIDAO.getAllBySaleID(drug.getId()));

                drug.setDateSale(resultSet.getDate("production_date"));
                EmployeesDAO EDAO = new EmployeesDAO();
                drug.setSaleEmloyees(EDAO.getById(resultSet.getInt("employee")));
                drug.setAmountPrice(resultSet.getBigDecimal("amount"));
                drugs.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public sale getById(int id) {
        return null;
    }

    @Override
    public void insert(sale entity) {

    }
}
