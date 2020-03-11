/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Modelos;
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
public class ModelosFacade extends AbstractFacade<Modelos> implements ModelosFacadeLocal {

    @PersistenceContext(unitName = "RentaCar")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModelosFacade() {
        super(Modelos.class);
    }
    
    //se hace un metodo en forma de lista para poder retornar una el combo completo de cada empresa
    @Override
    public List<Modelos> filtrarempresa(Usuario us){
       //llamamos la entidad ha evaluar y ademas la entidad de usuario para poder estar sobre session
       //createmos una variable string para almacenar la consulta sql
        String sql;
        
        try {
            //en la consulta jpql evaluamos el ahi de la empresa segun la enitidad del facade
            sql="Select m from Modelos m where m.ID_empresas.id =?1";
            //creamos una consulta query donde acedemos al EntityManager
            Query query = em.createQuery(sql);
            /*segun la consulta query llenamos los aprametros en la consulta lo inicialisamos en "?1" entonces
            el parametro sera el primero y llamamos el usuario (.) la foranea a evaluar (.) el campo que 
            seria el ID
            */
            query.setParameter(1, us.getID_empresas().getId());
            /*creamos una lista de la entidad para poderla retornar la almacenamos en una util lis
            y creamos una nueva linkedList
            */
            List<Modelos> ModelosLista = new LinkedList<Modelos>();
            //preparamos la lista para retornarla en un resultlist
            ModelosLista = query.getResultList();
            
            //retornamos la lista
            return ModelosLista;
        } catch (Exception e) {
            //y de lo contrario si algo sale mal retorna nulo
            System.out.println(e.getMessage());
            return null;
        }
        
        
    }
    
}
