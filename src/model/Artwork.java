package model;

public abstract class Artwork {
    private int id;
    private String title;
    private double price;
    private String asciiArt;
    private Artist artist;

    protected Artwork(int id, String title, double price, String asciiArt, Artist artist) {
        this.id = id;
        this.price = price;
        this.asciiArt = asciiArt;
        this.artist = artist;
        setTitle(title);
    }

    public abstract double calculateValue();
    public abstract String getType();

    public String getDisplayName() {
        return getType() + ": " + title;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public String getAsciiArt() { return asciiArt; }
    public Artist getArtist() { return artist; }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be empty");
        }
        this.title = title;
    }
}
