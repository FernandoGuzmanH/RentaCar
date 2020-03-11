/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ModelosFacadeLocal;
import entity.Empresas;
import entity.Modelos;
import entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author dennys.zepedausam
 */
@Named(value = "modelosController")
@SessionScoped
public class modelosController implements Serializable {

    @EJB
     private ModelosFacadeLocal modelosEJB;
    private Usuario user;
   private Modelos modelos;
   private Empresas empresas;
   private List<Modelos> lista;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public ModelosFacadeLocal getModelosEJB() {
        return modelosEJB;
    }

    public void setModelosEJB(ModelosFacadeLocal modelosEJB) {
        this.modelosEJB = modelosEJB;
    }

    public Modelos getModelos() {
        return modelos;
    }

    public void setModelos(Modelos modelos) {
        this.modelos = modelos;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public List<Modelos> getLista() {
        this.lista=modelosEJB.findAll();
        //se agrega el nuevo metodo que se creo en el facade
        this.lista=modelosEJB.filtrarempresa(user);
 
        return lista;
    }

    public void setLista(List<Modelos> lista) {
        this.lista = lista;
    }
   
   @PostConstruct
   public void init(){
   modelos = new Modelos();
   empresas = new  Empresas();
   user = new Usuario();
   user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
   }
   
   public void limpiar(){
   modelos = new Modelos();
   empresas = new  Empresas();   
   }
   
   public void guardar(){
       try {
           //se almacena dentro de una variable de session el usuario
           user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           //se inicialisa el id de la empresa en un nuevo usuario
           modelos.setID_empresas(user.getID_empresas());
           modelosEJB.create(modelos);
           limpiar();
       } catch (Exception e) {
       }
   }
   
   public void consultALl(){
       try {
           //se llena la session es el mismo metodo de el guardar
           System.out.println("Consultar");
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            System.out.println(user);
           lista = modelosEJB.findAll();
       } catch (Exception e) {
       }
   }
   
   public void eliminar(Modelos id){
       try {
           modelosEJB.remove(id);
       } catch (Exception e) {
       }
   }
   
   public void actualizar(){
       try {
           //se almacena dentro de una variable de session el usuario
           user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           //se inicialisa el id de la empresa en un nuevo usuario
           modelos.setID_empresas(user.getID_empresas());
           modelosEJB.edit(modelos);
           limpiar();
       } catch (Exception e) {
       }
   }
   
   public void leerId(Modelos id){
       this.empresas.setId(id.getID_empresas().getId());
       modelos = id;
   }
    
}
