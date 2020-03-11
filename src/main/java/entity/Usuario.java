/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "ID_empresas")
    private Empresas ID_empresas;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "clave")
    private String clave;

    public Empresas getID_empresas() {
        return ID_empresas;
    }

    public void setID_empresas(Empresas ID_empresas) {
        this.ID_empresas = ID_empresas;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.ID_empresas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.ID_empresas, other.ID_empresas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID_empresas=" + ID_empresas + '}';
    }

    public Usuario() {
    }

}
