/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ArtistaDAO;
import DAO.CancionDAO;
import DAO.ListaDAO;
import DAO.UsuarioDAO;

import java.util.List;

import model.Artista;
import model.Cancion;
import model.Lista;
import model.Usuario;

/**
 *
 * @author espin
 */
public class ListaController {

	private static ListaController instancia = null;

	public static ListaController getInstance() {
		instancia = new ListaController();
		return instancia;
	}

	/**
	 * Devuelve todas las listas de reproduccion con su creador
	 * 
	 * @return devuelve una lista de todas las listas de reproduccion
	 */
	public List<Lista> getAllList() {
		ListaDAO lDAO = new ListaDAO();
		List<Lista> lista = lDAO.getAll();
		for (Lista lista2 : lista) {
			UsuarioDAO uDAO = new UsuarioDAO(lista2.getCreador().getID());

			lista2.setCreador((Usuario) uDAO);
		}

		return lista;
	}

	public Lista getListById(int id) {
		ListaDAO lDAO = new ListaDAO(id);
		UsuarioDAO uDAO = new UsuarioDAO(lDAO.getCreador().getID());
		lDAO.setCreador((Usuario) uDAO);
		Lista l = new Lista(lDAO);
		return l;
	}

	public boolean insertList(Lista a) {
		boolean result = false;
		if (a != null) {
			ListaDAO lDAO = new ListaDAO();
			lDAO.insert(a);
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public boolean editList(Lista a) {
		boolean result = false;
		if (a != null) {
			ListaDAO lDAO = new ListaDAO();
			lDAO.edit(a);
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public boolean removeList(Lista a) {
		boolean result = false;
		if (a != null) {
			ListaDAO lDAO = new ListaDAO();
			lDAO.remove(a);
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public List<Cancion> getAllSongsList(int id) {
		ListaDAO lDAO = new ListaDAO();
		return lDAO.getCancionFromList(id);
	}

	public boolean insertListCanc(int a, int c) {
		ListaDAO lDAO = new ListaDAO();
		return lDAO.insertListCanc(a, c);
	}

	public boolean searchListByID(int id) {
		ListaDAO lDAO = new ListaDAO();
		return lDAO.searchByID(id);
	}

	public boolean removecanclist(int a, int c) {
		boolean result = false;
		ListaDAO lDAO = new ListaDAO(a);
		Lista li = new Lista(lDAO);
		CancionDAO cDAO = new CancionDAO(c);
		Cancion ca = new Cancion(cDAO);
		if (li != null && ca != null) {

			lDAO.removeSongList(a, c);
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public List<Lista> getListFromUser(int id) {
		ListaDAO lDAO = new ListaDAO();
		return lDAO.getListFromUser(id);
	}

	public boolean insertSubscripcion(Lista a, Usuario u) {
		boolean result = false;
		if (a != null && u != null) {
			ListaDAO lDAO = new ListaDAO();
			lDAO.insertListSub(a.getID(), u.getID());
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public boolean removeAllSongList(Cancion c) {
		boolean result = false;
		ListaDAO lDAO = new ListaDAO();
		CancionDAO cDAO = new CancionDAO(c);
		Cancion ca = new Cancion(cDAO);
		if (ca != null) {
			lDAO.removeAllSongList(c);
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public boolean removeSubofList(int a, int u) {
		boolean result = false;
		ListaDAO lDAO = new ListaDAO(a);
		Lista li = new Lista(lDAO);
		UsuarioDAO uDAO = new UsuarioDAO(u);
		Usuario us = new Usuario(uDAO);
		if (li != null && us != null) {

			lDAO.removeSubofList(a, u);
			;
			result = true;
		} else {
			result = false;
		}
		return result;

	}

}
