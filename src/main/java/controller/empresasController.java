/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.EmpresasFacadeLocal;
import entity.Empresas;
import entity.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

@Named(value = "empresasController")
@SessionScoped
public class empresasController implements Serializable {

    @EJB
    private EmpresasFacadeLocal empresasEJB;
    private Empresas empresas; 
    private Usuario user;
    private List<Empresas> lista;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public List<Empresas> getLista() {
       lista = empresasEJB.findAll();
        return lista;
    }

    public void setLista(List<Empresas> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init() {
        empresas = new Empresas();
        user = new Usuario();
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }

    public void guardar() {
        try {
            empresasEJB.create(empresas);
            lista = empresasEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void consultarAll() {
        try {
            lista = empresasEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void Eliminar(Empresas id) {
        try {

            empresasEJB.remove(id);
            lista = empresasEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void leerId(Empresas id) {
        try {

            empresas = id;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            empresasEJB.edit(empresas);
            lista = empresasEJB.findAll();
        } catch (Exception e) {
        }

    }
    
    
 
  
  

}
