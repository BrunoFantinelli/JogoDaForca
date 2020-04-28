package jogodaforca;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author bruno
 */
public class Controle {
        
    
    public String sortearPalavra(){
        Random gerador = new Random();
        int valor = gerador.nextInt(5);
        
        ArrayList<String> palavras = new ArrayList<>();
        
        palavras.add("luana");
        palavras.add("bruno");
        palavras.add("amanda");
        palavras.add("isadora");
        palavras.add("leonardo");
        
        return palavras.get(valor);
    }
    
    public String getResultado(boolean resultado){
        if(resultado){
            return "Ganhou. =)";
        }
        return "Perdeu. =(";
    }
}
