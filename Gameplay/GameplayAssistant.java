package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Gameplay;

import java.util.Random;
import java.util.Scanner;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Board.Board;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Board.BoardAssistant;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Card;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Player;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.PlayerAssistant;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Visual.ColorsText;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Visual.Writter;


public class GameplayAssistant {
    private static Random sorteador = new Random();

    public static Gameplay criarPartida(Scanner scan1){
        Player jogador1 = PlayerAssistant.criaJogador(scan1, "Azul");
        Player jogador2 = PlayerAssistant.criaJogador(scan1, "Vermelho");
        Gameplay partida = new Gameplay(jogador1, jogador2);
        ColorsText.clearScreen();
        return partida;
    }
    public static void rodada(Gameplay partida, Scanner scan1, Scanner scan2){
        Player jogadorAtual = partida.getJogador1();
        Player jogadorProximo = partida.getJogador2();
        turno(partida, scan1, scan2, jogadorAtual, jogadorProximo);
        if(!partida.getTabuleiro().isCheio()){
            jogadorAtual = partida.getJogador2();
            jogadorProximo = partida.getJogador1();
            turno(partida, scan1, scan2, jogadorAtual, jogadorProximo);
        }
        if(partida.getTabuleiro().isCheio()){
            if(partida.getJogador1().getPontuacao() > partida.getJogador2().getPontuacao()){
                partida.setGanhador(partida.getJogador1());
            }
            if(partida.getJogador2().getPontuacao() > partida.getJogador1().getPontuacao()){
                partida.setGanhador(partida.getJogador2());
            }
            partida.finalizarPartida();
        }
    }
    private static void turno(Gameplay partida, Scanner scan1, Scanner scan2, Player jogadorAtual, Player outroJogador){
        Card[] rotacaoCartasJog1, rotacaoCartasJog2;
        Card cartaEscolhida;
        mostrarCartasJogadorAtual(jogadorAtual, scan1);
        rotacaoCartasJog1 = jogadorAtual.getFilaDeCartas().rotacaoAtual();
        rotacaoCartasJog2 = outroJogador.getFilaDeCartas().rotacaoAtualClone();
        int sorteado = sorteador.nextInt(3);
        cartaEscolhida = rotacaoCartasJog1[sorteado];
        boolean aux = false;
        do{
            try{
                escolherPosicao(scan2, partida.getTabuleiro(), jogadorAtual, outroJogador, rotacaoCartasJog1, rotacaoCartasJog2, cartaEscolhida);
                aux = false;
            }
            catch(Exception e){
                aux = true;
                System.out.println(e.getMessage());
                System.out.println("Aperte enter para continuar: ");
                scan1.nextLine();
                ColorsText.clearScreen();
            }

        }while(aux);
        rotacaoCartasJog1[sorteado] = null;
        jogadorAtual.getFilaDeCartas().voltaCartas(rotacaoCartasJog1);
        jogadorAtual.useCard(cartaEscolhida);
        ColorsText.clearScreen();
        System.out.println("Fim do turno");
    }

    private static void mostrarCartasJogadorAtual(Player jogadorAtual, Scanner scan1){
        System.out.printf("O jogador %s está no controle (S/N): ", jogadorAtual.getCor());
        char res = scan1.nextLine().toLowerCase().charAt(0);
        while(res != 's'){
            System.out.print("Digite uma resposta válida: ");
            res = scan1.nextLine().toLowerCase().charAt(0);
        }
        ColorsText.clearScreen();
        Writter.cardsPrinter(jogadorAtual);
        System.out.println("Aperte enter quando estiver pronto: ");
        scan1.nextLine();
        ColorsText.clearScreen();
    }

    private static void escolherPosicao(Scanner scan2, Board board, Player jog1, Player jog2, Card[] rotacaoJog1, Card[] rotacaoJog2, Card cartaEscolhida) throws Exception{
        int res1, res2;
        Writter.boardPrinter(board, jog1, jog2, rotacaoJog1, rotacaoJog2, cartaEscolhida);
        System.out.println("\nEscolha um posição para jogar a carta: ");
        System.out.print("Linha: ");
        res1 = scan2.nextInt() - 1;
        System.out.print("Coluna: ");
        res2 = scan2.nextInt() - 1;
        BoardAssistant.colocarCartaNoTabuleiro(board, cartaEscolhida, res1, res2);
        comparaCartas(cartaEscolhida, board, res1, res2);
    }

    private static void comparaCartas(Card carta, Board tabuleiro, int linha, int coluna){
        boolean compCima = true;
        boolean compBaixo = true;
        boolean compDireita = true;
        boolean compEsquerda = true;
        Card cartaAux;

        if(linha == 0){
            compCima = false;
        }
        if(linha == 2){
            compBaixo = false;
        }
        if(coluna == 0){
            compEsquerda = false;
        }
        if(coluna == 2){
            compDireita = false;
        }

        if(compCima){
            cartaAux = tabuleiro.getTabuleiro()[linha-1][coluna];
            if(!(cartaAux == null)){
                if(carta.getNumeroDeCima() > cartaAux.getNumeroDeBaixo()){
                    carta.getDono().sobePontuacao();
                    cartaAux.getDono().baixaPontuacao();
                    cartaAux.setDono(carta.getDono());
                }
            }
        }
        if(compDireita){
            cartaAux = tabuleiro.getTabuleiro()[linha][coluna+1];
            if(!(cartaAux == null)){
                if(carta.getNumeroDaDireita() > cartaAux.getNumeroDaEsquerda()){
                    carta.getDono().sobePontuacao();
                    cartaAux.getDono().baixaPontuacao();
                    cartaAux.setDono(carta.getDono());
                }
            }
        }
        if(compBaixo){
            cartaAux = tabuleiro.getTabuleiro()[linha+1][coluna];
            if(!(cartaAux == null)){
                if(carta.getNumeroDeBaixo() > cartaAux.getNumeroDeCima()){
                    carta.getDono().sobePontuacao();
                    cartaAux.getDono().baixaPontuacao();
                    cartaAux.setDono(carta.getDono());
                }
            }
        }
        if(compEsquerda){
            cartaAux = tabuleiro.getTabuleiro()[linha][coluna-1];
            if(!(cartaAux == null)){
                if(carta.getNumeroDaEsquerda() > cartaAux.getNumeroDaDireita()){
                    carta.getDono().sobePontuacao();
                    cartaAux.getDono().baixaPontuacao();
                    cartaAux.setDono(carta.getDono());
                }
            }
        }
    }
}
