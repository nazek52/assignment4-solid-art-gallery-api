package controller;

import model.Artwork;
import service.interfaces.ArtworkService;

public class ArtworkController {

    private final ArtworkService service;

    public ArtworkController(ArtworkService service) {
        this.service = service;
    }

    public void create(Artwork artwork, int id) {
        service.addArtwork(artwork, id);
    }

    public void list() {
        service.getAll()
                .forEach(a -> System.out.println(a.getDisplayName()));
    }
}

