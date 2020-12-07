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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Artista;
import model.Cancion;
import model.Disco;
import model.Lista;

/**
 *
 * @author Jorge SB
 */

public class ArtistaDAO extends Artista implements DAO<Artista> {

	private final static String findAll = "Artista.findAll";
	private final static String findByID = "Artista.findByID";
	private final static String findDiscByIDArtist = "Artista.findDiscByIDArtist";

	public ArtistaDAO(int ID, String Nombre, String Nacionalidad, String Foto) {
		super(ID, Nombre, Nacionalidad, Foto);
	}

	public ArtistaDAO() {
		super();
	}

	public ArtistaDAO(Artista a) {
		super(a.getID(), a.getNombre(), a.getNacionalidad(), a.getFoto());
	}
	
	public ArtistaDAO(int id) {
		super(getByID(id));
	}

//______________________________________________________________________________NUEVO
	
	public void setDiscos(List<Disco> discos) {
        this.repertorio = discos;
        for (Disco disco : discos) {
			disco.setCreador(this);
		}
    }

//______________________________________________________________________________CRUD
	@Override
	public void insert(Artista a) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		manager.persist(a);
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
	}

	@Override
	public void edit(Artista a) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		manager.merge(a);
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
	}

	@Override
	public void remove(Artista a) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		manager.remove(manager.contains(a) ? a:manager.merge(a));
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
	}

	@Override
	public List<Artista> getAll() {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();
		TypedQuery<Artista> q = manager.createNamedQuery(findAll,Artista.class);
		
		List<Artista> artistas = q.getResultList();
		/*for (Object object : artistas) {
			object=(ArtistaDAO) object;
			System.out.println(object);
		}*/
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
		return artistas;
	}

	private static Artista getByID(int id) {
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();

		TypedQuery q = manager.createNamedQuery(findByID,Artista.class);
		q.setParameter("ID", id);
		Artista a = (Artista) q.getSingleResult();
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
		return a;
	}

	/**
	 * Recibe el id de un artista y devuelve todos sus discos
	 *
	 * @param id
	 * @return canciones
	 */
	
	public List<Disco> getListRepertorio(int id) {
		
		EntityManager manager = ConnectionUtils.getManager();
		manager.getTransaction().begin();

		TypedQuery q = manager.createNamedQuery(findDiscByIDArtist,Disco.class);
		q.setParameter("ID", id);
		List<Disco> repertorio =  q.getResultList();
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
		return repertorio;
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
		Artista c = getByID(id);
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
