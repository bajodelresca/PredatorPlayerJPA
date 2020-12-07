package controller;

import DAO.ArtistaDAO;
import java.util.List;
import model.Artista;
import model.Disco;

/**
 *
 * @author Jorge SB
 */
public class ArtistaController {

    private static ArtistaController instancia = null;

    public static ArtistaController getInstance() {
        instancia = new ArtistaController();
        return instancia;
    }

    public List<Artista> getAllArtists() {
        ArtistaDAO aDAO = new ArtistaDAO();
        return aDAO.getAll();
    }

    public Artista getArtistsById(int id) {
        ArtistaDAO aDAO = new ArtistaDAO(id);
        Artista a=new Artista(aDAO);
        return a;
    }

    public boolean insertArtists(Artista a) {
        boolean result = false;
        if (a != null) {
            ArtistaDAO aDAO = new ArtistaDAO();
            aDAO.insert(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean editArtists(Artista a) {
        boolean result = false;
        if (a != null) {
            ArtistaDAO aDAO = new ArtistaDAO();
            aDAO.edit(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean removeArtists(Artista a) {
        boolean result = false;
        if (a != null) {
            ArtistaDAO aDAO = new ArtistaDAO();
            aDAO.remove(a);
        } else {
            result = false;
        }
        return result;
    }
    
    
    public List<Disco> getRepertorio(int ID) {
        ArtistaDAO aDAO = new ArtistaDAO();
        return aDAO.getListRepertorio(ID);
    }

    public boolean searchByArtistaID(int id) {
        ArtistaDAO aDAO = new ArtistaDAO();
        return aDAO.searchByID(id);
    }
}
