
package projetobarbeiro;

/**
 *
 * @author Bruno Dourado Miranda
 */
public class ProjetoBarbeiro {

     public static boolean acordado;
     public static boolean[] lugares;
     public static boolean atendendo;
    public static void main(String[] args) {
        Barbearia b= new Barbearia();        
        GeraCliente c= new GeraCliente();
        HorarioFuncionamento aberto= new HorarioFuncionamento();
        
        c.start();
        aberto.start();
    }
    
}
