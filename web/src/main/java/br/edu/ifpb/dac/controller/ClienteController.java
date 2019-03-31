
package br.edu.ifpb.dac.controller;

import br.edu.ifpb.dac.infra.interfaces.PedidoDaoInterface;
import br.edu.ifpb.dac.jms.Comprador;
import br.edu.ifpb.dac.model.Cliente;
import br.edu.ifpb.dac.model.Pedido;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rodger
 * @author fernanda
 */
@Named
@RequestScoped
public class ClienteController {
   
    @Inject
    private Comprador clientes;
    
    private Cliente novoCliente = new Cliente();
    
    public String salvarCliente() {
        clientes.adicionar(novoCliente);
        return null;
    }

    public Cliente getCliente() {
        return novoCliente;
    }

    public void setCliente(Cliente cliente) {
        this.novoCliente = cliente;
    }
    
}
