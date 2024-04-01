package DAO;


import claasses.active_substance;
import claasses.manufacturer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActiveSubstanceDAO implements GenericDAO<active_substance> {
    private Connection connection;

    public ActiveSubstanceDAO() {
        try {
            this.connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<active_substance> getAll() {
        List<active_substance> drugs = new ArrayList<>();
        String sql = "SELECT id, name, description FROM active_substance";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                active_substance drug = new active_substance();
                drug.setName(resultSet.getString("name"));
                drug.setId(resultSet.getInt("id"));
                drug.setDescription(resultSet.getString("description"));
                drugs.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drugs;
    }
    public void deleteById(int id) {
        String sql = "DELETE FROM active_substance WHERE ID = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public active_substance getById(int id) {
        String sql = "SELECT id, name, description FROM active_substance where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Извлекаем данные из ResultSet
                    int groupId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    active_substance as = new active_substance();
                    as.setName(name);
                    as.setId(id);
                    as.setDescription(description);
                    return as;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Если ничего не найдено, возвращаем null
    }


    public void insert(active_substance drug){
        String sql = "INSERT INTO active_substance (name, description) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, drug.getName());
            statement.setString(2, drug.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

