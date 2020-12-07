/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alberto343
 */
public class ConnectionUtils {
	private final static String APLICATIONH2 = "aplicacionH2";
	private final static String APLICATIONSQL = "aplicacionSQL";

	private static EntityManagerFactory emf;

	

	private static EntityManagerFactory APLICATIONH2() {
		return Persistence.createEntityManagerFactory(APLICATIONH2);
	}

	private static EntityManagerFactory APLICATIONSQL() {
		return Persistence.createEntityManagerFactory(APLICATIONSQL);
	}

	public static boolean conexion(int op) {
		boolean result = false;
		switch (op) {
		case 1:
			emf = ConnectionUtils.APLICATIONH2();
			result = true;
			break;
		case 2:
			emf = ConnectionUtils.APLICATIONSQL();
			result = true;
			break;
		case 3:
			Utilities.p("Saliendo...");
			result = false;
			break;
		default:
			Utilities.p("Opción no valida");
		}

		return result;
	}

	public static EntityManager getManager() {
		return emf.createEntityManager();
	}

	public static void closeManager(EntityManager m) {
		m.close();
	}

}