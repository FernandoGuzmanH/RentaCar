/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.DetalleDeEntrada;
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
public class DetalleDeEntradaFacade extends AbstractFacade<DetalleDeEntrada> implements DetalleDeEntradaFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleDeEntradaFacade() {
        super(DetalleDeEntrada.class);
    }
     @Override
    public List<DetalleDeEntrada> mostrarEntrada(Usuario us){
        String sql;
        
        try {
            sql = "Select d from DetalleDeEntrada d where d.ID_empresas.id = ?1";
            Query query = em.createQuery(sql);
            query.setParameter(1, us.getID_empresas().getId());
            List<DetalleDeEntrada> listasetalleDeEntrada = new LinkedList<DetalleDeEntrada>();
           listasetalleDeEntrada= query.getResultList();
            return listasetalleDeEntrada;
        } catch (Exception e) {
            return null;
        }
    }
    
}
