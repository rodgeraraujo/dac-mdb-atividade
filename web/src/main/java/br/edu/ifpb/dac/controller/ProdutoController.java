
package br.edu.ifpb.dac.controller;

import br.edu.ifpb.dac.model.Produto;
import br.edu.ifpb.dac.infra.ProdutoDao;
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
public class ProdutoController {
    
    @Inject
    private ProdutoDao produtos;
    private Produto produto = new Produto();

    
    
}
