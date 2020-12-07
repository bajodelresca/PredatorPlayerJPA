package Utils;

import java.util.Scanner;

public class Utilities {

	private static Scanner keyboard = new Scanner(System.in);

	/**
	 * Escribe un texto en consola sin retorno de carro
	 *
	 * @param f texto a imprimir
	 */
	public static void p(String f) {
		System.out.print(f);
	}

	/**
	 * Escribe un texto en consola con retorno de carro
	 *
	 * @param f texto a imprimir
	 */
	public static void P(String f) {
		Utilities.p(f + "\n");
	}

	/**
	 * Lee un entero de teclado
	 *
	 * @return devuelve el entero leído
	 */
	public static int getInt() {
		Integer result = 0;
		boolean valid = false;
		do {
			try {
				result = Integer.parseInt(keyboard.nextLine());
				valid = true;

			} catch (IllegalStateException ex) {
				keyboard = new Scanner(System.in);
				Utilities.P("Error in keyboard. Please, try it again: ");
			} catch (NumberFormatException ex) {
				Utilities.P("Error reading integer type. Please, try it again: ");
			} catch (Exception ex) {
				ex.printStackTrace();
				Utilities.P("Error unknown. Please, try it again: ");
			}
		} while (!valid);
		return result;
	}

	/**
	 * Lee un entero de teclado
	 *
	 * @param f Mensaje a imprimir al usuario antes de solicitar el entero
	 * @return devuelve el entero leído
	 */
	public static int getInt(String f) {
		Utilities.p(f + " : ");
		return Utilities.getInt();
	}

	public static int MenuBD() {
		int opcion = 0;

		P("-----Seleccione la base de datos-----");
		P("1) H2");
		P("2) SQL");
		P("3) Salir del programa");
		P("-------------------------------------");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	public static int Menu() {
		int opcion = 0;
		P("  _______                     __           __                       _______   __                                \n"
				+ " |   _   | .----. .-----. .--|  | .---.-. |  |_  .-----. .----.    |   _   | |  | .---.-. .--.--. .-----. .----.\n"
				+ " |.  1   | |   _| |  -__| |  _  | |  _  | |   _| |  _  | |   _|    |.  1   | |  | |  _  | |  |  | |  -__| |   _|\n"
				+ " |.  ____| |__|   |_____| |_____| |___._| |____| |_____| |__|      |.  ____| |__| |___._| |___  | |_____| |__|  \n"
				+ " |:  |                                                             |:  |                  |_____|               \n"
				+ " |::.|                                                             |::.|                                        \n"
				+ " `---'                                                             `---'                                        ");

		P("-----Bienvenido a Predator Player-----");
		P("1) Listar");
		P("2) Insertar");
		P("3) Editar");
		P("4) Eliminar");
		P("5) Cerrar la base de datos");
		P("-------------------------------------");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	// ____________________________________________________________________________MenuListar
	public static int MenuListar() {
		int opcion = 0;
		P("-----Menú de Información-----");
		P("1) Listar Cancion");
		P("2) Listar Disco");
		P("3) Listar Artista");
		P("4) Listar lista de Reproducción");
		P("5) Listar subscriptores por Id de la lista");
		P("6) Listar listas a las que esta subscrito el usuario por Id");
		P("7) Listar las canciones de una lista de Reproducción");
		P("8) Listar las listas de Reproducción que ha creado un usuario");
		P("9) Listar todos los usuarios");
		P("10) Volver al menú anterior");
		P("-------------------------------------");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	public static int subMenuListar() {
		int opcion = 0;
		P("1) Listar todos");
		P("2) Listar por ID");
		P("3) Volver al menú anterior");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	public static int subMenuListarDisco() {
		int opcion = 0;
		P("1) Listar todos");
		P("2) Listar por ID");
		P("3) Listar las canciones por ID de disco");
		P("4) Volver al menú anterior");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	public static int subMenuListarArtista() {
		int opcion = 0;
		P("1) Listar todos");
		P("2) Listar por ID");
		P("3) Listar discos por ID de Artista");
		P("4) Volver al menú anterior");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	// ____________________________________________________________________________MenuInsertar
	public static int MenuInsertar() {
		int opcion = 0;
		P("-----Menú de Creación-----");
		P("1) Insertar Artista");
		P("2) Insertar Disco");
		P("3) Insertar Canción");
		P("4) Crear una lista de reproducción");
		P("5) Insertar una canción a una lista");
		P("6) Insertar un usuario");
		P("7) Subscribirte una lista de reproducción");
		P("8) Salir");
		P("-------------------------------------");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	// ____________________________________________________________________________MenuEditar
	public static int MenuEditar() {
		int opcion = 0;
		P("-----Menú de Edición-----");
		P("1) Editar un Artista");
		P("2) Editar un Disco");
		P("3) Editar un Canción");
		P("4) Editar una lista de reproducción");
		P("5) Editar un Usuario");
		P("6) Salir");
		P("-------------------------------------");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	public static int MenuEditarArtista() {
		int opcion = 0;
		P("-----Edicion Artista-----");
		P("1) Editar nombre");
		P("2) Editar nacionalidad");
		P("3) Editar foto");
		P("4) Salir");
		P("-------------------------------------");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	public static int MenuEditarDisco() {
		int opcion = 0;
		P("-----Edicion Disco-----");
		P("1) Editar Nombre");
		P("2) Editar foto");
		P("3) Editar fecha");
		P("4) Editar creador");
		P("5) Salir");
		P("-------------------------------------");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	public static int MenuEditarCancion() {
		int opcion = 0;
		P("-----Edicion Cancion-----");
		P("1) Editar Nombre");
		P("2) Editar Duracion");
		P("3) Editar Album");
		P("4) Salir");
		P("-------------------------------------");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	public static int MenuEditarLsita() {
		int opcion = 0;
		P("-----Edicion Lista-----");
		P("1) Editar Nombre");
		P("2) Editar Descripcion");
		P("3) Salir");
		P("-------------------------------------");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

	public static int MenuEditarUsuario() {
		int opcion = 0;
		P("-----Edicion Usuario-----");
		P("1) Editar nombre");
		P("2) Editar Correo");
		P("3) Editar foto");
		P("4) Salir");
		P("-------------------------------------");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}
	// ____________________________________________________________________________MenuEliminar

	public static int MenuEliminar() {
		int opcion = 0;
		P("-----Menú de Eliminación-----");
		P("1) Eliminar Artista");
		P("2) Eliminar Disco");
		P("3) Eliminar Canción");
		P("4) Eliminar una lista de reproducción");
		P("5) Eliminar una canción de una lista");
		P("6) Eliminar una suscripción a una lista");
		P("7) Eliminar un Usuario");
		P("8) Salir");
		P("-------------------------------------");
		p("> ");

		try {
			opcion = keyboard.nextInt();
		} catch (Exception e) {
			System.out.println("Introduzca un número entero");
			keyboard = new Scanner(System.in);
		}

		return opcion;
	}

}
