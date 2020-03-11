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
@Table(name = "detallesDeEntrada")
public class DetalleDeEntrada implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @Temporal(TemporalType.DATE)
   @Column(name = "fecha_ingreso")
    private Date fecha_ingreso;
    
    @Column(name = "precio_ingreso")
    private double precio_ingreso;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "descipcion")
    private String descipcion;
    
    @JoinColumn(name = "ID_empresas", referencedColumnName = "id")
    @ManyToOne
    private Empresas ID_empresas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public double getPrecio_ingreso() {
        return precio_ingreso;
    }

    public void setPrecio_ingreso(double precio_ingreso) {
        this.precio_ingreso = precio_ingreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public Empresas getID_empresas() {
        return ID_empresas;
    }

    public void setID_empresas(Empresas ID_empresas) {
        this.ID_empresas = ID_empresas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
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
        final DetalleDeEntrada other = (DetalleDeEntrada) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleDeEntrada{" + "id=" + id + '}';
    }

    public DetalleDeEntrada() {
    }

    

}
