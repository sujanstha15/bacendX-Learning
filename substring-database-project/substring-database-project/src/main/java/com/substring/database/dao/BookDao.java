package com.substring.database.dao;

import com.substring.database.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {

    //since we are working related to database, here we will inject JDBC
    private JdbcTemplate jdbcTemplate;

    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //making here all the database operation and all the method
    //save the book
    public void save(Book book){
        String query =" INSERT INTO books (title, about, author, language, available) VALUES (?,?,?,?,?) ";

        int rowsEffected = jdbcTemplate.update(

                query,
                book.getTitle(),
                book.getAbout(),
                book.getAuthor(),
                book.getLanguage(),
                book.getAvailable()

        );
        System.out.println("book added: " + rowsEffected);
       // return book;
    }

    //delete the book
    public void delete(int bookId){

        //write delete query
        String query = "DELETE FROM books where id=?";

        int rowsEffected = jdbcTemplate.update(
                query, //this is for the query we wrote above
                bookId //this is the placeholder (?)

        );


    }

    //update the book
    public void update(int bookId, Book newBook){
          String query = "UPDATE books SET title=?, about=?, author=?, language=?, available=? where id=? ";

          int rwosEffected = jdbcTemplate.update(

                  query,
                  newBook.getTitle(),
                  newBook.getAbout(),
                  newBook.getAuthor(),
                  newBook.getLanguage(),
                  newBook.getAvailable(),
                  bookId);
        System.out.println("Book updated: " + rwosEffected);

    }

    //get the book
    public Book get(int bookId){

        String query ="SELECT * FROM books where id=?";

        Book book = jdbcTemplate.queryForObject(
                query,
                new BookRowMapper(),
                bookId

        );

        return book;

    }

    public List<Book> getAll(){
        String query = "SELECT * FROM books";

        List<Book> books = jdbcTemplate.query(
                query,
                new BookRowMapper()

        );
        return books;

    }

    public List<Book> search(String titleKeyword){

        String query = "SELECT * FROM books WHERE title like ?";

        List<Book> books = jdbcTemplate.query(
                query,
                new BookRowMapper(),
                "%" + titleKeyword + "%"
        );
return books;
    }

}
