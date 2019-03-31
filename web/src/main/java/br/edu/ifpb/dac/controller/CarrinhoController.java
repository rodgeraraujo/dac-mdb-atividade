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
    private Clientes clientes;
    private String comprador = null;

    public String adicionarItem(Produto produto) {
        carrinho.adicionarProduto(produto);
        return null;
    }

    public String removerItem(Produto produto) {
        carrinho.removerProduto(produto);
        return null;
    }

    public List<ItemCompra> itensCarrinho() {
        return carrinho.verItensCarrinho();
    }

    public BigDecimal valorCompra() {
        return carrinho.valorTotalCarrinhoDeCompras();
    }

    public String finalizarCompra() {
        Cliente cliente = clientes.buscar(comprador);
        carrinho.adicionarCliente(cliente);
        carrinho.finalizarCompra();
        return null;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    private void reset() {
//        HttpSession session = (HttpSession) 
//                FacesContext.getCurrentInstance()
//                            .getExternalContext()
//                            .getSession(false);
//        session.invalidate();
    }
}
