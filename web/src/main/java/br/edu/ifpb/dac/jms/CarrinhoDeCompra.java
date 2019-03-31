package br.edu.ifpb.dac.jms;

import br.edu.ifpb.dac.infra.PedidoDao;
import br.edu.ifpb.dac.model.ItemCompra;
import br.edu.ifpb.dac.model.Cliente;
import br.edu.ifpb.dac.model.Pedido;
import br.edu.ifpb.dac.model.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Inject;

/**
 *
 * @author rodger
 * @author fernanda
 */
@Stateful
public class CarrinhoDeCompra {
    @Inject
    private ProcessaCompra processaCompra;
    
    @Inject
    private PedidoDao pedidoDao;
    private Pedido pedido = new Pedido();
    
    
    public void adicionarProduto(Produto produto) {
        pedido.add(produto);
    }
    
    public void removerProduto(Produto produto) {
        pedido.remove(produto);
    }
    
    public BigDecimal valorTotalCarrinhoDeCompras() {
        return pedido.valorPedido();
    }
   
    
    public Pedido displayCarrinhoDeCompras() {
        return pedido;
    }
    
    public void adicionarCliente(Cliente cliente) {
        pedido.setCliente(cliente);
    }

    public List<ItemCompra> verItensCarrinho() {
        return pedido.getProdutos();
    }
    
    public String finalizarCompra() {
        pedidoDao.salvar(pedido);
        processaCompra.analisarCompra(pedido);
        this.pedido = new Pedido();
        return null;
    }
}
