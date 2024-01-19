package week2.progett;

import java.io.Serializable;

public class Elemento  implements Serializable {
    private String codicerISBN;
    private  String titolo;
    private int annoPublicazione;
    private int numeroPagine;

    public Elemento(String codicerISBN, String titolo, int annoPublicazione, int numeroPagine) {
        this.codicerISBN = codicerISBN;
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getCodicerISBN() {
        return codicerISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }
}
