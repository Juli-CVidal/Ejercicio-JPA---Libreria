/*
// Curso Egg FullStack
 */
package Services;

// @author JulianCVidal
import Constants.Constants;
import Entities.Author;
import Persistance.AuthorDAOExt;

public class AuthorService {

    private final AuthorDAOExt DAO = new AuthorDAOExt();

    public void createAndSaveAuthor() {
        saveAuthor(createAuthor());
        System.out.println(Constants.AUTHOR_ADDED);
    }

    public Author createAuthor() {
        Author newAuthor = new Author();
        newAuthor.setName(Input.askString(Constants.ASK_NAME));
        newAuthor.setEnabled(Input.askBoolean(Constants.ASK_AVAILABLE_AUTHOR));
        return newAuthor;
    }

    public void saveAuthor(Author author) {
        DAO.save(author);
    }

    public void modifyAuthorById() {
         try {
             Integer id = Input.askInteger(Constants.ASK_AUTHOR_ID);
             if (null == id || 0 >= id) {
                 throw new Exception(Constants.INVALID_ID);
             }

             Author authorToModify = DAO.getAuthorById(id);
             authorToModify.setName(Input.askString(Constants.ASK_NAME));
             authorToModify.setEnabled(Input.askBoolean(Constants.ASK_AVAILABLE_AUTHOR));
             DAO.edit(authorToModify);
            
        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void makeAnAuthorUnavailable(){
        try {
            Integer id = Input.askInteger(Constants.ASK_AUTHOR_ID);
            if (null == id || 0 >= id) {
                throw new Exception(Constants.INVALID_ID);
            }
            DAO.makeAuthorUnavailable(id);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }
    
        public void makeAnAuthorAvailable() {
        try {
            Integer id = Input.askInteger(Constants.ASK_AUTHOR_ID);
            if (null == id || 0 >= id) {
                throw new Exception(Constants.INVALID_ID);
            }
            DAO.makeAuthorAvailable(id);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void showAuthorById() {
        try {
            Integer id = Input.askInteger(Constants.ASK_AUTHOR_ID);
            if (null == id) {
                throw new Exception(Constants.NO_NAME_ENTERED);
            }
            Author returnedAuthor = DAO.getAuthorById(id);
            if (null == returnedAuthor) {
                throw new Exception(Constants.NO_AUTHOR_FOUND);
            }
            System.out.println(returnedAuthor);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void showAuthorByName() {
        try {
            String name = Input.askString(Constants.ASK_NAME);
            if (null == name) {
                throw new Exception(Constants.NO_NAME_ENTERED);
            }
            Author returnedAuthor = DAO.getAuthorByName(name);
            if (null == returnedAuthor) {
                throw new Exception(Constants.NO_AUTHOR_FOUND);
            }
            System.out.println(returnedAuthor);
        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void showAllAuthors() {
        DAO.getAllAuthors().forEach(System.out::println);
    }
}
