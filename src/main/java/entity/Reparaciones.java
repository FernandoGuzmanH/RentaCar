/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reparaciones")
public class Reparaciones implements Serializable{
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "tipo_danio")
    private String tipo_danio;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @JoinColumn(name = "ID_vehiculos", referencedColumnName = "id")
    @ManyToOne
    private Vehiculos ID_vehiculos;
    
    @JoinColumn(name = "ID_empresas", referencedColumnName = "id")
    @ManyToOne
    private Empresas ID_empresas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_danio() {
        return tipo_danio;
    }

    public void setTipo_danio(String tipo_danio) {
        this.tipo_danio = tipo_danio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vehiculos getID_vehiculos() {
        return ID_vehiculos;
    }

    public void setID_vehiculos(Vehiculos ID_vehiculos) {
        this.ID_vehiculos = ID_vehiculos;
    }

    public Empresas getID_empresas() {
        return ID_empresas;
    }

    public void setID_empresas(Empresas ID_empresas) {
        this.ID_empresas = ID_empresas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
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
        final Reparaciones other = (Reparaciones) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reparaciones{" + "id=" + id + '}';
    }

    public Reparaciones() {
    }
    
}
