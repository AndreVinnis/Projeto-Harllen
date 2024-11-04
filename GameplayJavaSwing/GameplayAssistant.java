package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.GameplayJavaSwing;

import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Card;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Player;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.PlayerAssistant;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Gameplay.Gameplay;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Board.Board;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Board.BoardAssistant;

public class GameplayAssistant {

    public static Gameplay criarPartidaGUI() {
        Player jogador1 = PlayerAssistant.criaJogadorGUI("Azul");
        Player jogador2 = PlayerAssistant.criaJogadorGUI("Vermelho");
        return new Gameplay(jogador1, jogador2);
    }

    public static void jogarCartaGUI(Gameplay partida, int row, int col) throws Exception {
        Player jogadorAtual = partida.getJogadorAtual();
        Card cartaEscolhida = jogadorAtual.getFilaDeCartas().dequeue();

        Board board = partida.getTabuleiro();
        BoardAssistant.colocarCartaNoTabuleiro(board, cartaEscolhida, row, col);
        compararCartas(cartaEscolhida, board, row, col);

        partida.alternarJogador();
    }

    private static void compararCartas(Card carta, Board tabuleiro, int linha, int coluna) {
        boolean compCima = linha > 0;
        boolean compBaixo = linha < 2;
        boolean compDireita = coluna < 2;
        boolean compEsquerda = coluna > 0;
        Card cartaAux;

        if (compCima) {
            cartaAux = tabuleiro.getTabuleiro()[linha - 1][coluna];
            if (cartaAux != null && carta.getNumeroDeCima() > cartaAux.getNumeroDeBaixo()) {
                carta.getDono().sobePontuacao();
                cartaAux.getDono().baixaPontuacao();
                cartaAux.setDono(carta.getDono());
            }
        }
        if (compDireita) {
            cartaAux = tabuleiro.getTabuleiro()[linha][coluna + 1];
            if (cartaAux != null && carta.getNumeroDaDireita() > cartaAux.getNumeroDaEsquerda()) {
                carta.getDono().sobePontuacao();
                cartaAux.getDono().baixaPontuacao();
                cartaAux.setDono(carta.getDono());
            }
        }
        if (compBaixo) {
            cartaAux = tabuleiro.getTabuleiro()[linha + 1][coluna];
            if (cartaAux != null && carta.getNumeroDeBaixo() > cartaAux.getNumeroDeCima()) {
                carta.getDono().sobePontuacao();
                cartaAux.getDono().baixaPontuacao();
                cartaAux.setDono(carta.getDono());
            }
        }
        if (compEsquerda) {
            cartaAux = tabuleiro.getTabuleiro()[linha][coluna - 1];
            if (cartaAux != null && carta.getNumeroDaEsquerda() > cartaAux.getNumeroDaDireita()) {
                carta.getDono().sobePontuacao();
                cartaAux.getDono().baixaPontuacao();
                cartaAux.setDono(carta.getDono());
            }
        }
    }
}
