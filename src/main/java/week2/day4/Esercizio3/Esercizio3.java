package week2.day4.Esercizio3;
import week2.day4.classiIeri.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Esercizio3 {
    public static void main(String[] args) {

        List<Product> prodotti= new ArrayList<>();
        prodotti.add(new Product(1L, "Book1", "Books", 120.0));
        prodotti.add(new Product(2L, "Toy1", "Toys", 25.0));
        prodotti.add(new Product(3L, "Book2", "Books", 90.0));
        prodotti.add(new Product(4L, "Laptop", "Electronics", 1500.0));
        prodotti.add(new Product(5L, "Smartphone", "Electronics", 800.0));


        Optional<Product> prodottoPiuCostoso= prodotti.stream().max(Comparator.comparingDouble(Product::getPrice));

        prodottoPiuCostoso.ifPresent(product -> System.out.println("Prodotto più costoso: " + product.getName() + ", Categoria: " + product.getCategory() + ", Prezzo: " +
                product.getPrice()));
    }
}
