package jogodaforca;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Controle {

    Scanner entrada = new Scanner(System.in);
    
    ArrayList<String> palavras = new ArrayList<>();

    public String sortearPalavra() {
        Random gerador = new Random();
        int valor = gerador.nextInt(palavras.size());

        return palavras.get(valor);
    }

    public String getResultado(boolean resultado, String resposta) {
        System.out.println("Resposta: " + resposta);
        if (resultado) {
            return "Ganhou. =)";
        }
        return "Perdeu. =(";
    }

    public int selecionarDificuldade() {
        System.out.println("1 - Fácil");
        System.out.println("2 - Médio");
        System.out.println("3 - Díficil");
        System.out.print("Dificuldade: ");
        int result = entrada.nextInt();
        if (result == 1) {
            return 9;
        } else if (result == 2) {
            return 7;
        } else if (result == 3) {
            return 5;
        } else {
            return 7;
        }
    }

    public void carregarPalavras(int tema) throws FileNotFoundException, IOException {
        if (tema == 1) {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bruno\\Documents\\NetBeansProjects\\JogoDaForca\\wordlist\\pais.txt"));
            while (br.ready()) {
                String linha = br.readLine();
                palavras.add(linha);
                //System.out.println(linha);
            }
            br.close();
        }else if(tema == 2){
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bruno\\Documents\\NetBeansProjects\\JogoDaForca\\wordlist\\nome.txt"));
            //Ler contrato linha por linha
            while (br.ready()) {
                String linha = br.readLine();
                palavras.add(linha);
                //System.out.println(linha);
            }
             br.close();
        }else if(tema == 3){
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bruno\\Documents\\NetBeansProjects\\JogoDaForca\\wordlist\\fruta.txt"));
            //Ler contrato linha por linha
            while (br.ready()) {
                String linha = br.readLine();
                palavras.add(linha);
                //System.out.println(linha);
            }
             br.close();
        }else if(tema == 4){
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bruno\\Documents\\NetBeansProjects\\JogoDaForca\\wordlist\\pais.txt"));
            BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\bruno\\Documents\\NetBeansProjects\\JogoDaForca\\wordlist\\nome.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\bruno\\Documents\\NetBeansProjects\\JogoDaForca\\wordlist\\fruta.txt"));
            
            while (br.ready()) {
                String linha = br.readLine();
                palavras.add(linha);
                //System.out.println(linha);
            }
            while (br1.ready()) {
                String linha = br1.readLine();
                palavras.add(linha);
                //System.out.println(linha);
            }
            while (br2.ready()) {
                String linha = br2.readLine();
                palavras.add(linha);
                //System.out.println(linha);
            }
             br.close();
             br1.close();
             br2.close();
        }
    }

    public String escolherTema() throws IOException {
        System.out.println("1 - Países");
        System.out.println("2 - Nomes");
        System.out.println("3 - Frutas");
        System.out.println("4 - Todos juntos");
        System.out.print("Escolha: ");
        int result = entrada.nextInt();
        if (result < 5 && result > 0) {
            carregarPalavras(result);
        } else {
            carregarPalavras(4);
        }
        
        if(result == 1){
            return "País";
        }else if(result == 2){
            return "Nome";
        }else if(result == 3){
            return "Fruta";
        }else{
            return "Todos os temas";
        }
    }
}
