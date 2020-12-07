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

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Cancion;
import model.Disco;
//@MappedSuperclass

public class CancionDAO extends Cancion implements DAO<Cancion> {
	
	private final static String findAll = "Cancion.findAll";
	private final static String findByID = "Cancion.findByID";
	public CancionDAO(int ID, String Nombre, int Duracion, Disco Album) {
		super(ID, Nombre, Duracion, Album);

	}

	public CancionDAO() {
		super();

	}

	public CancionDAO(Cancion c) {
		super(c.getID(), c.getNombre(), c.getDuracion(), c.getAlbum());

	}
	public CancionDAO(String Nombre, int Duracion) {
		super(-1, Nombre, Duracion,null);

	}
	public CancionDAO(int id) {
		super(getByID(id));
	}
	

    public void setAlbum(Disco Album) {
        this.Album = Album;
        java.util.List<Cancion> canciones=this.Album.getCanciones();
        if(canciones==null) {
        	canciones=new ArrayList<Cancion>();
		}
		if(!canciones.contains(this)) {
			canciones.add(this);
		}
    }

	@Override
	public void insert(Cancion a) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		manager.persist(a);
		CancionDAO cDao=new CancionDAO(a);
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
	}

	@Override
	public void edit(Cancion a) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		manager.merge(a);
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
	}

	@Override
	public void remove(Cancion a) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		manager.remove(manager.contains(a) ? a:manager.merge(a));
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
	}

	
	@Override
	public List<Cancion> getAll() {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		TypedQuery q = manager.createNamedQuery(findAll,Cancion.class);
		List<Cancion> canciones =  q.getResultList();
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
		return canciones;
	}

	/**
	 * Metodo que devuelve una Cancion por id pasado
	 *
	 * @param id identificador de cada Cancion
	 * @return Devuelve una Cancion
	 */
	private static Cancion getByID(int id) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();

		TypedQuery q = manager.createNamedQuery(findByID,Cancion.class);
		q.setParameter("ID", id);
		Cancion c = (Cancion) q.getSingleResult();
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
		return c;

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
		Cancion c = getByID(id);
		if (c != null) {
			result = true;
		} else {
			result = false;
		}
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
		return result;
	}
}
