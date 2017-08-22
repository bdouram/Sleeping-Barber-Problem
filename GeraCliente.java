
package projetobarbeiro;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno Dourado Miranda
 */
public class GeraCliente extends Thread{
    private Random clienteAleatorio;
    GeraCliente(){
     clienteAleatorio= new Random();
    }
    
    @Override
    public void run() {
        while (true) {
    
            //Classe que cria um cliente;
            if (clienteAleatorio.nextInt(100) >= 50) {
                try {
                    Barbearia.filaAtendimento();
                } catch (InterruptedException ex) {
                    Logger.getLogger(GeraCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GeraCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
