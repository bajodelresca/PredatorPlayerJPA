package grupo1.proyectoacdat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.Date;
import DAO.ArtistaDAO;
import Utils.ConnectionUtils;
import Utils.Utilities;
import View.GUI;
import model.Artista;
import model.Cancion;
import model.Disco;

public class test {
	public static void main(String[] args) {
		Artista art =new Artista(1,"nombre","española","foto1");
		Date fecha=new Date(2001,12,12);
		Disco d=new Disco(2,"disco1","foto1",fecha,art);
		Cancion ca = new Cancion(3, "cancion",211,d);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacionH2");
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(art);
		manager.persist(d);
		manager.getTransaction().commit();
		ConnectionUtils.closeManager(manager);
/*
		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("aplicacionH2");
		EntityManager manager2 = emf2.createEntityManager();
		manager2.getTransaction().begin();

		manager2.getTransaction().commit();
		ConnectionUtils.closeManager(manager2);*/
	}
}
