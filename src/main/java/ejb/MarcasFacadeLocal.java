/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Marcas;
import entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dennys.zepedausam
 */
@Local
public interface MarcasFacadeLocal {

    void create(Marcas marcas);

    void edit(Marcas marcas);

    void remove(Marcas marcas);

    Marcas find(Object id);

    List<Marcas> findAll();
    
    public List<Marcas> mostrarMarcas(Usuario us);

   
    
}
