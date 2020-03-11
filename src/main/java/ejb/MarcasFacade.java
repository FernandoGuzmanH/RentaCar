/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Marcas;
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
public class MarcasFacade extends AbstractFacade<Marcas> implements MarcasFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcasFacade() {
        super(Marcas.class);
    }
    // se realizar el overide y se pasa por parametro un objeto de tipo usuario
    @Override
    public List<Marcas> mostrarMarcas(Usuario us){
    String sql;
        try {
            sql="Select m from Marcas m where m.ID_empresas.id = ?1";
            Query query = em.createQuery(sql);
            query.setParameter(1, us.getID_empresas().getId());
            List<Marcas> listaMarcas = new LinkedList<Marcas>();
            listaMarcas = query.getResultList();
            return listaMarcas;
        } catch (Exception e) {
            return null;
        }
    }
    
}
