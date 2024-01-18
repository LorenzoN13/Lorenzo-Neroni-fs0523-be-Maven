package week2.day4.Esercizio1;
import week2.day4.classiIeri.Product;
import week2.day4.classiIeri.Customer;
import week2.day4.classiIeri.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Esercizio1 {

    public static void main(String[] args) {
        List<Product> prodotti = new ArrayList<>();
        prodotti.add(new Product(1L, "Book1", "Books", 120.0));
        prodotti.add(new Product(2L, "Toy1", "Toys", 25.0));
        prodotti.add(new Product(3L, "Book2", "Books", 90.0));

        List<Customer> clienti = new ArrayList<>();
        clienti.add(new Customer(1L, "Customer1", 1));
        clienti.add(new Customer(2L, "Customer2", 2));
        clienti.add(new Customer(3L, "Customer3", 2));

        List<Order> ordini = new ArrayList<>();
        ordini.add(new Order(1L, "Shipped", LocalDate.parse("2021-02-05"), LocalDate.parse("2021-02-10"), prodotti.subList(0, 1),clienti.get(0)));
        ordini.add(new Order(2L, "Pending", LocalDate.parse("2021-03-15"), LocalDate.parse("2021-03-20"), prodotti.subList(1, 2), clienti.get(1)));
        ordini.add(new Order(3L, "Delivered", LocalDate.parse("2021-04-01"), LocalDate.parse("2021-04-05"), prodotti.subList(2, 3), clienti.get(2)));
        ordini.add(new Order(4L, "Shipped", LocalDate.parse("2021-04-05"), LocalDate.parse("2021-04-10"), prodotti.subList(0, 1), clienti.get(1)));

        Map<Customer, List<Order>> OrdiniClienti = ordini.stream().collect(Collectors.groupingBy(Order::getCustomer));

        System.out.println("Raggruppamento degli ordini per cliente:");
        OrdiniClienti.forEach((customer, customerOrders) -> {
            System.out.println("Cliente: " + customer.getName());
            System.out.println("Ordini:");
            customerOrders.forEach(order -> {
                System.out.println("  - Ordine ID: " + order.getId() + ", Stato dell'ordine: " + order.getStatus() + ", Data dell'ordine: " + order.getOrderDate());});
            System.out.println();
        });
    }
}
