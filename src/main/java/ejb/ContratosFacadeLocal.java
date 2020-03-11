/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Contratos;
import entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dennys.zepedausam
 */
@Local
public interface ContratosFacadeLocal {

    void create(Contratos contratos);

    void edit(Contratos contratos);

    void remove(Contratos contratos);

    Contratos find(Object id);

    List<Contratos> findAll();
    
    public List<Contratos> mostrarContrato(Usuario us);

    
    
}
