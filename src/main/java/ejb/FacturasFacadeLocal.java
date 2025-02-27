/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Facturas;
import entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dennys.zepedausam
 */
@Local
public interface FacturasFacadeLocal {

    void create(Facturas facturas);

    void edit(Facturas facturas);

    void remove(Facturas facturas);

    Facturas find(Object id);

    List<Facturas> findAll();

    public List<Facturas> mostrarFacturas(Usuario us);
}
