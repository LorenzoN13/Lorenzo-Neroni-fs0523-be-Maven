package week2.day4.Esercizio6;

import org.apache.commons.io.FileUtils;
import week2.day4.classiIeri.Product;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Esercizio6 {
    public static void salvaProdottiSuDisco(List<Product> products, String filePath) {
        StringBuilder DatiDaSalvare = new StringBuilder();

        for (Product product : products) {
            String DatiDelProdotto = String.format("%s@%s@%.2f#", product.getName(), product.getCategory(), product.getPrice());
            DatiDaSalvare.append(DatiDelProdotto);
        }


        try {
            FileUtils.writeStringToFile(new File(filePath), DatiDaSalvare.toString(), "UTF-8");
            System.out.println("Dati salvati su disco con successo.");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio su disco: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        List<Product> prodotti = List.of(
                new Product(1L,"Book1", "Books", 120.0),
                new Product(2L,"Toy1", "Toys", 25.0),
                new Product(3L,"Shirt1", "Clothing", 30.0)
        );


        String filePath = "path/del/tuo/file.txt";

        salvaProdottiSuDisco(prodotti, filePath);
    }
}
