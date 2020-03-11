/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.DetallesDeContratoFacadeLocal;
import entity.Contratos;
import entity.DetallesDeContrato;
import entity.Empresas;
import entity.Personas;
import entity.Usuario;
import entity.Vehiculos;
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
@Named(value = "detalleDeContratoController")
@SessionScoped
public class detalleDeContratoController implements Serializable {

    @EJB
    private DetallesDeContratoFacadeLocal detalleDeContratoEJB;
    private DetallesDeContrato detalledecontrato;
    private Contratos contratos;
    private Personas personas;
    private Vehiculos vehiculos;
    private Empresas empresas;
    private Usuario user;
    private List<DetallesDeContrato> lista;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public DetallesDeContrato getDetalledecontrato() {
        return detalledecontrato;
    }

    public void setDetalledecontrato(DetallesDeContrato detalledecontrato) {
        this.detalledecontrato = detalledecontrato;
    }

    public Contratos getContratos() {
        return contratos;
    }

    public void setContratos(Contratos contratos) {
        this.contratos = contratos;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public List<DetallesDeContrato> getLista() {
        this.lista=detalleDeContratoEJB.mostrardetallesdeConmtratos(user);
        return lista;
    }

    public void setLista(List<DetallesDeContrato> lista) {
        this.lista = lista;
    }
    
    
    @PostConstruct
    public void init() {
        detalledecontrato = new DetallesDeContrato();
        contratos = new Contratos();
        personas = new Personas();
        vehiculos = new Vehiculos();
        empresas = new Empresas();
        user = new Usuario();
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }

    public void limpiar() {
        contratos = new Contratos();
        personas = new Personas();
        vehiculos = new Vehiculos();
        empresas = new Empresas();
           user = new Usuario();

    }

    public void guardar() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.detalledecontrato.setID_contratos(contratos);
            this.detalledecontrato.setID_personas(personas);
            this.detalledecontrato.setID_vehiculos(vehiculos);
            this.detalledecontrato.setID_empresas(user.getID_empresas());
            detalleDeContratoEJB.create(detalledecontrato);

        } catch (Exception e) {
        }
    }

    public void consultAll() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            lista = detalleDeContratoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void eliminar(DetallesDeContrato id) {
        try {
            detalleDeContratoEJB.remove(id);
        } catch (Exception e) {
        }
    }

    public void actualizar() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.detalledecontrato.setID_contratos(contratos);
            this.detalledecontrato.setID_personas(personas);
            this.detalledecontrato.setID_vehiculos(vehiculos);
            this.detalledecontrato.setID_empresas(user.getID_empresas());
            detalleDeContratoEJB.edit(detalledecontrato);
        } catch (Exception e) {
        }
    }

    public void leerId(DetallesDeContrato id) {
        this.contratos.setId(id.getID_contratos().getId());
        this.personas.setId(id.getID_personas().getId());
        this.vehiculos.setId(id.getID_vehiculos().getId());
        this.empresas.setId(id.getID_empresas().getId());
        detalledecontrato = id;

    }
    
}
