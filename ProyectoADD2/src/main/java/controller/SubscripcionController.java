/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Lista;
import model.Usuario;

/**
 *
 * @author Alberto343
 */
public class SubscripcionController {

    private static SubscripcionController instancia = null;

    public static SubscripcionController getInstance() {
        instancia = new SubscripcionController();
        return instancia;
    }
/*
    public List<Subscripcion> getAllSubs() {
        SubscripcionDAO cDAO = new SubscripcionDAO();
        return cDAO.getAll();
    }

    public boolean insertSubs(Subscripcion a) {
        boolean result = false;
        if (a != null) {
            SubscripcionDAO cDAO = new SubscripcionDAO();
            cDAO.insert(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean editSubs(Subscripcion a) {
        boolean result = false;
        if (a != null) {
            SubscripcionDAO cDAO = new SubscripcionDAO();
            cDAO.edit(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean removeSubs(Subscripcion a) {
        boolean result = false;
        if (a != null) {
            SubscripcionDAO cDAO = new SubscripcionDAO();
            cDAO.remove(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public List<Usuario> getSubscriberFromList(int id) {
        SubscripcionDAO cDAO = new SubscripcionDAO();
        return cDAO.getSubscriberFromList(id);
    }

    public List<Lista> getListFromSubscriber(int id) {
        SubscripcionDAO cDAO = new SubscripcionDAO();
        return cDAO.getListFromSubscriber(id);
    }*/
}
