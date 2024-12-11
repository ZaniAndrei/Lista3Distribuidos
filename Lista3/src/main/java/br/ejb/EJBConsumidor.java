package br.ejb;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

/**
 
Mariana Pedroso Naves 2320720
Andrei Fernandes Zani 2367831
*/

@MessageDriven( activationConfig={
@ActivationConfigProperty(
propertyName="destinationLookup",
propertyValue="java/Fila"),
@ActivationConfigProperty(
propertyName="destinationType",
propertyValue="jakarta.jms.Queue")
})
public class EJBConsumidor implements MessageListener {
@Override
public void onMessage(Message msg) {
System.out.println("Mensagem recebida pelo " + this.getClass().getSimpleName());
try {
TextMessage tm = (TextMessage) msg;
System.out.println(tm.getText());
} catch (Exception e){
e.printStackTrace();
}
}
}