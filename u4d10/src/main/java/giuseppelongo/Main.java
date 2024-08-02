package giuseppelongo;


import giuseppelongo.entities.Book;
import giuseppelongo.entities.Magazine;
import giuseppelongo.enums.MagazinePeriodicity;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Visualizza catalogo");
            System.out.println("2. Aggiungi un elemento");
            System.out.println("3. Rimuovi un elemento (isbn)");
            System.out.println("4. Cerca per isbn");
            System.out.println("5. Cerca per anno di pubblicazione");
            System.out.println("6. Cerca per autore");
            System.out.println("7. Salva catalogo su disco");
            System.out.println("8. Carica catalogo da disco");
            System.out.println("9. Esci");

            System.out.print("Scegli un'opzione: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        // Visualizza il catalogo
                        System.out.println("Catalogo:");
                        System.out.println(catalog);
                        break;
                    case 2:
                        // Aggiunge un elemento
                        System.out.print("Tipo di elemento (libro/rivista): ");
                        String type = scanner.nextLine();
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Titolo: ");
                        String title = scanner.nextLine();
                        System.out.print("Anno di pubblicazione: ");
                        int year = scanner.nextInt();
                        System.out.print("Numero di pagine: ");
                        int pages = scanner.nextInt();
                        scanner.nextLine();

                        if (type.equalsIgnoreCase("libro")) {
                            System.out.print("Autore: ");
                            String author = scanner.nextLine();
                            System.out.print("Genere: ");
                            String genre = scanner.nextLine();
                            catalog.addItem(new Book(isbn, title, year, pages, author, genre));
                        } else if (type.equalsIgnoreCase("rivista")) {
                            System.out.print("Periodicità (SETTIMANALE, MENSILE, SEMESTRALE): ");
                            String periodicityStr = scanner.nextLine();
                            MagazinePeriodicity periodicity = MagazinePeriodicity.valueOf(periodicityStr.toUpperCase());
                            catalog.addItem(new Magazine(isbn, title, year, pages, periodicity));
                        } else {
                            System.out.println("Tipo di elemento non valido.");
                        }
                        break;
                    case 3:
                        // Rimuove un elemento dato un codice isbn
                        System.out.print("Inserisci isbn: ");
                        String removeIsbn = scanner.nextLine();
                        catalog.removeItem(removeIsbn);
                        break;
                    case 4:
                        // Ricerca per isbn
                        System.out.print("Inserisci isbn: ");
                        String searchIsbn = scanner.nextLine();
                        catalog.searchByIsbn(searchIsbn).ifPresentOrElse(
                                System.out::println,
                                () -> System.out.println("Elemento non trovato")
                        );
                        break;
                    case 5:
                        // Ricerca per anno pubblicazione
                        System.out.print("Inserisci anno di pubblicazione: ");
                        int searchYear = scanner.nextInt();
                        scanner.nextLine();
                        catalog.searchByPublicationYear(searchYear).forEach(System.out::println);
                        break;
                    case 6:
                        // Ricerca per autore
                        System.out.print("Inserisci autore: ");
                        String searchAuthor = scanner.nextLine();
                        catalog.searchByAuthor(searchAuthor).forEach(System.out::println);
                        break;
                    case 7:
                        // Salvataggio su disco dell'archivio
                        System.out.print("Nome del file per il salvataggio: ");
                        String saveFile = scanner.nextLine();
                        catalog.saveCatalogToFile(saveFile);
                        break;
                    case 8:
                        // Caricamento dal disco dell'archivio
                        System.out.print("Nome del file per il caricamento: ");
                        String loadFile = scanner.nextLine();
                        catalog.loadCatalogFromFile(loadFile);
                        break;
                    case 9:
                        System.out.println("Uscita...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opzione non valida.");
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Errore: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Input non valido: " + e.getMessage());
            }
        }
    }
}