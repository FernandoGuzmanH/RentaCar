/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.UsuarioFacadeLocal;
import entity.Empresas;
import entity.Usuario;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author dennys.zepedausam
 */
@Named(value = "usuarioController")
@SessionScoped
public class usuarioController implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private Usuario usuario;
    private Empresas empresa;
    String mensaje= "";
    private List<Usuario> lista;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        empresa = new Empresas();          
    }
    
    public String validar (){
        String ruta = "";
        Usuario valor ;
         valor = this.usuarioEJB.acceder(this.usuario);
        try {
             
        if(valor !=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", valor);
            ruta ="/view/Rolles.xhtml";
        }else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no registrado", "admin"));
        }
        } catch (Exception e) {
            throw  e;
        }
        return ruta;
        
        }
    
    
    
    public void guardar(){
    
   usuario.setID_empresas(empresa);
   usuarioEJB.create(usuario);
   clear();
        
   this.mensaje= "Usuario y clave se registro";
   
   FacesMessage mens =  new FacesMessage(this.mensaje);
   FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    
    public void clear(){
    usuario = new Usuario();
    empresa = new Empresas(); 
        
    }
    
    public void cerrarsession() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/RENTA_CAR/faces/view/login.xhtml");
    }
  
    public void validarSession(){
      
        
    }

}
