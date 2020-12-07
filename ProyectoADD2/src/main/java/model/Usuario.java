/*
---- * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.AppController;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author espin
 */
@Entity
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll",
            query = "SELECT  u  FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByID",
            query = "SELECT u  FROM Usuario u Where u.ID= :ID")
})
public class Usuario implements Serializable {

    private static AppController controlador = AppController.getInstance();
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    protected int ID;
    @Column(name = "NOMBRE")
    protected String Nombre;
    @Column(name = "CORREO")
    protected String Correo;
    @Column(name = "FOTO")
    protected String Foto;
    @ManyToMany(mappedBy = "subscriptores")
    protected List<Lista> listasubscrito;
    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected List<Lista> listacreada;

    public Usuario(int ID, String Nombre, String Correo, String Foto, List<Lista> listasubscrito) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Foto = Foto;
        this.listasubscrito = listasubscrito;
    }

    public Usuario(int ID, String Nombre, String Correo, String Foto) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Foto = Foto;
    }
    public Usuario( String Nombre, String Correo, String Foto) {
        this.ID = -1;;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Foto = Foto;
    }
    public Usuario(Usuario u) {
        this.ID = u.getID();
        this.Nombre = u.getNombre();
        this.Correo = u.getCorreo();
        this.Foto = u.getFoto();
    }

    public Usuario() {
        this(-1, "", "", null, null);
    }

    public List<Lista> getListasubscrito() {
        
        return listasubscrito;
    }

    public List<Lista> getListacreada() {
        return listacreada;
    }

    public void setListacreada(List<Lista> listacreada) {
        this.listacreada = listacreada;
    }
    

    public void setListasubscrito(List<Lista> listasubscrito) {
        this.listasubscrito = listasubscrito;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean igual = false;
        if (obj != null) {
            if (this == obj) {
                igual = true;
            } else {
                if (obj instanceof Usuario) {
                    Usuario n = (Usuario) obj;
                    if (this.ID == n.getID()) {
                        igual = true;
                    }
                }
            }
        }
        return igual;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID=" + ID + ", Nombre=" + Nombre + ", Correo=" + Correo + ", Foto=" + Foto + '}';
    }

}
