/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Rolles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dennys.zepedausam
 */
@Local
public interface RollesFacadeLocal {

    void create(Rolles rolles);

    void edit(Rolles rolles);

    void remove(Rolles rolles);

    Rolles find(Object id);

    List<Rolles> findAll();


    
}
