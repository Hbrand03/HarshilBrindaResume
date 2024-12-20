package bookstore;

// CD class
class CD extends Product {
    private String artist;

    public CD(String name, double price, int quantity, String artist) {
        super(name, price, quantity);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }
}