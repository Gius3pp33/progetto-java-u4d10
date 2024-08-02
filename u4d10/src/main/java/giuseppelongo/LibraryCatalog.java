package giuseppelongo;

import giuseppelongo.entities.Book;
import giuseppelongo.entities.CatalogItem;
import giuseppelongo.interfaces.CatalogOperations;
import giuseppelongo.interfaces.Searchable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Classe per gestire il catalogo della biblioteca
public class LibraryCatalog implements CatalogOperations, Searchable {
    private List<CatalogItem> catalog;

    // Costruttore
    public LibraryCatalog() {
        this.catalog = new ArrayList<>();
    }

    //Aggiunge un elemento al catlogo
    @Override
    public void addItem(CatalogItem item) {
        catalog.add(item);
    }

    //rimuove un elemento dal catalogo
    @Override
    public void removeItem(String isbn) {
        catalog.removeIf(item -> item.getIsbn().equals(isbn));
    }

    // Cerca un elemento per isbn
    @Override
    public Optional<CatalogItem> searchByIsbn(String isbn) {
        return catalog.stream()
                .filter(item -> item.getIsbn().equals(isbn))
                .findFirst();
    }

    // Cerca elementi per anno di pubblicazione
    @Override
    public List<CatalogItem> searchByPublicationYear(int year) {
        return catalog.stream()
                .filter(item -> item.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    // Cerca libri per autore
    @Override
    public List<Book> searchByAuthor(String author) {
        return catalog.stream()
                .filter(item -> item instanceof Book)
                .map(item -> (Book) item)
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Salva il catalogo su un file
    @Override
    public void saveCatalogToFile(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(catalog);
        }
    }

    // Carica il catalogo da un file

    @Override
    public void loadCatalogFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            catalog = (List<CatalogItem>) in.readObject();
        }
    }

    // Metodo toString per rappresentare il catalogo come stringa
    @Override
    public String toString() {
        return catalog.stream()
                .map(CatalogItem::toString)
                .collect(Collectors.joining("\n"));
    }
}