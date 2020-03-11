/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Empresas;
import java.util.ArrayList;
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
public class EmpresasFacade extends AbstractFacade<Empresas> implements EmpresasFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresasFacade() {
        super(Empresas.class);
    }
    //seria para poder entrar a la empresa por el Nombre sin seleccionarla por un selectOnemenu
    
   /* @Override
    public Empresas ObjetoEmpresas(Empresas ep){
        String sql;
        Empresas emp= null;
        
        try {
            sql="Select e from Empresas e where e.nombre = ?1";
            Query query = em.createQuery(sql);
            query.setParameter(1, ep.getNombre());
            List<Empresas> listaEmpresa= new ArrayList<Empresas>();
            listaEmpresa = query.getResultList();
            emp = listaEmpresa.get(0);
                return emp;
      
        } catch (Exception e) {
            return emp;
        }
        
    }*/
}
