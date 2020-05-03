/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Forca {
    
    int vidas;
    String tema;
    Scanner entrada = new Scanner(System.in);
    
    public void Jogar() throws IOException{
        Controle controle = new Controle();
        char letra;   
        boolean ganhou = false;
        
        vidas = controle.selecionarDificuldade();
        tema = controle.escolherTema();
        
        StringBuilder resposta_usuario = new StringBuilder();
        String resposta = controle.sortearPalavra();
        
        for(int j = 0; j < resposta.length(); j++){
               resposta_usuario.append("_");
               System.out.print("_ ");
        }
        
        System.out.println("\n");
        
        while(vidas > 0){
            System.out.print("Letra: ");
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
            
            if(!achou){
                vidas--;
            }
            
            System.out.println("  Vidas : " + vidas + " Tema: " + tema +  "\n");
        
            
            if(!resposta_usuario.toString().contains("_")){
                ganhou = true;
                break;
            }
        }
        
        System.out.println(controle.getResultado(ganhou, resposta));
        
    }
    

}
