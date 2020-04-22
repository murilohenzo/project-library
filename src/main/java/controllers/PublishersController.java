package controllers;

import dao.ClientDAO;
import models.Publishers;
import java.util.List;

public class PublishersController {

    private ClientDAO clientDAO = new ClientDAO();
    public void insert(Publishers publisher) {
        clientDAO.insertPublishers(publisher);
    }

    public void update(Publishers publisher) {
        clientDAO.updatePublishers(publisher);
    }

    public void delete(int publisher_id){
        clientDAO.deletePublishers(publisher_id);
    }

    public List<Publishers> getAll() {
        return clientDAO.publishersList();
    }
}
