package br.edu.ifpb.dac.infra.interfaces;

import br.edu.ifpb.dac.model.Pedido;
import java.util.List;

/**
 *
 * @author rodger
 * @author fernanda
 */
public interface PedidoDaoInterface {
    
    void salvar(Pedido pedido);

    List<Pedido> todos();
    
    void remover(Pedido pedido);
    
    Pedido editar(Pedido pedido);
    
}
