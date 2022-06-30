/*
// Curso Egg FullStack
 */
package Constants;

// @author JulianCVidal
public class Constants {

    //Menus
    public static final String MAIN_MENU_OPTIONS = "\nAvailable options:"
            + "\n1.Go to Author menu"
            + "\n2.Go to Book menu"
            + "\n3.Go to Editorial menu"
            + "\n4.Exit";

    public static final String AUTHOR_MENU_OPTIONS = "\nAvailable options:"
            + "\n1.Create a new Author"
            + "\n2.Show all authors"
            + "\n3.Search an author using it's id"
            + "\n4.Search an author using it's name"
            + "\n5.Modify an author using it's id"
            + "\n6.Make an author unavailable"
            + "\n7.Make an author available"
            + "\n8.Back to Main Menu";

    public static final String BOOK_MENU_OPTIONS = "\nAvailable options:"
            + "\n1.Create a new Book"
            + "\n2.Show all books"
            + "\n3.Search a book using it's isbn"
            + "\n4.Search a book using it's name"
            + "\n5.Show all books published by an author"
            + "\n6.Show all books published by an editorial"
            + "\n7.Borrow a book"
            + "\n8.Return a borrowed book"
            + "\n9.Back to main menu";

    public static final String EDITORIAL_MENU_OPTIONS = "\nAvailable options:"
            + "\n1.Create a new Editorial"
            + "\n2.Show all editorials"
            + "\n3.Search an editorial using it's id"
            + "\n4.Search an editorial using it's name"
            + "\n5.Modify an editorial using it's id"
            + "\n6.Make an editorial unavailable"
            + "\n7.Make an editorial available"
            + "\n8.Back to main menu";

    //Related to menus
    public static final String ASK_OPTION = "Please enter an option: ";

    public static final String INVALID_OPTION = "No valid option entered";

    public static final String ASK_POSITIVE_VALUE = "Please enter a positive value: ";

    public static final String ASK_ENTER = "Press enter to continue";
    
    public static final String EXIT = "We hope you liked it!";
    
    
    //Related to exceptions
    public static final String ERROR_OCURRED = "An error ocured: ";
    
    public static final String NO_NAME_ENTERED = "The name has not been indicated";
    
    public static final String INVALID_ID = "No valid id entered";
    
    
    //-----------------------------------------------------
    //Related to the authors
    public static String NO_AUTHOR_CREATED = "No author has been created";
    
    public static final String AUTHOR_ADDED = "The author has been added successfully";
    
    public static final String ASK_AUTHOR_ID = "Please enter the author's id: ";
    
    public static final String ASK_AUTHOR_NAME = "Please enter the author's name: ";
    
    public static final String ASK_AVAILABLE_AUTHOR = "Is the author available?(Y/N) ";
    
    public static final String AUTHOR_ALREADY_AVAILABLE = "The author you want to make available is already available.";
    
    public static final String UNAVAILABLE_AUTHOR = "The author has been made unavailable successfully";

    public static final String AUTHOR_ALREADY_UNAVAILABLE = "The author you want to make unavailable is already unavailable.";

    public static final String AVAILABLE_AUTHOR = "The author has been made available successfully";

    public static final String NO_AUTHOR_FOUND = "No authors have been found with the entered info";

    
    //Related to the books
    public static final String INVALID_ISBN = "No valid isbn entered";
    
    public static final String BOOK_ADDED = "The book has been added successfully";

    public static final String ASK_BOOK_ISBN = "Please enter the isbn: ";

    public static final String ASK_BOOK_TITLE = "What is the title of the book? ";

    public static final String ASK_BOOK_RELEASE_YEAR = "What year was it released?";

    public static final String ASK_COPIES = "How many copies are available? ";

    public static final String ASK_AVAILABLE_BOOK = "Is the book available?(Y/N) ";

    public static final String ALL_BORROWED_COPIES = "The book has no remaining copies";

    public static final String ALL_COPIES_STORED = "The book has no borrowed copies";

    public static final String DELIVERED_BOOK = "The book has been successfully delivered!";
    
    public static final String RETURNED_BOOK = "The book has been successfully returned";

    public static final String DELETED_BOOK = "The book has been deleted successfully";

    public static final String NO_BOOK_FOUND = "No books have been found with the entered info";

    
    //Related to the editorials
    public static String NO_EDITORIAL_CREATED = "No editorial has been created";
    
    public static final String EDITORIAL_ADDED = "The editorial has been added successfully";
    
    public static final String ASK_EDITORIAL_ID = "Please enter the editorial's id: ";

    public static final String ASK_EDITORIAL_NAME = "Please enter the editorial's name: ";
    
    public static final String ASK_AVAILABLE_EDITORIAL = "Is the editorial available?(Y/N) ";
    
    public static final String EDITORIAL_ALREADY_UNAVAILABLE = "The editorial you want to make unavailable is already unavailable.";
    
    public static final String UNAVAILABLE_EDITORIAL = "The editorial has been made unavailable successfully";

    public static final String EDITORIAL_ALREADY_AVAILABLE = "The editorial you want to make available is already available";

    public static final String AVAILABLE_EDITORIAL = "The editorial has been made available successfully";
    
    public static final String NO_EDITORIAL_FOUND = "No editorials have been found with the entered info";
}
