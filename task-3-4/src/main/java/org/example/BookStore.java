package org.example;

import java.util.ArrayList;
import java.util.List;

class BookStore {
    private List<Book> books;
    private List<Order> orders;
    private List<BookRequest> requests;
    private int nextOrderId = 1;
    private int nextRequestId = 1;

    public BookStore() {
        this.books = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.requests = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBookFromStock(Book book) {
        if (books.contains(book)) {
            book.setInStock(false);
            System.out.println("Книга \"" + book.getTitle() + "\" списана со склада.");
        } else {
            System.out.println("Книга \"" + book.getTitle() + "\" не найдена в магазине.");
        }
    }

    public Order createOrder(List<Book> requestedBooks) {
        List<Book> availableBooks = new ArrayList<>();
        List<Book> unavailableBooks = new ArrayList<>();

        for (Book book : requestedBooks) {
            if (book.isInStock()) {
                availableBooks.add(book);
            } else {
                unavailableBooks.add(book);
            }
        }

        Order order = new Order(nextOrderId++, availableBooks);
        orders.add(order);

        for (Book book : unavailableBooks) {
            createRequest(book);
            System.out.println("Книга \"" + book.getTitle() + "\" недоступна. Создан запрос.");
        }

        System.out.println("Создан заказ #" + order.getId() + " с доступными книгами.");
        return order;
    }

    public void cancelOrder(Order order) {
        if (orders.contains(order)) {
            order.setStatus(OrderStatus.CANCELLED);
            System.out.println("Заказ #" + order.getId() + " отменен.");
        } else {
            System.out.println("Заказ #" + order.getId() + " не найден.");
        }
    }

    public void updateOrderStatus(Order order, OrderStatus status) {
        if (orders.contains(order)) {
            if (status == OrderStatus.COMPLETED) {
                // Проверяем, выполнены ли все запросы для книг в заказе
                boolean allRequestsFulfilled = true;
                for (Book book : order.getBooks()) {
                    if (!book.isInStock()) {
                        // Проверяем, есть ли выполненный запрос на эту книгу
                        boolean requestFulfilled = requests.stream()
                                .anyMatch(r -> r.getBook().equals(book) && r.isFulfilled());
                        if (!requestFulfilled) {
                            allRequestsFulfilled = false;
                            break;
                        }
                    }
                }

                if (!allRequestsFulfilled) {
                    System.out.println("Невозможно завершить заказ #" + order.getId() + ". Не все запросы выполнены.");
                    return;
                }

                // Списываем книги со склада при завершении заказа
                for (Book book : order.getBooks()) {
                    if (book.isInStock()) {
                        book.setInStock(false);
                    }
                }
            }

            order.setStatus(status);
            System.out.println("Статус заказа #" + order.getId() + " изменен на " + status + ".");
        } else {
            System.out.println("Заказ #" + order.getId() + " не найден.");
        }
    }

    public void addBookToStock(Book book) {
        if (books.contains(book)) {
            book.setInStock(true);

            for (BookRequest request : requests) {
                if (request.getBook().equals(book) && !request.isFulfilled()) {
                    request.setFulfilled(true);
                    System.out.println("Запрос #" + request.getId() + " на книгу \"" + book.getTitle() + "\" выполнен.");
                }
            }

            System.out.println("Книга \"" + book.getTitle() + "\" добавлена на склад.");
        } else {
            System.out.println("Книга \"" + book.getTitle() + "\" не найдена в магазине.");
        }
    }

    public BookRequest createRequest(Book book) {
        if (!book.isInStock()) {
            BookRequest request = new BookRequest(nextRequestId++, book);
            requests.add(request);
            System.out.println("Создан запрос #" + request.getId() + " на книгу \"" + book.getTitle() + "\".");
            return request;
        } else {
            System.out.println("Книга \"" + book.getTitle() + "\" уже в наличии. Запрос не создан.");
            return null;
        }
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public List<BookRequest> getRequests() {
        return new ArrayList<>(requests);
    }
}