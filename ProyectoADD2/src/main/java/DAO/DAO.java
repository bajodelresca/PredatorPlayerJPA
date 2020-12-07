/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 * 
 * @author Alberto343
 * @param <T> es el objeto utilizado en cada DAO 
 */
public interface DAO<T> {
    
    /**
     * 
     * @param a 
     * Inserta un objeto a la base de datos
     */
    public void insert(T a);
   
    /**
     * 
     * @param a 
     * Edita un objeto de la base de datos
     */
    public void edit(T a);
    
    /**
     * 
     * @param a 
     * Elimina un objeto de la base de datos
     */
    public void remove(T a);
    
    /**
     * 
     * @return List<T>
     * Devuelve una lista de objetos 
     */
    List<T> getAll();
    
    
}
