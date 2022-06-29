/*
// Curso Egg FullStack
 */
package Persistance;

// @author JulianCVidal
import Constants.Constants;
import Entities.Author;
import java.util.List;

public class AuthorDAOExt extends DAO<Author> {

    public List<Author> getAllAuthors() {
        connect();
        List<Author> returnedAuthors = em.createQuery(
                "SELECT a FROM Author a")
                .getResultList();

        disconnect();
        return returnedAuthors;
    }

    public Author getAuthorById(Integer id) throws Exception {
        if (null == id || 0 >= id) {
            throw new Exception(Constants.INVALID_ID);
        }
        connect();
        Author returnedAuthor = (Author) em.createQuery(
                "SELECT a FROM Author a WHERE a.id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();

        disconnect();
        return returnedAuthor;
    }

    public Author getAuthorByName(String name) throws Exception {
        if (null == name) {
            throw new Exception(Constants.NO_NAME_ENTERED);
        }
        connect();
        Author returnedAuthor = (Author) em.createQuery(
                "SELECT a FROM Author a WHERE a.name LIKE :name")
                .setParameter("name", name)
                .getSingleResult();

        disconnect();
        return returnedAuthor;
    }

    public void makeAuthorUnavailable(Integer id) throws Exception {
        if (null == id || 0 >= id) {
            throw new Exception(Constants.INVALID_ID);
        }

        Author authorToDelete = getAuthorById(id);
        if (null == authorToDelete) {
            throw new Exception(Constants.NO_AUTHOR_FOUND);
        }
        if (false == authorToDelete.getEnabled()) {
            throw new Exception(Constants.AUTHOR_ALREADY_UNAVAILABLE);
        }
        authorToDelete.setEnabled(false);
        super.edit(authorToDelete);
    }

    public void makeAuthorAvailable(Integer id) throws Exception {
        if (null == id || 0 >= id) {
            throw new Exception(Constants.INVALID_ID);
        }

        Author authorToDelete = getAuthorById(id);
        if (null == authorToDelete) {
            throw new Exception(Constants.NO_AUTHOR_FOUND);
        }
        if (true == authorToDelete.getEnabled()) {
            throw new Exception(Constants.AUTHOR_ALREADY_AVAILABLE);
        }
        authorToDelete.setEnabled(true);
        super.edit(authorToDelete);
    }

    @Override
    public void edit(Author object) {
        super.edit(object);
    }

    @Override
    public void save(Author object) {
        super.save(object);
    }

}
