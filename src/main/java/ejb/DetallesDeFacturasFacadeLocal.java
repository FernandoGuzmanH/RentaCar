/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.DetallesDeFacturas;
import entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dennys.zepedausam
 */
@Local
public interface DetallesDeFacturasFacadeLocal {

    void create(DetallesDeFacturas detallesDeFacturas);

    void edit(DetallesDeFacturas detallesDeFacturas);

    void remove(DetallesDeFacturas detallesDeFacturas);

    DetallesDeFacturas find(Object id);

    List<DetallesDeFacturas> findAll();
    public List<DetallesDeFacturas> Consultadetalledactura(Usuario us);

    
    
}
