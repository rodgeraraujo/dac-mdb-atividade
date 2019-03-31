package br.edu.ifpb.dac.jms;

import br.edu.ifpb.dac.model.Pedido;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;

/**
 *
 * @author rodger
 * @author fernanda
 */
@Stateless
public class ProcessaCompra {
    
    @Resource(lookup = "jms/LojaVirtual")
    private Topic topic;
    
    @Inject
    private JMSContext context;
    
    public void analisarCompra(Pedido pedido) {
        JMSProducer producer = context.createProducer();
        producer.setProperty("destinatario", "cartaoDeCredito");
        producer.setProperty("clienteEmail", "processamentoCompra");
        producer.send(topic, pedido);
    }
}
