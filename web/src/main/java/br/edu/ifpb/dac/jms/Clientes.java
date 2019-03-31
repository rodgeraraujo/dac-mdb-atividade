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
public class Clientes {
    
    @Inject
    private ClienteDao repository;
    
    public void adicionar(Cliente cliente) {
        repository.salvar(cliente);
    }

    public Cliente editar(Cliente cliente) {
        return repository.editar(cliente);
    }
    
    public void remover(Cliente cliente) {
        repository.remover(cliente);
    }
    
    public Cliente buscar(String email) {
        return repository.buscar(email);
    }
    
    public List<Cliente> listar() {
        return repository.todos();
    }
    
}
