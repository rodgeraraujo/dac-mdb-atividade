package br.edu.ifpb.dac.cardCredit.jms;

import br.edu.ifpb.dac.model.Pedido;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;

/**
 *
 * @author rodger
 * @author fernanda
 */
@MessageDriven(
        mappedName = "jms/LojaVirtual",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType",
                    propertyValue = "javax.jms.Topic")
            ,
            @ActivationConfigProperty(propertyName = "destinationName",
                    propertyValue = "topic")
            ,
            @ActivationConfigProperty(propertyName = "messageSelector",
                    propertyValue = "destinatario = 'cartaoDeCredito'")
        })
public class ProcessaCartao implements MessageListener {

    @Resource(lookup = "jms/LojaVirtual")
    private Topic topic;
    
    @Inject
    private JMSContext context;

    private final BigDecimal VALOR_LIMITE_CARTAO = new BigDecimal(1500); // R$ 1,50

    @Override
    public void onMessage(Message message) {
        try {
            JMSProducer producer = context.createProducer();
            Pedido pedido = message.getBody(Pedido.class);
            
            if (pedido.valorPedido().compareTo(VALOR_LIMITE_CARTAO) == -1)
                producer.setProperty("finalizaCompra", true);
            else producer.setProperty("finalizaCompra", false);
                
            producer.setProperty("clienteEmail", "finalizaCompra");
            producer.send(topic, pedido);
        } catch (JMSException ex) {
            Logger.getLogger(ProcessaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
