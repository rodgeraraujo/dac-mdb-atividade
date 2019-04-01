
package br.edu.ifpb.dac.controller;

import br.edu.ifpb.dac.infra.ClienteDao;
import br.edu.ifpb.dac.infra.interfaces.PedidoDaoInterface;
import br.edu.ifpb.dac.jms.Clientes;
import br.edu.ifpb.dac.model.Cliente;
import br.edu.ifpb.dac.model.Pedido;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rodger
 * @author fernanda
 */

//@ManagedBean(name = "clienteController")
@Named
@RequestScoped
public class ClienteController {
   
    @Inject
    private ClienteDao clienteDao;
//    private Clientes clientes;
    
    private Cliente cliente = new Cliente();
    
    public String salvarCliente() {
//        System.out.println("NOVO CLIENTE:" + novoCliente);
        clienteDao.salvar(cliente);
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
