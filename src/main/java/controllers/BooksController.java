package controllers;

import dao.ClientDAO;
import models.Books;
import java.util.List;

public class BooksController {
    private ClientDAO clientDAO = new ClientDAO();
    public void insert(Books book) {
        clientDAO.insertBooks(book);
    }

    public void update(Books book) {
        clientDAO.updateBooks(book);
    }

    public void delete(String isbn) {
        clientDAO.deleteBooks(isbn);
    }

    public List<Books> getAll() {
        return clientDAO.booksList();
    }

    public  List<Books> search(String title) { return clientDAO.searchBooks(title); }

}
