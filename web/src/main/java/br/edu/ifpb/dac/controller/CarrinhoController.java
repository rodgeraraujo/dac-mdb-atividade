package br.edu.ifpb.dac.controller;

import br.edu.ifpb.dac.jms.CarrinhoDeCompra;
import br.edu.ifpb.dac.jms.Clientes;
import br.edu.ifpb.dac.model.Cliente;
import br.edu.ifpb.dac.model.ItemCompra;
import br.edu.ifpb.dac.model.Produto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rodger
 * @author fernanda
 */
@Named
@SessionScoped
public class CarrinhoController implements Serializable {

    @Inject
    private CarrinhoDeCompra carrinho;
    
    @Inject
    private Clientes comprador;
    
    private String clienteComprador = null;

    public String adicionarProduto(Produto produto) {
        carrinho.adicionarProduto(produto);
        return null;
    }

    public String removerProduto(Produto produto) {
        carrinho.removerProduto(produto);
        return null;
    }

    public List<ItemCompra> itensNoCarrinho() {
        return carrinho.verItensCarrinho();
    }

    public BigDecimal valorCompra() {
        return carrinho.valorTotalCarrinhoDeCompras();
    }

    public String concluirCompra() {
        Cliente cliente = comprador.buscar(clienteComprador);
        carrinho.adicionarCliente(cliente);
        carrinho.concluirCompra();
        return null;
    }

    public Clientes getComprador() {
        return comprador;
    }

    public void setComprador(Clientes comprador) {
        this.comprador = comprador;
    }
}
