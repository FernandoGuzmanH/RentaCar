/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.RollesFacadeLocal;
import entity.Rolles;
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
@Named(value = "rollController")
@SessionScoped
public class rollController implements Serializable {

   
   @EJB
    private RollesFacadeLocal rollEJB;
    private Rolles rolles;
    private Usuario user;
    private List<Rolles> lista;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public RollesFacadeLocal getRollEJB() {
        return rollEJB;
    }

    public void setRollEJB(RollesFacadeLocal rollEJB) {
        this.rollEJB = rollEJB;
    }

    public Rolles getRolles() {
        return rolles;
    }

    public void setRolles(Rolles rolles) {
        this.rolles = rolles;
    }

    public List<Rolles> getLista() {
        this.lista=rollEJB.findAll();
        
        return lista;
    }

    public void setLista(List<Rolles> lista) {
        this.lista = lista;
    }
     @PostConstruct
   public void init() {
        rolles = new Rolles();
        user = new Usuario();
        //esto es para llamar el nombre mediante la variable de session
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }
   
   public void guardar() {
        try {
            rollEJB.create(rolles);
            lista = rollEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void consultarAll() {
        try {
            lista = rollEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void Eliminar(Rolles id) {
        try {

            rollEJB.remove(id);
            lista = rollEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void leerId(Rolles id) {
        try {

            rolles = id;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            rollEJB.edit(rolles);
            lista = rollEJB.findAll();
        } catch (Exception e) {
        }

    }
    
}
