/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Empresas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dennys.zepedausam
 */
@Local
public interface EmpresasFacadeLocal {

    void create(Empresas empresas);

    void edit(Empresas empresas);

    void remove(Empresas empresas);

    Empresas find(Object id);

    List<Empresas> findAll();

 
    
}
