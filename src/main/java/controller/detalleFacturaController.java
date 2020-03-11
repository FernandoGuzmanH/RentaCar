/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.DetallesDeFacturasFacadeLocal;
import entity.DetallesDeFacturas;
import entity.Empresas;
import entity.Facturas;
import entity.Usuario;
import entity.Vehiculos;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;


@Named(value = "detalleFacturaController")
@SessionScoped
public class detalleFacturaController implements Serializable {

   @EJB
    private DetallesDeFacturasFacadeLocal detalleFacEJB;
    private DetallesDeFacturas detallesDeFacturas;
    private List<DetallesDeFacturas> lista;
    //objetos completos de entidad 
    private Empresas empresas;
    private Facturas facturas;
    private Vehiculos vehiculos;
    private Usuario user;
    

    public DetallesDeFacturas getDetallesDeFacturas() {
        return detallesDeFacturas;
    }

    public void setDetallesDeFacturas(DetallesDeFacturas detallesDeFacturas) {
        this.detallesDeFacturas = detallesDeFacturas;
    }

    public List<DetallesDeFacturas> getLista() {
        this.lista=detalleFacEJB.Consultadetalledactura(user);
        return lista;
    }

    public void setLista(List<DetallesDeFacturas> lista) {
        this.lista = lista;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    @PostConstruct
    public void init() {
        detallesDeFacturas = new DetallesDeFacturas();
        empresas = new Empresas();
        facturas = new Facturas();
        vehiculos = new Vehiculos();
        user = new Usuario();
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }

    public void mostrarTodo() {
        try {
              user =(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            // inclusion de entidades 
            lista = detalleFacEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void guardar() {
        try {
            user =(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            // inclusion de entidades 
            this.detallesDeFacturas.setID_empresas(user.getID_empresas());
            this.detallesDeFacturas.setID_facturas(facturas);
            this.detallesDeFacturas.setID_vehiculos(vehiculos);
            // metodo en si 
            detalleFacEJB.create(detallesDeFacturas);
            lista = detalleFacEJB.findAll();
            // limpieza de objeto 
            this.empresas = new Empresas();
            this.facturas = new Facturas();
            this.vehiculos = new Vehiculos();
        } catch (Exception e) {
        }
    }

    public void actualizar() {
        try {
             user =(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            // inclusion de entidades 
            this.detallesDeFacturas.setID_empresas(user.getID_empresas());
            this.detallesDeFacturas.setID_facturas(facturas);
            this.detallesDeFacturas.setID_vehiculos(vehiculos);
            //metodo en si 
            detalleFacEJB.edit(detallesDeFacturas);
            lista = detalleFacEJB.findAll();
            // limpieza de objeto 
            this.empresas = new Empresas();
            this.facturas = new Facturas();
            this.vehiculos = new Vehiculos();
        } catch (Exception e) {
        }
    }

    public void eliminiar(DetallesDeFacturas id) {
        try {
            detalleFacEJB.remove(id);
            lista = detalleFacEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void mostrarID(DetallesDeFacturas id) {
        try {
            //para cada una de las entidades 
            this.empresas.setId(id.getID_empresas().getId());
            this.facturas.setId(id.getID_facturas().getId());
            this.vehiculos.setId(id.getID_vehiculos().getId());
            // metodo en si 
            this.detallesDeFacturas = this.detalleFacEJB.find(id.getId());
        } catch (Exception e) {
        }
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
}
