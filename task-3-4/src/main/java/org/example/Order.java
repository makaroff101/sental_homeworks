package org.example;

import java.util.ArrayList;
import java.util.List;

class Order {
    private int id;
    private List<Book> books;
    private OrderStatus status;

    public Order(int id, List<Book> books) {
        this.id = id;
        this.books = new ArrayList<>(books);
        this.status = OrderStatus.NEW;
    }

    public int getId() {
        return id;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Заказ #" + id + " [");
        for (int i = 0; i < books.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(books.get(i).getTitle());
        }
        sb.append("] - Статус: ").append(status);
        return sb.toString();
    }
}