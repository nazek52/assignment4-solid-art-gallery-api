package service;

import model.Artwork;
import repository.interfaces.CrudRepository;
import service.interfaces.ArtworkService;

import java.util.List;

public class ArtworkServiceImpl implements ArtworkService {

    private final CrudRepository<Artwork> repository;

    public ArtworkServiceImpl(CrudRepository<Artwork> repository) {
        this.repository = repository;
    }

    @Override
    public void addArtwork(Artwork artwork, int id) {
        repository.create(artwork);
        System.out.println("Artwork created: " + artwork.getDisplayName());
    }

    @Override
    public void updateTitle(int id, String newTitle) {
        Artwork artwork = repository.findById(id);
        if (artwork == null) {
            throw new RuntimeException("Resource not found with id " + id);
        }
        artwork.setTitle(newTitle);
        System.out.println("Artwork updated: " + artwork.getDisplayName());
    }

    @Override
    public void deleteArtwork(int id) {
        repository.deleteById(id);
        System.out.println("Artwork deleted: ID " + id);
    }

    @Override
    public List<Artwork> getAll() {
        return repository.findAll();
    }
}
