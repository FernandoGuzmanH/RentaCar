/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Personas;
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
public class PersonasFacade extends AbstractFacade<Personas> implements PersonasFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonasFacade() {
        super(Personas.class);
    }
    
    @Override
    public List<Personas> mostarPersona(Usuario us){
    
        String sql;
        
        try {
            sql="Select p from Personas p where p.ID_empresas.id = ?1";
            Query query = em.createQuery(sql);
            query.setParameter(1, us.getID_empresas().getId());
            List<Personas> listaPersonas = new LinkedList<Personas>();
           listaPersonas =  query.getResultList();
           return listaPersonas;
        } catch (Exception e) {
            return null;
        }
    }
}
