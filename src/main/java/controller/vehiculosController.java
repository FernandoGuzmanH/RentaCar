/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.VehiculosFacadeLocal;
import entity.Empresas;
import entity.Marcas;
import entity.Modelos;
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
@Named(value = "vehiculosController")
@SessionScoped
public class vehiculosController implements Serializable {

   @EJB
    private VehiculosFacadeLocal vehiculosEJB;
    private Vehiculos vehiculos;
    private Modelos modelos;
    private Usuario user;
    private Marcas marcas;
    private Empresas empresas;
    private List<Vehiculos> lista;

    public VehiculosFacadeLocal getVehiculosEJB() {
        return vehiculosEJB;
    }

    public void setVehiculosEJB(VehiculosFacadeLocal vehiculosEJB) {
        this.vehiculosEJB = vehiculosEJB;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Modelos getModelos() {
        return modelos;
    }

    public void setModelos(Modelos modelos) {
        this.modelos = modelos;
    }

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

    public List<Vehiculos> getLista() {
        //depura las tenant
        this.lista=vehiculosEJB.listavehiculos(user);
        return lista;
    }

    public void setLista(List<Vehiculos> lista) {
        this.lista = lista;
    }
  @PostConstruct
    public void init(){
        vehiculos = new Vehiculos();
        modelos = new Modelos();
        marcas = new Marcas();
        empresas = new Empresas();
        user = new Usuario();
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }
    public void guardar(){
        try {
             user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.vehiculos.setID_modelos(modelos);
            this.vehiculos.setID_marcas(marcas);
            this.vehiculos.setID_empresas(user.getID_empresas());
            vehiculosEJB.create(vehiculos);
       
            limpiar();
        } catch (Exception e) {
        }
    }
    public void consultarAll(){
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            lista = vehiculosEJB.findAll();
        } catch (Exception e) {
        }
    }
    public void limpiar(){
        vehiculos = new Vehiculos();
        modelos = new Modelos();
        marcas = new Marcas();
        empresas = new Empresas();
           user = new Usuario();
    }
    public void eliminar(Vehiculos id){
        try {
            vehiculosEJB.remove(id);
        } catch (Exception e) {
        }
    }
    public void actualizar(){
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.vehiculos.setID_modelos(modelos);
            this.vehiculos.setID_marcas(marcas);
            this.vehiculos.setID_empresas(user.getID_empresas());
            vehiculosEJB.edit(vehiculos);
        } catch (Exception e) {
        }
    }
    public void leerId(Vehiculos id){
        try {
            this.modelos.setId(id.getID_modelos().getId());
            this.marcas.setId(id.getID_marcas().getId());
            this.empresas.setId(id.getID_empresas().getId());
            this.vehiculos = id;
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
