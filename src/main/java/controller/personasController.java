/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.PersonasFacadeLocal;
import entity.Empresas;
import entity.Personas;
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
@Named(value = "personasController")
@SessionScoped
public class personasController implements Serializable {

    @EJB
    private PersonasFacadeLocal personasEJB;
    private Personas personas;
    private Rolles rolles;
    private Usuario user;
    private Empresas empresa;
    private List<Personas> lista;

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public Rolles getRolles() {
        return rolles;
    }

    public void setRolles(Rolles rolles) {
        this.rolles = rolles;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    public List<Personas> getLista() {
        this.lista = personasEJB.mostarPersona(user);
        return lista;
    }

    public void setLista(List<Personas> lista) {
        this.lista = lista;
    }

    @PostConstruct
    private void init() {
        personas = new Personas();
        rolles = new Rolles();
        empresa = new Empresas();
        user  =  new Usuario();
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }
  public void limpiar() {
        personas = new Personas();
        rolles = new Rolles();
        empresa = new Empresas();
    }
    public void guardar() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.personas.setID_rolles(rolles);
            this.personas.setID_empresas(user.getID_empresas());
            personasEJB.create(personas);
            consultarAll();
            limpiar();
        } catch (Exception e) {
        }
    }

    public void consultarAll() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            lista = personasEJB.findAll();
        } catch (Exception e) {
        }
    }

  

    public void eliminar(Personas id) {
        try {
            personasEJB.remove(id);
        } catch (Exception e) {
        }
    }

    public void actualizar() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.personas.setID_rolles(rolles);
              this.personas.setID_empresas(user.getID_empresas());
            personasEJB.edit(personas);
        } catch (Exception e) {
        }
    }

    public void leerId(Personas id) {
        try {
            this.rolles.setId(id.getID_rolles().getId());
            this.empresa.setId(id.getID_empresas().getId());
            this.personas = id;
        } catch (Exception e) {
        }
    }

}
