/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.FacturasFacadeLocal;
import entity.Empresas;
import entity.Estados;
import entity.Facturas;
import entity.Personas;
import entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

@Named(value = "facturasController")
@SessionScoped
public class facturasController implements Serializable {

    @EJB
    private FacturasFacadeLocal facturaEJB;
    private Facturas facturas;
    private Personas personas;
    private Estados estados;
    private Empresas empresas;
    private Usuario user;
    private List<Facturas> lista;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
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

    public List<Facturas> getLista() {
        this.lista = facturaEJB.mostrarFacturas(user);
        return lista;
    }

    public void setLista(List<Facturas> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        facturas = new Facturas();
        personas = new Personas();
        estados = new Estados();
        empresas = new Empresas();
        user = new Usuario();
user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }

    public void guardar() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.facturas.setID_personas(personas);
            this.facturas.setID_estados(estados);
            this.facturas.setID_empresas(user.getID_empresas());
            facturaEJB.create(facturas);
            lista = facturaEJB.findAll();
            init();
        } catch (Exception e) {
        }
    }

    public void consultarAll() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            lista = facturaEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void Eliminar(Facturas id) {
        try {
            facturaEJB.remove(facturas);
        } catch (Exception e) {
        }
    }

    public void leerId(Facturas id) {
        try {
            this.personas.setId(id.getID_personas().getId());
            this.estados.setId(id.getID_estados().getId());
            this.empresas.setId(id.getID_empresas().getId());
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.facturas.setID_personas(personas);
            this.facturas.setID_estados(estados);
            this.facturas.setID_empresas(user.getID_empresas());
            facturaEJB.edit(facturas);
            init();
        } catch (Exception e) {
        }

    }
}
