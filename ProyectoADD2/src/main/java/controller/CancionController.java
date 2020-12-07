/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CancionDAO;
import java.util.List;
import model.Cancion;
import model.Lista;

/**
 *
 * @author Alberto343
 */
public class CancionController {

    private static CancionController instancia = null;

    public static CancionController getInstance() {
        instancia = new CancionController();
        return instancia;
    }

    public List<Cancion> getAllSongs() {
        CancionDAO cDAO = new CancionDAO();
        return cDAO.getAll();
    }

    public Cancion getSongsById(int id) {
        CancionDAO cDAO = new CancionDAO(id);
        Cancion c=new Cancion(cDAO);
        return c;      
    }

    public boolean insertSongs(Cancion a) {
        boolean result = false;
        if (a != null) {
            CancionDAO cDAO = new CancionDAO();
            cDAO.insert(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean editSongs(Cancion a) {
        boolean result = false;
        if (a != null) {
            CancionDAO cDAO = new CancionDAO();
            cDAO.edit(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean removeSongs(Cancion a) {
        boolean result = false;
        if (a != null) {
            CancionDAO cDAO = new CancionDAO();
            cDAO.remove(a);
        } else {
            result = false;
        }
        return result;
    }
     public boolean searchCancionByID(int id) {
        CancionDAO cDAO = new CancionDAO();
        return cDAO.searchByID(id);
    }
}
