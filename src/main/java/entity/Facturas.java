/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "facturas")
public class Facturas implements  Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;
    @JoinColumn(name = "ID_personas", referencedColumnName = "id")
    @ManyToOne
    private Personas ID_personas;
    @JoinColumn(name = "ID_estados", referencedColumnName = "id")
    @ManyToOne
    private Estados ID_estados;
    @Column(name = "correlativo")
    private int correlativo;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "ID_empresas", referencedColumnName = "id")
    @ManyToOne
    private Empresas ID_empresas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personas getID_personas() {
        return ID_personas;
    }

    public void setID_personas(Personas ID_personas) {
        this.ID_personas = ID_personas;
    }

    public Estados getID_estados() {
        return ID_estados;
    }

    public void setID_estados(Estados ID_estados) {
        this.ID_estados = ID_estados;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        hash = 19 * hash + this.id;
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
        final Facturas other = (Facturas) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facturas{" + "id=" + id + '}';
    }

    public Facturas() {
    }

    

   
}
