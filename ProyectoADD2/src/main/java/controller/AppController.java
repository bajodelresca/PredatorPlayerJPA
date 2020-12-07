package controller;

import java.util.List;
import model.Artista;
import model.Cancion;
import model.Connection;
import model.Disco;
import model.Lista;
import model.Usuario;

/**
 *
 * @author Alberto343
 */
public class AppController {

    private static AppController instancia = null;
    private ArtistaController artistControl = null;
    private DiscoController diskControl = null;
    private CancionController songControl = null;
    private SubscripcionController subsControl = null;
    private ListaController listControl = null;
    private UsuarioController userControl = null;

    public AppController() {
        artistControl = ArtistaController.getInstance();
        diskControl = DiscoController.getInstance();
        songControl = CancionController.getInstance();
        subsControl = SubscripcionController.getInstance();
        listControl = ListaController.getInstance();
        userControl = UsuarioController.getInstance();
    }
    
    public static AppController getInstance() {
        instancia = new AppController();
        return instancia;
    }

    //___________________________________________________________________________Funciones de ARTISTA
    public List<Artista> getAllArtists() {
        return artistControl.getAllArtists();
    }

    public Artista getArtistsById(int id) {
        return artistControl.getArtistsById(id);
    }

    public boolean insertArtists(Artista a) {
        return artistControl.insertArtists(a);
    }

    public boolean editArtists(Artista a) {
        return artistControl.editArtists(a);
    }

    public boolean removeArtists(Artista a) {
        return artistControl.removeArtists(a);
    }

    public List<Disco> getRepertorio(int ID) {
        return artistControl.getRepertorio(ID);
    }
    public boolean searchArtistaByID(int id){
     return artistControl.searchByArtistaID(id);
     }
    //___________________________________________________________________________Funciones de DISCO
    public List<Disco> getAllDiscs() {
        return diskControl.getAllDiscs();
    }

    public Disco getDiscsById(int id) {
        return diskControl.getDiscsById(id);
    }

    public boolean insertDiscs(Disco a) {
        return diskControl.insertDiscs(a);
    }

    public boolean editDiscs(Disco a) {
        return diskControl.editDiscs(a);
    }

    public boolean removeDiscs(Disco a) {
        return diskControl.removeDiscs(a);
    }

    public List<Cancion> getCanciones(int ID) {
        return diskControl.getCanciones(ID);
    }
    public boolean searchDiscByID(int id){
     return diskControl.searchDiscByID(id);
     }
    //___________________________________________________________________________Funciones de CANCION
    public List<Cancion> getAllSongs() {
        return songControl.getAllSongs();
    }

    public Cancion getSongsById(int id) {
        return songControl.getSongsById(id);
    }

    public boolean insertSongs(Cancion a) {
        return songControl.insertSongs(a);
    }

    public boolean editSongs(Cancion a) {
        return songControl.editSongs(a);
    }

    public boolean removeSongs(Cancion a) {
        return songControl.removeSongs(a);
    }
    public boolean searchSongByID(int id){
     return songControl.searchCancionByID(id);
     }

    //___________________________________________________________________________Funciones de SUBSCRIPCION
 /*   public List<Subscripcion> getAllSubs() {
        return subsControl.getAllSubs();
    }

    public boolean insertSubs(Subscripcion a) {
        return subsControl.insertSubs(a);
    }

    public boolean editSongs(Subscripcion a) {
        return subsControl.editSubs(a);
    }

    public boolean removeSubs(Subscripcion a) {
        return subsControl.removeSubs(a);
    }
    public List<Usuario> getSubscriberFromList(int id) {
        return subsControl.getSubscriberFromList(id);
    }

    public List<Lista> getListFromSubscriber(int id) {
        return subsControl.getListFromSubscriber(id);
    }*/

    //___________________________________________________________________________Funciones de LISTA

    public List<Lista> getAllList() {
        return listControl.getAllList();
    }

    public Lista getListById(int id) {
        return listControl.getListById(id);
    }

    public boolean insertList(Lista a) {
        return listControl.insertList(a);
    }

    public boolean editList(Lista a) {
        return listControl.editList(a);
    }

    public boolean removeList(Lista a) {
        return listControl.removeList(a);
    }
    public boolean removesongofList(Cancion a) {
        return listControl.removecanclist(a);
    }

    public List<Cancion> getAllSongsList(int id) {
        return listControl.getAllSongsList(id);
    }

    public boolean insertListCanc(int a, int c) {
        return listControl.insertListCanc(a, c);
    }
    public boolean searchListByID(int id){
     return listControl.searchListByID(id);
     }
    
    public List<Lista> getAllListUser(int id) {
        return listControl.getListFromUser(id);
    }
    //___________________________________________________________________________Funciones de User
    
    public List<Usuario> getAllUsers() {
        return userControl.getAllList();        
    }

    public Usuario getUserById(int id) {
        return userControl.getUserById(id);
    }

    public boolean insertUser(Usuario a) {
       return userControl.insertUser(a);
    }

    public boolean editUser(Usuario a) {
         return userControl.editUser(a);
    }
    public boolean removeUser(Usuario a) {
         return userControl.removeUser(a);
    }
    public boolean searchUserByID(int id){
     return userControl.searchUserByID(id);
     }
}
