package model;

public class Sculpture extends Artwork {
    private int weight;

    public Sculpture(int id, String title, double price, int weight,
                     String asciiArt, Artist artist) {
        super(id, title, price, asciiArt, artist);
        this.weight = weight;
    }

    @Override
    public double calculateValue() {
        return getPrice() * 1.5;
    }

    @Override
    public String getType() {
        return "Sculpture";
    }
}
