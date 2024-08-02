package giuseppelongo.entities;

import giuseppelongo.enums.MagazinePeriodicity;


public class Magazine extends CatalogItem {
    private static final long serialVersionUID = 1L;

    // Attributo
    private MagazinePeriodicity periodicity;

    //Costruttore
    public Magazine(String isbn, String title, int publicationYear, int numberOfPages, MagazinePeriodicity periodicity) {
        super(isbn, title, publicationYear, numberOfPages);
        this.periodicity = periodicity;
    }

    // Getter
    public MagazinePeriodicity getPeriodicity() {
        return periodicity;
    }

    // Metodo toString per rappresentare la rivista come stringa
    @Override
    public String toString() {
        return super.toString() + ", Periodicity: " + periodicity;
    }
}