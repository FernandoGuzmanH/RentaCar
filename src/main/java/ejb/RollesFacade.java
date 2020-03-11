/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Rolles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dennys.zepedausam
 */
@Stateless
public class RollesFacade extends AbstractFacade<Rolles> implements RollesFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RollesFacade() {
        super(Rolles.class);
    }
    
}
