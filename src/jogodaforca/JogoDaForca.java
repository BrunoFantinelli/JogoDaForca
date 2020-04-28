package jogodaforca;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class JogoDaForca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controle controle = new Controle();
        
        boolean ganhou = false;
        Scanner entrada = new Scanner(System.in);
        int vidas = 5;
        char letra;
        
        StringBuilder resposta_usuario = new StringBuilder();
        String resposta = controle.sortearPalavra();
        
        for(int j = 0; j < resposta.length(); j++){
               resposta_usuario.append("_");
               System.out.print("_ ");
        }
        
        System.out.println("\n");
        
        while(vidas > 0){
            letra = entrada.next().charAt(0);
            boolean achou = false;
            
            for(int i = 0; i < resposta.length(); i++){
                if(resposta.charAt(i) == letra){
                    resposta_usuario.deleteCharAt(i);
                    resposta_usuario.insert(i, letra);
                    achou = true;
                }
            }
            
            for(int x = 0; x < resposta.length(); x++){
                System.out.print(resposta_usuario.charAt(x) + " ");
            }
            
            System.out.println("\n");
        
            if(!achou){
                vidas--;
            }
            
            if(!resposta_usuario.toString().contains("_")){
                ganhou = true;
                break;
            }
        }
        
        System.out.println(controle.getResultado(ganhou));
        
    }

}
