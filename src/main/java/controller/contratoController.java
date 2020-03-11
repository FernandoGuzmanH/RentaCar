/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.ContratosFacadeLocal;
import entity.Contratos;
import entity.Empresas;
import entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author dennys.zepedausam
 */
@Named(value = "contratoController")
@SessionScoped
public class contratoController implements Serializable {

    @EJB
    private ContratosFacadeLocal contratoEJB;
    private Contratos contratos;
    private Usuario user;
    private List<Contratos> lista;
    // objeto completo de entidad 
    private Empresas empresas;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Contratos getContratos() {
        return contratos;
    }

    public void setContratos(Contratos contratos) {
        this.contratos = contratos;
    }

    public List<Contratos> getLista() {
        this.lista = contratoEJB.mostrarContrato(user);
        return lista;
    }

    public void setLista(List<Contratos> lista) {
        this.lista = lista;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    @PostConstruct
    public void init() {
        contratos = new Contratos();
        empresas = new Empresas();
        user = new Usuario();
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }

    public void mostrarTodo() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            // entidad relacionada
        lista = contratoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void guardar() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            // entidad relacionada
            this.contratos.setID_empresas(user.getID_empresas());
            // metodo en si 
            contratoEJB.create(contratos);
            lista = contratoEJB.findAll();
            // limpiar objeto 
            this.contratos = new Contratos();
            empresas = new Empresas();
        } catch (Exception e) {
        }
    }

    public void actualizar() {
        try {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            // entidad relacionada
            this.contratos.setID_empresas(user.getID_empresas());
            // metodo 
            contratoEJB.edit(contratos);
            lista = contratoEJB.findAll();
            // limpieza de objeto 
            contratos = new Contratos();
            empresas = new Empresas();
        } catch (Exception e) {
        }
    }

    public void eliminar(Contratos id) {
        try {
            contratoEJB.remove(id);
            lista = contratoEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void mostrarID(Contratos id) {
        try {
            this.empresas.setId(id.getID_empresas().getId());

            this.contratos = this.contratoEJB.find(id.getId());
        } catch (Exception e) {
        }
    }
    public int DiasTrabajados(Contratos fechas) {

        Date fecha_inicio = fechas.getFecha_inicio();
        Date fecha_fin = fechas.getFecha_final();

        int dias = (int) ((fecha_fin.getTime() - fecha_inicio.getTime()) / 86400000);

        return dias;

    }
}
