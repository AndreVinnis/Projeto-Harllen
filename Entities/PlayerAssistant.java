package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities;

import javax.swing.*;
import java.util.Scanner;

public class PlayerAssistant {
    
    public static Player criaJogador(Scanner scan, String cor) {
        System.out.printf("Registro do jogador: (%s)\n", cor);

        System.out.print("Nome: ");
        String nome = scan.nextLine();


        Card[] baralho = new Card[9];
        for(int i = 0; i < 9; i ++){
            baralho[i] = new Card();
        }
        Player player = new Player(nome, cor, baralho);
        for(int i = 0; i < 9; i ++){
            player.getBaralho()[i].setDono(player);
        }
        return player;
    }

    //Fiz esse metodo separado so pra n atrapalhar nos testes da Gameplay sem o javaSwing
    public static Player criaJogadorGUI(String cor) {

        String nome = JOptionPane.showInputDialog("Digite o nome do jogador " + cor + ":");

        Card[] baralho = new Card[9];

        for (int i = 0; i < 9; i ++) {
            baralho[i] = new Card();
        }

        Player player = new Player(nome, cor, baralho);

        for (int i = 0; i < 9; i++){
            player.getBaralho()[i].setDono(player);
        }
        return player;
    }
}
