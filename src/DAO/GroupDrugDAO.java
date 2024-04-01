package DAO;


import claasses.group_drug;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDrugDAO implements GenericDAO<group_drug> {
    private Connection connection;

    public GroupDrugDAO() {
        try {
            this.connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<group_drug> getAll() {
        List<group_drug> drugs = new ArrayList<>();
        String sql = "SELECT id, name, description FROM group_drug";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                group_drug drug = new group_drug();
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

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM group_drug WHERE ID = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public group_drug getById(int id) {
        String sql = "SELECT id, name, description FROM group_drug where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Извлекаем данные из ResultSet
                    int groupId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    group_drug drug = new group_drug();
                    drug.setName(name);
                    drug.setId(id);
                    drug.setDescription(description);
                    // Создаем объект group_drug на основе извлеченных данных
                    return drug;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Если ничего не найдено, возвращаем null
    }


    @Override
    public void insert(group_drug drug) {
        String sql = "INSERT INTO group_drug (name, description) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, drug.getName());
            statement.setString(2, drug.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}