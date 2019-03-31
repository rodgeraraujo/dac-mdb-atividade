package br.edu.ifpb.dac.infra;

import br.edu.ifpb.dac.infra.interfaces.ClienteDaoInterface;
import br.edu.ifpb.dac.model.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClienteDao{// implements ClienteDaoInterface {

    @PersistenceContext
    private EntityManager em;

//    @Override
    public void salvar(Cliente cliente) {
        em.persist(cliente);
    }
    
//    @Override
    public List<Cliente> todos() {
        return em.createQuery("SELECT c FROM cliente c", Cliente.class).getResultList();
    }

//    @Override
    public void remover(Cliente cliente) {
        em.remove(cliente);
    }
    
//    @Override
    public Cliente editar(Cliente cliente) {
        return em.merge(cliente);
    }

//    @Override
    public Cliente buscar(String email) {
        return em.createQuery("SELECT c FROM cliente c WHERE c.email = :email", Cliente.class)
                .setParameter("email", email)
                .getSingleResult();
    }    
}
