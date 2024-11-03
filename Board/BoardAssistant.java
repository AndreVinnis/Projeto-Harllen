package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Board;

import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Card;

public class BoardAssistant {
    public static void colocarCartaNoTabuleiro(Board tabuleiro, Card carta, int linha, int coluna) throws Exception{
        
        if (linha < 0 || linha >= tabuleiro.getOcupacao().length || coluna < 0 || coluna >= tabuleiro.getOcupacao()[0].length) {
            throw new Exception("Posição inválida!");
        }

        if (tabuleiro.getOcupacao()[linha][coluna]) {
            throw new Exception("Posição já ocupada!");
        }
        tabuleiro.addCarta(linha, coluna, carta); 
    }
}
