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
@Table(name = "vehiculos")
public class Vehiculos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "color")
    private String color;

    @Column(name = "tipo_vehiculo")
    private String tipo_vehiculo;
    
    @Column(name = "placa")
    private String placa;
    
    //campos de la imagen
    //@Column(name = "img")
    //private String img;

    @JoinColumn(name = "ID_modelos", referencedColumnName = "id")
    @ManyToOne
    private Modelos ID_modelos;
    
    @JoinColumn(name = "ID_marcas", referencedColumnName = "id")
    @ManyToOne
    private Marcas ID_marcas;
    
    @JoinColumn(name = "ID_empresas", referencedColumnName = "id")
    @ManyToOne
    private Empresas ID_empresas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Modelos getID_modelos() {
        return ID_modelos;
    }

    public void setID_modelos(Modelos ID_modelos) {
        this.ID_modelos = ID_modelos;
    }

    public Marcas getID_marcas() {
        return ID_marcas;
    }

    public void setID_marcas(Marcas ID_marcas) {
        this.ID_marcas = ID_marcas;
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
        hash = 97 * hash + this.id;
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
        final Vehiculos other = (Vehiculos) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "id=" + id + '}';
    }

    public Vehiculos() {
    }
    

}
