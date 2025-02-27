/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    @Override
     public Usuario acceder(Usuario us){
        Usuario usuario = null;
        String consulta = "";
        try {
            consulta = "Select u from Usuario u where u.usuario=?1 and u.clave=?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getUsuario());
            query.setParameter(2, us.getClave());
            List<Usuario> lista = query.getResultList();
            
            if(!lista.isEmpty()){
                usuario=lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
           return usuario;
    }
    
}
