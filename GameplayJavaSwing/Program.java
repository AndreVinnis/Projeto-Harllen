package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.GameplayJavaSwing;

import javax.swing.*;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Gameplay.Gameplay;

public class Program {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Jogo de Cartas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            GameplayPanel gameplayPanel = new GameplayPanel();
            frame.add(gameplayPanel);
            frame.setVisible(true);

            Gameplay partida = GameplayAssistant.criarPartidaGUI();
            gameplayPanel.startGame(partida);
        });
    }
}
