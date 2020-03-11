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
@Table(name = "personas")
public class Personas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private int edad;

    @Column(name = "dui")
    private String dui;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @JoinColumn(name = "ID_rolles", referencedColumnName = "id")
    @ManyToOne
    private Rolles ID_rolles;

    @JoinColumn(name = "ID_empresas", referencedColumnName = "id")
    @ManyToOne
    private Empresas ID_empresas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rolles getID_rolles() {
        return ID_rolles;
    }

    public void setID_rolles(Rolles ID_rolles) {
        this.ID_rolles = ID_rolles;
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
        hash = 23 * hash + this.id;
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
        final Personas other = (Personas) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Personas{" + "id=" + id + '}';
    }

    public Personas() {
    }

}
