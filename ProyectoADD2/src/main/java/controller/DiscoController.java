package controller;

import DAO.ArtistaDAO;
import DAO.DiscoDAO;
import java.util.List;

import model.Artista;
import model.Cancion;
import model.Disco;

/**
 *
 * @author Jorge SB
 */
public class DiscoController {

    private static DiscoController instancia = null;

    public static DiscoController getInstance() {
        instancia = new DiscoController();
        return instancia;
    }

    public List<Disco> getAllDiscs() {
        DiscoDAO dDAO = new DiscoDAO();
        return dDAO.getAll();
    }

    public Disco getDiscsById(int id) {
        DiscoDAO dDAO = new DiscoDAO(id);
        ArtistaDAO aDAO=new ArtistaDAO(dDAO.getCreador().getID());
        dDAO.setCreador((Artista)aDAO);
        Disco d = new Disco(dDAO);
        return d;
    }

    public boolean insertDiscs(Disco a) {
        boolean result = false;
        if (a != null) {
            DiscoDAO dDAO = new DiscoDAO();
            dDAO.insert(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean editDiscs(Disco a) {
        boolean result = false;
        if (a != null) {
            DiscoDAO dDAO = new DiscoDAO();
            dDAO.edit(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean removeDiscs(Disco a) {
        boolean result = false;
        if (a != null) {
            DiscoDAO dDAO = new DiscoDAO();

        } else {
            result = false;
        }
        return result;
    }

    public List<Cancion> getCanciones(int ID) {
        DiscoDAO dDAO = new DiscoDAO();
        return dDAO.getListCanciones(ID);
    }

    public boolean searchDiscByID(int id) {
        DiscoDAO dDAO = new DiscoDAO();
        return dDAO.searchByID(id);
    }
}
