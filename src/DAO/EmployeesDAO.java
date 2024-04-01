package DAO;

import claasses.documents_employer;
import claasses.employees;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO implements GenericDAO<employees> {
        private Connection connection;

        public EmployeesDAO() {
            try {
                this.connection = DatabaseConnector.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public List<employees> getAll() {
            List<employees> empls = new ArrayList<>();

            String sql = "SELECT id, first_name, last_name, middle_name,dociments FROM employees";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    employees empl = new employees();
                    empl.setId(resultSet.getInt("id"));
                    empl.setFirst_name(resultSet.getString("first_name"));
                    empl.setLast_name(resultSet.getString("last_name"));
                    empl.setMiddle_name(resultSet.getString("middle_name"));
                    int idDociments = resultSet.getInt("dociments");
                    DocumentsEmployerDao EDAO = new DocumentsEmployerDao();
                    empl.setDociments(EDAO.getById(idDociments));
                    empls.add(empl);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return empls;
        }

        @Override
        public void deleteById(int id) {
            String sql = "DELETE FROM employees WHERE ID = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public employees getById(int id) {
            String sql = "SELECT id, first_name, last_name, middle_name,dociments FROM employees where id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        employees empl = new employees();
                        empl.setId(resultSet.getInt("id"));
                        empl.setFirst_name(resultSet.getString("name"));
                        empl.setLast_name(resultSet.getString("last_name"));
                        empl.setMiddle_name(resultSet.getString("middle_name"));
                        int idDociments = resultSet.getInt("dociments");
                        DocumentsEmployerDao EDAO = new DocumentsEmployerDao();
                        empl.setDociments(EDAO.getById(idDociments));

                        return empl;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null; // Если ничего не найдено, возвращаем null
        }



        @Override
        public void insert(employees pr) {
            String sql = "INSERT INTO employees (first_name, last_name, middle_name, dociments) VALUES ( ?, ?, ?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, pr.getFirst_name());
                statement.setString(2, pr.getLast_name());
                statement.setString(3, pr.getMiddle_name());
                documents_employer de = pr.getDociments();
                System.out.println(de.getId());
                statement.setInt(4, de.getId());
                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }