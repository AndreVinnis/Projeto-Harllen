package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.GameplayJavaSwing;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Gameplay.Gameplay;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Card;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Player;

public class GameplayPanel extends JPanel {
    private Gameplay partida;
    private JTextArea infoArea;
    private JTextArea cartasArea;
    private JButton[] boardButtons;

    public GameplayPanel() {
        setLayout(new BorderLayout());

        infoArea = new JTextArea();
        infoArea.setEditable(false);
        add(new JScrollPane(infoArea), BorderLayout.NORTH);

        cartasArea = new JTextArea();
        cartasArea.setEditable(false);
        add(new JScrollPane(cartasArea), BorderLayout.SOUTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        boardButtons = new JButton[9];

        for (int i = 0; i < 9; i++) {
            boardButtons[i] = new JButton("");
            boardButtons[i].setPreferredSize(new Dimension(100, 100));
            int row = i / 3;
            int col = i % 3;
            boardButtons[i].addActionListener(e -> jogarCarta(row, col));
            boardPanel.add(boardButtons[i]);
        }

        add(boardPanel, BorderLayout.CENTER);
    }

    public void startGame(Gameplay partida) {
        this.partida = partida;
        atualizarTabuleiro();
        infoArea.setText("Novo jogo iniciado!\n");
        iniciarRodada();
    }

    private void iniciarRodada() {
        Player jogadorAtual = partida.getJogadorAtual();
        infoArea.append("Vez do jogador " + jogadorAtual.getNome() + " (" + jogadorAtual.getCor() + ")\n");
        mostrarCartasJogador(jogadorAtual);
    }

    private void mostrarCartasJogador(Player jogador) {
        cartasArea.setText("Cartas disponíveis:\n");

        Card[] firstThreeCards = jogador.getFilaDeCartas().escolheEntreTresCartas();
        int i = 0;
        for (Card carta : firstThreeCards) { //Mostra as opções que o sistema tem pra escolher
            cartasArea.append("Carta " + (i + 1) + ": " + carta.toString() + "\n");
            i++;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(firstThreeCards.length);
        Card cartaEscolhida = firstThreeCards[randomIndex]; //Escolhe a carta e logo dps printa na tela qual foi

        JOptionPane.showMessageDialog(null, "O sistema escolheu automaticamente: " + cartaEscolhida);

        jogador.setCartaEscolhida(cartaEscolhida);
    }


    private void jogarCarta(int row, int col) {
        try {
            GameplayAssistant.jogarCartaGUI(partida, row, col);
            atualizarTabuleiro();
            verificarVencedor();

            if (partida.isPartidaAtiva()) {
                iniciarRodada();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Card carta = partida.getTabuleiro().getCarta(i, j);
                boardButtons[i * 3 + j].setText(carta != null ? carta.toString() : "");
            }
        }
    }

    private void verificarVencedor() {
        if (partida.getTabuleiro().isFull()) {
            String mensagemVencedor;
            Player ganhador = partida.getGanhador();

            if (ganhador != null) {
                mensagemVencedor = "Parabéns, " + ganhador.getNome() + " venceu!";
            } else {
                mensagemVencedor = "Empate!";
            }

            JOptionPane.showMessageDialog(this, mensagemVencedor, "Fim do Jogo", JOptionPane.INFORMATION_MESSAGE);
            startGame(GameplayAssistant.criarPartidaGUI());
        }
    }
}
