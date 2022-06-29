/*
// Curso Egg FullStack
 */
package Orchestrator;

// @author JulianCVidal
import Constants.Constants;
import Services.AuthorService;
import Services.BookService;
import Services.EditorialService;
import Services.Input;
import java.util.Objects;

public class Orchestrator {

    public static final AuthorService AUTHOR_SERVICE = new AuthorService();
    public static final BookService BOOK_SERVICE = new BookService();
    public static final EditorialService EDITORIAL_SERVICE = new EditorialService();

    public static void mainMenu() {
        Integer opc, exitOption = 4;
        do {
            System.out.println(Constants.MAIN_MENU_OPTIONS);
            opc = Input.askInteger(Constants.ASK_OPTION);
            if (!validateOption(opc, exitOption)) {
                continue;
            }
            System.out.println();

            switch (opc) {
                case 1: //author menu
                    authorMenu();
                    break;

                case 2: //book menu
                    bookMenu();
                    break;

                case 3: //editorial menu
                    editorialMenu();
                    break;
            }
        } while (!Objects.equals(exitOption, opc));
        System.out.println(Constants.EXIT);
    }

    public static void authorMenu() {
        Integer opc, exitOption = 8;
        do {
            System.out.println(Constants.AUTHOR_MENU_OPTIONS);
            opc = Input.askInteger(Constants.ASK_OPTION);
            if (!validateOption(opc, exitOption)) {
                continue;
            }
            System.out.println();

            switch (opc) {
                case 1: //create an author
                    AUTHOR_SERVICE.createAndSaveAuthor();
                    break;
                case 2: //show all editorials
                    AUTHOR_SERVICE.showAllAuthors();
                    break;
                case 3: //search an author using id
                    AUTHOR_SERVICE.showAuthorById();
                    break;
                case 4: //search an author using name
                    AUTHOR_SERVICE.showAuthorByName();
                    break;
                case 5: //modify an author using id
                    AUTHOR_SERVICE.modifyAuthorById();
                    break;
                case 6: //make an author unavailable
                    AUTHOR_SERVICE.makeAnAuthorUnavailable();
                    break;
                case 7: //make an author available
                    AUTHOR_SERVICE.makeAnAuthorAvailable();
                    break;
            }
            askEnter();
        } while (!Objects.equals(exitOption, opc));
    }

    public static void bookMenu() {
        Integer opc, exitOption = 9;
        do {
            System.out.println(Constants.BOOK_MENU_OPTIONS);
            opc = Input.askInteger(Constants.ASK_OPTION);
            if (!validateOption(opc, exitOption)) {
                continue;
            }
            System.out.println();

            switch (opc) {
                case 1: //create a book
                    BOOK_SERVICE.createAndSaveBook();
                    break;
                case 2: //show all books
                    BOOK_SERVICE.showAllBooks();
                    break;
                case 3: //search a book using isbn
                    BOOK_SERVICE.showBookByIsbn();
                    break;
                case 4: //search a book using name
                    BOOK_SERVICE.showBookByTitle();
                    break;
                case 5: //show all author's books
                    BOOK_SERVICE.showBooksByAuthor();
                    break;
                case 6: //show all editorial's book
                    BOOK_SERVICE.showBooksByEditorial();
                    break;
                case 7: //borrow a book
                    BOOK_SERVICE.giveBook();
                    break;
                case 8: //return a book
                    BOOK_SERVICE.returnBook();
                    break;
            }
            askEnter();
        } while (!Objects.equals(exitOption, opc));
    }

    public static void editorialMenu() {
        Integer opc, exitOption = 8;
        do {
            System.out.println(Constants.EDITORIAL_MENU_OPTIONS);
            opc = Input.askInteger(Constants.ASK_OPTION);
            if (!validateOption(opc, exitOption)) {
                continue;
            }
            System.out.println();

            switch (opc) {
                case 1: //create an editorial
                    EDITORIAL_SERVICE.createAndSaveEditorial();
                    break;
                case 2: //show all editorials
                    EDITORIAL_SERVICE.showAllEditorials();
                    break;
                case 3: //search an editorial using id
                    EDITORIAL_SERVICE.showEditorialById();
                    break;
                case 4: //search an editorial using name
                    EDITORIAL_SERVICE.showEditorialByName();
                    break;
                case 5: //modify an editorial using id
                    EDITORIAL_SERVICE.modifyEditorialById();
                    break;
                case 6: //make an editorial unavailable
                    EDITORIAL_SERVICE.makeAnEditorialUnavailable();
                    break;
                case 7: //make an editorial available
                    EDITORIAL_SERVICE.makeAnEditorialAvailable();
                    break;
            }
            askEnter();
        } while (!Objects.equals(exitOption, opc));
    }

    private static boolean validateOption(Integer option, Integer lastOption) {
        if (null == option) {
            return false;
        }
        if (1 > option || lastOption < option) {
            System.out.println(Constants.INVALID_OPTION);
            return false;
        }
        return !Objects.equals(option, lastOption);
    }

    private static void askEnter() {
        String pass = Input.askString(Constants.ASK_ENTER);
    }
}
