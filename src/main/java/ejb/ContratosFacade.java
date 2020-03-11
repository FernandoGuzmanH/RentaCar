/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Contratos;
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
public class ContratosFacade extends AbstractFacade<Contratos> implements ContratosFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratosFacade() {
        super(Contratos.class);
    }
    
    @Override
    public List<Contratos> mostrarContrato(Usuario us){
    String sql;
    
        try {
            sql = "SELECT c FROM Contratos c  WHERE c.ID_empresas.id = ?1";
            Query query = em.createQuery(sql);
            query.setParameter(1, us.getID_empresas().getId());
            
            List<Contratos> listaContratos = new LinkedList<Contratos>();
            listaContratos = query.getResultList();
            return listaContratos;
        } catch (Exception e) {
            return null;
        }
        
    }
    
}
