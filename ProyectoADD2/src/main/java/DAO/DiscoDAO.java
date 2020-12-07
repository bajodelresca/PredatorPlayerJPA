package DAO;

import Utils.ConnectionUtils;
import controller.AppController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Artista;
import model.Cancion;
import model.Disco;

/**
 *
 * @author Jorge SB
 */


public class DiscoDAO extends Disco implements DAO<Disco> {
	
	private final static String findAll = "Disco.findAll";
	private final static String findByID = "Disco.findByID";
	private final static String findSongByIDDisc = "Disco.findSongByIDDisc";
	public DiscoDAO(int ID, String Nombre, String foto, Date fecha, Artista creador) {
		super(ID, Nombre, foto, fecha, creador);
	}

	public DiscoDAO() {
		super();
	}

	public DiscoDAO(Disco d) {
		super(d.getID(), d.getNombre(), d.getFoto(), d.getFecha(), d.getCreador());
	}
	
	public DiscoDAO(int id) {
		super(getByID(id));
	}

	public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
        for (Cancion cancion : canciones) {
			cancion.setAlbum((Disco)this);
		}
    }
	
//________________________________________________________________________NUEVO
	public void setCreador(Artista Creador) {
        this.creador = Creador;
        java.util.List<Disco> discos=this.creador.getRepertorio();
        if(discos==null) {
        	discos=new ArrayList<Disco>();
		}
		if(!discos.contains((Disco)this)) {
			discos.add((Disco)this);
		}
    }
//______________________________________________________________________________CRUD
	@Override
	public void insert(Disco a) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		manager.persist(a);
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
	}

	@Override
	public void edit(Disco a) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		manager.merge(a);
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
	}

	@Override
	public void remove(Disco a) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		manager.remove(manager.contains(a) ? a:manager.merge(a));
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
	}

	@Override
	public List<Disco> getAll() {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		TypedQuery q = manager.createNamedQuery(findAll,Disco.class);
		List<Disco> discos =  q.getResultList();
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
		return discos;
	}

	private static Disco getByID(int id) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();

		TypedQuery q = manager.createNamedQuery(findByID,Disco.class);
		q.setParameter("ID", id);
		Disco d = (Disco) q.getSingleResult();
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
		return d;
	}

	/**
	 * Recibe el id de un disco y devuelve todas sus canciones
	 *
	 * @param id
	 * @return canciones
	 */
	public List<Cancion> getListCanciones(int id) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();

		TypedQuery q = manager.createNamedQuery(findSongByIDDisc,Cancion.class);
		q.setParameter("ID", id);
		List<Cancion> canciones =  q.getResultList();
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
		return canciones;
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
		Disco c = getByID(id);
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
