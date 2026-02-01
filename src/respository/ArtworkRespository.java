package repository;

import model.Artwork;
import repository.interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class ArtworkRepository implements CrudRepository<Artwork> {

    private final List<Artwork> storage = new ArrayList<>();

    @Override
    public void create(Artwork item) {
        storage.add(item);
    }

    @Override
    public List<Artwork> findAll() {
        return storage;
    }

    @Override
    public Artwork findById(int id) {
        return storage.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(int id) {
        storage.removeIf(a -> a.getId() == id);
    }
}
