/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.DetalleDeEntrada;
import entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dennys.zepedausam
 */
@Local
public interface DetalleDeEntradaFacadeLocal {

    void create(DetalleDeEntrada detalleDeEntrada);

    void edit(DetalleDeEntrada detalleDeEntrada);

    void remove(DetalleDeEntrada detalleDeEntrada);

    DetalleDeEntrada find(Object id);

    List<DetalleDeEntrada> findAll();

    public List<DetalleDeEntrada> mostrarEntrada(Usuario us);
    
}
