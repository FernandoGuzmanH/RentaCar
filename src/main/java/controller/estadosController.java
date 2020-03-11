/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.EstadosFacadeLocal;
import entity.Empresas;
import entity.Estados;
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
@Named(value = "estadosController")
@SessionScoped
public class estadosController implements Serializable {

@EJB
 private EstadosFacadeLocal estadosEJB;
    private Estados estados;
    private Usuario user;
    private Empresas empresas;
    private List<Estados> lista;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public List<Estados> getLista() {
        this.lista=estadosEJB.ConsultarEstados(user);
        
        return lista;
    }

    public void setLista(List<Estados> lista) {
        this.lista = lista;
    }
     @PostConstruct
    public void init() {
       estados = new Estados();
       empresas = new Empresas();
       user = new Usuario();
       user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }

    public void guardar() {
        try { 
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.estados.setID_empresas(user.getID_empresas());
            estadosEJB.create(estados);
            lista = estadosEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void consultarAll() {
        try {
               user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            estados = (Estados) estadosEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void Eliminar(Estados id) {
        try {
            estadosEJB.remove(estados);
        } catch (Exception e) {
        }
    }

    public void leerId(Estados id) {
        try {
           this.empresas.setId(id.getID_empresas().getId());
           this.estados = estadosEJB.find(id.getId());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void actualizar() {
        try {
              user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.estados.setID_empresas(user.getID_empresas());
           estadosEJB.edit(estados);
        } catch (Exception e) {
        }

    }       
}
