package models;

public class Books{
    public String title;
    public String isbn;
    public String author_name, author_fname;
    public String publisher_name;
    public int publisher_id, author_id;
    public float price;


    public Books() {}

    public Books(String title, String isbn, int publisher_id, float price) {
        this.title = title;
        this.isbn = isbn;
        this.publisher_id = publisher_id;
        this.price = price;
    }

    public Books(String title, String isbn, int publisher_id, float price, int author_id, String author_name, String author_fname, String publisher_name) {
        this.title = title;
        this.isbn = isbn;
        this.publisher_id = publisher_id;
        this.price = price;
        this.author_id = author_id;
        this.author_name = author_name;
        this.author_fname = author_fname;
        this.publisher_name = publisher_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_fname() {
        return author_fname;
    }

    public void setAuthor_fname(String author_fname) {
        this.author_fname = author_fname;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }
}
