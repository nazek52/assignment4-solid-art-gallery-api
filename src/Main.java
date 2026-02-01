import model.*;
import repository.ArtworkRepository;
import service.ArtworkServiceImpl;
import utils.ReflectionUtils;
import utils.SortingUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArtworkRepository repo = new ArtworkRepository();
        ArtworkServiceImpl service = new ArtworkServiceImpl(repo);

        System.out.println("=== CREATING ARTWORKS ===");

        service.addArtwork(
                new Painting(1, "Starry Night", 1000000, "Oil",
                        "        ✦      ✦        ✦\n" +
                                "   ✦        ~~~~~~~~         ✦\n" +
                                "        ~~~~  @@@@  ~~~~\n" +
                                "  ✦    ~~~  @@@@@@@@@  ~~~   ✦\n" +
                                "       ~~~  @@@@@@@@@@@  ~~~\n" +
                                "   ✦   ~~~   @@@@@@@@@   ~~~ ✦\n" +
                                "        ~~~~    @@@@    ~~~~\n" +
                                "    ✦       ~~~~~~~~~~~       ✦\n" +
                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                                "        |||||||||||||||\n" +
                                "        |||||||||||||||",
                        null), 1);

        service.addArtwork(
                new Painting(2, "Mona Lisa", 850000, "Oil",
                        "     _____________\n" +
                                "     /             \n" +
                                "    |   o       o   |\n" +
                                "    |      ___      |\n" +
                                "    |     (___)     |\n" +
                                "    |      ___/    |\n" +
                                "                  /\n" +
                                "      ___________/\n" +
                                "        |||||||||\n" +
                                "        |||||||||",
                        null), 2);

        service.addArtwork(
                new Sculpture(3, "The Thinker", 300000, 150,
                        "          ____\n" +
                                "         | o__|\n" +
                                "          /||\n" +
                                "         / ||\n" +
                                "        /  ||\n" +
                                "       /___||___\n" +
                                "           ||\n" +
                                "          /  \\",
                        null), 3);
        service.addArtwork(
                new Sculpture(0, "Venus de Milo", 400000, 180,
                        "         ____           \n" +
                                "        | 0 0|          \n" +
                                "        |__~__|          \n" +
                                "          ||            \n" +
                                "      ____||____        \n" +
                                "          ||           \n" +
                                "          ||           \n" +
                                "          ||            \n" +
                                "         /  \\           \n",
                        null), 2
        );
        service.addArtwork(
                new Painting(0, "The Scream", 900000, "Tempera",
                        "      ███████████      \n" +
                                "     █    O   O    █     \n" +
                                "     █      ___    █     \n" +
                                "     █             █      \n" +
                                "     █       O     █     \n" +
                                "      ███████████      \n" +
                                "        |||||||         \n" +
                                "      //|||||||\\\\       \n" +
                                "    //  |||||||  \\\\     \n",
                        null), 1
        );
        service.addArtwork(
                new Sculpture(0, "David", 500000, 200,
                        "        /////         \n" +
                                "       |  o o |        \n" +
                                "       |   ^   |        \n" +
                                "        \\_____/        \n" +
                                "          |||           \n" +
                                "      ____|||____       \n" +
                                "     |     |||     |    \n" +
                                "     |     |||     |    \n" +
                                "      \\____|||____/     \n",
                        null), 3
        );

        System.out.println("\n=== ALL ARTWORKS ===");
        service.getAll().forEach(a -> System.out.println(a.getDisplayName()));

        List<Artwork> list = service.getAll();
        SortingUtils.sortByTitle(list);

        System.out.println("\n=== SORTED BY TITLE ===");
        list.forEach(a -> System.out.println(a.getDisplayName()));

        System.out.println("\n=== UPDATING ARTWORK ===");
        service.updateTitle(1, "Starry Night (Updated)");

        System.out.println("\n=== DELETING ARTWORK ===");
        service.deleteArtwork(2);

        System.out.println("\n=== EXCEPTION DEMO ===");
        try {
            service.updateTitle(99, "Fail");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            service.updateTitle(1, "");
        } catch (Exception e) {
            System.out.println("ERROR: Invalid input - " + e.getMessage());
        }

        System.out.println("\n=== REFLECTION OUTPUT ===");
        ReflectionUtils.inspect(list.get(0));
    }
}
