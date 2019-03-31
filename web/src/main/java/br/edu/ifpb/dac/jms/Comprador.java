package br.edu.ifpb.dac.jms;

import br.edu.ifpb.dac.model.Cliente;
import br.edu.ifpb.dac.infra.ClienteDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Rodger
 */
@Stateless
public class Comprador {
    
    @Inject
    private ClienteDao clienteDao;
    
    public void adicionar(Cliente cliente) {
        clienteDao.salvar(cliente);
    }
    
    public List<Cliente> listar() {
        return clienteDao.todos();
    }
    
    public Cliente editar(Cliente cliente) {
        return clienteDao.editar(cliente);
    }
    
    public void remover(Cliente cliente) {
        clienteDao.remover(cliente);
    }
    
    
    
    public Cliente buscar(String email) {
        return clienteDao.buscar(email);
    }
    
}
