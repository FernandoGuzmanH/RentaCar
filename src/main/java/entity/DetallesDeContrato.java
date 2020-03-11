/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleDeContrato")
public class DetallesDeContrato implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @JoinColumn(name = "ID_contratos", referencedColumnName = "id")
    @ManyToOne
    private Contratos ID_contratos;
    @JoinColumn(name = "ID_personas", referencedColumnName = "id")
    @ManyToOne
    private Personas ID_personas;
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

    public Contratos getID_contratos() {
        return ID_contratos;
    }

    public void setID_contratos(Contratos ID_contratos) {
        this.ID_contratos = ID_contratos;
    }

    public Personas getID_personas() {
        return ID_personas;
    }

    public void setID_personas(Personas ID_personas) {
        this.ID_personas = ID_personas;
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
        hash = 71 * hash + this.id;
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
        final DetallesDeContrato other = (DetallesDeContrato) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetallesDeContrato{" + "id=" + id + '}';
    }

    public DetallesDeContrato() {
    }
    
}
