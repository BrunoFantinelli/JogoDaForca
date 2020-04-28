/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca;

import java.util.ArrayList;
import java.util.Random;
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
        boolean ganhou = false;
        ArrayList<String> palavras = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        
        int vidas = 5;
        
        palavras.add("luana");
        palavras.add("bruno");
        palavras.add("amanda");
        palavras.add("isadora");
        palavras.add("leonardo");
        
        Random gerador = new Random();
        int valor = gerador.nextInt(5);
        
        StringBuilder resposta_usuario = new StringBuilder();
        String resposta = palavras.get(valor);
        
        for(int j = 0; j < resposta.length(); j++){
               resposta_usuario.append("_");
        }
        
        
        char letra;
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
            
            System.out.println(resposta_usuario);
                    
            if(!achou){
                vidas--;
            }
            
            if(!resposta_usuario.toString().contains("_")){
                ganhou = true;
                break;
            }
        }
        
        if(ganhou){
            System.out.println("Ganhou. =)");
        }else{
            System.out.println("Perdeu. =(");
        }
        
    }
    
}
