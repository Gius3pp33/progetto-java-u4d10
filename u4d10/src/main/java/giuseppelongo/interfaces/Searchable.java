package giuseppelongo.interfaces;

import giuseppelongo.entities.Book;
import giuseppelongo.entities.CatalogItem;

import java.util.List;
import java.util.Optional;

// Interfaccia per le operazioni di ricerca nel catalogo
public interface Searchable {
    Optional<CatalogItem> searchByIsbn(String isbn); // Cerca un elemento per ISBN

    List<CatalogItem> searchByPublicationYear(int year);  // Cerca elementi per anno di pubblicazione

    List<Book> searchByAuthor(String author); // Cerca libri per autore
}