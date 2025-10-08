package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем книжный магазин
        BookStore store = new BookStore();

        Book book1 = new Book("Война и мир", "Лев Толстой", true);
        Book book2 = new Book("Преступление и наказание", "Федор Достоевский", true);
        Book book3 = new Book("Мастер и Маргарита", "Михаил Булгаков", false);

        store.addBook(book1);
        store.addBook(book2);
        store.addBook(book3);

        System.out.println("--- Доступные книги ---");
        store.getOrders().forEach(order -> System.out.println(order));
        System.out.println("Книги: " + Arrays.asList(book1, book2, book3));

        System.out.println("\n--- Списание книги со склада ---");
        store.removeBookFromStock(book2);

        System.out.println("\n--- Создание заказа с доступной и недоступной книгой ---");
        List<Book> orderBooks = Arrays.asList(book1, book3);
        Order order1 = store.createOrder(orderBooks);

        System.out.println("\n--- Создание запроса на книгу ---");
        store.createRequest(book2);

        System.out.println("\n--- Список заказов ---");
        for (Order order : store.getOrders()) {
            System.out.println(order);
        }

        System.out.println("\n--- Список запросов ---");
        for (BookRequest request : store.getRequests()) {
            System.out.println(request);
        }

        System.out.println("\n--- Добавление книги на склад ---");
        store.addBookToStock(book2);

        System.out.println("\n--- Попытка завершить заказ ---");
        store.addBookToStock(book3);
        store.updateOrderStatus(order1, OrderStatus.COMPLETED);

        System.out.println("\n--- Список заказов после завершения ---");
        for (Order order : store.getOrders()) {
            System.out.println(order);
        }

        System.out.println("\n--- Отмена заказа ---");
        Order order2 = store.createOrder(Arrays.asList(book2));
        store.cancelOrder(order2);

        System.out.println("\n--- Финальный статус книг ---");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
    }
}