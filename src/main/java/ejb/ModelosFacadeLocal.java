/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Modelos;
import entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dennys.zepedausam
 */
@Local
public interface ModelosFacadeLocal {

    void create(Modelos modelos);

    void edit(Modelos modelos);

    void remove(Modelos modelos);

    Modelos find(Object id);

    List<Modelos> findAll();
    // el metodo que creamos en el facade lo copiamos y lo pegamos aqui y solo le agregamos (;) sino esto da error;
   List<Modelos> filtrarempresa(Usuario us);

  
}
