package br.edu.ifpb.dac.email;

import br.edu.ifpb.dac.model.Pedido;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author rodger
 * @author fernanda
 */
public class EnviadorDeEmail implements MessageListener {

    private static final String EMAIL = "dacmessagedrivebean@gmail.com";
    private static final String PASS = "messagedrivebean";

    @Override
    public void onMessage(Message message) {
        try {
            Pedido pedido = message.getBody(Pedido.class);
            boolean[] clienteEmail = new boolean[1];

            if (message.propertyExists("clienteEmail")) {

                if (message.getStringProperty("clienteEmail").equals("messageProcess")) {
                    enviarEmail(pedido, clienteEmail);

                } else if (message.getStringProperty("clienteEmail").equals("finalizaCompra")) {

                    if (message.propertyExists("finalizaCompra")) {
                        if (message.getBooleanProperty("finalizaCompra")) {
                            clienteEmail[0] = true;
                            enviarEmail(pedido, clienteEmail);
                        } else {
                            clienteEmail[0] = false;
                            enviarEmail(pedido, clienteEmail);
                        }
                    }

                }
            }
        } catch (JMSException ex) {
            Logger.getLogger(EnviadorDeEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void enviarEmail(Pedido pedido, boolean[] typeEmail) {
        System.out.println("Enviando email referente ao pedido" + pedido.toString());
    }

}
