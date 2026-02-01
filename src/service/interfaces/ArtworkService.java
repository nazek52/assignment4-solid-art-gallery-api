package service.interfaces;

import model.Artwork;
import java.util.List;

public interface ArtworkService {
    void addArtwork(Artwork artwork, int id);
    void updateTitle(int id, String newTitle);
    void deleteArtwork(int id);
    List<Artwork> getAll();
}
