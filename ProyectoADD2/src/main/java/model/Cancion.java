/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "CANCION")
@NamedQueries({
    @NamedQuery(name="Cancion.findAll",
                query="SELECT  c FROM Cancion c"),
    @NamedQuery(name="Cancion.findByID",
                query="SELECT c FROM Cancion c Where c.ID= :ID")
}) 
public class Cancion implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    protected int ID;
    @Column(name = "NOMBRE")
    protected String Nombre;
    @Column(name = "DURACION")
    protected int Duracion;
    @Column(name = "Genero")
    protected int Genero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDDISCO")
    protected Disco Album;

    @ManyToMany(mappedBy = "listareproduccion")
    private List<Lista> listas;

    public Cancion(int ID, String Nombre, int Duracion, Disco Album) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Duracion = Duracion;
        this.Genero = 0;
        this.Album = Album;
    }

    public Cancion(String Nombre, int Duracion, Disco Album) {
        this.ID = -1;
        this.Nombre = Nombre;
        this.Duracion = Duracion;
        this.Genero = 0;
        this.Album = Album;
    }
    
    public Cancion(Cancion c) {
        this.ID = c.getID();
        this.Nombre = c.getNombre();
        this.Duracion = c.getDuracion();
        this.Genero = 0;
        this.Album = c.getAlbum();
    }

    public Cancion() {
        this(-1, "", -1, null);
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

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    public int getGenero() {
        return Genero;
    }

    public void setGenero(int Genero) {
        this.Genero = Genero;
    }

    public Disco getAlbum() {
        return Album;
    }

    public void setAlbum(Disco Album) {
        this.Album = Album;
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
                if (obj instanceof Cancion) {
                    Cancion n = (Cancion) obj;
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
        return "Cancion{" + "ID=" + ID + ", Nombre=" + Nombre + ", Duracion=" + Duracion + ", Genero=" + Genero + ", Album=" + Album + '}';
    }

}
