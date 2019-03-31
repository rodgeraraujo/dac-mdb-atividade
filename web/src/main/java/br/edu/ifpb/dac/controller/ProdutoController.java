
package br.edu.ifpb.dac.controller;

import br.edu.ifpb.dac.model.Produto;
import br.edu.ifpb.dac.infra.ProdutoDao;
import java.util.Collections;
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
public class ProdutoController {
    
    @Inject
    private ProdutoDao produtoDao;
    private Produto produto = new Produto();

    public List<Produto> todosOsProdutos() {
        return Collections.unmodifiableList(produtoDao.todos());
    }
    
    public String adicionarProduto() {
        produtoDao.salvar(produto);
        produto = new Produto();
        return null;
//        return UrlDispatcher.dispatch("index.html");
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
