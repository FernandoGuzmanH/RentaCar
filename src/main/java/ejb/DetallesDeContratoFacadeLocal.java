/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.DetallesDeContrato;
import entity.Usuario;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dennys.zepedausam
 */
@Local
public interface DetallesDeContratoFacadeLocal {

    void create(DetallesDeContrato detallesDeContrato);

    void edit(DetallesDeContrato detallesDeContrato);

    void remove(DetallesDeContrato detallesDeContrato);

    DetallesDeContrato find(Object id);

    List<DetallesDeContrato> findAll();
     public List<DetallesDeContrato> mostrardetallesdeConmtratos(Usuario us);

  
    
}
