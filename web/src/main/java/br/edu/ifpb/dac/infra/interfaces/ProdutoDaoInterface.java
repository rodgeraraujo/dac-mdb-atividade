package br.edu.ifpb.dac.infra.interfaces;

import br.edu.ifpb.dac.model.Produto;
import java.util.List;

/**
 *
 * @author rodger
 * @author fernanda
 */
public interface ProdutoDaoInterface {
    
    void salvar(Produto produto);

    List<Produto> todos();
    
    void remover(Produto produto);
    
    Produto editar(Produto produto);
    
}
