package br.edu.ifpb.dac.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ricardo Job
 */
@Entity
public class Pedido implements Serializable {

    @Id
    private int id;

    @OneToMany
    private List<ItemCompra> produtos;

    @ManyToOne
    private Cliente cliente;

    public Pedido() {
        this.produtos = new ArrayList<>();
    }

    public BigDecimal valorPedido() {
        return produtos.parallelStream()
                .map(ItemPedido::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
//        return produtos.parallelStream()
//                .map((carrinho) -> carrinho.getPreco())
//                .reduce(BigDecimal.ZERO, (bigDecimal, augend) -> bigDecimal.add(augend));

//        BigDecimal valorTotal = new BigDecimal(0);
//        produtos.forEach((produto) -> {
//            valorTotal.add(produto.getPreco());
//        });
//        Long collect = produtos.stream()
//                .flatMap((Produto t) -> Stream.of(t.getPreco()))
//                .collect(Collectors.reducing();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void add(Produto produto) {
        List<ItemCompra> collect = produtos.parallelStream()
                .filter((p) -> (p.getProduto().getId() == produto.getId()))
                .collect(Collectors.toList());

        if (collect == null || collect.isEmpty()) {
            produtos.add(new ItemCompra(produto));
            return;
        }
        produtos.parallelStream().forEach((p) -> {
            if (p.getProduto().getId() == produto.getId()) {
                p.setQuantidade(p.getQuantidade().add(BigDecimal.ONE));
            }
        });

    }

    public void remove(Produto produto) {
        List<ItemCompra> collect = produtos.parallelStream()
                .filter((p) -> (p.getProduto().equals(produto)))
                .collect(Collectors.toList());

        if (!collect.isEmpty()) {
            ItemCompra remover = null;

            for (ItemCompra p : produtos) {
                if (p.getProduto().getId() == produto.getId()) {
                    if (p.getQuantidade().compareTo(BigDecimal.ONE) == 1) {
                        p.setQuantidade(p.getQuantidade().subtract(BigDecimal.ONE));
                    } else {
                        remover = p;
                    }
                    break;
                }
            }

            if (remover != null) {
                produtos.remove(remover);
            }
        }
//        this.produtos.remove(produto);
    }

    public List<ItemCompra> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ItemCompra> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void
            setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "\nPedido:\n" + "id=" + id + "\nprodutos=" + produtos
                + "\nValor total:" + this.valorPedido() + "\ncliente=" + cliente + '}';
    }

}
