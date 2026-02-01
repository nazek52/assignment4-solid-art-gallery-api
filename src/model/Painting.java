package model;

public class Painting extends Artwork {
    private String technique;

    public Painting(int id, String title, double price, String technique,
                    String asciiArt, Artist artist) {
        super(id, title, price, asciiArt, artist);
        this.technique = technique;
    }

    @Override
    public double calculateValue() {
        return getPrice() * 1.2;
    }

    @Override
    public String getType() {
        return "Painting";
    }
}
