/*
// Curso Egg FullStack
 */
package Services;

// @author JulianCVidal
import Constants.Constants;
import Entities.*;
import Persistance.AuthorDAOExt;
import Persistance.BookDAOExt;
import Persistance.EditorialDAOExt;

import java.util.List;

public class BookService {

    private final BookDAOExt DAO = new BookDAOExt();
    private final AuthorDAOExt authorDAO = new AuthorDAOExt();
    private final EditorialDAOExt editorialDAO = new EditorialDAOExt();

    public void createAndSaveBook() throws Exception {
        saveBook(createBook());
        System.out.println(Constants.BOOK_ADDED);
    }

    public Book createBook() throws Exception {
        if (!authorDAO.existAuthor()) {
            throw new Exception(Constants.NO_AUTHOR_CREATED);
        }
        
        if (!editorialDAO.existEditorial()) {
            throw new Exception(Constants.NO_EDITORIAL_CREATED);
        }

        Book newBook = new Book();
        newBook.setIsbn(Input.askInteger(Constants.ASK_BOOK_ISBN));
        newBook.setTitle(Input.askString(Constants.ASK_BOOK_TITLE));
        newBook.setReleaseYear(Input.askPositiveInteger(Constants.ASK_BOOK_RELEASE_YEAR));

        Integer copies = Input.askPositiveInteger(Constants.ASK_COPIES);
        newBook.setCopies(copies);
        newBook.setRemainingCopies(copies);
        newBook.setBorrowedCopies(0);

        newBook.setEnabled(Input.askBoolean(Constants.ASK_AVAILABLE_BOOK));

        Author author = askAuthor();
        newBook.setAuthor(author);

        Editorial editorial = askEditorial();
        newBook.setEditorial(editorial);

        return newBook;
    }

    private Author askAuthor() throws Exception {
        String authorName;
        Author returnedAuthor;
        do {
            authorName = Input.askString(Constants.ASK_AUTHOR_NAME);
            returnedAuthor = authorDAO.getAuthorByName(authorName);
            if (null == returnedAuthor) {
                System.out.println(Constants.NO_AUTHOR_FOUND);
            }
        } while (null == returnedAuthor);
        return returnedAuthor;
    }

    private Editorial askEditorial() throws Exception {
        String editorialName;
        Editorial returnedEditorial;

        do {
            editorialName = Input.askString(Constants.ASK_EDITORIAL_NAME);
            returnedEditorial = editorialDAO.getEditorialByName(editorialName);
            if (null == returnedEditorial) {
                System.out.println(Constants.NO_EDITORIAL_FOUND);
            }
        } while (null == returnedEditorial);
        return returnedEditorial;
    }

    public void showBookByIsbn() {
        try {
            Integer isbn = Input.askInteger(Constants.ASK_BOOK_ISBN);
            if (null == isbn) {
                throw new Exception(Constants.INVALID_ISBN);
            }
            Book returnedBook = DAO.getBookByIsbn(isbn);
            if (null == returnedBook) {
                throw new Exception(Constants.NO_BOOK_FOUND);
            }
            System.out.println(returnedBook);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void showBookByTitle() {
        try {
            String title = Input.askString(Constants.ASK_BOOK_TITLE);
            if (null == title) {
                throw new Exception(Constants.NO_NAME_ENTERED);
            }
            Book returnedBook = DAO.getBookByTitle(title);
            if (null == returnedBook) {
                throw new Exception(Constants.NO_BOOK_FOUND);
            }
            System.out.println(returnedBook);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void showBooksByAuthor() {
        try {
            String authorName = Input.askString(Constants.ASK_AUTHOR_NAME);
            if (null == authorName) {
                throw new Exception(Constants.NO_NAME_ENTERED);
            }
            List<Book> returnedBooks = DAO.getBooksByAuthor(authorName);
            returnedBooks.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void showBooksByEditorial() {
        try {
            String editorialName = Input.askString(Constants.ASK_EDITORIAL_NAME);
            if (null == editorialName) {
                throw new Exception(Constants.NO_NAME_ENTERED);
            }
            List<Book> returnedBooks = DAO.getBooksByEditorial(editorialName);
            returnedBooks.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void saveBook(Book book) {
        DAO.save(book);
    }

    public void giveBook() {
        try {
            Integer isbn = Input.askInteger(Constants.ASK_BOOK_ISBN);

            Book bookToModify = DAO.getBookByIsbn(isbn);
            if (null == bookToModify) {
                System.out.println(Constants.NO_BOOK_FOUND);
                return;
            }
            if (0 == bookToModify.getRemainingCopies()) {
                System.out.println(Constants.ALL_BORROWED_COPIES);
                return;
            }

            System.out.println(Constants.DELIVERED_BOOK);
            bookToModify.setBorrowedCopies(bookToModify.getBorrowedCopies() + 1);
            bookToModify.setRemainingCopies(bookToModify.getRemainingCopies() - 1);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void returnBook() {
        try {
            Integer isbn = Input.askInteger(Constants.ASK_BOOK_ISBN);

            Book bookToModify = DAO.getBookByIsbn(isbn);
            if (null == bookToModify) {
                System.out.println(Constants.NO_BOOK_FOUND);
                return;
            }
            if (0 == bookToModify.getBorrowedCopies()) {
                System.out.println(Constants.ALL_COPIES_STORED);
                return;
            }

            System.out.println(Constants.RETURNED_BOOK);
            bookToModify.setBorrowedCopies(bookToModify.getBorrowedCopies() - 1);
            bookToModify.setRemainingCopies(bookToModify.getRemainingCopies() + 1);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }

    }

    public void showAllBooks() {
        DAO.getAllBooks().forEach(System.out::println);
    }

}
