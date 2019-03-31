package br.edu.ifpb.dac.infra;

import br.edu.ifpb.dac.infra.interfaces.PedidoDaoInterface;
import br.edu.ifpb.dac.model.Pedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PedidoDao {//implements PedidoDaoInterface {

    @PersistenceContext
    private EntityManager em;

//    @Override
    public void salvar(Pedido pedido) {
        em.persist(pedido);
    }

//    @Override
    public List<Pedido> todos() {
        return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
    }

//    @Override
    public void remover(Pedido pedido) {
        em.remove(pedido);
    }

//    @Override
    public Pedido editar(Pedido pedido) {
        return em.merge(pedido);
    }
}
