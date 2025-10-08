package org.example;

class BookRequest {
    private int id;
    private Book book;
    private boolean fulfilled;

    public BookRequest(int id, Book book) {
        this.id = id;
        this.book = book;
        this.fulfilled = false;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    @Override
    public String toString() {
        return "Запрос #" + id + " на книгу " + book.getTitle() + " (" + (fulfilled ? "выполнен" : "ожидает") + ")";
    }
}