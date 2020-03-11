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
@Table(name="detallesDeFacturas")
public class DetallesDeFacturas implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "ID_facturas",referencedColumnName = "id")
    @ManyToOne
    private Facturas ID_facturas;
    @JoinColumn(name = "ID_vehiculos",referencedColumnName = "id")
    @ManyToOne
    private Vehiculos ID_vehiculos;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio")
    private double precio;
    @JoinColumn(name = "ID_empresas",referencedColumnName = "id")
    @ManyToOne
    private Empresas ID_empresas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Facturas getID_facturas() {
        return ID_facturas;
    }

    public void setID_facturas(Facturas ID_facturas) {
        this.ID_facturas = ID_facturas;
    }

    public Vehiculos getID_vehiculos() {
        return ID_vehiculos;
    }

    public void setID_vehiculos(Vehiculos ID_vehiculos) {
        this.ID_vehiculos = ID_vehiculos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Empresas getID_empresas() {
        return ID_empresas;
    }

    public void setID_empresas(Empresas ID_empresas) {
        this.ID_empresas = ID_empresas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final DetallesDeFacturas other = (DetallesDeFacturas) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetallesDeFacturas{" + "id=" + id + '}';
    }

    public DetallesDeFacturas() {
    }
    
}
