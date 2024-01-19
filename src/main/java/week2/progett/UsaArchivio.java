package week2.progett;



import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UsaArchivio {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Archivio archivio = new Archivio();

        // Aggiunta di un libro
        Libro libro1 = new Libro("123456789", "Il Signore degli Anelli", 1954, 1030, "Rolf Sellin e C. Malimpensa", "Fantasy");
        Libro libro2 = new Libro("236345634", "La ragazza di Teheran", 1984, 1020, "Fabio Volo", "Fantasy");
        Libro libro3 = new Libro("623512542", "I bambini del treno", 1994, 1060, "Marco Travaglio", "Fantasy");
        Libro libro4 = new Libro("367562365", "Treno Locale: Un avvincente giallo britannico", 1934, 1070, "Donato Carrisi", "Fantasy");
        Libro libro5 = new Libro("835676134", "Gli aghi d’oro", 1924, 990, "Antonio Scurati", "Fantasy");
        Libro libro6 = new Libro("164563414", "Le otto montagne", 1954, 908, " Fox Offerte", "Fantasy");
        Libro libro7 = new Libro("754264351", "Le persone sensibili hanno una marcia in più", 1964, 876, "Jack Benton e Cristiana Francone", "Fantasy");
        Libro libro8 = new Libro("617351234", "L'educazione delle farfalle", 1978, 787, "Ilaria Tuti", "Fantasy");
        archivio.aggiungiElemento(libro1);
        archivio.aggiungiElemento(libro2);
        archivio.aggiungiElemento(libro3);
        archivio.aggiungiElemento(libro4);
        archivio.aggiungiElemento(libro5);
        archivio.aggiungiElemento(libro6);
        archivio.aggiungiElemento(libro7);
        archivio.aggiungiElemento(libro8);

        // Rimozione di un libro
        archivio.rimuoviElementoPerISBN("123456789");

        // Salvataggio su disco
        try {
            archivio.salvataggioSuDisco("archivio.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Caricamento da disco
        try {
            List<Libro> libriCaricati = archivio.caricamentoDaDisco("archivio.dat");
            System.out.println("Libri caricati da disco: " + libriCaricati);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Elenco dei codici ISBN: " + archivio.elencoCodiciISBN());

        System.out.println("Inserire il Codice ISBN:");
        String isbn = scanner.nextLine();

        // Ricerca per ISBN
        Optional<Elemento> risultatoRicerca = archivio.ricercaPerISBN(isbn);
        risultatoRicerca.ifPresent(libro -> System.out.println("Libro trovato: " + libro.getTitolo()));

    }
}
