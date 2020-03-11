/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Facturas;
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
public class FacturasFacade extends AbstractFacade<Facturas> implements FacturasFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturasFacade() {
        super(Facturas.class);
    }
    
    @Override
    public List<Facturas> mostrarFacturas(Usuario us){
        String sql;
        
        try {
            sql = "Select f from Facturas f where f.ID_empresas.id = ?1";
            Query query = em.createQuery(sql);
            query.setParameter(1, us.getID_empresas().getId());
            List<Facturas> listaFactura = new LinkedList<Facturas>();
            listaFactura = query.getResultList();
            return listaFactura;
        } catch (Exception e) {
            return null;
        }
    }
    
}
