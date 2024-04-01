package DAO;


import claasses.documents_employer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class DocumentsEmployerDao implements GenericDAO<documents_employer> {
        private Connection connection;

        public DocumentsEmployerDao() {
            try {
                this.connection = DatabaseConnector.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public List<documents_employer> getAll() {
            List<documents_employer> documents = new ArrayList<>();
            String sql = "SELECT passport_id, phone, id FROM documents_employer";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    documents_employer de = new documents_employer();
                    de.setPassport(resultSet.getString("passport_id"));
                    de.setId(resultSet.getInt("id"));
                    de.setPhone(resultSet.getString("phone"));
                    documents.add(de);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return documents;
        }

        @Override
        public void deleteById(int id) {
            String sql = "DELETE FROM documents_employer WHERE ID = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public documents_employer getById(int id) {
            String sql = "SELECT id, passport_id, phone FROM documents_employer where id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Извлекаем данные из ResultSet
                        int groupId = resultSet.getInt("id");
                        String passport = resultSet.getString("passport_id");
                        String phone = resultSet.getString("phone");
                        documents_employer de = new documents_employer();
                        de.setPhone(phone);
                        de.setId(id);
                        de.setPassport(passport);
                        // Создаем объект group_drug на основе извлеченных данных
                        return de;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null; // Если ничего не найдено, возвращаем null
        }




        @Override
        public void insert(documents_employer de) {
            String sql = "INSERT INTO documents_employer (passport_id, phone) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, de.getPassport());
                statement.setString(2, de.getPhone());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }