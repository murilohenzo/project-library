package dao;

import models.Authors;
import models.Books;
import models.Publishers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/projetoBancoJava";
        String user = "root";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
        }
    }

    public void insertAuthor(Authors authors) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Authors values(?, ?, ?)");
            preparedStatement.setInt(1, authors.author_id);
            preparedStatement.setString(2, authors.name);
            preparedStatement.setString(3, authors.fname);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        }finally {
            closeConnection(connection);
        }
    }

    public void updateAuthor(Authors author) {
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update Authors set name = ?, fname = ? where author_id = ?");
            preparedStatement.setString(1, author.name);
            preparedStatement.setString(2, author.fname);
            preparedStatement.setInt(3, author.author_id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        }finally {
            closeConnection(connection);
        }
    }

    public void deleteAuthor(int author_id) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Authors where author_id = ?");
            preparedStatement.setInt(1, author_id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            closeConnection(connection);
        }
    }

    public List<Authors> authorsList() {
        ArrayList<Authors> authors = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Authors");
            while (resultSet.next()) {
                authors.add(new Authors(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            closeConnection(connection);
        }
        return authors;
    }

    // Publishers
    public void insertPublishers(Publishers publisher) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Publishers values(?, ?, ?)");
            preparedStatement.setInt(1, publisher.publisher_id);
            preparedStatement.setString(2, publisher.name);
            preparedStatement.setString(3, publisher.url);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        }finally {
            closeConnection(connection);
        }
    }
    public void updatePublishers(Publishers publisher) {
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update Publishers set name = ?, url = ? where publisher_id = ?");
            preparedStatement.setString(1, publisher.name);
            preparedStatement.setString(2, publisher.url);
            preparedStatement.setInt(3, publisher.publisher_id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        }finally {
            closeConnection(connection);
        }
    }
    public void deletePublishers(int publisher_id) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Publishers where publisher_id = ?");
            preparedStatement.setInt(1, publisher_id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            closeConnection(connection);
        }
    }

    public List<Publishers> publishersList() {
        ArrayList<Publishers> publishers = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Publishers");
            while (resultSet.next()) {
                publishers.add(new Publishers(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            closeConnection(connection);
        }
        return publishers;
    }

    // Books
    public void insertBooks(Books book) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Books values(?, ?, ?, ?)");
            preparedStatement.setString(1, book.title);
            preparedStatement.setString(2, book.isbn);
            preparedStatement.setInt(3, book.publisher_id);
            preparedStatement.setFloat(4, book.price);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        }finally {
            closeConnection(connection);
        }
    }
    public void updateBooks(Books book) {
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update Books set title = ?, publisher_id = ?, price = ? where isbn = ?");
            preparedStatement.setString(1, book.title);
            preparedStatement.setFloat(2, book.publisher_id);
            preparedStatement.setFloat(3, book.price);
            preparedStatement.setString(4, book.isbn);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        }finally {
            closeConnection(connection);
        }
    }
    public void deleteBooks(String isbn) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from Books where isbn = ?");
            preparedStatement.setString(1, isbn);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            closeConnection(connection);
        }
    }

    public List<Books> booksList() {
        ArrayList<Books> books = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Books");
            while (resultSet.next()) {
                books.add(new Books(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getFloat(4)));
            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            closeConnection(connection);
        }
        return books;
    }

    public List<Books> searchBooks(String title) {
        ArrayList<Books> books = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select Books.*, BooksAuthors.author_id, Authors.name, Authors.fname, Publishers.name from Books  \n" +
                    "inner join Publishers on Books.publisher_id = Publishers.publisher_id \n" +
                    "inner join BooksAuthors on Books.isbn = BooksAuthors.isbn \n" +
                    "inner join Authors on BooksAuthors.author_id = Authors.author_id where title like ?;");
            preparedStatement.setString(1, '%' + title + '%');
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                books.add(new Books(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getFloat(4)
                , resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8)));
            }
        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            closeConnection(connection);
        }
        return books;
    }

}
