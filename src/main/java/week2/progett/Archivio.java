package week2.progett;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Archivio  implements Serializable{
    private List<Elemento> catalogo = new ArrayList<>();

    public void aggiungiElemento(Elemento elemento){
        catalogo.add(elemento);
    }

    public void rimuoviElementoPerISBN(String codiceISBN){
        catalogo.removeIf(e -> e.getCodicerISBN().equals(codiceISBN));
    }

    public List<Elemento> ricercaPerAnnoPubblicazione(int anno) {
        return catalogo.stream().filter(e -> e.getAnnoPublicazione() == anno).collect(Collectors.toList());
    }
    public Optional<Elemento> ricercaPerISBN(String codiceISBN){
        return catalogo.stream().filter(e -> e.getCodicerISBN().equals(codiceISBN)).findFirst();
    }

    public List<Elemento> ricercaPerAutore(String autore){
        return catalogo.stream().filter(e -> e instanceof Libro && ((Libro) e).getAutore().equals(autore)).collect(Collectors.toList());
    }

    public void salvataggioSuDisco(String filePath) throws IOException {
        File file = new File("filepath/file.txt");

        try  {
            FileUtils.writeStringToFile(file, catalogo.toString(), Charset.defaultCharset(), true);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Libro> caricamentoDaDisco(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Libro>) ois.readObject();
        }
    }

    public List<String> elencoCodiciISBN() {
        return catalogo.stream().map(Elemento::getCodicerISBN).collect(Collectors.toList());
    }
}
