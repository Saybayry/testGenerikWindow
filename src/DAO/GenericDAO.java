package DAO;

import claasses.group_drug;

import java.util.List;

// Обобщенный интерфейс DAO для работы с объектами
    public interface GenericDAO<T> {
    List<T> getAll();
    void deleteById(int id);
    T getById(int id);
    // Другие методы, если необходимо


    void insert(T entity);
}
