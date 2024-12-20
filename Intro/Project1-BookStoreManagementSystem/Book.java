package bookstore;

// Book class
class Book extends Product {
    private String author;

    public Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
