package model;

import DAO.ArtistaDAO;
import controller.AppController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jorge SB
 */
@Entity
@Table(name = "ARTISTA")
@NamedQueries({
    @NamedQuery(name="Artista.findAll",
                query="SELECT a FROM Artista a"),
    @NamedQuery(name="Artista.findByID",
                query="SELECT a FROM Artista a Where a.ID= :ID"),
    @NamedQuery(name="Artista.findDiscByIDArtist",
    query="SELECT d FROM Disco as d INNER JOIN Artista as a on a.ID=d.creador WHERE a.ID= :ID")
}) 
public class Artista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    protected int ID;

    @Column(name = "NOMBRE")
    protected String nombre;

    @Column(name = "NACIONALIDAD")
    protected String nacionalidad;

    @Column(name = "FOTO")
    protected String foto;

    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected List<Disco> repertorio;

    public Artista(int ID, String nombre, String nacionalidad, String foto, List<Disco> repertorio) {
        this.ID = ID;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.foto = foto;
        this.repertorio = repertorio;
    }

    public Artista(int ID, String nombre, String nacionalidad, String foto) {
        this.ID = ID;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.foto = foto;
    }

    public Artista(String nombre, String nacionalidad, String foto) {
        this.ID = -1;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.foto = foto;
    }
    
    public Artista(Artista a) {
        this.ID = a.getID();
        this.nombre = a.getNombre();
        this.nacionalidad = a.getNacionalidad();
        this.foto = a.getFoto();
    }

    public Artista() {
        this(-1, "", "", null, null);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Disco> getRepertorio() {
        return repertorio;
    }

    public void setRepertorio(List<Disco> repertorio) {
        this.repertorio = repertorio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean igual = false;
        if (obj != null) {
            if (this == obj) {
                igual = true;
            } else {
                if (obj instanceof Artista) {
                    Artista n = (Artista) obj;
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
        return "Artista{" + "ID=" + ID + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", foto=" + foto + '}';
    }

}
