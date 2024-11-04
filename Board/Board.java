package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Board;

import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Card;

public class Board {
    private boolean[][] ocupacao;
    private Card[][] tabuleiro;
    private boolean cheio;

    public Board(int linhas, int colunas) {
        ocupacao = new boolean[linhas][colunas];
        tabuleiro = new Card[linhas][colunas];
        cheio = false;
        limpaTabuleiro();
    }
    public boolean[][] getOcupacao() {
        return ocupacao;
    }

    public Card[][] getTabuleiro() {
        return tabuleiro;
    }

    public boolean isCheio() {
        return cheio;
    }

    public void addCarta(int linha, int coluna, Card carta) {
        tabuleiro[linha][coluna] = carta;
        ocupacao[linha][coluna] = true;
        cheio = isFull();
    }

    public boolean isFull() {
        for (int i = 0; i < ocupacao.length; i++) {
            for (int j = 0; j < ocupacao.length; j++) {
                if(!ocupacao[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }    
    private void limpaTabuleiro(){
        for(int i = 0; i < ocupacao.length; i ++){
            for(int j = 0; j < ocupacao[0].length; j ++){
                ocupacao[i][j] = false;
                tabuleiro[i][j] = null;
            }
        }
    }

    //retorna a carta
    public Card getCarta(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            return tabuleiro[row][col];
        }
        return null;}

    //seta a carta. esses 2 metodos foram tentativas de fazer o jogo não terminar em empate na interface
    public void setCarta(int row, int col, Card carta) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            tabuleiro[row][col] = carta;
            ocupacao[row][col] = true;
            cheio = isFull();
        }
    }
}
