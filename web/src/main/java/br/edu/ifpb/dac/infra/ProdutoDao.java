package br.edu.ifpb.dac.infra;

import br.edu.ifpb.dac.infra.interfaces.ProdutoDaoInterface;
import br.edu.ifpb.dac.model.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProdutoDao {//implements ProdutoDaoInterface {

    @PersistenceContext
    private EntityManager em;

//    @Override
    public void salvar(Produto produto) {
        em.persist(produto);
    }

//    @Override
    public List<Produto> todos() {
        return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

//    @Override
    public void remover(Produto produto) {
        em.remove(produto);
    }

//    @Override
    public Produto editar(Produto produto) {
        return em.merge(produto);
    }

}
