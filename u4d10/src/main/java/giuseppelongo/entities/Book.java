package giuseppelongo.entities;

public class Book extends CatalogItem {
    private static final long serialVersionUID = 1L;

    // Attributi specifici per i libri
    private String author;
    private String genre;

    // Costruttore
    public Book(String isbn, String title, int publicationYear, int numberOfPages, String author, String genre) {
        super(isbn, title, publicationYear, numberOfPages);
        this.author = author;
        this.genre = genre;
    }

    // Getter
    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    // Metodo toString per rappresentare il libro come stringa
    @Override
    public String toString() {
        return super.toString() + ", Author: " + author + ", Genre: " + genre;
    }
}