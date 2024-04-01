package DAO;

import claasses.group_drug;
import claasses.manufacturer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO implements GenericDAO<manufacturer> {
    private Connection connection;

    public ManufacturerDAO() {
        try {
            this.connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<manufacturer> getAll() {
        List<manufacturer> drugs = new ArrayList<>();
        String sql = "SELECT id, name, description,country FROM manufacturer";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                manufacturer item = new manufacturer();
                item.setName(resultSet.getString("name"));
                item.setId(resultSet.getInt("id"));
                item.setDescription(resultSet.getString("description"));
                item.setCountry(resultSet.getString("country"));
                drugs.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drugs;
    }



    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM manufacturer WHERE ID = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public manufacturer getById(int id) {
        String sql = "SELECT id, name, description,country FROM manufacturer where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Извлекаем данные из ResultSet
                    int groupId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    String country = resultSet.getString("country");
                    manufacturer mf = new manufacturer();
                    mf.setName(name);
                    mf.setId(id);
                    mf.setDescription(description);
                    mf.setCountry(country);
                    return mf;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Если ничего не найдено, возвращаем null
    }



    @Override
    public void insert(manufacturer mf) {
        String sql = "INSERT INTO manufacturer (name, description,country ) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mf.getName());
            statement.setString(2, mf.getDescription());
            statement.setString(3, mf.getCountry());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}