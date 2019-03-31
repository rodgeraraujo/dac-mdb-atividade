package br.edu.ifpb.dac.infra.interfaces;

import br.edu.ifpb.dac.model.Cliente;
import java.util.List;

/**
 *
 * @author rodger
 * @author fernanda
 */
public interface ClienteDaoInterface {
    
    void salvar(Cliente cliente);

    List<Cliente> todos();
    
    void remover(Cliente cliente);
    
    Cliente editar(Cliente cliente);
        
    Cliente buscar(String email);
    
}
