/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.DetallesDeFacturas;
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
public class DetallesDeFacturasFacade extends AbstractFacade<DetallesDeFacturas> implements DetallesDeFacturasFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallesDeFacturasFacade() {
        super(DetallesDeFacturas.class);
    }
      @Override
    public List<DetallesDeFacturas> Consultadetalledactura(Usuario us){
    
        String sql;
        
        try {
            sql="Select e from DetallesDeFacturas e where e.ID_empresas.id =?1";
            Query query= em.createQuery(sql);
            query.setParameter(1, us.getID_empresas().getId());
            
            List<DetallesDeFacturas> listadetallefactura =  new LinkedList<DetallesDeFacturas>();
            listadetallefactura = query.getResultList();
            return  listadetallefactura;
        } catch (Exception e) {
            return null;
        }
    }
}
