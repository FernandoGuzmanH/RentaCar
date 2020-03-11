/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Usuario;
import entity.Vehiculos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dennys.zepedausam
 */
@Local
public interface VehiculosFacadeLocal {

    void create(Vehiculos vehiculos);

    void edit(Vehiculos vehiculos);

    void remove(Vehiculos vehiculos);

    Vehiculos find(Object id);

    List<Vehiculos> findAll();
     public List<Vehiculos> listavehiculos(Usuario us);

    
    
}
