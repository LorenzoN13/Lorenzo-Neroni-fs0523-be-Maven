package week2.day4.Esercizio5;
import week2.day4.classiIeri.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Esercizio5 {
    public static void main(String[] args) {
        List<Product> prodotti= new ArrayList<>();
        prodotti.add(new Product(1L, "Book1", "Books", 120.0));
        prodotti.add(new Product(2L, "Toy1", "Toys", 25.0));
        prodotti.add(new Product(3L, "Book2", "Books", 90.0));
        prodotti.add(new Product(4L, "Laptop", "Electronics", 1500.0));
        prodotti.add(new Product(5L, "Smartphone", "Electronics", 800.0));


        Map<String, Double> importiCategoria = prodotti.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));


        System.out.println("Somma degli importi per ogni categoria:");
        importiCategoria .forEach((category, totalAmount) -> System.out.println("Categoria: " + category + ", Somma Importi: " + totalAmount));
    }
}