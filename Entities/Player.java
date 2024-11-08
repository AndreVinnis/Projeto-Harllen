package Java.Aula_de_Laboratorio.AulasHarllen.Projetos.Projeto1.Entities;

public class Player {
    private String nome;
    private String cor;
    private Card[] baralho;
    private int quantCartas;
    private QueueCards filaDeCartas;
    private int pontuacao;
    private Card cartaEscolhida;

    public Player(String nome, String cor, Card[] baralho){
        this.nome = nome;
        this.cor = cor;
        this.baralho = baralho;
        quantCartas = baralho.length;
        filaDeCartas = new QueueCards(quantCartas);
        addQueue();
        pontuacao = 5;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public Card[] getBaralho() {
        return baralho;
    }

    public int getPontuacao() {
        return pontuacao;
    }
    
    public QueueCards getFilaDeCartas() {
        return filaDeCartas;
    }

    public int getQuantCartas() {
        return quantCartas;
    }

    public void sobePontuacao() {
        pontuacao ++;
    }
    public void baixaPontuacao() {
        pontuacao --;
    }

    private void addQueue(){
        for(int i = 0; i < baralho.length; i ++){
            filaDeCartas.enqueue(baralho[i]);
        }
    }
    public void useCard(Card card){
        for(int i = 0; i < quantCartas; i ++){
            if(baralho[i].equals(card)){
                baralho[i] = null;
            }
        }
        for(int i = 1; i < quantCartas; i ++){
            if(baralho[i-1] == null){
                baralho[i-1] = baralho[i];
                baralho[i] = null;
            }
        }
        quantCartas --;
    }

    public void setCartaEscolhida(Card cartaEscolhida) {
        this.cartaEscolhida = cartaEscolhida;
    }

    public Card getCartaEscolhida() {
        return cartaEscolhida;
    }
}
