/*
// Curso Egg FullStack
 */
package Persistance;

// @author JulianCVidal
import Constants.Constants;
import Entities.Book;
import java.util.List;

public class BookDAOExt extends DAO<Book> {

    public List<Book> getAllBooks() {
        connect();
        List<Book> returnedBooks = em.createQuery(
                "SELECT b FROM Book b").getResultList();
        disconnect();
        return returnedBooks;
    }

    public Book getBookByIsbn(Integer isbn) {
        connect();
        Book returnedBook = (Book) em.createQuery(
                "SELECT b FROM Book b WHERE b.isbn LIKE :isbn")
                .setParameter("isbn", isbn)
                .getSingleResult();
        
        disconnect();
        return returnedBook;
    }

    public Book getBookByTitle(String title) {
        connect();
        Book returnedBook = (Book) em.createQuery(
                "SELECT b FROM Book b WHERE b.title LIKE :title")
                .setParameter("title", title)
                .getSingleResult();
        disconnect();
        return returnedBook;
    }

    public List<Book> getBooksByAuthor(String authorName) {
        connect();
        List<Book> returnedBooks = em.createQuery(
                "SELECT b FROM Book b WHERE b.author.name LIKE :name")
                .setParameter("name", authorName)
                .getResultList();
        disconnect();
        return returnedBooks;
    }

    public List<Book> getBooksByEditorial(String editorialName) {
        connect();
        List<Book> returnedBooks = em.createQuery(
                "SELECT b FROM Book b WHERE b.editorial.name LIKE :name")
                .setParameter("name", editorialName)
                .getResultList();
        disconnect();
        return returnedBooks;
    }

    protected void deleteBookByIsbn(Integer isbn) throws Exception {
        Book bookToDelete = getBookByIsbn(isbn);
        if (null == bookToDelete){
            throw new Exception(Constants.NO_BOOK_FOUND);
        }
        super.delete(bookToDelete);
    }

    @Override
    protected void edit(Book object) {
        super.edit(object);
    }

    @Override
    public void save(Book object) {
        super.save(object);
    }
}
