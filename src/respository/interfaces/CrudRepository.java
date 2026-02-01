package repository.interfaces;

import java.util.List;

public interface CrudRepository<T> {
    void create(T item);
    List<T> findAll();
    T findById(int id);
    void deleteById(int id);
}
