package giuseppelongo.interfaces;


import java.io.IOException;

// Interfaccia per le operazioni di gestione del catalogo
public interface CatalogOperations {
    void addItem(giuseppelongo.entities.CatalogItem item); // Aggiungi un elemento al catalogo

    void removeItem(String isbn); // Rimuovi un elemento dal catalogo usando l'ISBN

    void saveCatalogToFile(String filename) throws IOException; // Salva il catalogo su un file

    void loadCatalogFromFile(String filename) throws IOException, ClassNotFoundException;  // Carica il catalogo da un file
}
