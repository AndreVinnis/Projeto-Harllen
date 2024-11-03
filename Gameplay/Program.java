package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Gameplay;

import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Gameplay partida = GameplayAssistant.criarPartida(scan1);
        while (partida.isPartidaAtiva()) {
            GameplayAssistant.rodada(partida, scan1, scan2);
            if(!(partida.isPartidaAtiva()) && partida.getGanhador() == null){
                System.out.println("EMPATE! Uma nova partida será iniciada, jogador 1 deve assumir\na posição de jogador 2 e vice-versa");
                partida = GameplayAssistant.criarPartida(scan1);
            }
        }
        System.out.printf("PARABÉNS!!! O JOGADOR %s FOI O VENCEDOR", partida.getGanhador().getNome().toUpperCase());
        scan1.close();
        scan2.close();
    }
}
