package bookstore;

// DVD class
class DVD extends Product {
    private String director;

    public DVD(String name, double price, int quantity, String director) {
        super(name, price, quantity);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }
}