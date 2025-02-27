/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Usuario;
import entity.Vehiculos;
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
public class VehiculosFacade extends AbstractFacade<Vehiculos> implements VehiculosFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculosFacade() {
        super(Vehiculos.class);
    }
    @Override
    public List<Vehiculos> listavehiculos(Usuario us){
        String sql;
        try {
            sql="Select v from Vehiculos v where v.ID_empresas.id =?1";
            Query query =em.createQuery(sql);
            query.setParameter(1, us.getID_empresas().getId());
            List<Vehiculos> MostrarAutos= new LinkedList<Vehiculos>();
            MostrarAutos = query.getResultList();
            return MostrarAutos;
        } catch (Exception e) {
            return null;
        }
    } 
    
}
