/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.DetalleDeEntradaFacadeLocal;
import entity.DetalleDeEntrada;
import entity.Empresas;
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
@Named(value = "detallesdeentradaController")
@SessionScoped
public class detallesdeentradaController implements Serializable {

    @EJB
    private DetalleDeEntradaFacadeLocal detallesEJB;
    private DetalleDeEntrada detalles;
    private Empresas empresas;
    private Usuario user;
    private List<DetalleDeEntrada> lista;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public DetalleDeEntrada getDetalles() {
        return detalles;
    }

    public void setDetalles(DetalleDeEntrada detalles) {
        this.detalles = detalles;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public List<DetalleDeEntrada> getLista() {
        this.lista = detallesEJB.mostrarEntrada(user);
        return lista;
    }

    public void setLista(List<DetalleDeEntrada> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
        detalles = new DetalleDeEntrada();
        empresas = new Empresas(); 
        user = new Usuario();
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }
    public void guardar(){
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.detalles.setID_empresas(user.getID_empresas());
            detallesEJB.create(detalles);
            limpiar();
        } catch (Exception e) {
        }
    }
    public void consultarAll(){
        try {
            
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
 
            lista = detallesEJB.findAll();
        } catch (Exception e) {
        }
    }
    public void limpiar(){
        detalles = new DetalleDeEntrada();
        empresas = new Empresas();
    }
    public void eliminar(DetalleDeEntrada id){
        try {
            detallesEJB.remove(id);
        } catch (Exception e) {
        }
    }
    public void actualizar(){
        try {
          
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            this.detalles.setID_empresas(user.getID_empresas());
            detallesEJB.edit(detalles);
            limpiar();
        } catch (Exception e) {
        }
    }
    public void leerId(DetalleDeEntrada id){
        try {
            this.empresas.setId(id.getID_empresas().getId());
            this.detalles = id;
        } catch (Exception e) {
        }
    }
}
