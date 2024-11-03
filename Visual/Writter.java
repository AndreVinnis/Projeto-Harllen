package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Visual;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Board.Board;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Card;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Player;

public class Writter {
    public static void boardPrinter(Board board, Player jog1, Player jog2, Card[] rotacaoJog1, Card[] rotacaoJog2, Card cartaEscolhida){
        ColorsText.clearScreen();
        String path = "C:\\Users\\User\\OneDrive\\Documentos\\Vscode\\Java\\Aula_de_Laboratorio\\AulasHarllen\\Projetos\\Projeto1\\Visual\\ExemploPartida.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            int contLine = 0;
            int indiceLinhaMat = 0;
            int indiceColunaMat = 0;
            while(line != null){
                char[] lineChar = line.toCharArray();
                for(int i = 0; i < lineChar.length; i ++){
                    boolean entra = false;
                    boolean generico = true;
                    if(contLine >= 1 && contLine <= 5){
                        indiceLinhaMat = 0;
                        if(i >= 2 && i <= 8){
                            indiceColunaMat = 0;
                            entra = true;
                        }
                        if(i >= 12 && i <= 18){
                            indiceColunaMat = 1;
                            entra = true;
                        }
                        if(i >= 22 && i <= 28){
                            indiceColunaMat = 2;
                            entra = true;
                        }
                        if(entra){
                            if((board.getOcupacao()[indiceLinhaMat][indiceColunaMat] == true)){
                                if(board.getTabuleiro()[indiceLinhaMat][indiceColunaMat].getDono().getCor() == "Azul"){
                                    System.out.print(ColorsText.BLUE);
                                    charPrinter(lineChar[i], board.getTabuleiro()[indiceLinhaMat][indiceColunaMat]);
                                    System.out.print(ColorsText.RESET);
                                    generico = false;
                                }
                                else{
                                    System.out.print(ColorsText.RED);
                                    charPrinter(lineChar[i], board.getTabuleiro()[indiceLinhaMat][indiceColunaMat]);
                                    System.out.print(ColorsText.RESET);
                                    generico = false;
                                }
                            }
                            else{
                                System.out.print(' ');
                                generico = false;
                            }
                        }
                    }
                    else if(contLine >= 7 && contLine <= 11){
                        indiceLinhaMat = 1;
                        if(i >= 2 && i <= 8){
                            indiceColunaMat = 0;
                            entra = true;
                        }
                        if(i >= 12 && i <= 18){
                            indiceColunaMat = 1;
                            entra = true;
                        }
                        if(i >= 22 && i <= 28){
                            indiceColunaMat = 2;
                            entra = true;
                        }
                        if(entra){
                            if((board.getOcupacao()[indiceLinhaMat][indiceColunaMat] == true)){
                                if(board.getTabuleiro()[indiceLinhaMat][indiceColunaMat].getDono().getCor() == "Azul"){
                                    System.out.print(ColorsText.BLUE);
                                    charPrinter(lineChar[i], board.getTabuleiro()[indiceLinhaMat][indiceColunaMat]);
                                    System.out.print(ColorsText.RESET);
                                    generico = false;
                                }
                                else{
                                    System.out.print(ColorsText.RED);
                                    charPrinter(lineChar[i], board.getTabuleiro()[indiceLinhaMat][indiceColunaMat]);
                                    System.out.print(ColorsText.RESET);
                                    generico = false;
                                }
                            }
                            else{
                                System.out.print(' ');
                                generico = false;
                            }
                        }
                    }
                    else if(contLine >= 13 && contLine <= 17){
                        indiceLinhaMat = 2;
                        if(i >= 2 && i <= 8){
                            indiceColunaMat = 0;
                            entra = true;
                        }
                        if(i >= 12 && i <= 18){
                            indiceColunaMat = 1;
                            entra = true;
                        }
                        if(i >= 22 && i <= 28){
                            indiceColunaMat = 2;
                            entra = true;
                        }
                        if(entra){
                            if((board.getOcupacao()[indiceLinhaMat][indiceColunaMat] == true)){
                                if(board.getTabuleiro()[indiceLinhaMat][indiceColunaMat].getDono().getCor() == "Azul"){
                                    System.out.print(ColorsText.BLUE);
                                    charPrinter(lineChar[i], board.getTabuleiro()[indiceLinhaMat][indiceColunaMat]);
                                    System.out.print(ColorsText.RESET);
                                    generico = false;
                                }
                                else{
                                    System.out.print(ColorsText.RED);
                                    charPrinter(lineChar[i], board.getTabuleiro()[indiceLinhaMat][indiceColunaMat]);
                                    System.out.print(ColorsText.RESET);
                                    generico = false;
                                }
                            }
                            else{
                                System.out.print(' ');
                                generico = false;
                            }
                        }
                    }

                    if(contLine >= 2 && contLine <= 6){
                        if(i >= 51 && i <= 57){
                            if(rotacaoJog1[0].getDono().getCor() == "Azul"){
                                System.out.print(ColorsText.BLUE);
                                charPrinter(lineChar[i], rotacaoJog1[0]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                            else{
                                System.out.print(ColorsText.RED);
                                charPrinter(lineChar[i], rotacaoJog1[0]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                        }
                        else if(i >= 61 && i <= 67){
                            if(rotacaoJog1[0].getDono().getCor() == "Azul"){
                                System.out.print(ColorsText.BLUE);
                                charPrinter(lineChar[i], rotacaoJog1[1]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                            else{
                                System.out.print(ColorsText.RED);
                                charPrinter(lineChar[i], rotacaoJog1[1]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                        }
                        else if(i >= 71 && i <= 77){
                            if(rotacaoJog1[0].getDono().getCor() == "Azul"){
                                System.out.print(ColorsText.BLUE);
                                charPrinter(lineChar[i], rotacaoJog1[2]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                            else{
                                System.out.print(ColorsText.RED);
                                charPrinter(lineChar[i], rotacaoJog1[2]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                        }
                    }
                    else if(contLine >= 11 && contLine <= 15){
                        if(i >= 51 && i <= 57){
                            if(rotacaoJog2[0].getDono().getCor() == "Azul"){
                                System.out.print(ColorsText.BLUE);
                                charPrinter(lineChar[i], rotacaoJog2[0]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                            else{
                                System.out.print(ColorsText.RED);
                                charPrinter(lineChar[i], rotacaoJog2[0]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                        }
                        else if(i >= 61 && i <= 67){
                            if(rotacaoJog2[0].getDono().getCor() == "Azul"){
                                System.out.print(ColorsText.BLUE);
                                charPrinter(lineChar[i], rotacaoJog2[1]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                            else{
                                System.out.print(ColorsText.RED);
                                charPrinter(lineChar[i], rotacaoJog2[1]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                        }
                        else if(i >= 71 && i <= 77){
                            if(rotacaoJog2[0].getDono().getCor() == "Azul"){
                                System.out.print(ColorsText.BLUE);
                                charPrinter(lineChar[i], rotacaoJog2[2]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                            else{
                                System.out.print(ColorsText.RED);
                                charPrinter(lineChar[i], rotacaoJog2[2]);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                        }
                    }
                    else if(contLine >= 22 &&  contLine <= 26){
                        if(i >= 2 && i <= 8){
                            if(cartaEscolhida.getDono().getCor() == "Azul"){
                                System.out.print(ColorsText.BLUE);
                                charPrinter(lineChar[i], cartaEscolhida);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                            else{
                                System.out.print(ColorsText.RED);
                                charPrinter(lineChar[i], cartaEscolhida);
                                System.out.print(ColorsText.RESET);
                                generico = false;
                            }
                        }
                    }
                    if(generico){
                        if(lineChar[i] == '%'){
                            if(contLine == 0){
                                System.out.print(jog1.getCor());
                            }
                            else{
                                System.out.print(jog2.getCor());
                            }
                        }
                        else{
                            System.out.print(lineChar[i]);
                        }
                    }
                }
                line = br.readLine();
                System.out.println();
                contLine ++;
            }
        } 
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void charPrinter(char caracter, Card carta){
        if (caracter == 'a') {
            if (carta.getNumeroDeCima() == 10) {
                System.out.print('A');
            } else {
                System.out.print(carta.getNumeroDeCima());
            }
        } else if (caracter == 'b') {
            if (carta.getNumeroDaDireita() == 10) {
                System.out.print('A');
            } else {
                System.out.print(carta.getNumeroDaDireita());
            }
        } else if (caracter == 'c') {
            if (carta.getNumeroDeBaixo() == 10) {
                System.out.print('A');
            } else {
                System.out.print(carta.getNumeroDeBaixo());
            }
        } else if (caracter == 'd') {
            if (carta.getNumeroDaEsquerda() == 10) {
                System.out.print('A');
            } else {
                System.out.print(carta.getNumeroDaEsquerda());
            }
        } else {
            System.out.print(caracter);
        }
    }

    public static void cardsPrinter(Player jogador){
        int pos = 0;
        for(int i = 0; i < jogador.getQuantCartas(); i ++){
            if (jogador.getBaralho()[i].equals(jogador.getFilaDeCartas().head())) {
                pos = i*10;
            }
        }
        String path = "C:\\Users\\User\\OneDrive\\Documentos\\Vscode\\Java\\Aula_de_Laboratorio\\AulasHarllen\\Projetos\\Projeto1\\Visual\\Baralho.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            Card cartaAtual = jogador.getBaralho()[0];
            while(line != null){
                int posAtual = 0;
                char[] lineChar = line.toCharArray();
                for(int i = 0; i < (jogador.getQuantCartas() * 10) + 1; i ++){
                    if(posAtual >= pos && posAtual < pos+31){
                        System.out.print(ColorsText.GREEN);
                        charPrinter(lineChar[i], cartaAtual);
                        System.out.print(ColorsText.RESET);
                    }
                    else{
                        charPrinter(lineChar[i], cartaAtual);
                    }
                    cartaAtual = jogador.getBaralho()[(i-1)/10];
                    posAtual = i;
                }
                System.out.println();
                line = br.readLine();
            }
        } 
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}