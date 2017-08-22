 
package projetobarbeiro;

import static java.lang.Thread.sleep;
import static projetobarbeiro.ProjetoBarbeiro.lugares;
import static projetobarbeiro.ProjetoBarbeiro.acordado;
import static projetobarbeiro.ProjetoBarbeiro.atendendo;
/**
 *
 * @author Bruno Dourado Miranda
 */
public class Barbearia {

    Barbearia() {
        //Seta as características da barbearia;
        acordado = false;//O Barbeiro está dormindo;
        atendendo=false;//O Barbeiro por estar dormindo, não está atendendo;
        lugares = new boolean[5];// E a fila, com 5 lugares, está vazia;
        for (int i = 0; i <= 4; i++) {
            lugares[i] = false;
        }
    }
    
    //Retorna um lugar vazio, se disponível, se a fila estiver cheia, retorna 5;
    public static int filaEspera(){
        int lugar=0;        
        while(lugar<=4 && lugares[lugar]){
            lugar++;
        }
        return lugar;
    }
   
    public static void filaAtendimento() throws InterruptedException {
        // Caso o cliente encontre um lugar na fila, ele "entra" na barbearia;
        if (filaEspera() < 5) {
            //Se a fila estiver vazia, então:
            if (filaEspera() == 0) {
                acordado = true;//O  barbeiro é acordado.
                lugares[0]=true;// O lugar 0, que é a cadeira, é ocupado;
                System.out.println("-----------------------------------------");
                System.out.println("-------------Cliente Chegou!-------------");
                System.out.println("------------Barbeiro Acordou!------------");
                System.out.println("-----------------------------------------");
                System.out.println("\n\n\n\n");
            } else {
                //Se tiver algum cliente sendo atendido no momento, o cliente recém chegado
                //ocupa um lugar na fila;
                lugares[filaEspera()]=true;
                System.out.println("---------------------------");
                System.out.println("------Cliente Chegou!------");
                System.out.println("---Cliente foi pra fila----");
                System.out.println("----------------------------");
                System.out.println("\n\n\n\n");
            }
        } else {
            //Se a barbearia estiver cheia, então o cliente que chegou vai embora;
            System.out.println("----------------------");
            System.out.println("------Fila Cheia------");
            System.out.println("--Cliente foi embora--");
            System.out.println("----------------------");
            System.out.println("\n\n\n\n");
        }
    }
    
    //O cliente que é atendido vai embora e a fila avança e libera o último lugar, caso estiver cheia;
    public static void retiraCliente() {
        int lugar=0;
        for (int i=1;i<=4;i++){
            lugares[lugar]=lugares[i];
            lugar++;
        }
        lugares[4]=false;
    }
    
   public static  void atendimentoAoCliente() throws InterruptedException {
        filaAtendimento();// O cliente recém chegado vai para a fila (ou cadeira de atendimento);
        if (acordado) {
            while (atendendo);// Enquanto o barbeiro está atendendo um cliente que chegou antes ele espera;  
            sleep(2000);       
            atendendo=true; // Ao chegar sua vez, ganha exclusividade com o barbeiro e é atendido;
            
            System.out.println("--------------------------------");
            System.out.println("--------Cliente atendido!-------");
            System.out.println("-----Barba e cabelo aparados----");
            System.out.println("--------------------------------");
            System.out.println("\n\n\n\n");
          
             
            retiraCliente();// Depois do atendimento, o cliente vai embora;
            atendendo=false;// O barbeiro não está mais atendendo e um provável próximo cliente pode ser atendido;
            
            if (filaEspera() == 0) {// Caso o cliente seja o último da fila a ser atendido, então o barbeiro volta a dormir;
                acordado = false;
                System.out.println("-----------------------------------");
                System.out.println("-----Barbeiro voltou a dormir!-----");
                System.out.println("-----------------------------------");
                System.out.println("\n\n\n\n");
            }
        }

    }
    
}
