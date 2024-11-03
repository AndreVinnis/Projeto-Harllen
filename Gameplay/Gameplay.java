package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Gameplay;

import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Board.Board;
import Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities.Player;

public class Gameplay {
    private Player jogador1;
    private Player jogador2;
    private Player ganhador;
    private Board tabuleiro;
    private boolean partidaAtiva;

    public Gameplay(Player jogador1, Player jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        tabuleiro = new Board(3, 3);
        ganhador = null;
        partidaAtiva = true;
    }

    public Player getJogador1() {
        return jogador1;
    }

    public Player getJogador2() {
        return jogador2;
    }

    public Player getGanhador() {
        return ganhador;
    }

    public Board getTabuleiro() {
        return tabuleiro;
    }

    public boolean isPartidaAtiva() {
        return partidaAtiva;
    }

    public void setGanhador(Player ganhador) {
        this.ganhador = ganhador;
    }

    public void finalizarPartida() {
        partidaAtiva = false;
    }
    
}
