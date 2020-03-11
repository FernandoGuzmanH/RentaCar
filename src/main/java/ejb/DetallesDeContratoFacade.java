/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.DetallesDeContrato;
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
public class DetallesDeContratoFacade extends AbstractFacade<DetallesDeContrato> implements DetallesDeContratoFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallesDeContratoFacade() {
        super(DetallesDeContrato.class);
    }
  @Override
  public List<DetallesDeContrato> mostrardetallesdeConmtratos(Usuario us){
      String sql;
      try {
          sql="Select c from DetallesDeContrato c where c.ID_empresas.id =?1";
          Query query = em.createQuery(sql);
          query.setParameter(1, us.getID_empresas().getId());
          List<DetallesDeContrato> listaDetallesDeContrato= new LinkedList<DetallesDeContrato>();
          listaDetallesDeContrato = query.getResultList();
          return listaDetallesDeContrato;
          
      } catch (Exception e) {
          return null;
      }
  }
    
}
