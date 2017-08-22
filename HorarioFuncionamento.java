/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobarbeiro;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Universidade
 */
public class HorarioFuncionamento extends Thread{
      @Override
  public void run() {
    while(true){
        //"Abre" a barbearia, criando assim outra Thread";
        try {
            Barbearia.atendimentoAoCliente();
        } catch (InterruptedException ex) {
            Logger.getLogger(HorarioFuncionamento.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      try {
        sleep(1500);
      } catch (InterruptedException ex) {
        Logger.getLogger(HorarioFuncionamento.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
