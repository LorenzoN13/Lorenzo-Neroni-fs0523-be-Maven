package week2.progett;

import java.io.Serializable;

public class Libro extends Elemento  implements Serializable{
    private static final long serialVersionUID = -3035658830276022369L; // Aggiorna con il valore corretto
    private String autore;
    private String genere;

    public Libro(String codicerISBN, String titolo, int annoPublicazione, int numeroPagine, String autore, String genere) {
        super(codicerISBN, titolo, annoPublicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public String toString() {
        return "\nLibro{" +
                "CodiceISBN='" + getCodicerISBN() + '\'' +
                ", Titolo='" + getTitolo() + '\'' +
                ", Anno Pubblicazione=" + getAnnoPublicazione() +
                ", NumeroPagine=" + getNumeroPagine() +
                ", Autore='" + autore + '\'' +
                ", Genere='" + genere + '\'' +
                '}' + "\n";
    }
}
