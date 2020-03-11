/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.MarcasFacadeLocal;
import entity.Empresas;
import entity.Marcas;
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
@Named(value = "marcasController")
@SessionScoped
public class marcasController implements Serializable {

   @EJB
   private MarcasFacadeLocal marcasEJB;
    private Marcas marcas;
    private Empresas empresas;
    private Usuario user;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    private List<Marcas> lista;
    

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public List<Marcas> getLista() {
        this.lista=marcasEJB.mostrarMarcas(user);
        return lista;
    }

    public void setLista(List<Marcas> lista) {
        this.lista = lista;
    }

      @PostConstruct
   public void init(){
       marcas = new Marcas();
       empresas = new Empresas();
       user = new Usuario();
       user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
   }
   
   public void limpiar(){
       marcas = new Marcas();
       empresas = new Empresas();
   }
   
   public void guardar(){
       try {
           user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           this.marcas.setID_empresas(user.getID_empresas());
           marcasEJB.create(marcas);
           
           limpiar();
       } catch (Exception e) {
       }
   }
   
   public void consultAll(){
       try {
      user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           lista = marcasEJB.findAll();
       } catch (Exception e) {
       }
   }
   
   public void eliminar(Marcas id){
       try {
          marcasEJB.remove(id);
       } catch (Exception e) {
       }
   }
   
   public void actualizar(){
       try {
          user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           this.marcas.setID_empresas(user.getID_empresas());
           marcasEJB.edit(marcas);
           
           limpiar();
       } catch (Exception e) {
       }
   }
   public void leerId(Marcas id){
       this.empresas.setId(id.getID_empresas().getId());
       marcas = id;    
   }
    
}
