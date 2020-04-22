package models;

public class BooksAuthors {
    public String isbn;
    public int author_id;
    public int seq_no;

    public BooksAuthors(){}

    public BooksAuthors(String isbn, int author_id, int seq_no) {
        this.isbn = isbn;
        this.author_id = author_id;
        this.seq_no = seq_no;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getSeq_no() {
        return seq_no;
    }

    public void setSeq_no(int seq_no) {
        this.seq_no = seq_no;
    }
}
