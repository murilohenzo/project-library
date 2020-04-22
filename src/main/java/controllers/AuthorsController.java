package controllers;

import dao.ClientDAO;
import models.Authors;
import java.util.List;

public class AuthorsController {
    private ClientDAO clientDAO = new ClientDAO();
    public void insert(Authors authors) {
        clientDAO.insertAuthor(authors);
    }

    public void update(Authors authors) {
        clientDAO.updateAuthor(authors);
    }

    public void delete(int author_id){
        clientDAO.deleteAuthor(author_id);
    }

    public List<Authors> getAll() {
        return clientDAO.authorsList();
    }
}
