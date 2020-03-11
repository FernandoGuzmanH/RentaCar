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
@Table(name = "modelos")
public class Modelos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "anio")
    private int anio;

    @JoinColumn(name = "ID_empresas", referencedColumnName = "id")
    @ManyToOne
    private Empresas ID_empresas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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
        final Modelos other = (Modelos) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos{" + "id=" + id + '}';
    }

    public Modelos() {
    }

}
