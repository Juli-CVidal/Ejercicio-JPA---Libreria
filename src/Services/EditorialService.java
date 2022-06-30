/*
// Curso Egg FullStack
 */
package Services;

// @author JulianCVidal
import Constants.Constants;
import Entities.Editorial;
import Persistance.EditorialDAOExt;

public class EditorialService {

    private final EditorialDAOExt DAO = new EditorialDAOExt();

    public void createAndSaveEditorial() {
        saveEditorial(createEditorial());
        System.out.println(Constants.EDITORIAL_ADDED);
    }

    public Editorial createEditorial() {
        Editorial newEditorial = new Editorial();
        newEditorial.setName(Input.askString(Constants.ASK_EDITORIAL_NAME));
        newEditorial.setEnabled(Input.askBoolean(Constants.ASK_AVAILABLE_EDITORIAL));
        return newEditorial;
    }

    public void saveEditorial(Editorial editorial) {
        DAO.save(editorial);
    }

    public void modifyEditorialById() {
        try {
            Integer id = Input.askInteger(Constants.ASK_EDITORIAL_ID);
            if (null == id || 0 >= id) {
                throw new Exception(Constants.INVALID_ID);
            }

            Editorial authorToModify = DAO.getEditorialById(id);
            authorToModify.setName(Input.askString(Constants.ASK_EDITORIAL_NAME));
            authorToModify.setEnabled(Input.askBoolean(Constants.ASK_AVAILABLE_EDITORIAL));
            DAO.edit(authorToModify);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void makeAnEditorialUnavailable() {
        try {
            Integer id = Input.askInteger(Constants.ASK_EDITORIAL_ID);
            if (null == id || 0 >= id) {
                throw new Exception(Constants.INVALID_ID);
            }
            DAO.makeEditorialUnavailable(id);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void makeAnEditorialAvailable() {
        try {
            Integer id = Input.askInteger(Constants.ASK_EDITORIAL_ID);
            if (null == id || 0 >= id) {
                throw new Exception(Constants.INVALID_ID);
            }
            DAO.makeEditorialAvailable(id);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void showEditorialById() {
        try {
            Integer id = Input.askInteger(Constants.ASK_EDITORIAL_ID);
            if (null == id) {
                throw new Exception(Constants.INVALID_ID);
            }
            Editorial returnedEditorial = DAO.getEditorialById(id);
            if (null == returnedEditorial) {
                throw new Exception(Constants.NO_EDITORIAL_FOUND);
            }
            System.out.println(returnedEditorial);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void showEditorialByName() {
        try {
            String name = Input.askString(Constants.ASK_EDITORIAL_NAME);
            if (null == name) {
                throw new Exception(Constants.NO_NAME_ENTERED);
            }
            Editorial returnedAuthor = DAO.getEditorialByName(name);
            if (null == returnedAuthor) {
                throw new Exception(Constants.NO_EDITORIAL_FOUND);
            }
            System.out.println(returnedAuthor);

        } catch (Exception e) {
            System.out.println(Constants.ERROR_OCURRED);
            System.out.println(e.toString());
        }
    }

    public void showAllEditorials() {
        DAO.getAllEditorials().forEach(System.out::println);
    }

}
