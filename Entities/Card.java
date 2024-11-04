package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities;

import java.util.Random;

public class Card {
    private static Random sorteia = new Random();
    private int numeroDeCima;
    private int numeroDeBaixo;
    private int numeroDaEsquerda;
    private int numeroDaDireita;
    private Player dono;

    public Card(){
        this.numeroDeCima = sorteia.nextInt(10) + 1;
        this.numeroDeBaixo = sorteia.nextInt(10) + 1;
        this.numeroDaEsquerda = sorteia.nextInt(10) + 1;
        this.numeroDaDireita = sorteia.nextInt(10) + 1;
    }

    public int getNumeroDeCima() {
        return numeroDeCima;
    }

    public int getNumeroDeBaixo() {
        return numeroDeBaixo;
    }

    public int getNumeroDaEsquerda() {
        return numeroDaEsquerda;
    }

    public int getNumeroDaDireita() {
        return numeroDaDireita;
    }

    public Player getDono() {
        return dono;
    }

    public void setDono(Player dono) {
        this.dono = dono;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numeroDeCima;
        result = prime * result + numeroDeBaixo;
        result = prime * result + numeroDaEsquerda;
        result = prime * result + numeroDaDireita;
        result = prime * result + ((dono == null) ? 0 : dono.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (numeroDeCima != other.numeroDeCima)
            return false;
        if (numeroDeBaixo != other.numeroDeBaixo)
            return false;
        if (numeroDaEsquerda != other.numeroDaEsquerda)
            return false;
        if (numeroDaDireita != other.numeroDaDireita)
            return false;
        if (dono == null) {
            if (other.dono != null)
                return false;
        } else if (!dono.equals(other.dono))
            return false;
        return true;
    }

    //toString pra testar se ta imprimindo as cartas na interface
    @Override public String toString() {
        return "Card [Cima: " + numeroDeCima + ", Baixo: "
                + numeroDeBaixo + ", Esquerda: " +
                numeroDaEsquerda + ", Direita: " + numeroDaDireita + "]"; }
}
