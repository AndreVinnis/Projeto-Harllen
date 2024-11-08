package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.GameplayJavaSwing;

import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Card;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Player;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.PlayerAssistant;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Gameplay.Gameplay;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Board.Board;

public class GameplayAssistant {

    //Maior parte da lógica pega da classe GameplayAssistant original
    public static Gameplay criarPartidaGUI() {
        Player jogador1 = PlayerAssistant.criaJogadorGUI("Azul");
        Player jogador2 = PlayerAssistant.criaJogadorGUI("Vermelho");
        return new Gameplay(jogador1, jogador2);
    }

    public static void jogarCartaGUI(Gameplay partida, int row, int col) throws Exception {
        Player jogadorAtual = partida.getJogadorAtual();

        if (partida.getTabuleiro().getOcupacao()[row][col]) {
            throw new Exception("Posição já ocupada!");
        }

        Card cartaEscolhida = jogadorAtual.getCartaEscolhida();
        if (cartaEscolhida == null) {
            throw new Exception("Nenhuma carta foi escolhida para jogar!");
        }

        Board board = partida.getTabuleiro();
        board.setCarta(row, col, cartaEscolhida);
        compararCartas(cartaEscolhida, board, row, col);
        jogadorAtual.getFilaDeCartas().removeCarta(cartaEscolhida);
        jogadorAtual.setCartaEscolhida(null);

        partida.alternarJogador();

        if (board.isFull()) {
            determinarGanhador(partida);
        }
    }


    private static void compararCartas(Card carta, Board tabuleiro, int linha, int coluna) {
        boolean compCima = linha > 0;
        boolean compBaixo = linha < 2;
        boolean compDireita = coluna < 2;
        boolean compEsquerda = coluna > 0;
        Card cartaAux;

        if (compCima) {
            cartaAux = tabuleiro.getCarta(linha - 1, coluna);
            if (cartaAux != null && carta.getNumeroDeCima() > cartaAux.getNumeroDeBaixo()) {
                carta.getDono().sobePontuacao();
                cartaAux.getDono().baixaPontuacao();
                cartaAux.setDono(carta.getDono());
            }
        }
        if (compDireita) {
            cartaAux = tabuleiro.getCarta(linha, coluna + 1);
            if (cartaAux != null && carta.getNumeroDaDireita() > cartaAux.getNumeroDaEsquerda()) {
                carta.getDono().sobePontuacao();
                cartaAux.getDono().baixaPontuacao();
                cartaAux.setDono(carta.getDono());
            }
        }
        if (compBaixo) {
            cartaAux = tabuleiro.getCarta(linha + 1, coluna);
            if (cartaAux != null && carta.getNumeroDeBaixo() > cartaAux.getNumeroDeCima()) {
                carta.getDono().sobePontuacao();
                cartaAux.getDono().baixaPontuacao();
                cartaAux.setDono(carta.getDono());
            }
        }
        if (compEsquerda) {
            cartaAux = tabuleiro.getCarta(linha, coluna - 1);
            if (cartaAux != null && carta.getNumeroDaEsquerda() > cartaAux.getNumeroDaDireita()) {
                carta.getDono().sobePontuacao();
                cartaAux.getDono().baixaPontuacao();
                cartaAux.setDono(carta.getDono());
            }
        }
    }



    private static void determinarGanhador(Gameplay partida) {
        Player jogador1 = partida.getJogador1();
        Player jogador2 = partida.getJogador2();

        if (jogador1.getPontuacao() > jogador2.getPontuacao()) {
            partida.setGanhador(jogador1);
        } else if (jogador2.getPontuacao() > jogador1.getPontuacao()) {
            partida.setGanhador(jogador2);
        } else {
            partida.setGanhador(null);
        }
        partida.finalizarPartida();
    }
}
