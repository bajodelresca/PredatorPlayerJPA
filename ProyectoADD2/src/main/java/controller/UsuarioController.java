/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UsuarioDAO;
import java.util.List;
import model.Usuario;

/**
 *
 * @author espin
 */
public class UsuarioController {

    private static UsuarioController instancia = null;

    public static UsuarioController getInstance() {
        instancia = new UsuarioController();
        return instancia;
    }

    public List<Usuario> getAllList() {
        UsuarioDAO UDAO = new UsuarioDAO();
        return UDAO.getAll();
    }

    public Usuario getUserById(int id) {
        UsuarioDAO UDAO = new UsuarioDAO(id);
        Usuario u=new Usuario(UDAO);
        return u;
    }

    public boolean insertUser(Usuario a) {
        boolean result = false;
        if (a != null) {
            UsuarioDAO UDAO = new UsuarioDAO();
            UDAO.insert(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean editUser(Usuario a) {
        boolean result = false;
        if (a != null) {
            UsuarioDAO UDAO = new UsuarioDAO();
            UDAO.edit(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean removeUser(Usuario a) {
        boolean result = false;
        if (a != null) {
            UsuarioDAO UDAO = new UsuarioDAO();
            UDAO.remove(a);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean searchUserByID(int id) {
        UsuarioDAO UDAO = new UsuarioDAO();
        return UDAO.searchByID(id);
    }
}
