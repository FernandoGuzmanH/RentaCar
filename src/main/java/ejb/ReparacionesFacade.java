/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Reparaciones;
import entity.Usuario;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dennys.zepedausam
 */
@Stateless
public class ReparacionesFacade extends AbstractFacade<Reparaciones> implements ReparacionesFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReparacionesFacade() {
        super(Reparaciones.class);
    }
    
    @Override
    public List<Reparaciones> mostrararreparaciones(Usuario us){
        String sql;
            try {
                sql="Select r from Reparaciones r where r.ID_empresas.id =?1";
                Query query = em.createQuery(sql);
                query.setParameter(1, us.getID_empresas().getId());
                List<Reparaciones> listaReparaciones = new LinkedList<Reparaciones>();
                listaReparaciones = query.getResultList();
                return  listaReparaciones;
                        
            } catch (Exception e) {
                return null;
            }
    }
    
}
