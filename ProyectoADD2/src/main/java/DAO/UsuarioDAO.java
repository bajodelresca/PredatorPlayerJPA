/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.ConnectionUtils;
import controller.AppController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Lista;

import model.Usuario;

/**
 *
 * @author Alberto343
 */
//@MappedSuperclass

public class UsuarioDAO extends Usuario implements DAO<Usuario> {

    private final static String findAll = "Usuario.findAll";
    private final static String findByID = "Usuario.findByID";

    enum queries {
        INSERT("INSERT INTO Usuario (ID, Correo, Nombre, Foto) VALUES (NULL,?,?,?)"),
        UPDATE("UPDATE Usuario SET Correo=?,Nombre=?,Foto=? WHERE ID=?"),
        DELETE("DELETE FROM Usuario WHERE ID=?"),
        GETBYID("SELECT * FROM Usuario Where ID=?"),
        GETALL("SELECT * FROM Lista");

        private String q;

        queries(String q) {
            this.q = q;
        }

        public String getQ() {
            return this.q;
        }
    }

    public UsuarioDAO() {
        super();
    }

    public UsuarioDAO(Usuario c) {
        super(c.getID(), c.getNombre(), c.getCorreo(), c.getFoto());
    }

    public UsuarioDAO(int id) {
        super(getByID(id));
    }
    
    public void setListacreada(List<Lista> listacreada) {
        this.listacreada = listacreada;
        for (Lista creada : listacreada) {
			creada.setCreador(this);
		}
    }
    
    public void setListasubscrito(List<Lista> listasubscrito) {
    	this.listasubscrito = listasubscrito;
        for (Lista subscrito : listasubscrito) {
			subscrito.getSubscriptores().add((Usuario)this);
		}
    }

    @Override
    public void insert(Usuario a) {
        EntityManager manager = ConnectionUtils.getManager();
        manager.getTransaction().begin();
        manager.persist(a);
        manager.getTransaction().commit();
        ConnectionUtils.closeManager(manager);
    }

    @Override
    public void edit(Usuario a) {
        EntityManager manager = ConnectionUtils.getManager();
        manager.getTransaction().begin();
        manager.merge(a);
        manager.getTransaction().commit();
        ConnectionUtils.closeManager(manager);
    }

    @Override
    public void remove(Usuario a) {
    	EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		manager.remove(manager.contains(a) ? a:manager.merge(a));
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
    }

    @Override
    public List<Usuario> getAll() {
        EntityManager manager = ConnectionUtils.getManager();
        manager.getTransaction().begin();
        TypedQuery q = manager.createNamedQuery(findAll,Usuario.class);
        List<Usuario> usuarios =  q.getResultList();
        manager.getTransaction().commit();
        ConnectionUtils.closeManager(manager);
        return usuarios;
    }

    /**
     * Metodo que devuelve un usuario por id pasado
     *
     * @param id identificador de cada usuario
     * @return Devuelve un usuario
     */
    private static Usuario getByID(int id) {
        EntityManager manager = ConnectionUtils.getManager();
        manager.getTransaction().begin();
        TypedQuery q = manager.createNamedQuery(findByID,Usuario.class);
        q.setParameter("ID", id);

        Usuario u = (Usuario) q.getSingleResult();

        manager.getTransaction().commit();
        ConnectionUtils.closeManager(manager);
        return u;
    }

    /**
     * Metodo que comprueba si existe el ID en la tabla
     *
     * @param id recibe un entero
     * @return devuelve un boolean, si existe devuelve true y false si no
     */
    public boolean searchByID(int id) {
        boolean result = false;
        EntityManager manager = ConnectionUtils.getManager();
        manager.getTransaction().begin();

        Usuario u = getByID(id);
        if (u != null) {
            result = true;
        } else {
            result = false;
        }
        manager.getTransaction().commit();
        ConnectionUtils.closeManager(manager);
        return result;
    }
}
