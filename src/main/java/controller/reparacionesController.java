/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ReparacionesFacadeLocal;
import entity.Empresas;
import entity.Reparaciones;
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
@Named(value = "reparacionesController")
@SessionScoped
public class reparacionesController implements Serializable {

    @EJB
    private ReparacionesFacadeLocal reparacionesEJB;
    private Reparaciones reparaciones;
    private Vehiculos vehiculos;
    private Empresas empresas;
    private Usuario user;
    private List<Reparaciones> lista;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Reparaciones getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(Reparaciones reparaciones) {
        this.reparaciones = reparaciones;
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

    public List<Reparaciones> getLista() {
        this.lista = reparacionesEJB.mostrararreparaciones(user);
        return lista;
    }

    public void setLista(List<Reparaciones> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        vehiculos = new Vehiculos();
        empresas = new Empresas();
        reparaciones = new Reparaciones();
        user = new Usuario();
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }

    public void guardar() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.reparaciones.setID_vehiculos(vehiculos);
            this.reparaciones.setID_empresas(user.getID_empresas());
            reparacionesEJB.create(reparaciones);
            consultarAll();
            limpiar();
        } catch (Exception e) {
        }
    }

    public void consultarAll() {
        try {
             user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            lista = reparacionesEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void limpiar() {
        vehiculos = new Vehiculos();
        empresas = new Empresas();
        reparaciones = new Reparaciones();
        user = new Usuario();
    }

    public void eliminar(Reparaciones id) {
        try {
            reparacionesEJB.remove(id);
        } catch (Exception e) {
        }
    }

    public void actualizar() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.reparaciones.setID_vehiculos(vehiculos);
            this.reparaciones.setID_empresas(user.getID_empresas());
            reparacionesEJB.edit(reparaciones);
        } catch (Exception e) {
        }
    }

    public void leerId(Reparaciones id) {
        try {
            this.vehiculos.setId(id.getID_vehiculos().getId());
            this.empresas.setId(id.getID_empresas().getId());
            this.reparaciones = id;
        } catch (Exception e) {
        }
    }
}
