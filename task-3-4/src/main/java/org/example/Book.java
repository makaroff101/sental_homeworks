package org.example;

class Book {
    private String title;
    private String author;
    private boolean inStock;

    public Book(String title, String author, boolean inStock) {
        this.title = title;
        this.author = author;
        this.inStock = inStock;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (" + (inStock ? "в наличии" : "отсутствует") + ")";
    }
}