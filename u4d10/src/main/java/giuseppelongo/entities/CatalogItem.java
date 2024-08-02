package giuseppelongo.entities;

import java.io.Serializable;

// Classe astratta per rappresentare un elemento del catalogo
public abstract class CatalogItem implements Serializable {
    private static final long serialVersionUID = 1L;

    // Attributi comuni a tutti gli elementi del catalogo
    private String isbn;
    private String title;
    private int publicationYear;
    private int numberOfPages;

    // Costruttore per inizializzare gli attributi comuni
    public CatalogItem(String isbn, String title, int publicationYear, int numberOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
    }

    // Getter per gli attributi
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    // Metodo toString per rappresentare l'elemento come stringa

    @Override
    public String toString() {
        return "isbn: " + isbn + ", Title: " + title + ", Year: " + publicationYear + ", Pages: " + numberOfPages;
    }
}