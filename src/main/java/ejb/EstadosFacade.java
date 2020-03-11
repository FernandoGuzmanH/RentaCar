/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Estados;
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
public class EstadosFacade extends AbstractFacade<Estados> implements EstadosFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadosFacade() {
        super(Estados.class);
    }
    
    @Override
    public List<Estados> ConsultarEstados(Usuario us){
    
        String sql;
        
        try {
            sql="Select e from Estados e where e.ID_empresas.id =?1";
            Query query= em.createQuery(sql);
            query.setParameter(1, us.getID_empresas().getId());
            
            List<Estados> ListaEstado =  new LinkedList<Estados>();
            ListaEstado = query.getResultList();
            return  ListaEstado;
        } catch (Exception e) {
            return null;
        }
    }
}
