/*
// Curso Egg FullStack
 */
package Persistance;

// @author JulianCVidal
import Constants.Constants;
import Entities.Editorial;
import java.util.List;

public class EditorialDAOExt extends DAO<Editorial> {

    public Integer countEditorials() {
        return em.createQuery("SELECT count(e.id) FROM Editorial e").getFirstResult();
    }

    public boolean existEditorial() {
        return 0 != countEditorials();
    }

    public List<Editorial> getAllEditorials() {
        connect();
        List<Editorial> returnedEditorials = em.createQuery(
                "SELECT e FROM Editorial e")
                .getResultList();

        disconnect();
        return returnedEditorials;
    }

    public Editorial getEditorialById(Integer id) throws Exception {
        if (null == id || 0 >= id) {
            throw new Exception(Constants.INVALID_ID);
        }
        connect();
        Editorial returnedEditorial = (Editorial) em.createQuery(
                "SELECT e FROM Editorial e WHERE e.id LIKE :id").
                setParameter("id", id)
                .getSingleResult();

        disconnect();
        return returnedEditorial;
    }

    public Editorial getEditorialByName(String name) throws Exception {
        if (null == name) {
            throw new Exception(Constants.NO_NAME_ENTERED);
        }
        connect();
        Editorial returnedEditorial = (Editorial) em.createQuery(
                "SELECT e FROM Editorial e WHERE e.name LIKE :name")
                .setParameter("name", name)
                .getSingleResult();

        disconnect();
        return returnedEditorial;
    }

    public void makeEditorialUnavailable(Integer id) throws Exception {
        if (null == id || 0 >= id) {
            throw new Exception(Constants.INVALID_ID);
        }

        Editorial editorialToDelete = getEditorialById(id);
        if (null == editorialToDelete) {
            throw new Exception(Constants.NO_EDITORIAL_FOUND);
        }
        if (false == editorialToDelete.getEnabled()) {
            throw new Exception(Constants.EDITORIAL_ALREADY_UNAVAILABLE);
        }
        System.out.println(Constants.UNAVAILABLE_EDITORIAL);
        editorialToDelete.setEnabled(false);
        super.edit(editorialToDelete);
    }

    public void makeEditorialAvailable(Integer id) throws Exception {
        if (null == id || 0 >= id) {
            throw new Exception(Constants.INVALID_ID);
        }

        Editorial editorialToDelete = getEditorialById(id);
        if (null == editorialToDelete) {
            throw new Exception(Constants.NO_EDITORIAL_FOUND);
        }
        if (true == editorialToDelete.getEnabled()) {
            throw new Exception(Constants.EDITORIAL_ALREADY_AVAILABLE);
        }
        System.out.println(Constants.AVAILABLE_EDITORIAL);
        editorialToDelete.setEnabled(true);
        super.edit(editorialToDelete);
    }

    @Override
    public void edit(Editorial object) {
        super.edit(object);
    }

    @Override
    public void save(Editorial object) {
        super.save(object);
    }

}
